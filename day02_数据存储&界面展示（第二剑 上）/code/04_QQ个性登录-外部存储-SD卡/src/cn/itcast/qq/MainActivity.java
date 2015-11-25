package cn.itcast.qq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etQQ;
	private EditText etPwd;
	private CheckBox cbRem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		cbRem = (CheckBox) findViewById(R.id.cb_rem);

		readData();
	}

	public void readData() {

		File file = new File("/mnt/sdcard/waibucunchu.txt");

		// 判断文件是否存在，如果存在读取上次存储的数据
		if (file.exists()) {
			try {
				 FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String text = br.readLine();
				br.close();

				String[] content = text.split("==");
				String qq = content[0];
				String pwd = content[1];
				// 回显数据到etQQ,etPwd
				etQQ.setText(qq);
				etPwd.setText(pwd);
				Toast.makeText(this, "ohohohoh", 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "哥们，读取失败！！！", 0).show();
				e.printStackTrace();
			}
		}
	}

	/**
	 * 点击按钮
	 * 
	 * @param view
	 */
	public void gxlogin(View view) {
		// System.out.println("点击按钮了，存储数据啦！");
		String qq = etQQ.getText().toString().trim();
		String pwd = etPwd.getText().toString().trim();
		if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(this, "QQ号或者密码不能为空！！！", 0).show();
			return;
		}

		// 用户是否勾选，记住密码
		boolean isChecked = cbRem.isChecked();
		if (isChecked) {
			try {
				File file = new File("/mnt/sdcard/waibucunchu.txt");
				FileOutputStream fos = new FileOutputStream(file);
				String text = qq + "==" + pwd;
				fos.write(text.getBytes());
				fos.close();
				Toast.makeText(this, "数据存储成功！", 0).show();
			} catch (Exception e) {
				Toast.makeText(this, "数据存储失败！", 0).show();
				e.printStackTrace();
			}
		} else {
			System.out.println("不存储数据");
		}

	}

}
