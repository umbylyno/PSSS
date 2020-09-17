package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class GUIAggiornaCartellaClinica {

	private JFrame frame;
	private static Client.Entity.Visita Visita;
	private String[] ciao;
	
	/**
	 * Launch the application.
	 */
	public static void main(final Client.Entity.Visita V) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visita = V;
					GUIAggiornaCartellaClinica window = new GUIAggiornaCartellaClinica();
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
	public GUIAggiornaCartellaClinica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 1251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMPILAZIONE CARTELLA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(249, 19, 345, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 64, 786, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Dati Anagrafici");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(17, 138, 174, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 274, 786, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 480, 786, 2);
		frame.getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Anamnesi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(17, 366, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(0, 697, 786, 2);
		frame.getContentPane().add(separator_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Esami");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(17, 538, 78, 39);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Precedenti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(17, 581, 128, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(0, 1201, 786, 2);
		frame.getContentPane().add(separator_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prescrizioni");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(17, 782, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(0, 1482, 786, 2);
		frame.getContentPane().add(separator_1_4);
		
		JTextArea textAnagrafica = new JTextArea();
		textAnagrafica.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textAnagrafica.setEditable(false);
		textAnagrafica.setBounds(187, 89, 561, 166);
		frame.getContentPane().add(textAnagrafica);
		
		//Settiamo l'Anagrafica
		textAnagrafica.setText(Visita.getCC().StampaDatiAnagrafici());
		
		final JTextArea textAnamnesi = new JTextArea();
		textAnamnesi.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textAnamnesi.setBounds(187, 295, 561, 166);
		frame.getContentPane().add(textAnamnesi);
		
		final JTextArea textEsamiPrec = new JTextArea();
		textEsamiPrec.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textEsamiPrec.setBounds(187, 501, 561, 166);
		frame.getContentPane().add(textEsamiPrec);
		
		final JTextArea textPresc = new JTextArea();
		textPresc.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textPresc.setBounds(187, 718, 561, 166);
		frame.getContentPane().add(textPresc);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(0, 903, 786, 2);
		frame.getContentPane().add(separator_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Trattamenti");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3_1.setBounds(17, 977, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		final JTextArea textTratt = new JTextArea();
		textTratt.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textTratt.setBounds(187, 924, 561, 166);
		frame.getContentPane().add(textTratt);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Client.ControllerClientMedico CCM = new Client.ControllerClientMedico();
				try {
					CCM.AggiornaCartellaClinica(Visita, textAnamnesi.getText(), textPresc.getText(), textEsamiPrec.getText(), textTratt.getText());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Client.GUIClientMedico.main(ciao);	
			frame.dispose();
			}
		});
		btnSalva.setBounds(335, 1137, 131, 31);
		frame.getContentPane().add(btnSalva);
		
		JSeparator separator_1_2_1_1 = new JSeparator();
		separator_1_2_1_1.setBounds(0, 1116, 786, 2);
		frame.getContentPane().add(separator_1_2_1_1);
	}
}
