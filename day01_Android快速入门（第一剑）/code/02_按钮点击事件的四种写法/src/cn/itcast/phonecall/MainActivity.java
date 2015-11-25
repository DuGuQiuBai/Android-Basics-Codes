package cn.itcast.phonecall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 界面
 * 
 */
public class MainActivity extends Activity {

	/**
	 * 创建activity对象是执行
	 * 
	 * 通过反射创建MainActivity对象，调用onCreate
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 加载布局文件
		setContentView(R.layout.activity_main);
		// 找到布局文件中的按钮
		Button btn = (Button) findViewById(R.id.button);
		// 设置点击事件的监听
		// 1> 采用内部类的方式
		// btn.setOnClickListener(new MyListener());
		// 2> 匿名内部类
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 意图 打 电话 泡 妞 打 酱油
				// 1. 初始化一个意图
				Intent intent = new Intent();
				// 2. 设置动作
				intent.setAction(Intent.ACTION_CALL);
				// 3. 设置数据
				// Url统一资源定位符 http://www.baidu.com < Uri 统一资源标识符
				// chuangzhi://04/班长
				Uri data = Uri.parse("tel://110");
				intent.setData(data);
				// 4. 激活意图
				startActivity(intent);
			}
		});

	}

	/**
	 * OnClickListener接口的一个实现类
	 * 
	 * 内部类
	 */
	class MyListener implements OnClickListener {
		// 点击按钮调用
		@Override
		public void onClick(View v) {
			System.out.println("您点击了按钮");

			// 意图 打 电话 泡 妞 打 酱油
			// 1. 初始化一个意图
			Intent intent = new Intent();
			// 2. 设置动作
			intent.setAction(Intent.ACTION_CALL);
			// 3. 设置数据
			// Url统一资源定位符 http://www.baidu.com < Uri 统一资源标识符 chuangzhi://04/班长
			Uri data = Uri.parse("tel://110");
			intent.setData(data);
			// 4. 激活意图
			startActivity(intent);
		}

	}

}
