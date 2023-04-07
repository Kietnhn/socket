package BaiTapLon;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interface extends Remote{
	public String add(String word,String mean) throws RemoteException;
	public String delete(String word) throws RemoteException;
	public String search(String word) throws RemoteException;
}
