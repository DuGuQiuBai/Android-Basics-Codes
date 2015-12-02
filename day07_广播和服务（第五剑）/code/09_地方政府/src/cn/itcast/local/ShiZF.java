package cn.itcast.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShiZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String order = getResultData();
		System.out.println("市政府收到文件：" + order);
		//无序广播无法拦截
		abortBroadcast();
	}

}
