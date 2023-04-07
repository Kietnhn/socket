package jdbc_rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Stub extends UnicastRemoteObject implements MyInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection connection = JDBC.getConnection();
	protected Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String add(String word,String mean) throws RemoteException{
		try {
			Statement statement = connection.createStatement();
			String SQL = "INSERT INTO dictionarytb(word, mean) VALUES ('" + word + "','" + mean + "');";
			
			statement.executeUpdate(SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("them tu that bai");
		}
			
			
			return null;
	}
	
	
	
	public String search(String word) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			String sql = "SELECT * from dictionarytb WHERE word = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, word);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String mean = rs.getString("mean");
				return mean;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Not found "+word+" in dictionary ";
	}
}
