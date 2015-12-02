package cn.itcast.sendcustombroadcast;

import android.os.Bundle;
import android.app.Activity;
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
    	//1.创建意图对象
    	Intent intent = new Intent();
    	//2.设置意图的action
    	intent.setAction("a.b.c");
    	//3.发送自定义无序广播
    	sendBroadcast(intent);
    	
    }
    
}
