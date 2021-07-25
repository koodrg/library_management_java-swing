package models;

import java.sql.DriverManager;

public class DBConnection {
	
	// Database Connection Information
	static String hostName = "//127.0.0.1";
	static String portNumber = "3307";
	static String dbName = "new_library";
	static String username = "root";
	static String password = "";
	static String JDBC_Driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql:"+hostName+":"+portNumber+"/"+dbName+ "?useUnicode=true&characterEncoding=UTF-8";
	
	
	public static java.sql.Connection conn = null;

	public static java.sql.Connection connect() 
	{
		if (conn != null) return conn;
		
		// else statement
			try {
				Class.forName(JDBC_Driver);
				conn = (java.sql.Connection) DriverManager.getConnection(url,username,password);
				System.out.println("DB connected");
				return conn;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		return conn;
	}
	
	public DBConnection()
	{
		DBConnection.connect();
	}
	
	public static void main(String[] args)
	{
	}
}
