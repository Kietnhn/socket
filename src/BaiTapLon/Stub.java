package BaiTapLon;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

public class Stub extends UnicastRemoteObject implements Interface {
	/**
	 * 
	 */
	Connection connection = jdbc.getConnection();
	private static final long serialVersionUID = 1L;

	protected Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String add (String word,String mean) throws RemoteException{
		return word;
	}

	public String delete(String word) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String search(String word) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
