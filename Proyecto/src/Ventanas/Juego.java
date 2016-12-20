package Ventanas;


import java.awt.EventQueue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BD.BD;
import LoginData.Usuario;
import LoginGui.VentanaContraseña;
import LoginGui.VentanaRegistro;
import LoginLogica.LoginManager;
import java.awt.Font;

public class Juego{

	/**
	 * 
	 */

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField pswField;
	private LoginManager lm = new LoginManager();
	/*
    private MenuPrincipal mp=new MenuPrincipal();
    private MenuMultijugador mm=new MenuMultijugador();
    private Menu1Jugador m1j=new Menu1Jugador();
    private MenuOpciones mo=new MenuOpciones();
    */
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
	frame.getContentPane().setLayout(null);
	
	JPanel pnlLogin = new JPanel();
	pnlLogin.setBounds(0, -11, 1194, 736);
	frame.getContentPane().add(pnlLogin);
	pnlLogin.setLayout(null);
	
	JPanel pnlContraseña = new JPanel();
	pnlContraseña.setBounds(10, 433, 1087, 196);
	pnlLogin.add(pnlContraseña);
	pnlContraseña.setLayout(null);
	
	JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
	lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblContrasea.setBounds(349, 0, 156, 54);
	pnlContraseña.add(lblContrasea);
	
	pswField = new JPasswordField();
	pswField.setBounds(489, 15, 189, 36);
	pnlContraseña.add(pswField);
	pswField.setColumns(10);
	
	JPanel pnlUsuario = new JPanel();
	pnlUsuario.setBounds(0, 206, 1184, 210);
	pnlLogin.add(pnlUsuario);
	pnlUsuario.setLayout(null);
	
	JLabel lblUsuario = new JLabel("Usuario:");
	lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblUsuario.setBounds(396, 85, 112, 39);
	pnlUsuario.add(lblUsuario);
	
	txtUsuario = new JTextField();
	txtUsuario.setBounds(501, 85, 188, 43);
	pnlUsuario.add(txtUsuario);
	txtUsuario.setColumns(10);
	
	JLabel lbldWars = new JLabel("2D WARS");
	lbldWars.setFont(new Font("Tahoma", Font.PLAIN, 36));
	lbldWars.setBounds(457, 75, 322, 76);
	pnlLogin.add(lbldWars);
	
	JLabel lblXabierSarrionandia = new JLabel("Xabier Sarrionandia");
	lblXabierSarrionandia.setBounds(998, 664, 160, 14);
	pnlLogin.add(lblXabierSarrionandia);
	
	JLabel lblAnderVillate = new JLabel("Ander Villate");
	lblAnderVillate.setBounds(998, 689, 144, 14);
	pnlLogin.add(lblAnderVillate);
	
	JPanel pnlBotones = new JPanel();
	pnlBotones.setBounds(0, 729, 1184, 33);
	frame.getContentPane().add(pnlBotones);
	
	JButton btnAceptar = new JButton("Aceptar");
	btnAceptar.setBounds(367, 5, 100, 23);
	
	
	/////////////////////////////////////////////////////////////////////
	//METODO DE LAS VENTANAS
	/////////////////////////////////////////////////////////////////////
	
	
	btnAceptar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
			//FIXME base de datos da error en crear la base de datos con nombre "Local" (hay que elegir otro nombre) 
			Connection c=BD.initBD( "Local" );
			Statement st=BD.usarBD(c);
			BD.usarCrearTablasBD(c);
			ArrayList<Usuario> u=BD.usuarioSelect( st, "NOMBRE="+txtUsuario.getText()+" AND CONTRASEÑA="+ new String(pswField.getPassword()) );
			Usuario u1=u.get(0);			
			lm.registro(u1);
			
			
			
			
			//Cambiar que se obtena de la base de datos FIXME
			
			if(lm.login(u1.getNombre(),u1.getContraseña())){
				
				//TODO abrir las otras ventanas principales
				MenuPrincipal mp=new MenuPrincipal();
				frame.setVisible(false);
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
			JOptionPane.showMessageDialog(null, "Login Correcto");

		}
			else
				JOptionPane.showMessageDialog(null, "Error en el login", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	});
	pnlBotones.setLayout(null);
	pnlBotones.add(btnAceptar);
	
	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setBounds(482, 5, 100, 23);
	pnlBotones.add(btnCancelar);
	
	JButton btnRegistrar = new JButton("Registrar");
	btnRegistrar.setBounds(592, 5, 100, 23);
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
	btnRecuperar.setBounds(702, 5, 100, 23);
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
