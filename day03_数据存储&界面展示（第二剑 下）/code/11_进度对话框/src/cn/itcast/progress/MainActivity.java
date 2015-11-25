package cn.itcast.progress;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// commPd();

		final ProgressDialog pd = new ProgressDialog(this);
		pd.setTitle("进度对话框");
		pd.setMessage("服务器忙...");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.show();

		new Thread() {
			public void run() {

				for (int i = 1; i <= 100; i++) {
					try {
						sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					pd.setProgress(i);
				}
			};
		}.start();

	}

	private void commPd() {
		ProgressDialog pd = new ProgressDialog(this);
		pd.setTitle("进度对话框");
		pd.setMessage("服务器忙...");
		pd.show();
	}

}
