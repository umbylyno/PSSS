package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Client.Entity.Visita;

public class main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		//Medico
		ControllerClientMedico CCM = new ControllerClientMedico();
		Visita V = CCM.EffettuaVisita(1);
		
		//Paziente
		ControllerClientPaziente CCP = new ControllerClientPaziente();
		CCP.VisualizzaCartellaClinica();
		System.out.println(CCP);
		
		//CCP.AggiornaCartellaClinica(V, "CIAO", "COME", "LA", "VA");
		
	}

}

