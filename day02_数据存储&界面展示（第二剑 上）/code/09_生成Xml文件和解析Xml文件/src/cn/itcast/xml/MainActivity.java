package cn.itcast.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private EditText etName;
	private EditText etNum;
	private RadioGroup rgSex;
	private TextView tvContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 找到关心的控件
		etName = (EditText) findViewById(R.id.et_name);
		etNum = (EditText) findViewById(R.id.et_num);
		rgSex = (RadioGroup) findViewById(R.id.rg_sex);
		tvContent = (TextView) findViewById(R.id.tv_content);

		readXmlData();
	}

	/**
	 * 解析Xml文件
	 */
	public void readXmlData() {
		try {
			// 1. 初始化Xml解析器
			XmlPullParser parser = Xml.newPullParser();
			// 2. 设置参数
			InputStream is = this.getAssets().open("student.xml");
			parser.setInput(is, "utf-8");
			// 3. 解析数据
			int type = parser.getEventType();
			String name = null;
			String num = null;
			String sex = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				// 获取标签名字
				String tag = parser.getName();
				switch (type) {
				case XmlPullParser.START_TAG:// 开始标签
					if ("name".equals(tag)) {// 名字
						name = parser.getText();
						Log.e(TAG, name);
					} else if ("num".equals(tag)) {// 学号
						num = parser.nextText();
						Log.e(TAG, num);
					} else if ("sex".equals(tag)) {// 性别
						sex = parser.nextText();
						Log.e(TAG, sex);
					}
					break;

				default:
					break;
				}

				// 拿到当前的事件
				type = parser.next();
			}
			is.close();
			
			tvContent.setText("姓名:"+name+" 学号:"+num+"性别："+sex);
			Toast.makeText(this, "读取成功！", 0).show();
		} catch (Exception e) {
			Toast.makeText(this, "读取失败！", 0).show();
			e.printStackTrace();
		}
	}

	/**
	 * 点击按钮生成Xml文件
	 * 
	 * @param v
	 */
	public void create(View v) {
		String name = etName.getText().toString().trim();
		String num = etNum.getText().toString().trim();
		if (TextUtils.isEmpty(name) || TextUtils.isEmpty(num)) {
			Toast.makeText(this, "姓名或者学号不能为空！", MODE_PRIVATE).show();
			return;
		}
		// 生成Xml文件
		try {
			// 1. 初始化Xml序列化器
			XmlSerializer serializer = Xml.newSerializer();
			// 2. 设置参数，编码
			FileOutputStream fos = this.openFileOutput("student.xml", 0);
			serializer.setOutput(fos, "utf-8");
			// 3. 生成Xml文件
			serializer.startDocument("utf-8", true);

			serializer.startTag(null, "stu");

			// 名字
			serializer.startTag(null, "name");
			serializer.text(name);
			serializer.endTag(null, "name");

			// 学号
			serializer.startTag(null, "num");
			serializer.text(num);
			serializer.endTag(null, "num");

			// 性别
			String sex = "妖";
			int id = rgSex.getCheckedRadioButtonId();
			switch (id) {
			case R.id.rb_boy:// 男
				sex = "男";
				break;
			case R.id.rb_girl:// 女
				sex = "女";
				break;
			case R.id.rb_yao:// 妖
				sex = "妖";
				break;
			default:
				break;
			}
			serializer.startTag(null, "sex");
			serializer.text(sex);
			serializer.endTag(null, "sex");

			serializer.endTag(null, "stu");
			serializer.endDocument();
			fos.close();
			Toast.makeText(this, "生成Xml文件succ", 0).show();
		} catch (Exception e) {
			Toast.makeText(this, "生成Xml文件失败", 0).show();
			e.printStackTrace();
		}

	}

}
