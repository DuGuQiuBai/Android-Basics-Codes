package cn.itcast.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShengZF extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String order = getResultData();
		System.out.println("省政府收到文件：" + order);
		//无序广播不能修改内容
		setResultData("每人发80斤大米");

	}

}
