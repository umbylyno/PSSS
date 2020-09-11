package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIClientMedico {

	private JFrame frame;
	private JTextField CodiceField;

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
		
		JLabel lblNewLabel_1 = new JLabel("Inserisci il codice");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(48, 180, 189, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		CodiceField = new JTextField();
		CodiceField.setBounds(337, 187, 271, 29);
		frame.getContentPane().add(CodiceField);
		CodiceField.setColumns(10);
		
		JButton CercaButton = new JButton("Cerca");
		CercaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ricerca Codice Prenotazione
				
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
