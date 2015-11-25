package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.tv_list_item);
		tv.setText("我是Activity的标题!!!");
		// 2. 在Activity中找到ListView
		ListView lv = (ListView) this.findViewById(R.id.lv);
		// 3. 设置数据适配器
		lv.setAdapter(new MyAdapter());

	}

	/**
	 * 4. 用内部类实现数据适配器
	 * 
	 * 控制器：C
	 */
	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return 100;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(MainActivity.this,
						R.layout.adapter_list_item, null);
			}

			//空指针异常  ：没有写convertView
			TextView tv = (TextView) convertView
					.findViewById(R.id.tv_list_item);

			tv.setText("我是listview的孩子：" + position);

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
