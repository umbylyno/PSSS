package Server.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.omg.PortableServer.POAPackage.ServantAlreadyActive;

import Client.Entity.Ambulatorio;
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

	public ArrayList<Client.Entity.Medico> Prenotazione(Client.Entity.Ambulatorio A) throws RemoteException {
		
		Server.Ambulatorio AServer = new Server.Ambulatorio();
		AServer.setNome(A.getNome());
		AServer.setCodice(A.getCodice());
		
		//SCARICHIAMO I MEDICI
		ArrayList<Server.Medico> Medici = AServer.RicercaMedici();
		
		//STAMPIAMO I MEDICI PER TESTING
		for(int i=0; i<Medici.size(); i++) {
			System.out.println(Medici.get(i));
		}
		
//		ACCEDO AL CALENDARIO MEDICO (CALENDARIO DEGLI APPUNTAMENTI DEL MEDICO)
		for(int i=0; i<Medici.size(); i++) {
			//Setto la disponibilità dei medici
			Medici.get(i).DisponibilitaMedico();
		}
		
		//STUB
//		Timestamp DataOdierna = new Timestamp(System.currentTimeMillis());
//		Server.CalendarioMedico CM = new Server.CalendarioMedico();
//		CM.setData(DataOdierna);
//		CM.setMedico_Calendario(Medici.get(0));
//		ArrayList<Server.CalendarioMedico> CMA = new ArrayList<CalendarioMedico>();
//		CMA.add(CM);
//		Medici.get(0).setCalendario(CMA);
		
		
		
		//STAMPO GLI APPUNTAMENTI
		for(int i=0; i<Medici.size(); i++) {
			System.out.println(Medici.get(i));
			for(int j=0; j<Medici.get(i).getCalendario().size(); j++) {
				System.out.println(Medici.get(i).getCalendario().get(j));
			}
			
		}
		
		//A questo punto ho l'Arraylist di medici con il relativo calendario che indica la loro data e devo restituirlo
		
		ArrayList <Client.Entity.Medico> med= new ArrayList<Client.Entity.Medico>();
		for(int i =0; i<Medici.size();i++) {
			Client.Entity.Medico m= new Client.Entity.Medico();
			m.setId(Medici.get(i).getId());
			m.setCognome(Medici.get(i).getCognome());
			m.setNome(Medici.get(i).getNome());
			m.setSpecializzazione(Medici.get(i).getSpecializzazione());
			
			Client.Entity.CalendarioMedico cm= new Client.Entity.CalendarioMedico();
			cm.setData(Medici.get(i).getCalendario().get(0).getData());
			cm.setMedico_Calendario(m);
			
			ArrayList<Client.Entity.CalendarioMedico> CM= new ArrayList<Client.Entity.CalendarioMedico>();
			CM.add(cm);
			m.setCalendario(CM);
			med.add(m);
		}
		
		return med;					
		
		
	}
	
	public String ConfermaPrenotazione(Client.Entity.Medico m, String Tipologia, Client.Entity.Paziente P, Client.Entity.Ambulatorio A) throws RemoteException {
		
		Server.Prenotazione Pren= new Server.Prenotazione();
		
		Server.Ambulatorio Amb= new Server.Ambulatorio();
		Amb.setCodice(A.getCodice());
		
		Server.Paziente paz= new Server.Paziente();
		paz.setCodiceFiscale(P.getCodiceFiscale());
		paz.setCognome(P.getCognome());
		
		Server.Medico Med= new Server.Medico();
		Med.setId(m.getId());
		Med.setNome(m.getNome());
		Med.setCognome(m.getCognome());
		
		//Aggiungo l'appuntamento al calendario del medio
		
		
		Pren.setAmbulatorio_Prenotazione(Amb);
		Pren.setData(new Timestamp(m.getCalendario().get(0).getData().getTime()));
		//Pren.setId(id);
		Pren.setMedico_Prenotazione(Med);
		Pren.setPaziente_Prenotazione(paz);
		Pren.setTipologia(Tipologia);
		Pren.CaricaSuDB();
		
		Med.CreaAppuntamento(Pren);
	
		// Carica su DB è void, come faccio a sapere se il caricamento è stato corretto?
		
		String s ="Prenotazione effettuata per il signor "+ Pren.getPaziente_Prenotazione().getCognome()+ " per il giorno "+Pren.getData()+
				" con il medico "+Pren.getMedico_Prenotazione().getCognome()+" "+Pren.getMedico_Prenotazione().getNome() + "\n Codice Prenotazione "+Pren.getId();		
		
		return s;
	}

	public Client.Entity.Clinica CaricaAmbulatoriPrestazioni() throws RemoteException {
		
		//STUB
		Client.Entity.Clinica C = new Client.Entity.Clinica();
		
		//CREO GLI AMBULATORI
		Client.Entity.Ambulatorio A1 = new Client.Entity.Ambulatorio("01", "Cardiologia"); //CARDIOLOGIA
		Client.Entity.Ambulatorio A2 = new Client.Entity.Ambulatorio("02", "Dermatologia"); //DERMATOLOGIA
		Client.Entity.Ambulatorio A3 = new Client.Entity.Ambulatorio("04","Pediatria"); //PEDIATRIA
		Client.Entity.Ambulatorio A4 = new Client.Entity.Ambulatorio("05", "Oculistica"); //OCULISTICA
		
		//CARDIOLOGIA
		Client.Entity.Prestazione P1A1 = new Client.Entity.Prestazione("ECG");
		Client.Entity.Prestazione P2A1 = new Client.Entity.Prestazione("EcoColorDoppler");
		Client.Entity.Prestazione P3A1 = new Client.Entity.Prestazione("Scintigrafia Miocardica");
		Client.Entity.Prestazione P4A1 = new Client.Entity.Prestazione("Coronografia");
		ArrayList <Client.Entity.Prestazione> PA1= new ArrayList<Client.Entity.Prestazione>();
		PA1.add(P1A1);
		PA1.add(P2A1);
		PA1.add(P3A1);
		PA1.add(P4A1);
		A1.setPrestazioni(PA1);
		
		//DERMATOLOGIA
		Client.Entity.Prestazione P1A2 = new Client.Entity.Prestazione("Mappatura Nei");
		Client.Entity.Prestazione P2A2 = new Client.Entity.Prestazione("Crioterapia");
		Client.Entity.Prestazione P3A2 = new Client.Entity.Prestazione("Biopsia Cute");
		Client.Entity.Prestazione P4A2 = new Client.Entity.Prestazione("Courettage");
		ArrayList <Client.Entity.Prestazione> PA2= new ArrayList<Client.Entity.Prestazione>();
		PA2.add(P1A2);
		PA2.add(P2A2);
		PA2.add(P3A2);
		PA2.add(P4A2);
		A2.setPrestazioni(PA2);
		
		//PEDIATRIA
		Client.Entity.Prestazione P1A3 = new Client.Entity.Prestazione("Sviluppo Cognitivo");
		Client.Entity.Prestazione P2A3 = new Client.Entity.Prestazione("Misurazione del Peso");
		Client.Entity.Prestazione P3A3 = new Client.Entity.Prestazione("Vaccinazione");
		Client.Entity.Prestazione P4A3 = new Client.Entity.Prestazione("Sviluppo motorio");
		ArrayList <Client.Entity.Prestazione> PA3= new ArrayList<Client.Entity.Prestazione>();
		PA3.add(P1A3);
		PA3.add(P2A3);
		PA3.add(P3A3);
		PA3.add(P4A3);
		A3.setPrestazioni(PA3);
		
		//OCULISTICA
		Client.Entity.Prestazione P1A4 = new Client.Entity.Prestazione("Fondo Oculare");
		Client.Entity.Prestazione P2A4 = new Client.Entity.Prestazione("Topografia Corneale");
		Client.Entity.Prestazione P3A4 = new Client.Entity.Prestazione("Pachimetria");
		Client.Entity.Prestazione P4A4 = new Client.Entity.Prestazione("OCT");
		ArrayList <Client.Entity.Prestazione> PA4= new ArrayList<Client.Entity.Prestazione>();
		PA4.add(P1A4);
		PA4.add(P2A4);
		PA4.add(P3A4);
		PA4.add(P4A4);
		A4.setPrestazioni(PA4);
		
		ArrayList<Ambulatorio> Ambulatori= new ArrayList<Ambulatorio>();
		Ambulatori.add(A1);
		Ambulatori.add(A2);
		Ambulatori.add(A3);
		Ambulatori.add(A4);
		
		C.setAmbulatori(Ambulatori);
		
		return C;
	}

	
	
}
