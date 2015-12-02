package cn.itcast.sdstatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SDReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		//判断收到的是什么广播
		String action = intent.getAction();
		if(Intent.ACTION_MEDIA_MOUNTED.equals(action)){
			Toast.makeText(context, "SD卡可用", 0).show();
		}
		else if(Intent.ACTION_MEDIA_UNMOUNTED.equals(action)){
			Toast.makeText(context, "SD卡不可用", 0).show();
		}
		else if(Intent.ACTION_MEDIA_REMOVED.equals(action)){
			Toast.makeText(context, "SD卡摔出来了", 0).show();
		}
	}

}
