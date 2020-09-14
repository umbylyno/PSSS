package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		ControllerClientPaziente CCP= new ControllerClientPaziente();
		
		CCP.VisualizzaCartellaClinica();
		
	}

}
