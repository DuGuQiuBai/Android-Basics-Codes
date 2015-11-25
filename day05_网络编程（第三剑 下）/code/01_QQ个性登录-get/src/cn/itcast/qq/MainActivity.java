package cn.itcast.qq;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etQQ;
	private EditText etPwd;
	private String qq;
	private String pwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);

	}

	/**
	 * 点击按钮
	 * 
	 * @param view
	 */
	public void login(View view) {
		qq = etQQ.getText().toString().trim();
		pwd = etPwd.getText().toString().trim();
		if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(this, "QQ号或者密码不能为空！！！", 0).show();
			return;
		}

		//在子线程中访问网络
		new Thread(){
			public void run() {
				requestNet();
			}
		}.start();
	}

	/**
	 * 提交QQ账号和密码到服务器
	 */
	private void requestNet(){
		try {
			String path = "http://192.168.1.253:8080/web/LoginServlet"
								+"?qq="+URLEncoder.encode(qq, "utf-8")
								+"&pwd="+URLEncoder.encode(pwd, "utf-8");
			// 1. 初始化Url
			URL url = new URL(path);
			// 2. 通过Url获取Http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. 设置请求参数和请求方式
			conn.setRequestMethod("GET");
			conn.setReadTimeout(3000);
			// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. 拿到从服务器端返回的输入流
				InputStream is = conn.getInputStream();
				//把服务器端返回的输入流转成字符串
				String text = StreamUtils.parserStream2String(is);
				showToastInThread(text);
			}else {
				showToastInThread("code:"+code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			showToastInThread("哥哥，异常了!!!");
		}
	}
	
	/**
	 * 在线程中用消息机制弹土司
	 * @param text
	 */
	private void showToastInThread(final String text){
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainActivity.this, text, 0).show();	
			}
		});
	}
	
}
