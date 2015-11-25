package cn.itcast.frame;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {

	AnimationDrawable rocketAnimation;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView rocketImage = (ImageView) findViewById(R.id.rocket_image);
		rocketImage.setBackgroundResource(R.drawable.anim);
		rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			rocketAnimation.start();
			return true;
		}
		return super.onTouchEvent(event);
	}
}
