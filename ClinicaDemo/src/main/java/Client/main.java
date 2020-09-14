package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Client.Entity.Visita;

public class main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		ControllerClientMedico CCP= new ControllerClientMedico();
		
		Visita V = CCP.EffettuaVisita(1);
		
		System.out.println(V);
		
		CCP.AggiornaCartellaClinica(V, "CIAO", "COME", "LA", "VA");
		
	}

}

