package cn.itcast.insertcontact;

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


    public void click(View v){
    	ContentResolver resolver = getContentResolver();
    	//插入联系人之前先查询raw_contacts,计算最新插入的联系人id应该是多少
    	Cursor cursor = resolver.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"_id"}, 
    			null, null, null);
    	int _id = 0;
    	//移动至最后一行
    	if(cursor.moveToLast()){
    		_id = cursor.getInt(0);
    	}
    	//计算最新联系人的id应该是多少
    	_id++;
    	
    	//先插入联系人id
    	ContentValues values = new ContentValues();
    	values.put("contact_id", _id);
    	resolver.insert(Uri.parse("content://com.android.contacts/raw_contacts"), values);
    	
    	values.clear();
    	values.put("raw_contact_id", _id);
    	values.put("mimetype", "vnd.android.cursor.item/name");
    	values.put("data1", "圣战者王卓");
    	//在data表中插入联系人信息
    	resolver.insert(Uri.parse("content://com.android.contacts/data"), values);
    	
    	values.clear();
    	values.put("raw_contact_id", _id);
    	values.put("mimetype", "vnd.android.cursor.item/phone_v2");
    	values.put("data1", "13444444");
    	//在data表中插入联系人信息
    	resolver.insert(Uri.parse("content://com.android.contacts/data"), values);
    }
    
}
