package cn.itcast.musicplayer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

public class MusicService extends Service {

	//多媒体播放器类
	MediaPlayer player;
	private Timer timer;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MusicController();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		player = new MediaPlayer();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		player.stop();
		player.release();
		
		if(timer != null){
			//停止刷新进度
			timer.cancel();
			timer = null;
		}
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

		@Override
		public void continuePlay() {
			MusicService.this.continuePlay();
			
		}

		@Override
		public void seekTo(int progress) {
			MusicService.this.seekTo(progress);
			
		}

	}
	
	public void play(){
		//进入空闲状态
		player.reset();
		try {
			//加载要播放的音乐
			player.setDataSource("sdcard/zxmzf.mp3");
//			player.setDataSource("http://192.168.1.100:8080/bzj.mp3");
			//同步准备
//			player.prepare();
			//异步准备
			player.prepareAsync();
			player.setOnPreparedListener(new OnPreparedListener() {
				
				//异步准备完成时，此方法调用
				@Override
				public void onPrepared(MediaPlayer mp) {
					player.start();
					addTimer();
				}
			});
//			player.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void pause(){
		player.pause();
	}
	public void continuePlay(){
		player.start();
	}
	
	public void seekTo(int progress){
		player.seekTo(progress);
	}
	
	public void addTimer(){
		if(timer == null){
			timer = new Timer();
			timer.schedule(new TimerTask() {
				//run方法是在子线程中执行的
				@Override
				public void run() {
					//获取音频文件的总时长
					int duration = player.getDuration();
					//获取当前播放进度
					int currentPosition = player.getCurrentPosition();
					
					//创建消息
					Message msg = MainActivity.handler.obtainMessage();
					//把播放进度封装至消息中
					Bundle data = new Bundle();
					data.putInt("duration", duration);
					data.putInt("currentPosition", currentPosition);
					msg.setData(data);
					//发送消息
					MainActivity.handler.sendMessage(msg);
					
				}
				//5毫秒后执行run方法，并且每500毫秒执行一次run方法
			}, 5, 500);
		}
	}
}
