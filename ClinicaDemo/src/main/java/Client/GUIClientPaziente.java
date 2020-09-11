package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIClientPaziente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIClientPaziente window = new GUIClientPaziente();
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
	public GUIClientPaziente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Recuperiamo qui il nome e cognome di un paziente
		
		frame = new JFrame();
		frame.setBounds(100, 100, 861, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLINICA PRIVATA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(304, 19, 261, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 64, 837, 2);
		frame.getContentPane().add(separator);
		
		JLabel LabelNomePaziente = new JLabel("New label");
		LabelNomePaziente.setBounds(61, 117, 82, 23);
		frame.getContentPane().add(LabelNomePaziente);
		
		JButton VisualizzaCartellaButton = new JButton("Visualizza cartella clinica");
		VisualizzaCartellaButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		VisualizzaCartellaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Metodo della cartella clinica
				Client.GUIVisualizzaCartellaClinica.main();
				//frame.setVisible(false);
			}
		});
		
		VisualizzaCartellaButton.setBounds(78, 274, 318, 63);
		frame.getContentPane().add(VisualizzaCartellaButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 409, 837, 2);
		frame.getContentPane().add(separator_1);
		
		JButton PrenotazioneButton = new JButton("Effettua una prenotazione");
		PrenotazioneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIEffettuaPrenotazione.main();
//				frame.setVisible(false);
			}
		});
		PrenotazioneButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		PrenotazioneButton.setBounds(450, 274, 339, 63);
		frame.getContentPane().add(PrenotazioneButton);
		LabelNomePaziente.setVisible(false);
	}
}
