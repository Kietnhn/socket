package BaiTapLon;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
	public static void main(String agrs[]) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			
			Interface baitaplon = (Interface) registry.lookup("baitaplon");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
