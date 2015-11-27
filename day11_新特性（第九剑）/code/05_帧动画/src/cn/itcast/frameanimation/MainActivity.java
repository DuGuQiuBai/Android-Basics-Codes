package cn.itcast.frameanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView rocketImage = (ImageView) findViewById(R.id.iv);
		//把帧动画的资源文件设为imageview的背景图片
		rocketImage.setBackgroundResource(R.drawable.frameanimation);
		//获取imageView的背景，把背景强转成动画Drawable
		AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
		//播放动画
		rocketAnimation.start();
	}


}
