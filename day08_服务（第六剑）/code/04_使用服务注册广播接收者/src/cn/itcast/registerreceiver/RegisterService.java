package cn.itcast.registerreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class RegisterService extends Service {

	private ScreenOffOnReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	//注册广播接收者
	@Override
	public void onCreate() {
		super.onCreate();
		receiver = new ScreenOffOnReceiver();
		//创建意图过滤器对象
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		
		//注册
		registerReceiver(receiver, filter);
		
	}
	
	//解除注册
	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}
}
