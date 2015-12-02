package cn.itcast.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	int blood = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("主create");
        blood = 1000000;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	System.out.println("主start");
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	System.out.println("主resume");
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	System.out.println("主pause");
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	System.out.println("主stop");
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	System.out.println("主destroy");
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	System.out.println("主restart");
    }
    
    public void click(View v){
    	Intent intent = new Intent(this, SecondActivity.class);
    	startActivity(intent);
    }
}
