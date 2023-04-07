package jdbc_rmi;
import java.sql.Connection;
import java.sql.DriverManager;
public class JDBC {
    public static Connection getConnection() {
    	String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    	String USER_NAME = "root";
    	String PASSWORD = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
