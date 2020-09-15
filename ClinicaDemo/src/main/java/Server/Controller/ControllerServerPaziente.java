package Server.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

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

	public void Prenotazione(Client.Entity.Ambulatorio A) throws RemoteException {
		
		Server.Ambulatorio AServer = new Server.Ambulatorio();
		AServer.setNome(A.getNome());
		AServer.setCodice(A.getCodice());
		
		//SCARICHIAMO I MEDICI
		ArrayList<Server.Medico> Medici = AServer.RicercaMedici();
		
		//STAMPIAMO I MEDICI PER TESTING
		for(int i=0; i<Medici.size(); i++) {
			System.out.println(Medici.get(i));
		}
		
		//ACCEDO AL CALENDARIO MEDICO (CALENDARIO DEGLI APPUNTAMENTI DEL MEDICO)
		for(int i=0; i<Medici.size(); i++) {
			//Setto la disponibilità dei medici
			Medici.get(i).DisponibilitaMedico();
		}
		
		//STAMPO GLI APPUNTAMENTI
		for(int i=0; i<Medici.size(); i++) {
			System.out.println(Medici.get(i));
			for(int j=0; j<Medici.get(i).getCalendario().size(); j++) {
				System.out.println(Medici.get(i).getCalendario().get(j));
			}
			
		}
		

		
		
		
	}

	
	
}
