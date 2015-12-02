package cn.itcast.sbzhangyao;

import cn.itcast.alipay.PayInterface;
import cn.itcast.alipay.PayInterface.Stub;
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

	PayInterface pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = new Intent();
    	intent.setAction("cn.itcast.alipay");
    	bindService(intent, new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				pi = Stub.asInterface(service);
				
			}
		}, BIND_AUTO_CREATE);
    }
    
    


    public void click(View v){
    	try {
			pi.pay();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
