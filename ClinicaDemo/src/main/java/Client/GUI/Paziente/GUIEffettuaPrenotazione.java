package Client.GUI.Paziente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;

import Client.Entity.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GUIEffettuaPrenotazione {

	private static JFrame frame;
	private static JButton ConfermaButton = new JButton("Conferma");
	final static JComboBox comboBoxAmbulatori = new JComboBox();
	static JLabel lblTipologia = new JLabel("Tipologia");
	static final JLabel lblData = new JLabel("Data");
	static final JComboBox comboBoxDate = new JComboBox();
	static JComboBox comboBoxTipologie = new JComboBox();
	private static Client.Entity.Clinica C;
	private static int indiceAmbulatorio = -1;
	private static ArrayList<Client.Entity.Medico> Medici;
	private static String[] ciao;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUIEffettuaPrenotazione window = new GUIEffettuaPrenotazione();
					window.frame.setVisible(true);
					
					Popolate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIEffettuaPrenotazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 77, 866, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("PRENOTAZIONE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(321, 19, 269, 60);
		frame.getContentPane().add(lblNewLabel);
		
		comboBoxAmbulatori.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBoxAmbulatori.setBounds(250, 117, 531, 36);
		frame.getContentPane().add(comboBoxAmbulatori);
		
		
		lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTipologia.setBounds(39, 199, 131, 36);
		frame.getContentPane().add(lblTipologia);
		lblTipologia.setVisible(false);
		
		
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblData.setBounds(39, 280, 82, 23);
		frame.getContentPane().add(lblData);
		lblData.setVisible(false);
		
		
		comboBoxDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBoxDate.setBounds(250, 273, 531, 36);
		frame.getContentPane().add(comboBoxDate);
		comboBoxDate.setVisible(false);
		
		
		comboBoxTipologie.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBoxTipologie.setVisible(false);
		
		
		comboBoxTipologie.setBounds(250, 199, 531, 36);
		frame.getContentPane().add(comboBoxTipologie);
		
		JLabel lbAmbulatorio = new JLabel("Ambulatorio");
		lbAmbulatorio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAmbulatorio.setBounds(39, 122, 146, 23);
		frame.getContentPane().add(lbAmbulatorio);
		
		
		
		
		ConfermaButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ConfermaButton.setBounds(321, 419, 192, 31);
		frame.getContentPane().add(ConfermaButton);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 397, 866, 2);
		frame.getContentPane().add(separator_1);
		
		
		
		
	}
	
	public static void Popolate() throws MalformedURLException, RemoteException, NotBoundException {
		
		//MI PRENDO LA CLINICA
		C = new Client.Entity.Clinica();
		final Client.Controller.Paziente.ControllerClientPaziente CCP = new Client.Controller.Paziente.ControllerClientPaziente();
		C = CCP.CaricaAmbulatoriPrestazioni();
		
		
		
		
		
		String[] Ambulatori = new String[C.getAmbulatori().size()];
		for(int i=0; i<C.getAmbulatori().size(); i++) {
			Ambulatori[i] = C.getAmbulatori().get(i).getNome();
		}
		comboBoxAmbulatori.setModel(new DefaultComboBoxModel(Ambulatori));
		comboBoxAmbulatori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeAmb = comboBoxAmbulatori.getSelectedItem().toString();
				
				boolean trovato = false;
				int i=0;
				
				
				while(!trovato && i<C.getAmbulatori().size()) {
					
					if(nomeAmb.equals(C.getAmbulatori().get(i).getNome())) {
						trovato = true;
						indiceAmbulatorio = i;
					}
					else i++;
				}
				
				//Setto la tipologia
				String[] Tipologie = new String[C.getAmbulatori().get(indiceAmbulatorio).getPrestazioni().size()];
				for(int j=0; j<C.getAmbulatori().get(indiceAmbulatorio).getPrestazioni().size(); j++) {
					Tipologie[j] = C.getAmbulatori().get(indiceAmbulatorio).getPrestazioni().get(j).getNome();
				}
				comboBoxTipologie.setModel(new DefaultComboBoxModel(Tipologie));
				lblTipologia.setVisible(true);
				comboBoxTipologie.setVisible(true);
				comboBoxTipologie.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						
						final String NomeTipologia = comboBoxTipologie.getSelectedItem().toString();
						Medici = new ArrayList<Client.Entity.Medico>();
						try {
							Medici = CCP.EffettuaPrenotazione(C.getAmbulatori().get(indiceAmbulatorio), NomeTipologia);
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						String[] Date = new String[Medici.size()];
						
						for(int j=0; j<Date.length; j++) {
							Date[j] = Medici.get(j).getCalendario().get(0).getData() + " - Dott. " + Medici.get(j).getCognome();
						}
						
						comboBoxDate.setModel(new DefaultComboBoxModel(Date));
						lblData.setVisible(true);
						comboBoxDate.setVisible(true);
						
						ConfermaButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
								int sceltaMedico = comboBoxDate.getSelectedIndex();
								String Conferma;
								
								try {
									Conferma = CCP.ConfermaPrenotazione(Medici.get(sceltaMedico), NomeTipologia, C.getAmbulatori().get(indiceAmbulatorio));
									JLabel label = new JLabel(Conferma);
									label.setFont(new Font("Tahoma", Font.BOLD, 24));
									JOptionPane.showMessageDialog(null,label,"PRENOTAZIONE AVVENUTA",JOptionPane.INFORMATION_MESSAGE);
								} catch (MalformedURLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (RemoteException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (NotBoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								frame.dispose();
								Client.GUI.Paziente.GUIClientPaziente.main(ciao);
								
							}
						});
						
						
					}
				});
			}
		});
		
		
		
		
		
		

	}
}
