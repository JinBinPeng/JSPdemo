package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcConnection;

import entity.User;

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			Connection conn;
			 String sql;
			 PreparedStatement ps;
			 ResultSet re;
			 User user=new User();
			 String username,password;
			 try {
				conn=JdbcConnection.getConnection();
				sql="select * from user where username =? and password =?";
				username=request.getParameter("username");
				password=request.getParameter("password");
				if(username.trim().length()!=0&&password.trim().length()!=0){
				ps=conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				re=ps.executeQuery();
				user.setUsername(username);//登录只需要封装username就好
						if(re.next()==true){
								request.getSession().setAttribute("UserLogin", user);
								request.getRequestDispatcher("../LoginSuccess.jsp").forward(request, response);
						}else{
							request.getRequestDispatcher("../LoginFailure.jsp").forward(request, response);
						}
				}else{
					request.getRequestDispatcher("../LoginFailure.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
