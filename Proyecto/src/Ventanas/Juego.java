package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import LoginGui.VentanaContraseña;
import LoginGui.VentanaRegistro;
import LoginLogica.LoginManager;

public class Juego {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField pswField;
	private LoginManager lm = new LoginManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					/*
					 * 
					 * 
					 * 
					 * FIXME
					 Ventana V2
					VentanaLogin window = new VentanaLogin();
					window.frame.setVisible(true);
					
					*/
					
					Juego window1 = new Juego();
					window1.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Juego(){
	frame = new JFrame();
	frame.setBounds(100,100,1200, 800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new BorderLayout(0, 0));
	
	JPanel pnlLogin = new JPanel();
	frame.getContentPane().add(pnlLogin);
	pnlLogin.setLayout(new GridLayout(2, 0, 0, 0));
	
	JPanel pnlUsuario = new JPanel();
	pnlLogin.add(pnlUsuario);
	
	JLabel lblUsuario = new JLabel("Usuario:");
	pnlUsuario.add(lblUsuario);
	
	txtUsuario = new JTextField();
	pnlUsuario.add(txtUsuario);
	txtUsuario.setColumns(10);
	
	JPanel pnlContraseña = new JPanel();
	pnlLogin.add(pnlContraseña);
	
	JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
	pnlContraseña.add(lblContrasea);
	
	pswField = new JPasswordField();
	pswField.setColumns(10);
	pnlContraseña.add(pswField);
	
	JPanel pnlBotones = new JPanel();
	frame.getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	
	JButton btnAceptar = new JButton("Aceptar");
	btnAceptar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(lm.login(txtUsuario.getText(),
					new String(pswField.getPassword())))
				//TODO abrir las otras ventanas principales
				
				JOptionPane.showMessageDialog(null, "Login Correcto");
			
			else
				
				
				
				JOptionPane.showMessageDialog(null, "Error en el login", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	});
	pnlBotones.add(btnAceptar);
	
	JButton btnCancelar = new JButton("Cancelar");
	pnlBotones.add(btnCancelar);
	
	JButton btnRegistrar = new JButton("Registrar");
	btnRegistrar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			//TODO Guardar en la base de datos los jugadores
			VentanaRegistro dialog = new VentanaRegistro(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	});
	pnlBotones.add(btnRegistrar);
	
	JButton btnRecuperar = new JButton("Recuperar");
	btnRecuperar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			VentanaContraseña dialog = new VentanaContraseña(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	});
	pnlBotones.add(btnRecuperar);
}



}
