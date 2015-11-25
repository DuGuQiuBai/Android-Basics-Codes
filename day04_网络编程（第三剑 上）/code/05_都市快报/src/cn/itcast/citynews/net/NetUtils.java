package cn.itcast.citynews.net;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import android.content.Context;

import cn.itcast.citynews.R;
import cn.itcast.citynews.bean.NewsBean;
import cn.itcast.citynews.service.ParserXml;

/**
 * 访问网络
 * 
 */
public class NetUtils {

	/**
	 * 从服务器获取数据
	 * @param context
	 * 			上下文
	 * @return
	 * 			null:表示失败
	 */
	public static List<NewsBean> requestNetWorkData(Context context){
		String path = context.getString(R.string.serverip);
		try {
			// 1. 初始化Url
			URL url = new URL(path);
			// 2. 通过Url获取Http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 3. 设置请求参数和请求方式
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(3000);
			// 4. 获取返回码 200:成功 3xxx缓存 4xxx客户端错误 500服务器错误
			int code = conn.getResponseCode();
			if (code == 200) {
				// 5. 拿到从服务器端返回的输入流
				InputStream is = conn.getInputStream();
				//解析Xml文件
				return ParserXml.parserXmlFromStream(is);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
