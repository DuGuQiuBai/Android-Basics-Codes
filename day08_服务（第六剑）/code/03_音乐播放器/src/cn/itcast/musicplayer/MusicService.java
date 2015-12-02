package cn.itcast.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MusicController();
	}

	//把中间人中的方法抽取到接口中，然后实现这个接口
	class MusicController extends Binder implements MusicControllerInterface{
		@Override
		public void play(){
			//调用外部类的同名方法
			MusicService.this.play();
		}

		@Override
		public void pause() {
			MusicService.this.pause();
			
		}
	}
	
	public void play(){
		System.out.println("播放音乐了");
	}
	
	public void pause(){
		System.out.println("音乐播放暂停了");
	}
}
