package cn.itcast.transmitdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
    	EditText et_maleName = (EditText) findViewById(R.id.et_malename);
    	EditText et_femaleName = (EditText) findViewById(R.id.et_femalename);
    	
    	String maleName = et_maleName.getText().toString();
    	String femaleName = et_femaleName.getText().toString();
    	
    	Intent intent = new Intent(this, SecondActivity.class);
    	
    	//把数据封装至意图对象中
    	//可以封装数据类型，八大基本、String、bundle对象、实现了序列化接口的对象
//    	intent.putExtra("maleName", maleName);
//    	intent.putExtra("femaleName", femaleName);
    	
    	//bundle是Android中用来封装数据的一个api
    	//bundle能封装的数据类型与intent一样
    	Bundle bundle = new Bundle();
    	bundle.putString("maleName", maleName);
    	bundle.putString("femaleName", femaleName);
    	
    	//把bundle放入意图中
    	intent.putExtras(bundle);
    	startActivity(intent);
    }
    
}
