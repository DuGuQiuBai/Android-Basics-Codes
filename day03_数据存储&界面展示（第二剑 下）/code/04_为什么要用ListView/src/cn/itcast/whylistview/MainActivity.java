package cn.itcast.whylistview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private LinearLayout llContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		llContent = (LinearLayout) findViewById(R.id.ll_content);
	}

	public void why(View v) {
		for(int i=0;i<Integer.MAX_VALUE;i++){
			
			TextView tv = new TextView(this);
			tv.setText("我是哥创建出来的条目:"+i);
			tv.setTextSize(20);
			tv.setTextColor(Color.RED);
			
			// 给Linearlayout里面添加孩子
			llContent.addView(tv);
		}
	}
}
