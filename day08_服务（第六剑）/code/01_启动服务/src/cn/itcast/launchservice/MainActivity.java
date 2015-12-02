package cn.itcast.launchservice;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private MyConnection conn;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        conn = new MyConnection();
    }

    public void start(View v){
    	Intent intent = new Intent(this, MyService.class);
    	startService(intent);
    }
    public void stop(View v){
    	Intent intent = new Intent(this, MyService.class);
    	stopService(intent);
    }
    
    public void bind(View v){
    	Intent intent = new Intent(this, MyService.class);
    	//绑定服务,其实也是建立连接
    	bindService(intent, conn, BIND_AUTO_CREATE);
    }
    
    public void unbind(View v){
    	//解绑服务
    	unbindService(conn);
    }
    
    class MyConnection implements ServiceConnection{

    	//当服务连接被创建时调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
		}

		//当失去服务连接时调用
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
