package cn.itcast.receivenotify;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.database.ContentObserver;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getContentResolver().registerContentObserver(Uri.parse("content://cn.itcast.person"), true, 
        		new ContentObserver(new Handler()) {
		        	@Override
		        	public void onChange(boolean selfChange) {
		        		// TODO Auto-generated method stub
		        		super.onChange(selfChange);
		        		System.out.println("01项目数据库内容改变");
		        	}
				});
    }


    
    
}
