package cn.itcast.tweenanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;
	private TranslateAnimation ta;
	private ScaleAnimation sa;
	private AlphaAnimation aa;
	private RotateAnimation ra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
	}

	//平移效果
	public void translate(View v){
		//创建平移补间动画
//		TranslateAnimation ta = new TranslateAnimation(-100, 100, -50, 50);
		
		ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -3, Animation.RELATIVE_TO_SELF, 3, 
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
		//设置动画播放时长
		ta.setDuration(2000);
		//设置重复播放次数
		ta.setRepeatCount(1);
		//设置重复播放模式
		ta.setRepeatMode(Animation.REVERSE);
		//设置动画停留在结束位置
		ta.setFillAfter(true);
		
		iv.startAnimation(ta);
	}

	public void scale(View v){
//		ScaleAnimation sa = new ScaleAnimation(1, 2, 1, 0.5f);
//		ScaleAnimation sa = new ScaleAnimation(1, 2, 1, 0.5f, iv.getWidth() / 2, iv.getHeight() / 2);
		
		sa = new ScaleAnimation(1, 2, 2, 0.5f, 
				//0.5 * 自己的宽度，等同于 iv.getWidth() / 2
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(1);
		sa.setRepeatMode(Animation.REVERSE);
		sa.setFillAfter(true);
		
		iv.startAnimation(sa);
	}
	
	public void alpha(View v){
		//0全透明，1全不透明
		
		aa = new AlphaAnimation(0.2f, 1);
		aa.setDuration(2000);
		aa.setRepeatCount(1);
		aa.setRepeatMode(Animation.REVERSE);
		
		iv.startAnimation(aa);
	}
	
	public void rotate(View v){
//		RotateAnimation ra = new RotateAnimation(0, 360);
		
		ra = new RotateAnimation(0, 360, 
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		
		ra.setDuration(2000);
		ra.setRepeatCount(1);
		ra.setRepeatMode(Animation.REVERSE);
		
		iv.startAnimation(ra);
	}
	
	public void fly(View v){
		//创建一个动画集合
		AnimationSet as = new AnimationSet(false);
		//把动画添加到集合中
		as.addAnimation(ta);
		as.addAnimation(sa);
		as.addAnimation(aa);
		as.addAnimation(ra);
		
		iv.startAnimation(as);
	}
}
