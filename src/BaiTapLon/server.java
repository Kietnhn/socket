package BaiTapLon;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class server {
	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(1099);
			
			Interface baitaplon = new Stub();
			
			Naming.rebind("baitaplon", baitaplon);
			
			System.out.println("Server is running...");
		}catch(Exception e) {
			System.out.println("Somethings wrong in server!!!");
			e.printStackTrace();
		}
	}
}
