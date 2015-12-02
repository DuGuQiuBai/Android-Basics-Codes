package cn.itcast.service;

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


    public void start(View v){
    	//创建意图对象
    	Intent intent = new Intent(this, MyService.class);
    	//启动服务  
    	startService(intent);
    }
    
    public void stop(View v){
    	//创建意图对象
    	Intent intent = new Intent(this, MyService.class);
    	//启动服务  
    	stopService(intent);
    }
    
}
