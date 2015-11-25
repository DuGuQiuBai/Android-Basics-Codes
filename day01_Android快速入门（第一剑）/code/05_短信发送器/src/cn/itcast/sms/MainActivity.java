package cn.itcast.sms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etNum;
	private EditText etText;
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局文件
		setContentView(R.layout.activity_main);
		//找到关心的控件
		etNum = (EditText) findViewById(R.id.et_num);
		etText = (EditText) findViewById(R.id.et_text);
		btn = (Button) findViewById(R.id.btn);
		//注册监听
		btn.setOnClickListener(new MyBtnOnClickListener());
	}

	/**
	 * MainActivity的内部类
	 */
	class MyBtnOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			System.out.println("按钮被我点击了！");
			
			String num = etNum.getText().toString();
			String text = etText.getText().toString().trim();
			//判断用户输入的手机号或者短信是否为空
			if (TextUtils.isEmpty(num) || TextUtils.isEmpty(text)) {
				//  MainActivity.this ： MainActivity的对象
				
//				Toast.makeText(MainActivity.this, "手机号码或者短信内容不能为空！！！！！", Toast.LENGTH_SHORT).show();
				Toast.makeText(MainActivity.this, "手机号码或者短信内容不能为空！！！！！", 0).show();
				return;
			}
			//短信管理器
			SmsManager sm = SmsManager.getDefault();
			/*
			 * destinationAddress:接受短信的电话号码
			 * scAddress		  ：null
			 * text				 :短信的内容
			 * sentIntent		  ：短信发送成功报告
			 * deliveryIntent	  ：对方接受成功
			 */
			sm.sendTextMessage(num, null, text, null, null);
			
			
		}

		
	}
	
}
