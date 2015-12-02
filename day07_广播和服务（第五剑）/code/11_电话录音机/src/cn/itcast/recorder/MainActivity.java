package cn.itcast.recorder;

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
    	//Æô¶¯Â¼Òô·þÎñ
    	Intent intent = new Intent(this, RecorderService.class);
    	startService(intent);
    }
    
}
