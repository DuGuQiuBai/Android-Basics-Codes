package com.example.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private String[] objects = new String[] { "风清扬", "张辽", "玉麒麟", "独孤求败" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.lv);
		/*
		 * context :上下文 resource ：Listview条目的布局文件
		 * textViewResourceId：Listview条目的布局文件中tv的Id objects
		 * ：ListView上每个条目textview显示的数据
		 */
		// lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,
		// R.layout.adapter_list_array_item, R.id.tv_array_item, objects));

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "aaa");
		map1.put("phto", R.drawable.ic_launcher);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "aaa");
		map2.put("phto", R.drawable.ic_launcher);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "aaa");
		map3.put("phto", R.drawable.ic_launcher);

		data.add(map1);
		data.add(map2);
		data.add(map3);

		/*
		 * context ：上下文 data ：要显示的数据 resource ：Listview条目的布局文件 from
		 * ：每个条目map中的key to ：条目布局文件中控件的ID
		 */
		lv.setAdapter(new SimpleAdapter(MainActivity.this, data,
				R.layout.adapter_list_array_item,
				new String[] { "phto", "name" }, new int[] { R.id.iv,
						R.id.tv_array_item }));
	}

}
