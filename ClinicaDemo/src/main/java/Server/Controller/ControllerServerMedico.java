package Server.Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.omg.PortableServer.POAPackage.ServantAlreadyActive;

import com.mysql.cj.xdevapi.ClientFactory;

import Client.Entity.CartellaClinica;
import Client.Entity.Paziente;
import Server.*;
import rmi_Interfaces.Medico_Interface;

public class ControllerServerMedico extends UnicastRemoteObject implements Medico_Interface {

	public ControllerServerMedico() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Client.Entity.Visita EffettuaVisita(int CodicePrenotazione, Client.Entity.Medico M) throws RemoteException {
		
		Ambulatorio A = new Ambulatorio();
		Prenotazione P = A.RicercaPrenotazione(CodicePrenotazione);
		
		System.out.println(P);
		
		Server.Medico MServer = new Server.Medico();
		MServer.setId(M.getId());
		MServer.setNome(M.getNome());
		MServer.setCognome(M.getCognome());
		MServer.setSpecializzazione(M.getSpecializzazione());
		
		Visita VServer = MServer.CreaVisita(P.getTipologia());
		
		VServer.CreaCartellaClinica(P);
		
		VServer.getCC().CaricaCartella();
		
		Client.Entity.Visita V = new Client.Entity.Visita();
		V.setTipologia(VServer.getTipologia());
		V.setData(VServer.getData());
		
		Client.Entity.Paziente Paz = new Client.Entity.Paziente();
		Paz.setCodiceFiscale(P.getPaziente_Prenotazione().getCodiceFiscale());
		
		Client.Entity.CartellaClinica C = new Client.Entity.CartellaClinica();
		C.setPaziente_CartellaClinica(Paz);
		
		V.setCC(C);
		
		return V;
	}

	public void AggiornaCartellaClinica(Client.Entity.Visita V) throws RemoteException {
		
		Server.Visita VServer = new Server.Visita();
		VServer.setData(V.getData());
		VServer.setTipologia(V.getTipologia());
		
		Server.CartellaClinica CartServer = new Server.CartellaClinica();
		CartServer.setAnamnesiClinica(V.getCC().getAnamnesiClinica());
		CartServer.setEsamiPrecedenti(V.getCC().getEsamiPrecedenti());
		CartServer.setPrescrizioni(V.getCC().getPrescrizioni());
		CartServer.setTrattamenti(V.getCC().getTrattamenti());
		
		Server.Paziente Paz = new Server.Paziente();
		Paz.setCodiceFiscale(V.getCC().getPaziente_CartellaClinica().getCodiceFiscale());
		
		CartServer.setPaziente_CartellaClinica(Paz);
		
		VServer.setCC(CartServer);
		
		VServer.AggiornaCartellaClinica();
		
		
	}


	
	
	
}
