package cn.itcast.createcopy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 1. 拿到原图
		Bitmap srcBmp = BitmapFactory.decodeFile("/sdcard/2015.jpg");
		// 2. 创建和原图一样样的空白纸张
		Bitmap copyBmp = srcBmp.createBitmap(srcBmp.getWidth(),
				srcBmp.getHeight(), srcBmp.getConfig());
		// 3. 把空白的纸张铺在画板上
		Canvas canvas = new Canvas(copyBmp);
		// 4. 创建画笔
		Paint paint = new Paint();
		// 5. 开始画画
		 Matrix matrix = new Matrix();
		 //平移
//		 matrix.setTranslate(100, 200);
		 //旋转
//		 matrix.setRotate(45);
//		 matrix.setRotate(45, copyBmp.getWidth()/2, copyBmp.getHeight()/2);
		 //缩放
//		 matrix.setScale(0.5f, 2,copyBmp.getWidth()/2, copyBmp.getHeight()/2);
		 //镜面
//		 matrix.setScale(-1, 1);
//		 matrix.postTranslate(copyBmp.getWidth(), 0);
		 //倒影
		 matrix.setScale(1, -0.5f);
		 matrix.postTranslate(0, copyBmp.getHeight());
		 
		canvas.drawBitmap(srcBmp,matrix, paint);

		ImageView ivCopy = (ImageView) findViewById(R.id.iv_copy);
		ivCopy.setImageBitmap(copyBmp);
		ImageView ivSrc = (ImageView) findViewById(R.id.iv_src);
		ivSrc.setImageBitmap(srcBmp);
	}

}
