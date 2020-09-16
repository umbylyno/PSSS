package rmi_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.Paziente;

public interface Paziente_Interface extends Remote {
	
	public Client.Entity.CartellaClinica VisualizzaCartellaClinica(Client.Entity.Paziente P) throws RemoteException;
	public ArrayList<Client.Entity.Medico> Prenotazione(Client.Entity.Ambulatorio A) throws RemoteException;
	public String ConfermaPrenotazione(Client.Entity.Medico m, String Tipologia, Client.Entity.Paziente P, Client.Entity.Ambulatorio A)throws RemoteException;
	public Client.Entity.Clinica CaricaAmbulatoriPrestazioni() throws RemoteException;
	
}
