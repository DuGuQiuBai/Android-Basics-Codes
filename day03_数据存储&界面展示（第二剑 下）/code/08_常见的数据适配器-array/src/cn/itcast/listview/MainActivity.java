package cn.itcast.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] objects = new String[] { "风清扬", "张辽", "独孤求败", "玉麒麟" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.tv_list_item);
		tv.setText("我是ArrayAdapter");
		// 2. 在Activity中找到ListView
		ListView lv = (ListView) this.findViewById(R.id.lv);
		// 3. 设置数据适配器

		/*
		 * context ：上下文
		 *  resource ：listview的item布局文件
		 * textViewResourceId:显示文本的Textview的ID 
		 * objects ：显示的数据
		 */
		lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
				R.layout.adapter_list_item, R.id.tv_list_item, objects));

	}

}
