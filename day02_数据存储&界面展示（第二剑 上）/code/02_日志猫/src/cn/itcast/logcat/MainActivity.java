package cn.itcast.logcat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private static final String TAG="MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		System.out.println("MainActivity对象呗创建了，onCreate被调用了！");
		
		Log.v(TAG, "我是日志   提示  ");
		Log.d(TAG, "我是日志   调试  ");
		Log.i(TAG, "我是日志   信息  ");
		Log.w(TAG, "我是日志   警告  ");
		Log.e(TAG, "我是日志   错误  ");
	}

}
