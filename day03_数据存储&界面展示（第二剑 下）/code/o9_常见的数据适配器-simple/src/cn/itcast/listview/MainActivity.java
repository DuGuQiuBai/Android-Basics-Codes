package cn.itcast.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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


		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "林青霞	");
		map1.put("photo", R.drawable.ic_launcher);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "刘德华");
		map2.put("photo", R.drawable.ic_launcher);

		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "张学友");
		map3.put("photo", R.drawable.ic_launcher);

		data.add(map1);
		data.add(map2);
		data.add(map3);
		
		/*
		 * context ：上下文 
		 * data ：填充到list中item的数据
		   resource ：填充到list中item的布局文件
		   from ：map里面的key
		 * to ：显示view的ID
		 */
		lv.setAdapter(new SimpleAdapter(MainActivity.this, data,
				R.layout.adapter_list_item, new String[]{"photo","name"}, 
				new int[]{R.id.iv,R.id.tv_list_item}));

	}

}
