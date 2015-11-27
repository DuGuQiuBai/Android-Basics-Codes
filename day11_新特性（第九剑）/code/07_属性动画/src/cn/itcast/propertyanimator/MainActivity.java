package cn.itcast.propertyanimator;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv;
	private ObjectAnimator oa1;
	private ObjectAnimator oa2;
	private ObjectAnimator oa3;
	private ObjectAnimator oa5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "你点我呀", 0).show();
				
			}
		});
	}

	public void translate(View v){
//		//创建平移补间动画
//		TranslateAnimation ta = new TranslateAnimation(0, 100, 0, 0);
//		//设置动画播放时长
//		ta.setDuration(2000);
//		//设置动画停留在结束位置
//		ta.setFillAfter(true);
//		iv.startAnimation(ta);
		
		//创建属性动画师
		//arg0:指定播放动画的组件
		//arg1:要修改哪个属性的值
		//arg2:要修改的新的值
		
		oa1 = ObjectAnimator.ofFloat(iv, "translationX", 0, 70, 20, 120);
		oa1.setDuration(2000);
		oa1.setRepeatCount(1);
		oa1.setRepeatMode(ObjectAnimator.REVERSE);
		//开始播放属性动画
		oa1.start();
	}
	
	public void scale(View v){
		oa2 = ObjectAnimator.ofFloat(iv, "scaleY", 0.5f, 1.5f, 0.7f, 2);
		oa2.setDuration(2000);
		oa2.setRepeatCount(1);
		oa2.setRepeatMode(ObjectAnimator.REVERSE);
		//开始播放属性动画
		oa2.start();
	}

	public void alpha(View v){
		oa3 = ObjectAnimator.ofFloat(iv, "alpha", 0.3f, 0.7f, 0.4f, 1);
		oa3.setDuration(2000);
		oa3.setRepeatCount(1);
		oa3.setRepeatMode(ObjectAnimator.REVERSE);
		//开始播放属性动画
		oa3.start();
	}
	public void rotate(View v){
		oa5 = ObjectAnimator.ofFloat(iv, "rotationY", 0, 200, 45, 360);
		oa5.setDuration(2000);
		oa5.setRepeatCount(1);
		oa5.setRepeatMode(ObjectAnimator.REVERSE);
		//开始播放属性动画
		oa5.start();
	}
	public void fly(View v){
		//创建一个动画师集合
		AnimatorSet as = new AnimatorSet();
		//一个一个装逼一个一个飞
//		as.playSequentially(oa1, oa2, oa3, oa5);
		//一起装逼一起飞
		as.playTogether(oa1, oa2, oa3, oa5);
		//设置播放动画的对象
		as.setTarget(iv);
		as.start();
	}
	
	public void loadXml(View v){
		//加载xml定义的属性动画
		Animator at = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);
		at.setTarget(iv);
		at.start();
	}
}
