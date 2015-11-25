package cn.itcast.citynews;

import java.util.List;

import org.w3c.dom.Text;

import com.loopj.android.image.SmartImageView;

import cn.itcast.citynews.bean.NewsBean;
import cn.itcast.citynews.net.NetUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected static final int MSG_ERR = 0;
	protected static final int MSG_SUCC = 1;

	// 从服务器端拿到的新闻条目的集合
	private List<NewsBean> newsList;
	private ListView lvNews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 2. 在MainActivity中找到ListView
		lvNews = (ListView) findViewById(R.id.lv_news);
		//从网络获取数据
		initData();
	}

	/**
	 * // 4. 采用内部类的方式去写
	 */
	private class NewsAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return newsList == null ? 0 : newsList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(MainActivity.this,
						R.layout.adapter_news_item, null);
			}
			TextView title = (TextView) convertView.findViewById(R.id.tv_title);
			TextView des = (TextView) convertView.findViewById(R.id.tv_des);
			TextView comment = (TextView) convertView
					.findViewById(R.id.tv_comment);
			// 显示新闻条目的数据
			NewsBean bean = newsList.get(position);
			title.setText(bean.getTitle());
			des.setText(bean.getDes());
			comment.setText(bean.getComment());

			// 显示图片
			SmartImageView iv = (SmartImageView) convertView.findViewById(R.id.iv_news_pic);
			iv.setImageUrl(bean.getImage(),R.drawable.err);
			
			return convertView;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}
	}

	// 2.在主线程（Activity）中写一个Handler
	private Handler mHandler = new Handler() {
		// 3.在handlmessage方法中修改UI
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SUCC:// 成功
				// 给listView设置数据适配器
				lvNews.setAdapter(new NewsAdapter());
				break;
			case MSG_ERR:// 失败
				Toast.makeText(MainActivity.this, "哥，失败low！！", 0).show();
				break;

			default:
				break;
			}
		};
	};

	/**
	 * 在子线程中访问网络
	 */
	public void initData() {
		new Thread() {
			public void run() {
				newsList = NetUtils.requestNetWorkData(MainActivity.this);
				if (newsList == null) {
					// 1.写一个子线程发送消息
					Message msg = Message.obtain();
					msg.what = MSG_ERR;
					mHandler.sendMessage(msg);

				} else {
					// 1.写一个子线程发送消息
					Message msg = Message.obtain();
					msg.what = MSG_SUCC;
					mHandler.sendMessage(msg);
				}
			}
		}.start();
	}

}
