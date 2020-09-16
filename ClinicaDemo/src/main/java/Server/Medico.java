package Server;

import java.sql.Timestamp;
import java.util.ArrayList;

//import DB.CalendarioMedico;

public class Medico {

	private int id;
	private String Nome;
	private String Cognome;
	private String Specializzazione;
	private ArrayList<CalendarioMedico> Calendario = new ArrayList<CalendarioMedico>();
	private ArrayList<Visita> Visite = new ArrayList<Visita>();

	
	
	public Medico() {
		super();
	}
	


	public Medico(int ID ,String nome, String cognome, String specializzazione, ArrayList<CalendarioMedico> calendario,
			ArrayList<Visita> visite) {
		super();
		id = ID;
		Nome = nome;
		Cognome = cognome;
		Specializzazione = specializzazione;
		Calendario = calendario;
		Visite = visite;
	}



	public void DisponibilitaMedico() {

		
		DB.CalendarioMedico CM = new DB.CalendarioMedico();
		//Scarico tutti i calendari
		ArrayList<DB.CalendarioMedico> CalendariDB =  CM.DownloadCalendari();
		
		//FILTRAGGIO E CASTING
		for(int i=0; i<CalendariDB.size(); i++) {
			
			if(CalendariDB.get(i).getIdCalendarioMedico() == this.id) {
				Server.CalendarioMedico CalServer = new Server.CalendarioMedico();
				CalServer.setData(CalendariDB.get(i).getData());
				this.Calendario.add(CalServer);
			}

		}
		
		Timestamp DataOdierna = new Timestamp(System.currentTimeMillis());
		this.getCalendario().get(0).setData(DataOdierna);
		
//		Timestamp DataOdierna = new Timestamp(System.currentTimeMillis());
//		
//		Timestamp Slot1 = new Timestamp(DataOdierna.getTime());
//		Slot1.setDate(DataOdierna.getDate()+1);
//		Slot1.setHours(8);
//		Slot1.setMinutes(0);
//		Slot1.setSeconds(0);
//		Slot1.setNanos(0);
//		
//		Timestamp Slot2 = new Timestamp(Slot1.getTime());
//		Slot2.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot3 = new Timestamp(Slot2.getTime());
//		Slot3.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot4 = new Timestamp(Slot3.getTime());
//		Slot4.setHours(Slot1.getHours()+2);
//		
//		int i=0;
//		boolean trovato = false;
		
//		Timestamp DataFittizia = new Timestamp(this.Calendario.get(0).getData().getTime());
//		System.out.println(DataFittizia);
//		System.out.println(this.Calendario.get(0).getData());
//		if(this.Calendario.contains(DataFittizia)) {
//			System.out.println(DataFittizia);
//		}
//		else System.out.println("Non funziono");ino
		
		
//		while (!trovato) {
//			
//			if(!Slot1.equals(this.getCalendario().get(i).getData())) {
//				Server.CalendarioMedico SC = new Server.CalendarioMedico();
//				SC.setData(Slot1);
//				SC.setMedico_Calendario(this);
//				this.Calendario.clear();
//				this.Calendario.add(SC);
//				trovato = true;
//			}
//			i++;
//			if (!Slot2.equals(this.getCalendario().get(i).getData())) {
//				Server.CalendarioMedico SC = new Server.CalendarioMedico();
//				SC.setData(Slot1);
//				SC.setMedico_Calendario(this);
//				this.Calendario.clear();
//				this.Calendario.add(SC);
//				trovato = true;
//			}
//			i++;
//			
//			
//			
//		}
		
		
	}
	
	public void CreaAppuntamento(Server.Prenotazione CM) {
		
		DB.CalendarioMedico DBCal = new DB.CalendarioMedico();
		DBCal.setIdCalendarioMedico(this.id);
		DBCal.setData(CM.getData());
		
		DBCal.UploadToDB();
		
	}
	
	public Visita CreaVisita(String Tipologia) {
		
		Visita V = new Visita(Tipologia);
		
		return V;
		
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return Nome;
	}





	public void setNome(String nome) {
		Nome = nome;
	}





	public String getCognome() {
		return Cognome;
	}





	public void setCognome(String cognome) {
		Cognome = cognome;
	}





	public String getSpecializzazione() {
		return Specializzazione;
	}





	public void setSpecializzazione(String specializzazione) {
		Specializzazione = specializzazione;
	}





	public ArrayList<CalendarioMedico> getCalendario() {
		return Calendario;
	}





	public void setCalendario(ArrayList<CalendarioMedico> calendario) {
		Calendario = calendario;
	}





	public ArrayList<Visita> getVisite() {
		return Visite;
	}





	public void setVisite(ArrayList<Visita> visite) {
		Visite = visite;
	}



	@Override
	public String toString() {
		return "Medico [id=" + id + ", Nome=" + Nome + ", Cognome=" + Cognome + ", Specializzazione=" + Specializzazione + " ]";
	}
	
	
	

}