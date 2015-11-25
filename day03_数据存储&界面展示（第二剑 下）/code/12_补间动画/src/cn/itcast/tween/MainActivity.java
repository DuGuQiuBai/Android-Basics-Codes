package cn.itcast.tween;

import android.app.Activity;
import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.iv_fly);
	}

	/**
	 * 透明度动画
	 * 
	 * @param v
	 */
	public void alpha(View v) {
		/*
		 * 第一个参数fromAlpha：动画起始时的透明度， 第二个参数toAlpha： 动画结束时的透明度。
		 */
		Animation alpha = new AlphaAnimation(1f, 0.1f);

		// 设置显示时间长度
		alpha.setDuration(2000);
		// 设置重复次数
		alpha.setRepeatCount(2);
		// 设置动画重复的模式
		alpha.setRepeatMode(Animation.REVERSE);

		// 在ImageView上播放动画
		iv.startAnimation(alpha);

	}

	/**
	 * 缩放动画
	 * 
	 * @param v
	 */
	public void scale(View v) {

		/*
		 * 参数1：x方向起始大小(1f表示原图大小) 参数2：x方向终止大小(0.2f表示原图的0.2倍)
		 * 参数3：y方向起始大小(1f表示原图大小) 参数4：y方向终止大小(0.2f表示原图的0.2倍) 参数5：缩放中心点x轴取值的参照方式
		 * 参数6: 中心点x轴的取值(0.5f表示相对与原图的0.5倍) 参数7：缩放中心点y轴取值参照方式 参数8:
		 * 中心点y轴的取值(0.5f表示相对与原图的0.5倍)
		 */
		ScaleAnimation rotate = new ScaleAnimation(4f, 0.2f, 4f, 0.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// 设置显示时间长度
		rotate.setDuration(2000);
		// 设置重复次数
		rotate.setRepeatCount(2);
		// 设置动画重复的模式
		rotate.setRepeatMode(Animation.REVERSE);

		// 在ImageView上播放动画
		iv.startAnimation(rotate);
	}

	/**
	 * 旋转动画
	 * 
	 * @param v
	 */
	public void rotate(View v) {

		/*
		 * 参数1：旋转的起始角度 参数2：旋转的终止角度 参数3：旋转中心的x轴取值参照方式
		 * 参数4：中心点x轴的取值(0.5f表示相对与原图的0.5倍) 参数5：旋转中心的y轴取值参照方式
		 * 参数6：中心点y轴的取值(0.5f表示相对与原图的0.5倍)
		 */
		RotateAnimation rotate = new RotateAnimation(360, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// 设置显示时间长度
		rotate.setDuration(2000);
		// 设置重复次数
		rotate.setRepeatCount(2);
		// 设置动画重复的模式
		rotate.setRepeatMode(Animation.REVERSE);

		// 在ImageView上播放动画
		iv.startAnimation(rotate);

	}

	/**
	 * 位移动画
	 * 
	 * @param v
	 */
	public void translate(View v) {

		/*
		 * 参数1,参数3，参数5，参数7： 设置参照点的方式（相对自己）Animation.RELATIVE_TO_SELF
		 * 参数2：x轴起始移动的位置 (0表示原图位置左上角x轴的坐标) 参数4：x轴停止移动的位置（2表示移动原图宽度的两倍）
		 * 参数6：y轴起始移动的位置 (0表示原图位置左上角y轴的坐标) 参数8：y轴停止移动的位置（2表示移动原图高度的两倍）
		 */
		TranslateAnimation tras = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2,
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);
		// 设置显示时间长度
		tras.setDuration(2000);
		// 设置重复次数
		tras.setRepeatCount(2);
		// 设置动画重复的模式
		tras.setRepeatMode(Animation.REVERSE);

		// 在ImageView上播放动画
		iv.startAnimation(tras);
	}
	
	public void mahang (View view){
		AnimationSet set = new AnimationSet(false);
		
		TranslateAnimation tras = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2,
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 2);
		// 设置显示时间长度
		tras.setDuration(2000);
		// 设置重复次数
		tras.setRepeatCount(2);
		// 设置动画重复的模式
		tras.setRepeatMode(Animation.REVERSE);
		
		RotateAnimation rotate = new RotateAnimation(360, 0,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// 设置显示时间长度
		rotate.setDuration(2000);
		// 设置重复次数
		rotate.setRepeatCount(2);
		// 设置动画重复的模式
		rotate.setRepeatMode(Animation.REVERSE);

		
		
		ScaleAnimation scale = new ScaleAnimation(4f, 0.2f, 4f, 0.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);

		// 设置显示时间长度
		scale.setDuration(2000);
		// 设置重复次数
		scale.setRepeatCount(2);
		// 设置动画重复的模式
		scale.setRepeatMode(Animation.REVERSE);

		
		Animation alpha = new AlphaAnimation(1f, 0.1f);

		// 设置显示时间长度
		alpha.setDuration(2000);
		// 设置重复次数
		alpha.setRepeatCount(2);
		// 设置动画重复的模式
		alpha.setRepeatMode(Animation.REVERSE);
		
		set.addAnimation(tras);
		set.addAnimation(alpha);
		set.addAnimation(rotate);
		set.addAnimation(scale);
		
		// 在ImageView上播放动画
		iv.startAnimation(set);

	}
}
