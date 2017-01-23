package Ventanas;

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
/**
 * 
 * Clase que permite crear partidas multijugador
 *
 */
public class CrearPartida extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;



	/**
	 * Metodo para crear la ventana con la que se crean partidas
	 * En caso de valores repetidos, se alerta al usuario del error
	 * 
	 */
	public CrearPartida() {
		frame = new JFrame();
		setBounds(100, 100, 363, 192);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		//Boton para crear la partida
		JButton btnCrear = new JButton("Crear partida");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Se inicializa la partida como null para evitar conflictos posteriores
				Ventanas.Partida p=null;
				//Elementos principales de una partida
				LogicaBatallas.ArraysPartida lb=new LogicaBatallas.ArraysPartida();
				LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();
				//Conexion a BD remota (creacion de tablas en caso de no haber)
				BD.usarCrearTablasBD(BD.initBDOnline("Remoto"));
				//Se crea el objeto ElementosPartida con los valores pasados por parametro
				LogicaBatallas.ElementosPartida pa=new LogicaBatallas.ElementosPartida(textField.getText(),textField_1.getText(),textField.getText()+" vs "+textField_1.getText());
				
				//Se recupera las partidas que coincidan con los jugadores indicados
				ArrayList<ElementosPartida> p2=BD.PartidaSelect(BD.usarBD(BD.initBDOnline("Remoto")),"usuario1='"+textField_1.getText()+"' and usuario2='"+textField.getText()+"' or usuario1='"+textField.getText()+"' and usuario2='"+textField_1.getText()+"'");
				//Si el tamaño del array p2 es 0, significa que no hay ninuna partida que coincida  con esos jugadores
				if(p2.size()==0){
					//Se recupera la lista de usuario
					ArrayList<Usuario> a=BD.usuarioSelect(BD.usarBD(BD.initBDOnline("Remoto")),"nombre='"+textField_1.getText()+"'");
					//Si el otro usuario existe, el array de usuarios a deberia tener un tamaño distinto de 0
					if(a.size()!=0 ){try {
						//se crea la ventana
						p = new Ventanas.Partida(p1, lb);
					} catch (IOException e) {

						e.printStackTrace();
					}
					//se ajustan las propiedades de la ventana
					setVisible(false);
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					p.setVisible(true);
					p.setSize(970, 950);
					p.setResizable(false);
					//se repintan los botones
					p.repintar();
					}
					//en caso de existir la persona, se ejecuta el codigo siguiente, que de lo contrario dara un NullPointerException
				try{
				//Se ajustan los valores siguientes a la partida
				p.setP(pa);
				Statement st=BD.usarBD(BD.initBDOnline("Remoto"));
				BD.PartidaInsert(st, p.getP());
				}catch(NullPointerException e){
				//El usuario no existe, y se avisa mediante una alerta
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
				//Si todo lo anterior no se cumple, se da el caso de que la partida contra el jugador objetivo existe y se alerta por pantalla
				else{JFrame frame=new JFrame();
				Object[] options = {"OK"};
			    int n = JOptionPane.showOptionDialog(frame,
		                "Ya existe una partida contra "+textField_1.getText(),"Cuidado",
		                JOptionPane.PLAIN_MESSAGE,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                options,
		                options[0]);
			    //Despues, se vuelve al menu multijugador
			    setVisible(false);
			    MenuMultijugador mm=new MenuMultijugador();
				mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mm.setVisible(true);
				
				}

				
			}
		});
		btnCrear.setBounds(81, 115, 114, 23);
		getContentPane().add(btnCrear);
		//Boton para volver al menu multijugador
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
}
