package cn.itcast.lifecycle;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        System.out.println("二create");
    }

    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	System.out.println("二start");
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	System.out.println("二resume");
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	System.out.println("二pause");
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	System.out.println("二stop");
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	System.out.println("二destroy");
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	System.out.println("二restart");
    }
}
