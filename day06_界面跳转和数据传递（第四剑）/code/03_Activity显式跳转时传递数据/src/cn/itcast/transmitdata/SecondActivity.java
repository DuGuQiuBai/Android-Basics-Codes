package cn.itcast.transmitdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		//获取到启动该Activity的意图对象
		Intent intent = getIntent();
		
//		String maleName = intent.getStringExtra("maleName");
//		String femaleName = intent.getStringExtra("femaleName");
		
		Bundle bundle = intent.getExtras();
		String maleName = bundle.getString("maleName");
		String femaleName = bundle.getString("femaleName");
		
		String text = maleName + femaleName;
		byte[] b = text.getBytes();
		int total = -100;
		for (byte c : b) {
			total += c;
		}
		//取绝对值，避免负数，模101，最大值就是100
		total = Math.abs(total) % 101;
		
		TextView tv = (TextView) findViewById(R.id.tv);
		tv.setText(maleName + "和" + femaleName + "的姻缘值为：" + total + ",实乃天作之合,天赐良缘、天生一对");
	}
}
