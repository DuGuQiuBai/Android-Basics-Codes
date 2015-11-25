package cn.itcast.xiaotou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		read07YYData();
	}

	/**
	 * 往07应用中写数据
	 * 
	 * @param v
	 */
	public void nama(View v) {
		try {
//			File file = new File("/data/data/cn.itcast.mode/files/writeable.txt");
//			File file = new File("/data/data/cn.itcast.mode/files/readable.txt");
//			File file = new File("/data/data/cn.itcast.mode/files/private.txt");
			File file = new File("/data/data/cn.itcast.mode/files/all");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write("让你嚣张！ 我给你  -8元".getBytes());

			fos.close();
			Toast.makeText(this, "写入数据成功！", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "写入07应用的数据失败！", 0).show();
		}
	}

	/**
	 * 读取07应用的数据
	 */
	public void read07YYData() {
		try {
			// File file = new
			// File("/data/data/cn.itcast.mode/files/private.txt");
			// File file = new File("/data/data/cn.itcast.mode/files/all");
			// File file = new
			// File("/data/data/cn.itcast.mode/files/readable.txt");
			File file = new File(
					"/data/data/cn.itcast.mode/files/writeable.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String text = br.readLine();
			br.close();
			Toast.makeText(this, text, 0).show();

		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "读取07应用的数据失败！", 0).show();
		}
	}
}
