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
import LoginData.Usuario;
import LoginLogica.LoginManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;

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
				LogicaBatallas.ArraysPartida lb=new LogicaBatallas.ArraysPartida();
				LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();

				//FIXME mirar si hay una aprtida con esos jugadores y si la hay, enviar una alerta (joption pane)
				//////TEMPORAL
				BD.usarCrearTablasBD(BD.initBD("Local"));
				
				LogicaBatallas.ElementosPartida pa=new LogicaBatallas.ElementosPartida(textField.getText(),textField_1.getText(),textField.getText()+" vs "+textField_1.getText());
				
				
				ArrayList<ElementosPartida> p2=BD.PartidaSelect(BD.usarBD(BD.initBD("Local")),"usuario1='"+textField_1.getText()+"' and usuario2='"+textField.getText()+"' or usuario1='"+textField.getText()+"' and usuario2='"+textField_1.getText()+"'");
				if(p2.size()==0){
					ArrayList<Usuario> a=BD.usuarioSelect(BD.usarBD(BD.initBD("Local")),"nombre='"+textField_1.getText()+"'");
					
					if(a.size()!=0 ){try {
						p = new Ventanas.Partida(p1, lb);
					} catch (IOException e) {

						e.printStackTrace();
					}
					
					setVisible(false);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					p.setVisible(true);
					p.setSize(970, 950);
					p.setResizable(false);}
					
					try{
				p.setP(pa);
				Statement st=BD.usarBD(BD.initBD("Local"));
				BD.PartidaInsert(st, p.getP());
				}catch(NullPointerException e){System.out.println("No existe esa persona");//FIXME sustituir por logger
				JFrame frame=new JFrame();
				Object[] options = {"OK"};
			    int n = JOptionPane.showOptionDialog(frame,
		                "No existe ese jugador "+textField_1.getText(),"Cuidado",
		                JOptionPane.PLAIN_MESSAGE,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                options,
		                options[0]);
			    setVisible(false);
			    MenuMultijugador mm=new MenuMultijugador();
				mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mm.setVisible(true);}
				

				}
				else{						JFrame frame=new JFrame();
				Object[] options = {"OK"};
			    int n = JOptionPane.showOptionDialog(frame,
		                "Ya existe una partida contra "+textField_1.getText(),"Cuidado",
		                JOptionPane.PLAIN_MESSAGE,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                options,
		                options[0]);
			    setVisible(false);
			    MenuMultijugador mm=new MenuMultijugador();
				mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mm.setVisible(true);
				
				}

				
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
		    MenuMultijugador mm=new MenuMultijugador();
			mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			mm.setVisible(true);
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
