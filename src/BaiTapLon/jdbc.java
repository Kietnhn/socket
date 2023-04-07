package BaiTapLon;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
	public static Connection getConnection() {
		String DB_URL = "";
		String USERNAME = "root";
		String PASSWORD  = "";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connect succesfully!");
		}catch(Exception e) {
			System.out.println("Connect fail!");
			e.printStackTrace();
		}
		
		return conn;
	}
}
