package Client.GUI.Medico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class GUIClientMedico {

	private JFrame frame;
	private JTextField CodiceField;
	private Client.Entity.Visita V;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIClientMedico window = new GUIClientMedico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIClientMedico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 788, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLINICA PRIVATA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(267, 19, 189, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il codice prenotazione");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(29, 185, 360, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		CodiceField = new JTextField();
		CodiceField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CodiceField.setBounds(394, 190, 338, 29);
		frame.getContentPane().add(CodiceField);
		CodiceField.setColumns(10);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ricerca Codice Prenotazione
				Client.Controller.Medico.ControllerClientMedico CCM = new Client.Controller.Medico.ControllerClientMedico();
				try {
					V = CCM.EffettuaVisita(Integer.parseInt(CodiceField.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				
				if (V!=null) {
					
					Client.GUI.Medico.GUIAggiornaCartellaClinica.main(V);
					frame.setVisible(false);
					
				}
				else JOptionPane.showMessageDialog(frame, "Non ho trovato la prenotazione!");
			}
		});
		CercaButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		CercaButton.setBounds(296, 378, 160, 56);
		frame.getContentPane().add(CercaButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 71, 764, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 368, 764, 2);
		frame.getContentPane().add(separator_1);
	}
	
	

}
