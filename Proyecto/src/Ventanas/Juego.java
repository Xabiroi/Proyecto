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
import LoginGui.VentanaRegistro;
import LoginLogica.LoginManager;
import java.awt.Font;
/**
 * Clase principal que ejecuta 2D Wars
 * @author -Xabier Sarrionandia
 * @author -Ander Villate
 */
public class Juego{

	
//Atributos para el login 
	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField pswField;
	public static LoginManager lm = new LoginManager();
	/**
	 * 
	 * @return Devuelve el login manager que se esta utilizando
	 */
	public static LoginManager getLM(){return lm;}
	/**
	 * Main de la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					BD.usarCrearTablasBD(BD.initBDOnline("Remoto"));
					Juego window1 = new Juego();
					window1.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Constructor de la aplicacion
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
	
	
	////////////////////////////
	//LISTENER PARA EL LOGIN///
	//////////////////////////
	
	
	btnAceptar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {

		
			//Se autentifica via online (es necesario internet y acceso a la base de datos)
			Connection c=BD.initBDOnline( "Remoto" );
			Statement st=BD.usarBD(c);
			//Crea las tablas en caso de necesitarlas
			BD.usarCrearTablasBD(c);
			//Selecciona al usuario que tenga por nombre y contraseña esos datos
			ArrayList<Usuario> u=BD.usuarioSelect( st, "NOMBRE="+"'"+txtUsuario.getText()+"'"+" AND CONTRASEÑA="+"'"+ new String(pswField.getPassword())+"'" );
			Usuario u1=null;
			try{
			u1=u.get(0);
			lm.registro(u1);}catch(IndexOutOfBoundsException e){JOptionPane.showMessageDialog(null, "Login Erroneo");}
			//Se hace login con el usuario y contraseña
			try{
			if(lm.login(u1.getNombre(),u1.getContraseña())){
				//Si hace login se lanza la ventana principal con el mensaje de login correcto
				MenuPrincipal mp=new MenuPrincipal();
				frame.setVisible(false);
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
			JOptionPane.showMessageDialog(null, "Login Correcto");

		}
		}catch(NullPointerException e){}
		}});
	pnlBotones.setLayout(null);
	pnlBotones.add(btnAceptar);
	//Boton que cierra la aplicacion
	JButton btnCancelar = new JButton("Salir");
	btnCancelar.setBounds(482, 5, 100, 23);
	btnCancelar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.exit(0);
		}
	});
	pnlBotones.add(btnCancelar);
	//Ventana que inicia el registro de los jugadores
	JButton btnRegistrar = new JButton("Registrar");
	btnRegistrar.setBounds(592, 5, 100, 23);
	btnRegistrar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			VentanaRegistro dialog = new VentanaRegistro(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	});
	pnlBotones.add(btnRegistrar);

}
}
