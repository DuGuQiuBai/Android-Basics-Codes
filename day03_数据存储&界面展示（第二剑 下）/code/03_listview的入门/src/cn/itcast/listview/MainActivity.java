package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 2. 在Activity中找到ListView
		ListView lv = (ListView) findViewById(R.id.lv);

		// 3. 设置数据适配器
		lv.setAdapter(new MyAdapter());
	}

	/**
	 * 4. 用内部类实现数据适配器
	 * 
	 *  C:控制器
	 *  
	 */
	class MyAdapter extends BaseAdapter {

		// 告诉系统显示多少个条目
		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		// Android系统调用getView（）
		//数据模型  M
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = null;
//			tv = new TextView(MainActivity.this);
			
			if (convertView == null) {
				tv = new TextView(MainActivity.this);
				System.out.println("convertView 创建出来的对象:" + convertView);
			}else {
				System.out.println("convertView 复用划出手机屏的的条目:" + convertView);
				tv=(TextView) convertView;
			}

			System.out.println("getView()" + position);
			tv.setText("我是：" + position);
			tv.setTextSize(30);
			tv.setTextColor(Color.RED);

			return tv;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

	}
}
