package Server;

public class CartellaClinica {

	private String AnamnesiClinica;
	private String Prescrizioni;
	private String EsamiPrecedenti;
	private String Trattamenti;
	private Paziente Paziente_CartellaClinica;
	
	public CartellaClinica() {
		
	}

	public CartellaClinica(String anamnesiClinica, String prescrizioni,
			String esamiPrecedenti, String trattamenti, Paziente paziente_CartellaClinica) {
		super();
		
		AnamnesiClinica = anamnesiClinica;
		Prescrizioni = prescrizioni;
		EsamiPrecedenti = esamiPrecedenti;
		Trattamenti = trattamenti;
		Paziente_CartellaClinica = paziente_CartellaClinica;
	}
	
	public CartellaClinica(DB.CartellaClinica CC) {
		
		AnamnesiClinica = CC.getAnamnesiClinica();
		Prescrizioni = CC.getPrescrizioni();
		EsamiPrecedenti = CC.getEsamiPrecedenti();
		Trattamenti = CC.getTrattamenti();
		Paziente_CartellaClinica = null;
	}
	
	public void CaricaCartella() {
		
		DB.CartellaClinica CartellaDB = new DB.CartellaClinica();
		CartellaDB.setPaziente_CodiceFiscale(this.getPaziente_CartellaClinica().getCodiceFiscale());
		
		CartellaDB.setAnamnesiClinica(this.AnamnesiClinica);
		CartellaDB.setEsamiPrecedenti(this.EsamiPrecedenti);
		CartellaDB.setPrescrizioni(this.Prescrizioni);
		CartellaDB.setTrattamenti(this.Trattamenti);
		
		CartellaDB.UploadToDB();
		
	}


	public String getAnamnesiClinica() {
		return AnamnesiClinica;
	}

	public void setAnamnesiClinica(String anamnesiClinica) {
		AnamnesiClinica = anamnesiClinica;
	}

	public String getPrescrizioni() {
		return Prescrizioni;
	}

	public void setPrescrizioni(String prescrizioni) {
		Prescrizioni = prescrizioni;
	}

	public String getEsamiPrecedenti() {
		return EsamiPrecedenti;
	}

	public void setEsamiPrecedenti(String esamiPrecedenti) {
		EsamiPrecedenti = esamiPrecedenti;
	}

	public String getTrattamenti() {
		return Trattamenti;
	}

	public void setTrattamenti(String trattamenti) {
		Trattamenti = trattamenti;
	}

	public Paziente getPaziente_CartellaClinica() {
		return Paziente_CartellaClinica;
	}

	public void setPaziente_CartellaClinica(Paziente paziente_CartellaClinica) {
		Paziente_CartellaClinica = paziente_CartellaClinica;
	}
	
	

}