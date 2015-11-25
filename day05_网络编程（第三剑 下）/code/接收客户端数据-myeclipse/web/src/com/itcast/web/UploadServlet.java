package com.itcast.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 判断上传的是否包含文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// 获取路径
			String realpath = request.getSession().getServletContext()
					.getRealPath("/files");
			System.out.println(realpath);

			File dir = new File(realpath);
			if (!dir.exists())
				dir.mkdirs();
			
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			try {
				// 解析请求参数 其实就是 form表单的每个input节点
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {
						// 如果是表单 解析每个表单 打印到控制台
						String name1 = item.getFieldName();// 得到请求参数的名称
						String value = item.getString("UTF-8");// 得到参数值
						System.out.println(name1 + "=" + value);
					} else {
						// 把文件写到当前servlet所对应的路径
						item.write(new File(dir, System.currentTimeMillis()
								+ item.getName().substring(
										item.getName().lastIndexOf("."))));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
