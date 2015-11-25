package cn.itcast.qq;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 把流转化成 字符串工具类
 */
public class StreamUtils {

	/**
	 * 把流转成字符串
	 * @param is
	 * 		输入流
	 * @return
	 */
	public static String  parserStream2String(InputStream is){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte buffer[] = new byte[1024*8]; 
			int len = 0;
			while((len = is.read(buffer)) != -1){
				baos.write(buffer, 0, len);
			}
			String text = new String(baos.toByteArray());
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
