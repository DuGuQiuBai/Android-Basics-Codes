package cn.itcast.insertsms;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v){
    	//通过内容提供者插入短信至数据库
    	final ContentResolver resolver = getContentResolver();
    	final ContentValues values = new ContentValues();
    	
    	Thread t = new Thread(){
    		@Override
    		public void run() {
    			try {
					sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			values.put("address", "95555");
    	    	values.put("date", System.currentTimeMillis());
    	    	values.put("type", 1);
    	    	values.put("body", "您尾号为XXXX的招行储蓄卡收到转账1,000,000人民币");
    	    	resolver.insert(Uri.parse("content://sms"), values);
    		}
    	};
    	t.start();
    	
    }
}
