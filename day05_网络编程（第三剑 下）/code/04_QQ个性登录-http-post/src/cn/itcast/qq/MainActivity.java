package cn.itcast.qq;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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

		// 在子线程中访问网络
		new Thread() {
			public void run() {
				requestNet();
			}
		}.start();
	}

	/**
	 * 提交QQ账号和密码到服务器
	 */
	private void requestNet() {
		try {
			// 1>重要， 请求的Url不一样
			String path = "http://192.168.1.253:8080/web/LoginServlet";

			// 1. 打开浏览器
			HttpClient client = new DefaultHttpClient();
			// 2. 输入Url网址
			HttpPost url = new HttpPost(path);
			//提交到服务器端的数据
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			BasicNameValuePair p1 = new BasicNameValuePair("qq", qq);
			parameters.add(p1);
			parameters.add(new BasicNameValuePair("pwd", pwd));
			//经过form表单编码的URl
			HttpEntity entity = new UrlEncodedFormEntity(parameters, "utf-8");
			url.setEntity(entity);
			// 3. 敲回车
			HttpResponse response = client.execute(url);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				// 5. 拿到从服务器端返回的输入流
				InputStream is = response.getEntity().getContent();
				// 把服务器端返回的输入流转成字符串
				String text = StreamUtils.parserStream2String(is);
				showToastInThread(text);
			} else {
				showToastInThread("code:" + code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			showToastInThread("哥哥，异常了!!!");
		}
	}

	/**
	 * 在线程中用消息机制弹土司
	 * 
	 * @param text
	 */
	private void showToastInThread(final String text) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(MainActivity.this, text, 0).show();
			}
		});
	}

}
