package Client.Entity;

import java.io.Serializable;
import java.util.Date;

public class CalendarioMedico implements Serializable{

	private Date Data;
	private Medico Medico_Calendario;
	
	public CalendarioMedico() {
		
	}
	
	public CalendarioMedico(Date data, Medico medico_Calendario) {
		super();
		Data = data;
		Medico_Calendario = medico_Calendario;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Medico getMedico_Calendario() {
		return Medico_Calendario;
	}

	public void setMedico_Calendario(Medico medico_Calendario) {
		Medico_Calendario = medico_Calendario;
	}

	@Override
	public String toString() {
		return "CalendarioMedico [Data=" + Data ;
	}
	
	

	
	
}