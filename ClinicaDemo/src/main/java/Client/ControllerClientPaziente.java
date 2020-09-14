package Client;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.Registry;

import Client.Entity.*;

public class ControllerClientPaziente {

	
	public void VisualizzaCartellaClinica() throws MalformedURLException, RemoteException, NotBoundException {
		
		Client.Entity.Paziente P = new Client.Entity.Paziente();
		P.setNome("Marco");
		P.setCognome("Carta");
		P.setEta(30);
		P.setCodiceFiscale("CRTMRC");
		
		rmi_Interfaces.Paziente_Interface PazienteInterface = (rmi_Interfaces.Paziente_Interface) Naming.lookup("rmi://localhost:3033/pippo");
		
//		Server.Paziente PServer = new Server.Paziente(P); 
//		System.out.println(PazienteInterface.VisualizzaCartellaClinica(P));
		CartellaClinica CC = PazienteInterface.VisualizzaCartellaClinica(P);
		System.out.println(CC);
		
	} 
	
	public void EffettuaPrenotazione() {
		
		
		
	}
	
	
	
	
	
	
}
