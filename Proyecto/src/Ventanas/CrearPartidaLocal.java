package Ventanas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.BD;
import LogicaBatallas.ElementosPartida;
import LoginLogica.LoginManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 
 *Clase que permite crear partidas locales
 *
 */
//Clase con la misma estructura que CrearPartida pero con funcionalidad un poco distinta
public class CrearPartidaLocal extends JDialog{

	//Atributos
	private static final long serialVersionUID = 6L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Constructor de la aplicacion.
	 */
	public CrearPartidaLocal() {
		setFrame(new JFrame());
		setBounds(100, 100, 363, 192);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCrear = new JButton("Crear partida");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ventanas.Partida p=null;
				LogicaBatallas.ArraysPartida lb=new LogicaBatallas.ArraysPartida();
				LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();
				//Variable para solucionar un problema posterior con partidas existentes, si existe ya, la variable cambia de valor y no se ejecuta la creacion de la ventana
				int n=0;
				
				//Conexiones a la base de datos local
				BD.usarCrearTablasBD(BD.initBD("Local"));
				Statement st=BD.usarBD(BD.initBD("Local"));
				LogicaBatallas.ElementosPartida pa=new LogicaBatallas.ElementosPartida(textField.getText(),textField_1.getText(),textField.getText()+" vs "+textField_1.getText());
				ArrayList<ElementosPartida> a1=BD.PartidaSelect1J(st,"");
					
					for(LogicaBatallas.ElementosPartida l:a1){//Partida existente
						if(l.getPartida().equals(textField.getText()+"vs"+textField_1.getText())){
						n=1;
						JFrame frame=new JFrame();
						Object[] options = {"OK"};
					    int j = JOptionPane.showOptionDialog(frame,
				                "Ya existe una partida contra "+textField_1.getText(),"Cuidado",
				                JOptionPane.PLAIN_MESSAGE,
				                JOptionPane.QUESTION_MESSAGE,
				                null,
				                options,
				                options[0]);
					    setVisible(false);
					    Menu1Jugador mm=new Menu1Jugador();
						mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						mm.setVisible(true);}}
					//En caso de que la variable n siga con el valor 0, es decir, no haya partida existente con ese nombre
					if(n==0){
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
					p.setSize(970, 950);
					p.setResizable(false);
					p.repintar();
					//Conexion local y operaciones locales
					BD.usarCrearTablasBD(BD.initBD("Local"));
					p.setP(pa);
					BD.Partida1JInsert(st, p.getP());;
					}
				}

				
			
		});
		btnCrear.setBounds(81, 115, 114, 23);
		getContentPane().add(btnCrear);
		//Boton volver
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

	/**
	 * Devuelve el frame principal
	 * @return frame principal
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Modifica el frame principal
	 * @param frame indicado
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
