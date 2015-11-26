package cn.itcast.loadbitmap;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click(View v){
		Options opt = new Options();
		//不解析像素信息，只解析图片宽高
		opt.inJustDecodeBounds = true;
		//不再解析像素信息，就不需要申请内存
		BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		
		//获取图片宽高
		int imageWidth = opt.outWidth;
		int imageHeight = opt.outHeight;
		
		//获取屏幕宽高
		Display dp = getWindowManager().getDefaultDisplay();
		int screenWidth = dp.getWidth();
		int screenHeight = dp.getHeight();
		
		//计算缩放比例
		int widthScale = imageWidth / screenWidth;
		int heightScale = imageHeight / screenHeight;
		
		//最终使用的缩放比例
		int scale = 1;
		if(widthScale >= heightScale && widthScale > 1){
			scale = widthScale;
		}
		else if(widthScale < heightScale && heightScale > 1){
			scale = heightScale;
		}	
		
		opt.inSampleSize = scale;
		opt.inJustDecodeBounds = false;
		//先缩小，再加载
		Bitmap bm = BitmapFactory.decodeFile("sdcard/dog.jpg", opt);
		
		ImageView iv = (ImageView) findViewById(R.id.iv);
		iv.setImageBitmap(bm);
	}

}
