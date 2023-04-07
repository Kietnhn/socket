package jdbc_udp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_rmi.JDBC;

public class Manager implements MyInterface{
	Connection connection = JDBC.getConnection();
	public void add(String word,String mean) {
		try {
			Statement statement = connection.createStatement();
			String SQL = "INSERT INTO dictionarytb(word, mean) VALUES ('" + word + "','" + mean + "');";
			
			statement.executeUpdate(SQL);
			System.out.println("Suscessfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethings wrong!");
			e.printStackTrace();
		}
	}
	public void delete(String word) {
		try {
			Statement statement = connection.createStatement();
			String SQL = "DELETE FROM dictionarytb WHERE word='"+word+"'";
			
			statement.executeUpdate(SQL);
			System.out.println("Suscessfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethings wrong!");
			e.printStackTrace();
		}
	}
	public String search(String word) {
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
