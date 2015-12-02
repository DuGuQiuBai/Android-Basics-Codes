package cn.itcast.contentobserver;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //注册内容观察者
        ContentResolver resolver = getContentResolver();
        //arg0:接收哪个内容提供者发出的通知
        //arg1：true表示只要以content://sms开头的uri上改变的数据，都能收到通知；false：表示必须精确匹配，只有content://sms上的数据改变，才会收到通知
        resolver.registerContentObserver(Uri.parse("content://sms"), true, new MyObserver(new Handler()));
    }
    
    class MyObserver extends ContentObserver{

		public MyObserver(Handler handler) {
			super(handler);
			// TODO Auto-generated constructor stub
		}
		
		//收到数据库内容改变的通知时,此方法调用
		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			
			System.out.println("短信数据库内容改变");
		}
    	
    }


    
}
