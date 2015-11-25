package cn.itcast.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void qdqx(View v) {
		// 创建对话框对象
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 设置对话框的标题
		builder.setTitle("独孤9剑");
		builder.setMessage("欲练此功，跟我走吧！");

		// 取消按钮
		builder.setNegativeButton("我不学-取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "不跟着我走，后果自负！", 0).show();
			}
		});

		// 确定按钮
		builder.setPositiveButton("要要要-确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "我们天天都在练独孤9剑！！", 0).show();
			}
		});

		// 重要
		builder.show();

	}

	String sex;

	public void single(View v) {
		// 创建对话框对象
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 设置对话框的标题
		builder.setTitle("单选对话框！");

		final String[] items = new String[] { "男", "女", "妖", "未知" };
		builder.setSingleChoiceItems(items, 3, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				sex = items[which];
				dialog.dismiss();
				Toast.makeText(MainActivity.this, items[which], 0).show();
			}
		});

		builder.show();
	}

	public void mutil(View view) {
		// 创建对话框对象
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 设置对话框的标题
		builder.setTitle("多选对话框！");

		final String[] items = new String[] { "读书", "Android", "篮球", "旅", "独孤九剑" };
		final boolean[] checkedItems = new boolean[] { true, true, false,
				false, true };
		builder.setMultiChoiceItems(items, checkedItems,
				new OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						checkedItems[which] = isChecked;
						Toast.makeText(MainActivity.this,
								"是否勾选：" + checkedItems[which], 0).show();
					}
				});

		builder.setPositiveButton(

			"我喜欢",
			new OnClickListener() {
	
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < checkedItems.length; i++) {
						if (checkedItems[i]) {
							
							sb.append(" "+items[i]);
						}
					}
					
					Toast.makeText(MainActivity.this, sb.toString(), 0).show();
				}
			}

		);
		builder.show();
	}
}
