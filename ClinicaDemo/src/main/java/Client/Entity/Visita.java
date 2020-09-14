package Client.Entity;

import java.io.Serializable;
import java.sql.Timestamp;



public class Visita implements Serializable{

	private String Tipologia;
	private Timestamp Data;
	private CartellaClinica CC;
	
	
	
	public Visita() {
		super();
	}


	public Visita(String tipologia) {
		super();
		Tipologia = tipologia;
	}



//	public void AggiornaCartellaClinica(int Dati) {
//		// TODO - implement Visita.AggiornaCartellaClinica
//		throw new UnsupportedOperationException();
//	}
	
	
	
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


	@Override
	public String toString() {
		return "Visita [Tipologia=" + Tipologia + ", Data=" + Data + ", CC=" + CC.getPaziente_CartellaClinica().getCodiceFiscale() + "]";
	}


	
	
}