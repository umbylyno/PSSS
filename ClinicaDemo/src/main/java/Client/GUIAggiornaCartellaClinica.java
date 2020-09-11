package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAggiornaCartellaClinica {

	private JFrame frame;
	private JTextField AnagraficaField;
	private JTextField AnamnesiField;
	private JTextField ExamField;
	private JTextField PrescrizioniField;
	private JTextField TrattamentiField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		frame.setBounds(100, 100, 810, 1677);
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
		lblNewLabel_1.setBounds(17, 171, 174, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		AnagraficaField = new JTextField();
		AnagraficaField.setBounds(187, 82, 561, 226);
		frame.getContentPane().add(AnagraficaField);
		AnagraficaField.setColumns(10);
		AnagraficaField.setEditable(false);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 342, 786, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 637, 786, 2);
		frame.getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Anamnesi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(17, 466, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		AnamnesiField = new JTextField();
		AnamnesiField.setColumns(10);
		AnamnesiField.setBounds(187, 377, 561, 226);
		frame.getContentPane().add(AnamnesiField);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(0, 920, 786, 2);
		frame.getContentPane().add(separator_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Esami");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(17, 722, 78, 39);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		ExamField = new JTextField();
		ExamField.setColumns(10);
		ExamField.setBounds(187, 660, 561, 226);
		frame.getContentPane().add(ExamField);
		
		JLabel lblNewLabel_2 = new JLabel("Precedenti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(17, 761, 128, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(0, 1201, 786, 2);
		frame.getContentPane().add(separator_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prescrizioni");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(17, 1030, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		PrescrizioniField = new JTextField();
		PrescrizioniField.setColumns(10);
		PrescrizioniField.setBounds(187, 941, 561, 226);
		frame.getContentPane().add(PrescrizioniField);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(0, 1482, 786, 2);
		frame.getContentPane().add(separator_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Trattamenti");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4.setBounds(17, 1311, 174, 29);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		TrattamentiField = new JTextField();
		TrattamentiField.setColumns(10);
		TrattamentiField.setBounds(187, 1222, 561, 226);
		frame.getContentPane().add(TrattamentiField);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Salva Cartella clinica
			}
		});
		SalvaButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		SalvaButton.setBounds(322, 1536, 149, 45);
		frame.getContentPane().add(SalvaButton);
	}

}
