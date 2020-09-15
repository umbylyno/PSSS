package rmi_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Server.Paziente;

public interface Paziente_Interface extends Remote {
	
	public Client.Entity.CartellaClinica VisualizzaCartellaClinica(Client.Entity.Paziente P) throws RemoteException;
	public void Prenotazione(Client.Entity.Ambulatorio A) throws RemoteException;
	

}
