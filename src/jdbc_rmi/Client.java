package jdbc_rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	 public static void main(String[] args) throws IOException {
		try {
	        
	        Registry registry = LocateRegistry.getRegistry("localhost");
	        MyInterface myinterface = (MyInterface) registry.lookup("myinterface");
	
	        
            while(true) {
            	BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
            	System.out.print("Enter mode: ");
            	String mode = inputFromUser.readLine();
            	if(mode.compareTo("1") == 0) {
            		System.out.print("Enter word: ");
            		String word = inputFromUser.readLine();
            		System.out.print("Enter mean: ");
            		String mean = inputFromUser.readLine();
            		myinterface.add(word, mean);
            		
            	}
            	if(mode.compareTo("2") == 0) {
            		System.out.print("Enter word: ");
            		String word = inputFromUser.readLine();

            		System.out.println(myinterface.search(word));
            	}
            	if(mode.compareTo("q") == 0) {
            		break;
            	}
         		
            }
	    } catch (NotBoundException e) {
	        System.err.println("CalculatorClient exception: " + e.getMessage());
	        e.printStackTrace();
	    } catch (RemoteException ex) {
	        System.err.println("CalculatorClient exception: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	 }
}
