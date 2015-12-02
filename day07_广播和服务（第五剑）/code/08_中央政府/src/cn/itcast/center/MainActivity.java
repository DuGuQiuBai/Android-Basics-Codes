package cn.itcast.center;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v){
    	//1.创建意图
    	Intent intent = new Intent();
    	//2.设置action
    	intent.setAction("cn.itcast.fdm");
    	
    	//3.发送有序广播
    	//resultReceiver:结果接收者:这个广播接收者，会在所有接收者都接收到广播之后，才接收广播，并且一定会接收到
    	sendOrderedBroadcast(intent, null, new MyReceiver(), null, 
    			0, "每人发100斤大米", null);//这三个参数都是用来封装传递数据的
    }
    
    class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			String order = getResultData();
			System.out.println("反贪局收到文件：" + order);
			
		}
    	
    }
    
}
