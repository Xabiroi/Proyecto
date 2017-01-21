package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import BD.BD;



public class Menu1Jugador extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
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
					Menu1Jugador window = new Menu1Jugador();
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
	public Menu1Jugador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

			
			setBounds(100, 100, 1193, 802);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Partida local");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(498, 62, 241, 60);
			 getContentPane().add(lblNewLabel);
			
			 ArrayList<LogicaBatallas.ElementosPartida> a=BD.PartidaSelect1J( BD.usarBD(BD.initBD("Local")),"usuario1="+"'"+Juego.getLM().getUsuario().getNombre()+"'");
				JComboBox<LogicaBatallas.ElementosPartida> comboBox =new JComboBox<LogicaBatallas.ElementosPartida>();
				for(LogicaBatallas.ElementosPartida p:a){comboBox.addItem(p);}
				
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBox.getSelectedItem()!=null){
							textDinero1.setText(""+a.get(comboBox.getSelectedIndex()).getDineroAliado());
							textpuntos1.setText(""+a.get(comboBox.getSelectedIndex()).getPuntuacionAliado());
							textdinero2.setText(""+a.get(comboBox.getSelectedIndex()).getDineroEnemigo());
							textpuntos2.setText(""+a.get(comboBox.getSelectedIndex()).getPuntuacionEnemigo());
							textUsuario2.setText("J2 Local");
							textUsuario1.setText(a.get(comboBox.getSelectedIndex()).getUsuario());
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
			lblFecha.setBounds(599, 219, 49, 14);
			 getContentPane().add(lblFecha);
			
			JLabel lblUsuario = new JLabel("Usuario 1:");
			lblUsuario.setBounds(577, 257, 71, 14);
			 getContentPane().add(lblUsuario);
			
			JLabel lblUsuario_1 = new JLabel("Usuario 2:");
			lblUsuario_1.setBounds(577, 370, 71, 14);
			 getContentPane().add(lblUsuario_1);
			
			JLabel lblDinero = new JLabel("Dinero");
			lblDinero.setBounds(627, 294, 59, 14);
			 getContentPane().add(lblDinero);
			
			JLabel lblPuntos = new JLabel("Puntos");
			lblPuntos.setBounds(627, 319, 46, 14);
			 getContentPane().add(lblPuntos);
			
			JLabel lblDinero_1 = new JLabel("Dinero");
			lblDinero_1.setBounds(627, 417, 46, 14);
			 getContentPane().add(lblDinero_1);
			
			JLabel lblPuntos_1 = new JLabel("Puntos");
			lblPuntos_1.setBounds(627, 442, 46, 14);
			 getContentPane().add(lblPuntos_1);
			
			textDinero1 = new JTextField();
			textDinero1.setBounds(696, 291, 86, 20);
			textDinero1.setEditable(false);
			 getContentPane().add(textDinero1);
			textDinero1.setColumns(10);
			
			textpuntos1 = new JTextField();
			textpuntos1.setBounds(696, 316, 86, 20);
			textpuntos1.setEditable(false);
			 getContentPane().add(textpuntos1);
			textpuntos1.setColumns(10);
			
			textdinero2 = new JTextField();
			textdinero2.setBounds(696, 414, 86, 20);
			textdinero2.setEditable(false);
			 getContentPane().add(textdinero2);
			textdinero2.setColumns(10);
			
			textpuntos2 = new JTextField();
			textpuntos2.setBounds(696, 439, 86, 20);
			textpuntos2.setEditable(false);
			 getContentPane().add(textpuntos2);
			textpuntos2.setColumns(10);
			
			textUsuario2 = new JTextField();
			textUsuario2.setBounds(653, 367, 86, 20);
			textUsuario2.setEditable(false);
			 getContentPane().add(textUsuario2);
			textUsuario2.setColumns(10);
			
			textUsuario1 = new JTextField();
			textUsuario1.setBounds(653, 254, 86, 20);
			textUsuario1.setEditable(false);
			 getContentPane().add(textUsuario1);
			textUsuario1.setColumns(10);
			
			textFecha = new JTextField();
			textFecha.setBounds(651, 216, 86, 20);
			textFecha.setEditable(false);
			 getContentPane().add(textFecha);
			textFecha.setColumns(10);
			
			JButton btnJugar = new JButton("JUGAR!");
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Ventanas.Partida p=null;
					//TODO añadir las recuperaciones de la base de datos para la partida (soldados y asi)
					LogicaBatallas.LogicaPartida lb=new LogicaBatallas.LogicaPartida();
					LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();
				//	lb.setListaAliados(listaAliados);//FIXME hay que cambiar la parte de BD de soldados para poder distinguir de que equipo son
				//	lb.setListaEnemigos(listaEnemigos);
					p1=BD.PartidaSelect(BD.usarBD(BD.initBD("Local")), "USUARIO="+Juego.getLM().getUsuario().getNombre()+"'").get(0);
					
					
					
					
					
					try {
						p = new Ventanas.Partida(p1,lb);
						p.setSize(965, 940);
						p.setResizable(false);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.setVisible(false);
					p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					p.setVisible(true);
					
				}
			});
			btnJugar.setBounds(358, 681, 127, 23);
			 getContentPane().add(btnJugar);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setVisible(false);
					MenuPrincipal mp=new MenuPrincipal();
					mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					mp.setVisible(true);
					
				}
			});
			btnVolver.setBounds(681, 681, 89, 23);
			 getContentPane().add(btnVolver);
			 
			 JButton btnCrearPartida = new JButton("Crear partida");
			 btnCrearPartida.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		CrearPartida cp=new CrearPartida();
			 		cp.initialize();
			 		cp.setBounds(100, 100, 363, 192);
					cp.getContentPane().setLayout(null);
			 		setVisible(false);
			 		cp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					cp.setVisible(true);
			 		
			 	}
			 });
			 btnCrearPartida.setBounds(523, 681, 118, 23);
			 getContentPane().add(btnCrearPartida);
		}
	}
