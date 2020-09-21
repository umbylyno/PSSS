package Server;

import java.rmi.RemoteException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		Registry r = LocateRegistry.createRegistry(3033);
		
		r.rebind("pippo", new Server.Controller.Paziente.ControllerServerPaziente());
		r.rebind("pluto", new Server.Controller.Medico.ControllerServerMedico());
	}

}
