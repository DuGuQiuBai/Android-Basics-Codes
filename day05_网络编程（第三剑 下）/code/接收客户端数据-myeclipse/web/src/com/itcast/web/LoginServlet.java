package com.itcast.web;
/**
 * tomcat采用的码表是 iso-8859-1码表。 没有中文。
 * 如果遇到了不认识的字符串 就默认使用本地的默认码表（gbk）
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**   
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取输入的QQ号 和密码
		String qq = request.getParameter("qq");
		String pwd = request.getParameter("pwd");
		
		//控制台打印结果
		System.out.println("---------------");
		System.out.println("qq:"+ new String(qq.getBytes("iso-8859-1"),"utf-8"));
		System.out.println("pwd:"+pwd);
		
		//模拟服务器的操作，查询数据库 看qq和密码是否正确
		if("123".equals(qq)&&"asd".equals(pwd)){
			//输出结果到浏览器  或者  手机
			response.getOutputStream().write("登录成功".getBytes("utf-8"));
		}else{
			response.getOutputStream().write("登录失败".getBytes("utf-8"));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
		System.out.println();
		System.out.println("post提交的数据");
	}

}
