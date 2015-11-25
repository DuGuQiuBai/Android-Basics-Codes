<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>模拟QQ登录</title>
</head>
<body>
	<h3>GET方式提交数据</h3>
	<form action="LoginServlet" method="get">
		请输入QQ号码: <input type="text" name="qq"> <br> 请输入QQ密码: <input
			type="password" name="pwd"> <br> <input type="submit"
			value="登陆">
	</form>


	<br>
	<hr>
	<h3>POST方式提交数据</h3>
	<form action="LoginServlet" method="post">
		请输入QQ号码: <input type="text" name="qq"> <br> 请输入QQ密码: <input
			type="password" name="pwd"> <br> <input type="submit"
			value="登陆">
	</form>

</body>
</html>