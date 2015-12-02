package cn.itcast.getsms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import cn.itcast.getsms.domain.Sms;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Xml;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	List<Sms> smsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        smsList = new ArrayList<Sms>();
    }


    public void click(View v){
    	//通过内容提供者访问系统的短信数据库
    	
    	//获取ContentResolver
    	ContentResolver resolver = getContentResolver();
    	//获取短信
    	Cursor cursor = resolver.query(Uri.parse("content://sms"), new String[]{"address", "date", "type", "body"}, 
    			null, null, null);
    	while(cursor.moveToNext()){
    		String address = cursor.getString(0);
    		long date = cursor.getLong(1);
    		int type = cursor.getInt(2);
    		String body = cursor.getString(3);
    		
    		Sms sms = new Sms(address, date, type, body);
    		smsList.add(sms);
    	}
    }
    public void click2(View v){
    	//生成xml文件备份短信
    	XmlSerializer xs = Xml.newSerializer();
    	//设置保存路径
    	File file = new File("sdcard/sms.xml");
    	try {
			FileOutputStream fos = new FileOutputStream(file);
			
			xs.setOutput(fos, "utf-8");
			
			xs.startDocument("utf-8", true);
			xs.startTag(null, "smss");

			for (Sms sms : smsList) {
				xs.startTag(null, "sms");
				
				xs.startTag(null, "address");
				xs.text(sms.getAddress());
				xs.endTag(null, "address");
				
				xs.startTag(null, "date");
				xs.text(sms.getDate() + "");
				xs.endTag(null, "date");
				
				xs.startTag(null, "type");
				xs.text(sms.getType() + "");
				xs.endTag(null, "type");
				
				xs.startTag(null, "body");
				xs.text(sms.getBody());
				xs.endTag(null, "body");
				
				xs.endTag(null, "sms");
			}
			
			xs.endTag(null, "smss");
			xs.endDocument();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
