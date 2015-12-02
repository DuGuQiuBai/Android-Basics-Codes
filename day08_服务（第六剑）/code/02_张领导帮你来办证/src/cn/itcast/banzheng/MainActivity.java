package cn.itcast.banzheng;

import cn.itcast.banzheng.LeaderService.WangMiShu;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	PublicBusiness ms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent= new Intent(this, LeaderService.class);
        bindService(intent, new MyConnection(), BIND_AUTO_CREATE);
    }

    class MyConnection implements ServiceConnection{
    	//服务连接建立时调用
    	//service:服务的onBind方法返回的中间人对象
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			ms = (PublicBusiness) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }

    public void click(View v){
    	ms.qianXian();
//    	ms.daMaJiang();
    }
    
}
