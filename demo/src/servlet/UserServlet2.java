package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.JdbcConnection;

import entity.User;


public class UserServlet2 extends HttpServlet {

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
				User user=new User();
				String username,password,confirmpass;
				try {
					conn=JdbcConnection.getConnection();//��ȡ���ݿ�����
					username=request.getParameter("username");
					password=request.getParameter("password");
					confirmpass=request.getParameter("confirmpass");
					if(password.equals(confirmpass)&&username.trim().length()!=0&&password.trim().length()!=0){
					sql="INSERT INTO user (username,password) values(?,?)";//��дsql���
					ps=conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ps.executeUpdate();
					user.setUsername(username);
					user.setPassword(password);
					//�Ѷ��󱣴���session��
					request.getSession().setAttribute("UserRegister", user);
					//�������ڲ���ת
					request.getRequestDispatcher("../userInfo.jsp").forward(request, response);
					}else{
					request.getRequestDispatcher("../error.jsp").forward(request, response);	
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
