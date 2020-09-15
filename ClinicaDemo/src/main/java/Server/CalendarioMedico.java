package Server;

import java.sql.Timestamp;
import java.util.Date;

public class CalendarioMedico {

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
		return "CalendarioMedico [Data=" + Data + "]";
	}
	
	
	@Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof CalendarioMedico)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        CalendarioMedico c = (CalendarioMedico) o; 
          
        // Compare the data members and return accordingly  
        return c.Data.equals(this.Data);
    } 
	
	
}