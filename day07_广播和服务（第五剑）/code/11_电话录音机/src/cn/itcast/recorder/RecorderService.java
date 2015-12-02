package cn.itcast.recorder;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
public class RecorderService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		//1.获取电话管理器
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		//2.监听电话状态
		//arg0:电话侦听器
		//arg1：电话侦听器能侦听的状态很多，指定只侦听电话状态改变
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
		
	}
	
	class MyListener extends PhoneStateListener{

		private MediaRecorder recorder;

		//当电话状态改变时，此方法调用
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			
			switch (state) {
			//空闲状态
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("空闲");
				if(recorder != null){
					//停止录音
					recorder.stop();
					//释放资源
					recorder.release();
					recorder = null;
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("响铃");
				if(recorder == null){
					recorder = new MediaRecorder();
					//设置音频来源
					recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
					//设置输出格式
					recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					recorder.setOutputFile("sdcard/abc.3gp");
					//设置音频的编码
					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					try {
						recorder.prepare();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("摘机");
				if(recorder != null){
					recorder.start();
				}
				break;

			}
			
		}
		
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy(); 
	}

}
