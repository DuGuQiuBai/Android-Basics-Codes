package cn.itcast.seconds;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("MainActivity所在线程："
				+ Thread.currentThread().getName());

		tvMM = (TextView) findViewById(R.id.tv_mm);
	}
	// 2.在主线程（Activity）中写一个Handler
	private Handler mHandler = new Handler() {
		// 3.在handlmessage方法中修改UI
				@Override
				public void handleMessage(Message msg) {
					super.handleMessage(msg);
					int i = (Integer) msg.obj;
					// 在handleMessage中修改UI
					tvMM.setText(String.valueOf(i));
				}
	};
	
	private void zixianchengzhognfangfa() {
		System.out
				.println("开启的子线程：" + Thread.currentThread().getName());

		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Message msg = new Message();
			msg.obj = i;
			mHandler.sendMessage(msg);
		}
	};
	
	private TextView tvMM;
	public void start(View v) {
		// 1.写一个子线程发送消息
		new Thread() {
			public void run() {
				
				zixianchengzhognfangfa();
			}
		}.start();

	}
}
