package cn.itcast.musicplayer;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	MusicControllerInterface mi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = new Intent(this, MusicService.class);
        
        //为了让进程变成服务进程
        startService(intent);
        //为了拿到中间人对象
        bindService(intent, new MyConnection(), BIND_AUTO_CREATE);
    }

    class MyConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mi = (MusicControllerInterface) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
    	
    }

    public void play(View v){
    	mi.play();
    }
    
    public void pause(View v){
    	mi.pause();
    }
    
}
