package cn.itcast.videoplayer;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MainActivity extends Activity {

	
	private MediaPlayer player;

	int currentPosition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		SurfaceView sv = (SurfaceView) findViewById(R.id.sv);
		//获取SurfaceView控制器
		final SurfaceHolder sh = sv.getHolder();
		
		//这些代码无效，因为SurfaceView不可见
//		player.reset();
//		try {
//			player.setDataSource("sdcard/2.3gp");
//			//设置视频播放在哪个界面上
//			player.setDisplay(sh);
//			player.prepare();
//			player.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Thread t = new Thread(){
//			@Override
//			public void run() {
//				try {
//					sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				//在主线程运行
//				runOnUiThread(new Runnable() {
//					@Override
//					public void run() {
//						player.reset();
//						try {
//							player.setDataSource("sdcard/2.3gp");
//							//设置视频播放在哪个界面上
//							player.setDisplay(sh);
//							player.prepare();
//							player.start();
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				});
//			}
//		};
//		t.start();
		
		sh.addCallback(new Callback() {
			//SurfaceView销毁时调用
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				if(player != null){
					currentPosition = player.getCurrentPosition();
					player.stop();
					player.release();
					player = null;
				}
			}
			
			//SurfaceView创建时调用
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				if(player == null){
					player = new MediaPlayer();
					player.reset();
					try {
						player.setDataSource("sdcard/2.3gp");
						//设置视频播放在哪个界面上
						player.setDisplay(sh);
						player.prepare();
						player.seekTo(currentPosition);
						player.start();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			//SurfaceView结构改变时调用
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				
			}
		});
	}


}
