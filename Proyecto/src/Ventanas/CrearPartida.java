package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BD.BD;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class CrearPartida extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPartida window = new CrearPartida();
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
	public CrearPartida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 363, 192);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCrear = new JButton("Crear partida");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Partida p=null;
				try {
					p = new Partida();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(false);
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				p.setVisible(true);
				p.setSize(1200, 1000);
				//FIXME es temporal pero ni creando las tablas con el codigo de usarCrearTablas la partida multijugador se ejecuta
				//////TEMPORAL
				BD.usarCrearTablasBD(BD.initBD("Local"));
				//////
				//FIXME las operaciones de crear una nueva partida (crear un constructor de ventana con parametros como oro y demas o sino como loginmanager meter un objeto como atributo a PARTIDA)
				LogicaBatallas.Partida pa=new LogicaBatallas.Partida(textField.getText(),textField_1.getText(),System.currentTimeMillis(),textField.getText()+"vs"+textField_1.getText());
				p.setP(pa);
				Statement st=BD.usarBD(BD.initBD("Local"));
				BD.PartidaInsert(st, p.getP());
				
				
				
			}
		});
		btnCrear.setBounds(81, 115, 114, 23);
		frame.getContentPane().add(btnCrear);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setVisible(false);
			
			}
		});
		btnVolver.setBounds(228, 115, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		JLabel lblUsuario = new JLabel("Usuario 1:");
		lblUsuario.setBounds(81, 42, 77, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblUsuario_1 = new JLabel("Usuario 2:");
		lblUsuario_1.setBounds(81, 67, 77, 14);
		frame.getContentPane().add(lblUsuario_1);
		
		textField = new JTextField();
		textField.setBounds(168, 39, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 64, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
