<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
<br><br>
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
			请选择文件上传<input type="file" name="file"><br><br>
			<input type="submit" value="提交">
	</form>

</body>
</html>