package cn.itcast.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
			
	}

	
	public void zuse(View v){
		new Thread(){
			public void run() {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("子线中UI界面");
			};
		}.start();
		
		System.out.println("修改UI界面");
	}
}
