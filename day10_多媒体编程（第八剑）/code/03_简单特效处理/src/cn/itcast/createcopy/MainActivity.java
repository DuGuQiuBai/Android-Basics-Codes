package cn.itcast.createcopy;

import cn.itcast.matrix.R;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//加载图片，此对象是只读的
		Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/photo3.jpg");
		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		iv_src.setImageBitmap(bmSrc);
		
		//创建图片的副本
		//1.创建一个与原图大小一致的拷贝，相当于创建了一张与原图大小一致的白纸
		Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
		
		//2.创建画笔
		Paint paint = new Paint();
		
		//3.创建画板，然后把白纸铺在画板上
		Canvas canvas = new Canvas(bmCopy);
		
		Matrix matrix = new Matrix();
		//平移效果
		matrix.setTranslate(10, 20);
		
		//缩放效果
		matrix.setScale(0.5f, 2);
		//指定缩放中心点
		matrix.setScale(0.5f, 2, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
		
		//旋转效果
		matrix.setRotate(45);
		matrix.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
		
		//镜面效果
		matrix.setScale(-1, 1);
		matrix.postTranslate(bmCopy.getWidth(), 0);
		
		//倒影效果
		matrix.setScale(1, -1);
		matrix.postTranslate(0, bmCopy.getHeight());
		
		//4.开始作画
		canvas.drawBitmap(bmSrc, matrix, paint);
		ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		
		iv_copy.setImageBitmap(bmCopy);
	}


}
