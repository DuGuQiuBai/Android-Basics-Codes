package cn.itcast.registerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenOffOnReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if(Intent.ACTION_SCREEN_OFF.equals(action)){
			System.out.println("ÆÁÄ»¹Ø±Õ");
		}
		if(Intent.ACTION_SCREEN_ON.equals(action)){
			System.out.println("ÆÁÄ»´ò¿ª");
		}

	}

}
