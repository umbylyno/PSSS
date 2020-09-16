package Client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.clinica.ClinicaDemo.Ambulatorio;

import Client.Entity.Visita;

public class main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		//Medico
		ControllerClientMedico CCM = new ControllerClientMedico();
		//Visita V = CCM.EffettuaVisita(1);
		
		//Paziente
		ControllerClientPaziente CCP = new ControllerClientPaziente();
//		Client.Entity.Ambulatorio A = new Client.Entity.Ambulatorio();
//		A.setCodice("01");
//		A.setNome("Cardiologia");
//		ArrayList<Client.Entity.Medico> medici =  CCP.EffettuaPrenotazione(A, "Visita Cardiologica");
//		
//		for(int i=0; i<medici.size();i++) {
//			System.out.println(medici.get(i));
//		}
//		
//		String Risultato = CCP.ConfermaPrenotazione(medici.get(0), "Visita Cardiologica", A);
//		
//		
//		System.out.println(Risultato);
		
		//CCP.AggiornaCartellaClinica(V, "CIAO", "COME", "LA", "VA");
		Client.Entity.Clinica c =CCP.CaricaAmbulatoriPrestazioni();
		for (int i=0; i< c.getAmbulatori().size(); i++) {
			System.out.println("Ambulatorio "+ c.getAmbulatori().get(i).getCodice());
			System.out.println("Prestazioni");
			for (int j=0; j<c.getAmbulatori().get(i).getPrestazioni().size(); j++) {
				System.out.println(c.getAmbulatori().get(i).getPrestazioni().get(j).getNome());
			}
		}
		
		
	}

}

