package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import BD.BD;
import LogicaBatallas.Partida;
import LoginLogica.LoginManager;

import java.awt.Font;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuMultijugador extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	private JFrame frame;
	private JTextField textDinero1;
	private JTextField textpuntos1;
	private JTextField textdinero2;
	private JTextField textpuntos2;
	private JTextField textUsuario2;
	private JTextField textUsuario1;
	private JTextField textFecha;

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
		 
		 
		 ArrayList<LogicaBatallas.Partida> a=BD.PartidaSelect( BD.usarBD(BD.initBD("Local")),"usuario1="+Juego.getLM().getUsuario()+" OR usuario2="+Juego.getLM().getUsuario());//FIXME cambiar la conexion
		//AÑADIR LA UNION DE BASE DE DATOS FIXME
		

		
		JComboBox<LogicaBatallas.Partida> comboBox =new JComboBox<LogicaBatallas.Partida>();
		for(LogicaBatallas.Partida p:a){comboBox.addItem(p);}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()!=null){
					textDinero1.setText(""+a.get(comboBox.getSelectedIndex()).getDineroAliado());
					textpuntos1.setText(""+a.get(comboBox.getSelectedIndex()).getPuntuacionAliado());
					textdinero2.setText(""+a.get(comboBox.getSelectedIndex()).getDineroEnemigo());
					textpuntos2.setText(""+a.get(comboBox.getSelectedIndex()).getPuntuacionEnemigo());
					textUsuario2.setText(""+a.get(comboBox.getSelectedIndex()).getUsuario2());
					textUsuario1.setText(""+a.get(comboBox.getSelectedIndex()).getUsuario());
					textFecha.setText(""+a.get(comboBox.getSelectedIndex()).getFechaPartida());
				}
			}
		});
		
		
		
		
		
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
		
		textDinero1 = new JTextField();
		textDinero1.setBounds(696, 291, 86, 20);
		 getContentPane().add(textDinero1);
		textDinero1.setColumns(10);
		
		textpuntos1 = new JTextField();
		textpuntos1.setBounds(696, 316, 86, 20);
		 getContentPane().add(textpuntos1);
		textpuntos1.setColumns(10);
		
		textdinero2 = new JTextField();
		textdinero2.setBounds(696, 414, 86, 20);
		 getContentPane().add(textdinero2);
		textdinero2.setColumns(10);
		
		textpuntos2 = new JTextField();
		textpuntos2.setBounds(696, 439, 86, 20);
		 getContentPane().add(textpuntos2);
		textpuntos2.setColumns(10);
		
		textUsuario2 = new JTextField();
		textUsuario2.setBounds(653, 367, 86, 20);
		 getContentPane().add(textUsuario2);
		textUsuario2.setColumns(10);
		
		textUsuario1 = new JTextField();
		textUsuario1.setBounds(653, 254, 86, 20);
		 getContentPane().add(textUsuario1);
		textUsuario1.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(651, 216, 86, 20);
		 getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		JButton btnJugar = new JButton("JUGAR!");
		btnJugar.setBounds(358, 681, 127, 23);
		 getContentPane().add(btnJugar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(681, 681, 89, 23);
		 getContentPane().add(btnVolver);
		 
		 JButton btnCrearPartida = new JButton("Crear partida");
		 btnCrearPartida.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		CrearPartida cp=new CrearPartida();
		 		
		 		
		 		
		 		
		 	}
		 });
		 btnCrearPartida.setBounds(523, 681, 118, 23);
		 getContentPane().add(btnCrearPartida);
	}
}
