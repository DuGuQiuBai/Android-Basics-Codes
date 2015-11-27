package cn.itcast.transmit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;

public class Fragment01 extends Fragment {

	//系统调用，返回一个View对象，作为Fragment的显示内容
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//把布局文件填充成View对象，return出去
		final View v = inflater.inflate(R.layout.fragment01, null);
		Button bt_fragment01 = (Button) v.findViewById(R.id.bt_fragment01);
		
		//设置按钮点击侦听
		bt_fragment01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				//获取用户输入数据
				EditText et = (EditText) v.findViewById(R.id.et_fragment01);
				String text = et.getText().toString();
				//传递给Activity
				//获取MainActivity的对象
				((MainActivity)getActivity()).setText(text);
			}
		});
		return v;
	}
}
