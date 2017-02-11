package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					//处理中文乱码
					request.setCharacterEncoding("UTF-8");
					User user=new User();
					String username,password,confirmpass;
				try{
					username=request.getParameter("username");
					password=request.getParameter("password");
					confirmpass=request.getParameter("confirmpass");
					if(password.equals(confirmpass)){
					user.setUsername(username);
					user.setPassword(password);
					//把对象保存在session中
					request.getSession().setAttribute("UserRegister", user);
					//服务器内部跳转
					request.getRequestDispatcher("../userInfo.jsp").forward(request, response);
					}else {
					request.getRequestDispatcher("../error.jsp").forward(request, response);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}

}
