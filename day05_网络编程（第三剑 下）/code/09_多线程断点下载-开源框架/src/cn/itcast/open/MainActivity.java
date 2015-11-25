package cn.itcast.open;

import java.io.File;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ProgressBar mPb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPb = (ProgressBar) findViewById(R.id.pb);
	}

	public void download(View v){
		String path = "http://192.168.1.253:8080/web/download/gui.exe";
		//初始化对象
		FinalHttp h = new FinalHttp();
		//下载文件
		h.download(path, "/mnt/sdcard/gui.exe", true,
				 new AjaxCallBack<File>() {
					//开始下载
					@Override
					public void onStart() {
						super.onStart();
						Toast.makeText(MainActivity.this, "哥，我开始工作了！", 0).show();
					}
					//现在的进度
					@Override
					public void onLoading(long count, long current) {
						super.onLoading(count, current);
						mPb.setMax((int)count);
						mPb.setProgress((int)current);
					}
					//下载成功
					@Override
					public void onSuccess(File t) {
						super.onSuccess(t);
						Toast.makeText(MainActivity.this, "哥，我干完活了！", 0).show();
					}
					//下载失败
					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						Toast.makeText(MainActivity.this, strMsg, 0).show();
					}
					
				});
	}
}
