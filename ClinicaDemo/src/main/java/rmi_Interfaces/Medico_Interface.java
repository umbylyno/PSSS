package rmi_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Medico_Interface extends Remote {

	public Client.Entity.Visita EffettuaVisita(int CodicePrenotazione, Client.Entity.Medico M) throws RemoteException;
	
	public void AggiornaCartellaClinica(Client.Entity.Visita V) throws RemoteException;
	
}
