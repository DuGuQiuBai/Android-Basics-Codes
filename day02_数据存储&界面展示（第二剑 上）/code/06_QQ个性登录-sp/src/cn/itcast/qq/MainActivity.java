package cn.itcast.qq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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

	SharedPreferences mSp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etQQ = (EditText) findViewById(R.id.et_qq);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		cbRem = (CheckBox) findViewById(R.id.cb_rem);
		// 1. 初始化SharedPreference
		mSp = this.getSharedPreferences("config.xml", 0);
		readData();
	}

	public void readData() {

		// 判断文件是否存在，如果存在读取上次存储的数据
		String qq = mSp.getString("qq", "");
		String pwd = mSp.getString("mm", "");

		// 回显数据
		etQQ.setText(qq);
		etPwd.setText(pwd);
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
			// 存储数据

			// 2. 获取编辑器Editor
			Editor edit = mSp.edit();
			// 3. 用编辑器存储数据
			edit.putString("qq", qq);
			edit.putString("mm", pwd);
			// 4. 重要，记住提交数据
			edit.commit();

			Toast.makeText(this, "数据存储成功！", 0).show();
		} else {
			System.out.println("不存储数据");
		}

	}

}
