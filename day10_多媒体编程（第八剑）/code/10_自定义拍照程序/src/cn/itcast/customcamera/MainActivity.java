package cn.itcast.customcamera;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkCameraHardware(this)){
	        // 获取摄像头实例
	        mCamera = getCameraInstance();
	
	        // 创建预览界面的对象
	        mPreview = new CameraPreview(this, mCamera);
	        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
	        //把预览界面添加为帧布局的子节点
	        preview.addView(mPreview);
	        
	        //获取拍照按钮
	        Button captureButton = (Button) findViewById(R.id.button_capture);
	        //设置点击侦听
	        captureButton.setOnClickListener(
	            new View.OnClickListener() {
	                @Override
	                public void onClick(View v) {
	                	//自动对焦
	                	mCamera.autoFocus(new AutoFocusCallback(){

	                		//对焦完成时调用
							@Override
							public void onAutoFocus(boolean success,
									Camera camera) {
								//拍照
			                    mCamera.takePicture(null, null, mPicture);
							}
	                		
	                	});
	                    
	                }
	            }
	        );
        }
    }


	/** 检查手机是否有摄像头 */
	private boolean checkCameraHardware(Context context) {
	    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
	        // 手机有摄像头
	        return true;
	    } else {
	        // 没有摄像头
	        return false;
	    }
	}
	
	/** 一个安全的方式去获取一个摄像头的实例 */
	public static Camera getCameraInstance(){
	    Camera c = null;
	    try {
	        c = Camera.open(); // 获取后置摄像头实例
	    }
	    catch (Exception e){
	        // Camera is not available (in use or does not exist)
	    }
	    return c; // returns null if camera is unavailable
	}
	
	private PictureCallback mPicture = new PictureCallback() {

		//拍照完毕，此方法调用
		//data:照片的字节数组
	    @Override
	    public void onPictureTaken(byte[] data, Camera camera) {

	        File pictureFile = new File("sdcard/ohohoho.jpg");

	        try {
	            FileOutputStream fos = new FileOutputStream(pictureFile);
	            fos.write(data);
	            fos.close();
	        } catch (FileNotFoundException e) {
	            Log.d(CameraPreview.TAG, "File not found: " + e.getMessage());
	        } catch (IOException e) {
	            Log.d(CameraPreview.TAG, "Error accessing file: " + e.getMessage());
	        } finally{
	        	mCamera.startPreview();
	        }
	    }
	};

}
