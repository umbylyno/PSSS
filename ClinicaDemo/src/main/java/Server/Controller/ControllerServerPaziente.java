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
		
		Timestamp DataOdierna = new Timestamp(System.currentTimeMillis());
//		Timestamp Domani = new Timestamp(DataOdierna.getTime());
//		Domani.setDate(DataOdierna.getDate()+1);
		
		Timestamp Slot1 = new Timestamp(DataOdierna.getTime());
		Slot1.setDate(DataOdierna.getDate()+1);
		Slot1.setHours(8);
		Slot1.setMinutes(0);
		Slot1.setSeconds(0);
		Slot1.setNanos(0);
		
		Timestamp Slot2 = new Timestamp(Slot1.getTime());
		Slot2.setHours(Slot1.getHours()+2);
		
		Timestamp Slot3 = new Timestamp(Slot2.getTime());
		Slot3.setHours(Slot1.getHours()+2);
		
		Timestamp Slot4 = new Timestamp(Slot3.getTime());
		Slot4.setHours(Slot1.getHours()+2);
		
		int i=0, j=0;
		boolean trovato = false;
		
		while (!trovato) {
			
			if(!Slot1.equals(Medici.get(i).getCalendario().get(j).getData())) {
				Server.CalendarioMedico SC = new Server.CalendarioMedico();
				SC.setData(Slot1);
				SC.setMedico_Calendario(Medici.get(i));
				Medici.get(i).getCalendario().add(SC);
				trovato = true;
			}
			
			//CONTROLLIAMO TUTTI GLI SLOT
			//SE TUTTI OCCUPATI, INCREMENTIAMO LA DATA
			
		}
		
		
		
		
	}

	
	
}
