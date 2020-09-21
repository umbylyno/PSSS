package Client.GUI.Paziente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

import Client.Controller.Paziente.ControllerClientPaziente;
import Client.Entity.CartellaClinica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GUIVisualizzaCartellaClinica {

	private static JFrame frame;
	private String[] args;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVisualizzaCartellaClinica window = new GUIVisualizzaCartellaClinica();
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
	public GUIVisualizzaCartellaClinica() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARTELLA CLINICA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(283, 14, 215, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 62, 804, 2);
		frame.getContentPane().add(separator);
		
		JButton IndietroButton = new JButton("Annulla");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Client.GUI.Paziente.GUIClientPaziente.main(args);
				frame.dispose();
				
			}
		});
		IndietroButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		IndietroButton.setBounds(38, 393, 208, 47);
		frame.getContentPane().add(IndietroButton);
		
		
		
		
		
		
	}
	
	private static void Popolate() throws MalformedURLException, RemoteException, NotBoundException {
		
		JTextArea textFieldCartella = new JTextArea();
		textFieldCartella.setBounds(38, 83, 686, 283);
		frame.getContentPane().add(textFieldCartella);
		textFieldCartella.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		//Effettuo operazioni
		ControllerClientPaziente CCP = new ControllerClientPaziente();
		CartellaClinica CC = CCP.VisualizzaCartellaClinica();
		
		String CartellaStringa = CC.toString();
		
		textFieldCartella.setText(CartellaStringa);
		textFieldCartella.setEditable(false);
		
	}
}
