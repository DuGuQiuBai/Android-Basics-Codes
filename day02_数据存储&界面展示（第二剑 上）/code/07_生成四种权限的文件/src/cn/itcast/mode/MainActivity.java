package cn.itcast.mode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 找到关心的控件
		Button btnP = (Button) findViewById(R.id.btn_private);
		Button btnR = (Button) findViewById(R.id.btn_read);
		Button btnW = (Button) findViewById(R.id.btn_write);
		Button btnRW = (Button) findViewById(R.id.btn_rw);
		// 设置监听
		btnP.setOnClickListener(this);
		btnR.setOnClickListener(this);
		btnW.setOnClickListener(this);
		btnRW.setOnClickListener(this);
	}

	/**
	 * 点击按钮
	 */
	@Override
	public void onClick(View v) {
		// Log.i(TAG, "我点击了按钮！");
		try {
			int id = v.getId();
			FileOutputStream fos = null;

			switch (id) {
			case R.id.btn_private:// 私有
				fos = this.openFileOutput("private.txt", MODE_PRIVATE);
				break;
			case R.id.btn_read: // 全局可读
				fos = this.openFileOutput("readable.txt", MODE_WORLD_READABLE);
				break;
			case R.id.btn_write:// 全局可写
				fos = this
						.openFileOutput("writeable.txt", MODE_WORLD_WRITEABLE);
				break;
			case R.id.btn_rw: // 全局可读可写
				fos = openFileOutput("all", MODE_WORLD_READABLE
						+ MODE_WORLD_WRITEABLE);
				break;
			default:
				break;
			}
			fos.write("过来那我的钱！".getBytes());
			fos.close();
			Toast.makeText(this, "保存文件成功！！", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "保存文件失败！！", 0).show();
		}

	}

}
