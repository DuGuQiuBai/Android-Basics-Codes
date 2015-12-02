package cn.itcast.launchremoteservice;

import cn.itcast.remoteservice.PublicBusiness;
import cn.itcast.remoteservice.PublicBusiness.Stub;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private MyConnection conn;
    PublicBusiness pb;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        conn = new MyConnection();
    }


    public void start(View v){
    	Intent intent = new Intent();
    	intent.setAction("a.b.c");
    	startService(intent);
    }
    public void stop(View v){
    	Intent intent = new Intent();
    	intent.setAction("a.b.c");
    	stopService(intent);
    }
    
    public void bind(View v){
    	Intent intent = new Intent();
    	intent.setAction("a.b.c");
    	bindService(intent, conn, BIND_AUTO_CREATE);
    }
    
    public void unbind(View v){
    	unbindService(conn);
    }
    
    class MyConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//把service强转成PublicBusiness
			pb = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
    	
    }
    
    public void click(View v){
    	try {
    		//调用服务的方法
			pb.qianXian();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
