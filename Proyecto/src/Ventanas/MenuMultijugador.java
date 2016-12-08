package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuMultijugador extends JDialog{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMultijugador window = new MenuMultijugador();
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
	public MenuMultijugador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 1193, 802);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Multijugador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(498, 62, 241, 60);
		 getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 209, 200, 35);
		 getContentPane().add(comboBox);
		
		JLabel lblPartidas = new JLabel("Partidas");
		lblPartidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPartidas.setBounds(114, 184, 93, 14);
		 getContentPane().add(lblPartidas);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(615, 219, 33, 14);
		 getContentPane().add(lblFecha);
		
		JLabel lblUsuario = new JLabel("Usuario 1:");
		lblUsuario.setBounds(599, 257, 49, 14);
		 getContentPane().add(lblUsuario);
		
		JLabel lblUsuario_1 = new JLabel("Usuario 2:");
		lblUsuario_1.setBounds(599, 370, 49, 14);
		 getContentPane().add(lblUsuario_1);
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setBounds(640, 294, 46, 14);
		 getContentPane().add(lblDinero);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setBounds(640, 319, 33, 14);
		 getContentPane().add(lblPuntos);
		
		JLabel lblDinero_1 = new JLabel("Dinero");
		lblDinero_1.setBounds(640, 417, 33, 14);
		 getContentPane().add(lblDinero_1);
		
		JLabel lblPuntos_1 = new JLabel("Puntos");
		lblPuntos_1.setBounds(640, 442, 33, 14);
		 getContentPane().add(lblPuntos_1);
		
		textField = new JTextField();
		textField.setBounds(696, 291, 86, 20);
		 getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(696, 316, 86, 20);
		 getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(696, 414, 86, 20);
		 getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(696, 439, 86, 20);
		 getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(653, 367, 86, 20);
		 getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(653, 254, 86, 20);
		 getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(651, 216, 86, 20);
		 getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnJugar = new JButton("JUGAR!");
		btnJugar.setBounds(413, 681, 89, 23);
		 getContentPane().add(btnJugar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(597, 681, 89, 23);
		 getContentPane().add(btnVolver);
	}
}
