package Atm_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class relationdatabaseinfo implements databaseinfo {
	public static Connection connection=null;
	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	private static String password = "root";
	private static String username="root";
	private static String url = "jdbc:mysql:// :3306/Atm?user=root&password=root";
	@Override
	public String getDrivername() {
		return DRIVER_NAME;	
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public static Connection getConnection () throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
//		System.out.println("Connector loaded successfully");
		connection=DriverManager.getConnection(url);
//		System.out.println("Connected with host:port/database.");
		return connection;

	}
}
