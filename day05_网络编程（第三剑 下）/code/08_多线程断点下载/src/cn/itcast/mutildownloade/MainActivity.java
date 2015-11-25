package cn.itcast.mutildownloade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private EditText etTC;
	private EditText etPath;

	// 线程数
	private int threadCount = 3;
	private LinearLayout llContent;
	// 网络url
	private String path;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etPath = (EditText) findViewById(R.id.et_path);
		etTC = (EditText) findViewById(R.id.et_thread_count);
		llContent = (LinearLayout) findViewById(R.id.ll_content);
	}

	/**
	 * 下载文件
	 * 
	 * @param v
	 */
	public void download(View v) {
		path = etPath.getText().toString().trim();
		String count = etTC.getText().toString().trim();
		if (!TextUtils.isEmpty(count)) {
			threadCount = Integer.valueOf(count);
		}

		// 移除ll里面的所有view
		llContent.removeAllViews();

		// 给ll里面添加进度条
		for (int i = 0; i < threadCount; i++) {
			View pb = View.inflate(this, R.layout.progressbar, null);
			llContent.addView(pb);
		}

		// 在线程网络通信
		new Thread() {
			public void run() {
				requestNet();
			};
		}.start();
	}

	private void requestNet() {
		// (1). 创建和服务器资源文件一样大小的空文件
		try {
			// 1. 初始化Url
			URL url = new URL(path);
			// 2. 通过Url获取Http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. 设置请求参数和请求方式
			conn.setRequestMethod("GET");
			// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
			int code = conn.getResponseCode();
			// 5. 拿到从服务器端返回的资源文件的大小
			int fileLength = conn.getContentLength();
			if (code == 200) {
				System.out.println("服务器资源文件的大小：" + fileLength);
				RandomAccessFile raf = new RandomAccessFile(getFileName(), "rw");
				// 重要设置文件的大小
				raf.setLength(fileLength);
				raf.close();
			}

			// (2).开启多个线程下载
			// 每个区块的大小
			int blockSize = fileLength / threadCount;

			for (int threadId = 0; threadId < threadCount; threadId++) {
				int startIndex = threadId * blockSize;
				int endIndex = (threadId + 1) * blockSize;
				// 最后一个线程
				if (threadId == threadCount - 1) {
					// 修正文件结束的位置
					endIndex = fileLength - 1;
				}
				// 开始线程
				new DownLoadThread(startIndex, endIndex, threadId).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class DownLoadThread extends Thread {
		// 开始位置
		int startIndex;
		// 结束位置
		int endIndex;
		// 线程Id
		int threadId;
		// 每个线程相对于资源文件的下载位置
		int lastDownFilePos;
		ProgressBar  mPb;
		//每一个线程下载的总进度
		int totalSize ;
		//理论上现在的开始位置
		int firstStartIndex;
		//当前线程下载的进度
		int progress;
		public DownLoadThread(int startIndex, int endIndex, int threadId) {
			super();
			firstStartIndex = startIndex;
			
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.threadId = threadId;
			lastDownFilePos = startIndex;
			mPb = (ProgressBar) llContent.getChildAt(threadId);
			totalSize = endIndex - startIndex;
			mPb.setMax(totalSize);
			
		}

		@Override
		public void run() {
			super.run();
			System.out.println("理论上线程" + threadId + ": " + startIndex + " ~ "
					+ endIndex);
			// System.out.println("线程" + threadId + "工作量: "
			// +(endIndex-startIndex));

			try {
				File file = new File(getTmpFileName(threadId));
				if (file.exists() && file.length() > 0) {
					FileInputStream fis = new FileInputStream(file);
					BufferedReader br = new BufferedReader(
							new InputStreamReader(fis));
					lastDownFilePos = Integer.valueOf(br.readLine());
					startIndex = lastDownFilePos;
					br.close();
				}
				System.out.println("	实际上线程" + threadId + ": " + startIndex
						+ " ~ " + endIndex);

				// 1. 初始化Url
				URL url = new URL(path);
				// 2. 通过Url获取Http连接
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				// 3. 设置请求参数和请求方式
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(3000);
				// 重要，设置每个线程请求服务器资源的大小
				conn.setRequestProperty("Range", "bytes=" + startIndex + "-"
						+ endIndex);
				// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
				// 206:表示部分请求成功
				int code = conn.getResponseCode();
				System.out.println("部分请求成功：" + code);
				if (code == 206) {
					// 5. 拿到从服务器端返回的输入流
					InputStream is = conn.getInputStream();
					RandomAccessFile rf = new RandomAccessFile(getFileName(),
							"rw");
					// 重要，每个线程从他的开始位置写文件
					rf.seek(startIndex);
					byte[] buffer = new byte[1024];
					int len = -1;
					while ((len = is.read(buffer)) != -1) {
						rf.write(buffer, 0, len);

						lastDownFilePos = lastDownFilePos + len;
						
						//计算当前现在下载的进度
						progress = lastDownFilePos-firstStartIndex;
						mPb.setProgress(progress);
						
						// 存储线程下载文件的进度
						RandomAccessFile f = new RandomAccessFile(
								getTmpFileName(threadId), "rwd");
						String pos = String.valueOf(lastDownFilePos);
						f.write(pos.getBytes());
						f.close();
					}
					rf.close();
				}

				System.out.println("线程" + threadId + "干完活了！");
				// 删除储存进度的临时文件
				System.out.println(file.delete());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 服务器资源的名字
	 * 
	 * @return
	 */
	String getFileName() {
		int index =path.lastIndexOf("/") + 1;
		return  "/mnt/sdcard/"+path.substring(index);
	}

	/**
	 * 线程下载进度文件的存储
	 * 
	 * @param threadId
	 * @return
	 */
	String getTmpFileName(int threadId) {

		return getFileName() + threadId + ".txt";
	}

}
