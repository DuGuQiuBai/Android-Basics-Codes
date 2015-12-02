package cn.itcast.jump;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //隐式跳转
    public void click1(View v){
    	//创建意图对象，隐式意图
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_CALL);
    	intent.setData(Uri.parse("tel:110"));
    	//启动新的Activity，也就是Activity的跳转
    	startActivity(intent);
    }
    
    /**
     * 显式启动SecondActivity
     * @param v
     */
    //显式跳转
    public void click2(View v){
    	//显式意图
    	Intent intent = new Intent();
    	//通过指定Activity类的字节码，指定要跳转到哪一个Activity
    	intent.setClass(this, SecondActivity.class);
    	startActivity(intent);
    }
    
    /**
     * 显式启动拨号器
     * @param v
     */
    public void click3(View v){
    	Intent intent = new Intent();
    	//指定要启动哪个应用中的哪个Activity
    	intent.setClassName("com.android.dialer", "com.android.dialer.DialtactsActivity");
    	startActivity(intent);
    	
    }
    /**
     * 隐式启动拨号器
     * @param v
     */
    public void click4(View v){
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_DIAL);
    	startActivity(intent);
    	
    }
    
    /**
     * 隐式启动SecondActivity
     * @param v
     */
    public void click5(View v){
    	Intent intent = new Intent();
    	intent.setAction("a.b.c");
//    	intent.setData(Uri.parse("itcast:hahaha"));
//    	intent.setType("aa/bb");
    	//setData和setType方法不能共存
    	intent.setDataAndType(Uri.parse("itcast:hahaha"), "aa/bb");
    	//这行代码写不写都可以,不写就默认匹配CATEGORY_DEFAULT
//    	intent.addCategory(Intent.CATEGORY_DEFAULT);
    	startActivity(intent);
    	
    }
    
    /**
     * 显式启动浏览器
     * @param v
     */
    public void click6(View v){
    	Intent intent = new Intent();
    	intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
    	startActivity(intent);
    	
    }
    /**
     * 隐式启动浏览器
     * @param v
     */
    public void click7(View v){
    	Intent intent = new Intent();
    	//如果有多个Activity与这个intent匹配，那么就会弹出选择对话框
    	intent.setAction(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http:www.baidu.com"));
    	startActivity(intent);
    	
    }
}
