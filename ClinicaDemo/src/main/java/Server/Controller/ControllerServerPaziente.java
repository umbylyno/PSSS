package Server.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi_Interfaces.Paziente_Interface;
import Server.*;

public class ControllerServerPaziente extends UnicastRemoteObject implements Paziente_Interface{

	public ControllerServerPaziente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Client.Entity.CartellaClinica VisualizzaCartellaClinica(Client.Entity.Paziente P) throws RemoteException{
		
		Clinica CServer = new Clinica();
		
		//Costruttore Server P
		Paziente PServer = new Paziente();
		PServer.setNome(P.getNome());
		PServer.setCognome(P.getCognome());
		PServer.setEta(P.getEta());
		PServer.setCodiceFiscale(P.getCodiceFiscale());
		
		
		CartellaClinica CartServer = CServer.RicercaCartellaClinica(PServer);
		
		//Return CC Entity client
		Client.Entity.CartellaClinica C = new Client.Entity.CartellaClinica();
		C.setAnamnesiClinica(CartServer.getAnamnesiClinica());
		C.setEsamiPrecedenti(CartServer.getEsamiPrecedenti());
		C.setPaziente_CartellaClinica(P);
		C.setTrattamenti(CartServer.getTrattamenti());
		C.setPrescrizioni(CartServer.getPrescrizioni());
		
		return C;
	}

	public void Prenotazione() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	
}
