package cn.itcast.getcontacts;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.getcontacts.domain.Contact;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	List<Contact> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        contactList = new ArrayList<Contact>();
    }


    public void click(View v){
    	//通过内容提供者获取联系人信息
    	ContentResolver resolver = getContentResolver();
    	Cursor cursor = resolver.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"contact_id"}, 
    			null, null, null);
    	while(cursor.moveToNext()){
    		//拿到联系人id
    		String contactId = cursor.getString(0);
    		
    		//拿着联系人id，去data表中把所有属于该联系人的信息取出来  
    		Cursor cursorData = resolver.query(Uri.parse("content://com.android.contacts/data"), new String[]{"data1", "mimetype"}, 
        			"raw_contact_id = ?", new String[]{contactId}, null);
    		
    		//获取所有字段的名字
//    		String[] names = cursorData.getColumnNames();
//    		for (String string : names) {
//				System.out.println(string);
//			}
    		
    		//创建javabean
    		Contact contact = new Contact();
    		while(cursorData.moveToNext()){
	    		String data = cursorData.getString(0);
	    		String mimetype = cursorData.getString(1);
	    		
	    		if("vnd.android.cursor.item/email_v2".equals(mimetype)){
	    			contact.setEmail(data);
	    		}
	    		else if("vnd.android.cursor.item/phone_v2".equals(mimetype)){
	    			contact.setPhone(data);
	    		}
	    		else if("vnd.android.cursor.item/name".equals(mimetype)){
	    			contact.setName(data);
	    		}
    		}
    		contactList.add(contact);
    	}
    	
    	
    	//打印,验证
    	for (Contact contact : contactList) {
			System.out.println(contact.toString());
		}
    }
    
}
