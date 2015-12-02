package cn.itcast.smslanjie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {

	//intent:这个意图对象就是广播中携带的那个意图对象
	@Override
	public void onReceive(Context context, Intent intent) {
//		System.out.println("接收到短信广播");
		//获取短信
		Bundle bundle = intent.getExtras();
		//数组中的每一个元素，都是一条短信
		Object[] object = (Object[]) bundle.get("pdus");
		
		//把object短信转换成短信对象SmsMessage
		for (Object obj : object) {
			SmsMessage sms = SmsMessage.createFromPdu((byte[])obj);
			//获取短信地址
			String address = sms.getOriginatingAddress();
			//获取短信内容
			String body = sms.getMessageBody();
			System.out.println(address + ":" + body);
			if("138438".equals(address)){
				//拦截广播
				abortBroadcast();
			}
		}
	}

}
