package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	private static String url="jdbc:mysql://localhost/demo";
	private static String driverClass="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="1997";	
	public static Connection con; //用来承载获取连接之后的连接

	public static Connection getConnection() throws SQLException{
		try {
			//加载数据库驱动并捕获异常
			Class.forName(driverClass);
			//获取与mysql数据库的连接
			con=DriverManager.getConnection(url, user, password);//需要抛去sql异常
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;//返回连接
	}
}
