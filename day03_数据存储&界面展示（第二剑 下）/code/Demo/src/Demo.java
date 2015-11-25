import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Demo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		//1. 在内存中初始化了一个file对象
		File file = new File("C:\\info.txt");
		
		//2. 用file对象在硬盘上创建文件
		FileOutputStream fos = new FileOutputStream(file);
		fos.write("呵呵。。。。".getBytes());
		fos.close();
		
	}

}
