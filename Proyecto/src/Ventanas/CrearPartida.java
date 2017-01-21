package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BD.BD;
import LoginLogica.LoginManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
		frame = new JFrame();
		setBounds(100, 100, 363, 192);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCrear = new JButton("Crear partida");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ventanas.Partida p=null;
				LogicaBatallas.LogicaPartida lb=new LogicaBatallas.LogicaPartida();
				LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();
				try {
					p = new Ventanas.Partida(p1, lb);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				p.setVisible(true);
				p.setSize(1200, 1000);
				//FIXME mirar si hay una aprtida con esos jugadores y si la hay, enviar una alerta (joption pane)
				//////TEMPORAL
				BD.usarCrearTablasBD(BD.initBD("Local"));
				LogicaBatallas.ElementosPartida pa=new LogicaBatallas.ElementosPartida(textField.getText(),textField_1.getText(),textField.getText()+"vs"+textField_1.getText());
				p.setP(pa);
				Statement st=BD.usarBD(BD.initBD("Local"));
				BD.PartidaInsert(st, p.getP());
				
				
				
			}
		});
		btnCrear.setBounds(81, 115, 114, 23);
		getContentPane().add(btnCrear);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(false);
			
			}
		});
		btnVolver.setBounds(228, 115, 89, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblUsuario = new JLabel("Usuario 1:");
		lblUsuario.setBounds(81, 42, 77, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblUsuario_1 = new JLabel("Usuario 2:");
		lblUsuario_1.setBounds(81, 67, 77, 14);
		getContentPane().add(lblUsuario_1);
		
		textField = new JTextField();
		textField.setBounds(168, 39, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(LoginManager.getUsuario().getNombre());
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 64, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	
	}
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
	}
}
