package cn.itcast.sd;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	/**
	 * 检测Sd卡的插拔状态
	 * @param v
	 */
	public void click(View v) {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "SD已插入", 0).show();
		} else if (state.equals(Environment.MEDIA_UNMOUNTED)) {
			Toast.makeText(this, "SD被移除", 0).show();
		}
	}
	
	/**
	 * 获取SD卡的路径
	 * @param view
	 */
	public void path(View view){
		File file = Environment.getExternalStorageDirectory();
		Toast.makeText(this, file.getAbsolutePath(), 0).show();
	}
	
	/**
	 * 获取SD卡的可用空间
	 * @param view
	 */
	public void space(View view){
		File file = Environment.getExternalStorageDirectory();
		long size = file.getFreeSpace(); //byte
		String formatFileSize = Formatter.formatFileSize(this, size);
		
		Toast.makeText(this, formatFileSize, 0).show();
	}
	
}
