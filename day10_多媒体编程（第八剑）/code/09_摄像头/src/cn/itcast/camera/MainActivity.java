package cn.itcast.camera;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void click1(View v){
		//启动系统自带的拍照程序
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		//指定照片保存路径
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("sdcard/haha.jpg")));
		
		startActivityForResult(intent, 10);
	}
	
	public void click2(View v){
		//启动系统自带的摄像程序
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		//指定视频保存路径
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("sdcard/haha.3gp")));
		//指定摄像质量
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		startActivityForResult(intent, 20);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 10){
			Toast.makeText(this, "拍照成功", 0).show();
		}
		else if(requestCode == 20){
			Toast.makeText(this, "摄像成功", 0).show();
		}
	}

}
