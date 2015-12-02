package cn.itcast.packagelistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class PackageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//判断接收到的是神马广播
		String action = intent.getAction();
		//获取应用的包名
		Uri uri = intent.getData();
		if(Intent.ACTION_PACKAGE_ADDED.equals(action)){
			Toast.makeText(context, uri.toString() + "安装了", 0).show();
		}
		else if(Intent.ACTION_PACKAGE_REPLACED.equals(action)){
			Toast.makeText(context, uri.toString() + "更新了", 0).show();
		}
		else if(Intent.ACTION_PACKAGE_REMOVED.equals(action)){
			Toast.makeText(context, uri.toString() + "卸载了", 0).show();
		}

	}

}
