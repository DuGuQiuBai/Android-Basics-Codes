package cn.itcast.launchmode;

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
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
    public void click2(View v){
    	Intent intent = new Intent(this, SecondActivity.class);
    	startActivity(intent);
    }
    
}
