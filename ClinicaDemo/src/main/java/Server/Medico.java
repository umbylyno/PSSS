package Server;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

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
		
		
		Random r = new Random();
		int day  = r.nextInt(60) + 1;
		int scelta = r.nextInt(3);
		
		DataOdierna.setDate(DataOdierna.getDate() + day);
		
		
		switch(scelta) {
			
		case 0:
			DataOdierna.setHours(8);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 1:
			DataOdierna.setHours(10);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 2:
			DataOdierna.setHours(12);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 3:
			DataOdierna.setHours(14);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		
		}
		
		this.getCalendario().get(0).setData(DataOdierna);
		
		
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