package jdbc_rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
        try {
            
            @SuppressWarnings("unused")
			Registry registry = LocateRegistry.createRegistry(1099);
            
            MyInterface myinterface = new Stub();
            
            Naming.rebind("myinterface", myinterface);	
            
            System.out.println("CalculatorServer is running...");
        } catch (Exception e) {
            System.err.println("CalculatorServer exception: " + e.getMessage());
          
        }
    }
}
