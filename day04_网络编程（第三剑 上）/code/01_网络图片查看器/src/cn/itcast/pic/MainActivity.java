package cn.itcast.pic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private EditText etPath;
	private ImageView ivPic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etPath = (EditText) findViewById(R.id.et_path);
		ivPic = (ImageView) findViewById(R.id.iv_pink);
		
		System.out.println("当前线程："+Thread.currentThread().getName());
	}

	public void look(View v) {
		final String path = etPath.getText().toString().trim();

		//在子线程进行网络访问
		new Thread(){
			public void run() {
				requestNetWork(path);
			};
		}.start();
	}

	/**
	 * 访问网络获取图片
	 * @param path
	 */
	private void requestNetWork(String path) {
		try {
			// 1. 初始化Url
			URL url = new URL(path);
			// 2. 通过Url获取Http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. 设置请求参数和请求方式
			conn.setRequestMethod("GET");// 默认的请求方式
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. 拿到从服务器端返回的输入流
				InputStream is = conn.getInputStream();

				// 把服务器返回的二进制输入流转成图片对象
				Bitmap bmp = BitmapFactory.decodeStream(is);
				// 把图片对象显示在iv
				ivPic.setImageBitmap(bmp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
