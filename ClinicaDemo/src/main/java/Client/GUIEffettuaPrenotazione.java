package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GUIEffettuaPrenotazione {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEffettuaPrenotazione window = new GUIEffettuaPrenotazione();
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
	public GUIEffettuaPrenotazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 805, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 77, 781, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("PRENOTAZIONE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(287, 19, 269, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTipologia.setBounds(39, 184, 131, 36);
		frame.getContentPane().add(lblTipologia);
		
		final JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblData.setBounds(39, 264, 82, 23);
		frame.getContentPane().add(lblData);
		lblData.setVisible(false);
		
		final JComboBox comboBoxDate = new JComboBox();
		comboBoxDate.setModel(new DefaultComboBoxModel(new String[] {"21-23", "21-58"}));
		comboBoxDate.setBounds(250, 263, 288, 29);
		frame.getContentPane().add(comboBoxDate);
		comboBoxDate.setVisible(false);
		
		JComboBox comboBoxTipologie = new JComboBox();
		comboBoxTipologie.setModel(new DefaultComboBoxModel(new String[] {"gallo", "nano"}));
		comboBoxTipologie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TIPOLOGIA 
				lblData.setVisible(true);
				comboBoxDate.setVisible(true);
			}
		});
		comboBoxTipologie.setBounds(250, 190, 288, 29);
		frame.getContentPane().add(comboBoxTipologie);
		
		JLabel lbAmbulatorio = new JLabel("Ambulatorio");
		lbAmbulatorio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbAmbulatorio.setBounds(39, 122, 146, 23);
		frame.getContentPane().add(lbAmbulatorio);
		
		JComboBox comboBoxAmbulatori = new JComboBox();
		comboBoxAmbulatori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AMBULATORIO
				
			}
		});
		comboBoxAmbulatori.setBounds(250, 121, 288, 29);
		frame.getContentPane().add(comboBoxAmbulatori);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CONFERMA PRENOTAZIONE
				
			}
		});
		ConfermaButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ConfermaButton.setBounds(293, 419, 192, 31);
		frame.getContentPane().add(ConfermaButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 397, 781, 2);
		frame.getContentPane().add(separator_1);
		
		
	}
}
