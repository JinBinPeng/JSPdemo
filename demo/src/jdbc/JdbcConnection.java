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
	public static Connection con; //�������ػ�ȡ����֮�������

	public static Connection getConnection() throws SQLException{
		try {
			//�������ݿ������������쳣
			Class.forName(driverClass);
			//��ȡ��mysql���ݿ������
			con=DriverManager.getConnection(url, user, password);//��Ҫ��ȥsql�쳣
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;//��������
	}
}
