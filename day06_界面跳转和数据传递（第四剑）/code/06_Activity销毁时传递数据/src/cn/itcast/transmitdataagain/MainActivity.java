package cn.itcast.transmitdataagain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	static final int CONTACTS_SELECT = 10;
	static final int SMS_SELECT = 20;
	static final int MASTER_SELECT = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    public void click(View v){
    	Intent intent = new Intent(this, ContactsActivity.class);
//    	startActivity(intent);
    	//为了结果去启动Activity，那么当ContactsActivity销毁时，系统才会调用onActivityResult
    	startActivityForResult(intent, CONTACTS_SELECT);
    }
    public void click2(View v){
    	Intent intent = new Intent(this, SmsActivity.class);
    	//为了结果去启动Activity，那么当ContactsActivity销毁时，系统才会调用onActivityResult
    	startActivityForResult(intent, SMS_SELECT);
    }
    public void click3(View v){
    	Intent intent = new Intent(this, MasterActivity.class);
    	//为了结果去启动Activity，那么当ContactsActivity销毁时，系统才会调用onActivityResult
    	startActivityForResult(intent, MASTER_SELECT);
    }
    
    //当某个Activity销毁时，把intent传递给MainActivity时，此方法调用
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	//requestCode:判断数据来自哪一个Activity
    	//resultCode:判断传递过来的数据属于什么类型
    	if(requestCode == CONTACTS_SELECT){
    		//从intent取出传递过来的数据
    		String name = data.getStringExtra("name");
    		EditText et_name = (EditText) findViewById(R.id.et_name);
    		//把数据回显至输入框
    		et_name.setText(name);
    	}
    	else if(requestCode == SMS_SELECT){
    		String content = data.getStringExtra("content");
    		EditText et_content = (EditText) findViewById(R.id.et_content);
    		//把数据回显至输入框
    		et_content.setText(content);
    	}
    	else if(requestCode == MASTER_SELECT){
    		if(resultCode == MasterActivity.MASTER_NAME){
    			String name = data.getStringExtra("name");
        		EditText et_name = (EditText) findViewById(R.id.et_name);
        		et_name.setText(name);
    		}
    		else if(resultCode == MasterActivity.MASTER_CONTENT){
    			String content = data.getStringExtra("content");
        		EditText et_content = (EditText) findViewById(R.id.et_content);
        		et_content.setText(content);
    		}
    	}
    }
}
