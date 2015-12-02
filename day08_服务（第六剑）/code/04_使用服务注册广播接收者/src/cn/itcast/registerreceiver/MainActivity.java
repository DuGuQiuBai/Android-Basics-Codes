package cn.itcast.registerreceiver;

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


    public void click1(View v){
    	Intent intent = new Intent(this, RegisterService.class);
    	startService(intent);
    }
    public void click2(View v){
    	Intent intent = new Intent(this, RegisterService.class);
    	stopService(intent);
    }
    
}
