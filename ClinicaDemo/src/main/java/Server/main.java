package Server;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
//		
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
//		Date d = new Date(System.currentTimeMillis());
//		Timestamp DataOdierna1 = new Timestamp(System.currentTimeMillis());
//		
//		Timestamp Slot1 = new Timestamp(DataOdierna.getTime());
//		Slot1.setDate(DataOdierna.getDate()+1);
//		Slot1.setHours(8);
//		Slot1.setMinutes(0);
//		Slot1.setSeconds(0);
//		
//		Timestamp Slot2 = new Timestamp(Slot1.getTime());
//		
//		Slot2.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot3 = new Timestamp(Slot2.getTime());
//		Slot3.setHours(Slot1.getHours()+2);
//		
//		Timestamp Slot4 = new Timestamp(Slot3.getTime());
//		Slot4.setHours(Slot1.getHours()+2);
////		System.out.println(DataOdierna);
////		System.out.println(Slot1);
////		
////		System.out.println(Slot2);
//////		System.out.println(Slot3);
//////		System.out.println(Slot4);
////		System.out.println(DataOdierna.equals(Slot1));
//		
//		ArrayList<Timestamp> Date = new ArrayList<Timestamp>();
//		Date.add(Slot1);
//		Date.add(Slot2);
//		Date.add(Slot3);
//		Date.add(Slot4);
//		Date.add(DataOdierna1);
//		
//		boolean trovato = false;
//		int i=0;
//		
//		if(d.equals(DataOdierna)) {
//			System.out.println(DataOdierna);
//			System.out.println("Ciao");
//		}
		
//		while(!trovato) {
//			
//			
//			
//		}
		
		System.out.println(DataOdierna);
		
//	    Date dNow = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat("ddMMHHmmss");
//        String datetime = ft.format(dNow);
//        int data = Integer.parseInt(datetime);
//        System.out.println(data);
		
		Random r = new Random();
		int day  = 30 + 1;
		int scelta = r.nextInt(3);
		
		DataOdierna.setDate(DataOdierna.getDate() + day);
		
		
		switch(scelta) {
			
		case 0:
			DataOdierna.setHours(8);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 1:
			DataOdierna.setHours(10);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 2:
			DataOdierna.setHours(12);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		case 3:
			DataOdierna.setHours(14);
			DataOdierna.setMinutes(0);
			DataOdierna.setSeconds(0);
			break;
		
		}
		
		System.out.println(DataOdierna);
		
	}

}
