package cn.itcast.qq;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

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

		String path = "http://192.168.1.253:8080/web/LoginServlet" + "?qq="
				+ qq + "&pwd=" + pwd;

		// 访问网络
		// 1.初始化客户端
		AsyncHttpClient client = new AsyncHttpClient();
		// 2.用get方式提交数据
		client.get(path, new AsyncHttpResponseHandler() {
			// 请求成功
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					byte[] responseBody) {
				String text = new String(responseBody);
				Toast.makeText(MainActivity.this, text, 0).show();
			}
			//请求失败
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
				String text = new String(responseBody);
				Toast.makeText(MainActivity.this, text, 0).show();
			}
		});

	}

}
