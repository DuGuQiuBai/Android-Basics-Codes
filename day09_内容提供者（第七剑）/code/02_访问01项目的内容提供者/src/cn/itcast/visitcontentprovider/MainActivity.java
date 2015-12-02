package cn.itcast.visitcontentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void insert(View v){
    	//通过内容提供者，往01项目的私有数据库插入数据
    	
    	//获取ContentResolver
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues values = new ContentValues();
//    	values.put("name", "鹏飞");
//    	values.put("money", "13000");
//    	//这个insert方法会去访问内容提供者的insert方法
//    	cr.insert(Uri.parse("content://cn.itcast.person/person"), values);
    	
    	//清除values的内容
    	values.clear();
    	values.put("name", "侃爷");
    	cr.insert(Uri.parse("content://cn.itcast.person/handsome"), values);
    }
    
    public void delete(View v){
    	//获取ContentResolver
    	ContentResolver cr = getContentResolver();
    	int i = cr.delete(Uri.parse("content://cn.itcast.person"), "name = ?", new String[]{"老兵"});
    	System.out.println(i);
    }
    
    public void update(View v){
    	//获取ContentResolver
    	ContentResolver cr = getContentResolver();
    	ContentValues values = new ContentValues();
    	values.put("money", 13200);
    	int i = cr.update(Uri.parse("content://cn.itcast.person"), values, "name = ?", new String[]{"耘赫"});
    	System.out.println(i);
    }
    
    public void query(View v){
    	//获取ContentResolver
    	ContentResolver cr = getContentResolver();
    	Cursor cursor = cr.query(Uri.parse("content://cn.itcast.person/person"), new String[]{"money", "name"}, null, null, null);
    	
    	while(cursor.moveToNext()){
    		String name = cursor.getString(cursor.getColumnIndex("name"));
    		String money = cursor.getString(cursor.getColumnIndex("money"));
    		
    		System.out.println(name + ":" + money);
    	}
    }
    public void querySingle(View v){
    	ContentResolver cr = getContentResolver();
    	Cursor cursor = cr.query(Uri.parse("content://cn.itcast.person/person/4"), null, null, null, null);
    	if(cursor.moveToFirst()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String money = cursor.getString(cursor.getColumnIndex("money"));
			
			System.out.println(name + ":" + money);
		}
    }
}
