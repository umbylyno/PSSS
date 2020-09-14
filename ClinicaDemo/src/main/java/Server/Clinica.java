package Server;

import java.util.ArrayList;

public class Clinica {

	private String Nome;
	private ArrayList<Ambulatorio> Ambulatori;
	private ArrayList<Paziente> Pazienti;
	private ArrayList<CartellaClinica> CC;

	
	
	public Clinica() {
		super();
	}
	
	


	public Clinica(String nome, ArrayList<Ambulatorio> ambulatori, ArrayList<Paziente> pazienti) {
		super();
		Nome = nome;
		Ambulatori   = new ArrayList<Ambulatorio>();
		Pazienti  = new ArrayList<Paziente>();
		CC  = new ArrayList<CartellaClinica>();
	}



//	public void RicercaPaziente(int CodiceFiscale) {
//		// TODO - implement Clinica.RicercaPaziente
//		throw new UnsupportedOperationException();
//	}

	
	public void AssegnaAmbulatorio(int Tipologia) {
		// TODO - implement Clinica.AssegnaAmbulatorio
		throw new UnsupportedOperationException();
	}
	
	public CartellaClinica RicercaCartellaClinica(Paziente P) {
		
		DB.CartellaClinica CC= new DB.CartellaClinica();
		ArrayList<DB.CartellaClinica> ListaCartelle = CC.DownloadCartelleCliniche();
		
//		System.out.println(ListaCartelle.get(1));
		
		boolean trovato = false;
		int i = 0;
		
		while (i< ListaCartelle.size() && trovato == false) {
			
			if(ListaCartelle.get(i).getPaziente_CodiceFiscale().equals(P.getCodiceFiscale())) {
				trovato = true;
				CartellaClinica Cart = new CartellaClinica(ListaCartelle.get(i));
				Cart.setPaziente_CartellaClinica(P);
				return Cart;
			}
			else i++;
		}
		
		return null;
		
	}

	


	public ArrayList<CartellaClinica> getCC() {
		return CC;
	}




	public void setCC(ArrayList<CartellaClinica> cC) {
		CC = cC;
	}




	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public ArrayList<Ambulatorio> getAmbulatori() {
		return Ambulatori;
	}




	public void setAmbulatori(ArrayList<Ambulatorio> ambulatori) {
		Ambulatori = ambulatori;
	}




	public ArrayList<Paziente> getPazienti() {
		return Pazienti;
	}




	public void setPazienti(ArrayList<Paziente> pazienti) {
		Pazienti = pazienti;
	}

	
}