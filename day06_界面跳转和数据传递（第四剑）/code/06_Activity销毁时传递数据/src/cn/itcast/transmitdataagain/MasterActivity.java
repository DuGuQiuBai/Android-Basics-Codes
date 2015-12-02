package cn.itcast.transmitdataagain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MasterActivity extends Activity {

	static final int MASTER_NAME = 1;
	static final int MASTER_CONTENT = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_master);
		
		TextView tv_mastername = (TextView) findViewById(R.id.tv_mastername);
		TextView tv_mastercontent = (TextView) findViewById(R.id.tv_mastercontent);
		
		tv_mastername.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("name", "耘赫");
				setResult(MASTER_NAME, data);
				finish();
			}
		});
		tv_mastercontent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("content", "请把我的手鸡还给我");
				setResult(MASTER_CONTENT, data);
				finish();
			}
		});
	}
}
