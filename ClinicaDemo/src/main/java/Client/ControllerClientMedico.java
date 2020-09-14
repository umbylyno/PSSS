package Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Client.Entity.*;

public class ControllerClientMedico {

	public void AggiornaCartellaClinica(Visita V, String Anamnesi, String Prescrizioni, String EsamiPrecedenti, String Trattamenti) throws RemoteException, MalformedURLException, NotBoundException {
		
		V.getCC().setAnamnesiClinica(Anamnesi);
		V.getCC().setEsamiPrecedenti(EsamiPrecedenti);
		V.getCC().setPrescrizioni(Prescrizioni);
		V.getCC().setTrattamenti(Trattamenti);
		
		rmi_Interfaces.Medico_Interface MedicoInterface = (rmi_Interfaces.Medico_Interface) Naming.lookup("rmi://localhost:3033/pippo");
		
		MedicoInterface.AggiornaCartellaClinica(V);
		
	}
	
	
	
	public Visita EffettuaVisita(int CodicePrenotazione) throws MalformedURLException, RemoteException, NotBoundException {
		
		Medico M = new Medico(1, "Umberto", "De Rosa", "Cardiologia", null, null);
		
		
		rmi_Interfaces.Medico_Interface MedicoInterface = (rmi_Interfaces.Medico_Interface) Naming.lookup("rmi://localhost:3033/pippo");
		
		Visita V = MedicoInterface.EffettuaVisita(CodicePrenotazione, M);
		
		
		return V;
	}
	
}
