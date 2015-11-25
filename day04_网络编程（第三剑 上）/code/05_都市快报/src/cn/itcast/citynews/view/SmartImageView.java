package cn.itcast.citynews.view;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import cn.itcast.citynews.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 从网络加载一张图片
 */
public class SmartImageView extends ImageView {

	protected static final int MSG_SUCC = 0;
	protected static final int MSG_ERR = 1;

	public SmartImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SmartImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SmartImageView(Context context) {
		super(context);
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SUCC://成功
				Bitmap bm = (Bitmap) msg.obj ;
				//调用父类ImageView的方法给他设置图片
				setImageBitmap(bm);
				break;
			case MSG_ERR://失败
				Toast.makeText(getContext(), "code:"+msg.obj, 0).show();
				//显示默认的错误图片
				setImageResource(R.drawable.err);
				break;

			default:
				break;
			}
			
		};
	};

	/**
	 * 从Url给ImageView设置图片
	 * 
	 * @param path
	 */
	public void setImageUrl(final String path) {
		new Thread() {
			public void run() {
				try {
					// 1. 初始化Url
					URL url = new URL(path);
					// 2. 通过Url获取Http连接
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					// 3. 设置请求参数和请求方式
					conn.setRequestMethod("GET");
					// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
					int code = conn.getResponseCode();
					if (code == 200) {
						// 5. 拿到从服务器端返回的输入流
						InputStream is = conn.getInputStream();
						Bitmap bmp = BitmapFactory.decodeStream(is);
						Message msg = Message.obtain();
						msg.obj = bmp;
						msg.what = MSG_SUCC;
						mHandler.sendMessage(msg);
					} else {
						Message msg = Message.obtain();
						msg.what = MSG_ERR;
						msg.obj = code;
						mHandler.sendMessage(msg);
					}

				} catch (Exception e) {
					e.printStackTrace();
					Message msg = Message.obtain();
					msg.what = MSG_ERR;
					mHandler.sendMessage(msg);
				}
			};
		}.start();

	}

}
