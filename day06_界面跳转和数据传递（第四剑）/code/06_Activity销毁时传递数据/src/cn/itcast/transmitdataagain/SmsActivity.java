package cn.itcast.transmitdataagain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		
		final String[] content = new String[]{
				"耘赫正在跪键盘，一会他会回复你",
				"耘赫正在捡肥皂，一会他会回复你",
				"耘赫正在挨揍，一会他可能也回不了你"
		};
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_listview, //要填充成listview条目的布局文件的资源id
				R.id.tv_name, //字符串显示在哪个组件中
				content));
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent data = new Intent();
				//把数据封装至intent中
				data.putExtra("content", content[position]);
				setResult(20, data);
				
				//销毁当前Activity
				finish();
			}
		});
	}
}
