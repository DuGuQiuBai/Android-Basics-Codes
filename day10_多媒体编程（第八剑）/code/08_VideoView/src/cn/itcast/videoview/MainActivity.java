package cn.itcast.videoview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.VideoView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		VideoView vv = (VideoView) findViewById(R.id.vv);
		vv.setVideoPath("sdcard/2.3gp");
		vv.start();
	}


}
