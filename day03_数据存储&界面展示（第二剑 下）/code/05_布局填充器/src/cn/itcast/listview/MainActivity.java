package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
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
		ListView lv = (ListView) this.findViewById(R.id.lv);
		TextView tvItem = (TextView) this.findViewById(R.id.tv_item);
		tvItem.setText("我是Activity加载的textview");

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
			if (convertView == null) {
				//采用布局填充器给listview填充一个布局
				convertView = View.inflate(MainActivity.this, R.layout.adapter_list_item, null);
				
//				LayoutInflater intInflater = LayoutInflater.from(MainActivity.this);
//				convertView = intInflater.inflate(R.layout.adapter_list_item, null);
				
//				LayoutInflater  inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//				convertView= inflater.inflate(R.layout.adapter_list_item, null);
				
				System.out.println("convertView 创建出来的对象:" + convertView);
			}else {
				System.out.println("convertView 复用划出手机屏的的条目:" + convertView);
			}
			System.out.println("getView()" + position);
			TextView tvItem = (TextView) convertView.findViewById(R.id.tv_item);
			tvItem.setText("我是Activity加载的ListView里面的adapter_list_item的textview");
			return convertView;
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
