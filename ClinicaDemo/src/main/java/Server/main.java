package Server;

import java.rmi.RemoteException;
import java.sql.Timestamp;

public class main {

	public static void main(String[] args) throws RemoteException {

//		Ambulatorio A = new Ambulatorio();
//		Prenotazione P = A.RicercaPrenotazione(5);
//		
//		Medico M = new Medico();
//		M.setId(8);
//		
//		Paziente Paz = new Paziente();
//		Paz.setCodiceFiscale("POLLO");
//		
//		A.setCodice("H");
//		
//		Timestamp T = Timestamp.valueOf("2020-12-2 14:22:00");
//		
//		
//		A.AggiungiPrenotazione(T, "Psicosi", Paz, M);
		
//		Server.Controller.ControllerServerPaziente CSP = new Server.Controller.ControllerServerPaziente();
//		
//		Client.Entity.Ambulatorio A = new Client.Entity.Ambulatorio();
//		A.setCodice("01");
//		
//		CSP.Prenotazione(A);
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		timestamp.setHours(timestamp.getHours() - 2);
//		System.out.println(timestamp);
		
		Timestamp DataOdierna = new Timestamp(System.currentTimeMillis());
		
		Timestamp Slot1 = DataOdierna;
		Slot1.setDate(DataOdierna.getDate()+1);
		Slot1.setHours(8);
		Slot1.setMinutes(0);
		Slot1.setSeconds(0);
		
		Timestamp Slot2 = new Timestamp(Slot1.getTime());
		
		Slot2.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot3 = Slot2;
//		Slot3.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot4 = Slot3;
//		Slot4.setHours(Slot1.getHours()+2);
		System.out.println(DataOdierna);
		System.out.println(Slot1);
		
		System.out.println(Slot2);
//		System.out.println(Slot3);
//		System.out.println(Slot4);
		System.out.println(DataOdierna.equals(Slot1));
	}

}
