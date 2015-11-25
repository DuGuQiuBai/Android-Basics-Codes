package cn.itcast.citynews.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import cn.itcast.citynews.bean.NewsBean;

/**
 * 解析xml文件的工具类
 */
public class ParserXml {

	/**
	 * 从输入流中解析Xml文件
	 * @param is
	 * 			输入流
	 * @return
	 * 			null:表示解析Xml文件出错
	 */
	public static List<NewsBean> parserXmlFromStream(InputStream is){
		List<NewsBean> newsList = new ArrayList<NewsBean>();
		try {
			// 1. 初始化Xml解析器
			XmlPullParser parser = Xml.newPullParser();
			// 2. 设置参数，编码
			parser.setInput(is, "utf-8");
			// 3. 解析数据
			int type = parser.getEventType();
			NewsBean bean = null;
			
			while(type != XmlPullParser.END_DOCUMENT){
				//开始或者结束标签
				String tag = parser.getName();
				switch (type) {
				case XmlPullParser.START_TAG://开始标签
					if("item".equals(tag)){			//每个新闻条目的开始标签
						bean  = new NewsBean();
					}else if("title".equals(tag)){	//新闻的标题
						String title = parser.nextText();
						bean.setTitle(title);
					}else if("des".equals(tag)){	//新闻的描述
						String des = parser.nextText();
						bean.setDes(des);
					}else if("image".equals(tag)){	//新闻的图片的Url
						String imageUrl = parser.nextText();
						bean.setImage(imageUrl);
					}else if("comment".equals(tag)){//新闻的评论
						String comment = parser.nextText();
						bean.setComment(comment);
					}
					break;
				case XmlPullParser.END_TAG://结束标签
					if("item".equals(tag)){			//每个新闻条目的结束标签
						newsList.add(bean);
					}
					break;

				default:
					break;
				}
				
				//拿到下一次事件
				type = parser.next();
			}
			
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
