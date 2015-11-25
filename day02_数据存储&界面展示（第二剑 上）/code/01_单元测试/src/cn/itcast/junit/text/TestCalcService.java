package cn.itcast.junit.text;

import cn.itcast.junit.CalcService;
import android.test.AndroidTestCase;

/**
 * 1. 写一个类继承 AndroidTestCase
 * 
 */
public class TestCalcService extends AndroidTestCase {
	/**
	 * 2. 写一个测试方法
	 * 		抛出异常给Android系统
	 * 		方法的名字必须是public，Android系统要用反射去掉用
	 * 
	 * @throws Exception
	 */
	public void testAdd()throws Exception{
		CalcService calc = new CalcService();
		int res = calc.add(1, 1);
		
		//3. 要对测试结果进行断言
		assertEquals(2, res);
	}
}
