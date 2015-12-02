package cn.itcast.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CallReceiver extends BroadcastReceiver {

	//收到广播时，就会调用
	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("收到打电话广播");
		//从广播中取出拨打的号码
		String phone = getResultData();
		
		phone = "17951" + phone;
		
		//把修改后的电话号码，存入广播中
		setResultData(phone);
		//拦截无效，因为打电话应用的接收者是电话广播的最终接收者
		//abortBroadcast();
	}

}
