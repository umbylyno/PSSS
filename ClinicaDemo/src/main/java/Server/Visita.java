package Server;

import java.sql.Timestamp;


public class Visita {

	private String Tipologia;
	private Timestamp Data;
	private CartellaClinica CC;

	
	public Visita() {
		super();
	}


	public Visita(String tipologia) {
		super();
		Tipologia = tipologia;
		Data = new Timestamp(System.currentTimeMillis());
		CC = null;
		
	}
	
	public void CreaCartellaClinica(Prenotazione P) {
		
		CartellaClinica CC = new CartellaClinica();
		CC.setPaziente_CartellaClinica(P.getPaziente_Prenotazione());
		
		this.CC = CC;
		
		
		
	}


	public void AggiornaCartellaClinica() {
		
		DB.CartellaClinica CartDB = new DB.CartellaClinica();
		
		CartDB.setTrattamenti(this.CC.getTrattamenti());
		CartDB.setAnamnesiClinica(this.CC.getAnamnesiClinica());
		CartDB.setEsamiPrecedenti(this.CC.getEsamiPrecedenti());
		CartDB.setPrescrizioni(this.CC.getPrescrizioni());
		CartDB.setPaziente_CodiceFiscale(this.CC.getPaziente_CartellaClinica().getCodiceFiscale());
		
		CartDB.UploadToDB();
		
	}
	
	
	
	public Timestamp getData() {
		return Data;
	}


	public void setData(Timestamp data) {
		Data = data;
	}


	public CartellaClinica getCC() {
		return CC;
	}


	public void setCC(CartellaClinica cC) {
		CC = cC;
	}


	public String getTipologia() {
		return Tipologia;
	}



	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}


}