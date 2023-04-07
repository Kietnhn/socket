package jdbc_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	public String add(String word,String mean) throws RemoteException;
	public String search(String word) throws RemoteException;
}
