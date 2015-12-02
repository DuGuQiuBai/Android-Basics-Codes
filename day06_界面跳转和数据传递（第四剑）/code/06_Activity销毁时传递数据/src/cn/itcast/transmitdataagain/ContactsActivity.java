package cn.itcast.transmitdataagain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		
		
		final String[] names = new String[]{
				"美丽动人的凤老婆",
				"可爱的闺女"
		};
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_listview, //要填充成listview条目的布局文件的资源id
				R.id.tv_name, //字符串显示在哪个组件中
				names));
		
		//设置条目侦听，可以理解为给条目设置侦听
		lv.setOnItemClickListener(new OnItemClickListener() {

			//当listView的条目被点击时，此方法调用
			//position:点击的条目的索引
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				//把要传递的数据封装至intent对象中
				Intent data = new Intent();
				data.putExtra("name", names[position]);
				
				//当前Activity销毁时，会把data传递给MainActivity
				setResult(10, data);
				//销毁当前Activity
				finish();
			}

		});
	}
	
}
