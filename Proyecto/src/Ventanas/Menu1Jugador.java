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
import BD.UnidadBD;
import LogicaBatallas.ElementosPartida;
import UnidadesAmigas.Bazooka;
import UnidadesAmigas.Francotirador;
import UnidadesAmigas.Semioruga;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Spawn;
import UnidadesAmigas.Tanque;
import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.BazookaEnemigo;
import UnidadesEnemigas.FrancotiradorEnemigo;
import UnidadesEnemigas.SemiorugaEnemigo;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.SpawnEnemigo;
import UnidadesEnemigas.TanqueEnemigo;
import UnidadesEnemigas.UnidadEnemiga;


/**
 * 
 *Menu para jugar en local (1 ordenador)
 *
 */
public class Menu1Jugador extends JDialog{


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
	 * Constructor
	 */
	public Menu1Jugador() {
		initialize();
	}

	/**
	 * Metodo que inicializa los objetos y valores de la ventana
	 */
	private void initialize() {

			
			setBounds(100, 100, 1193, 802);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Partida local");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(498, 62, 241, 60);
			 getContentPane().add(lblNewLabel);
			//Elige las partidas que tenga como usuario el mismo jugador
			 ArrayList<LogicaBatallas.ElementosPartida> a=BD.PartidaSelect1J( BD.usarBD(BD.initBD("Local")),"usuario1="+"'"+Juego.getLM().getUsuario().getNombre()+"'");
			 //A�ade las partidas a un comboBox, y en caso de seleccionar una, se muestran los valores de la partida
				JComboBox<LogicaBatallas.ElementosPartida> comboBox =new JComboBox<LogicaBatallas.ElementosPartida>();
				for(LogicaBatallas.ElementosPartida p:a){comboBox.addItem(p);}
				//Para mostrar solo el nombre, se ha a�adido un rendere al comboBox
				comboBox.setRenderer(new Renderer());
				comboBox.setSelectedItem(0);
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(comboBox.getSelectedItem()!=null){
							//Se muestran los valores si el item seleccionado existe
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
			//Boton que inicia la partida
			JButton btnJugar = new JButton("JUGAR!");
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//Evitar errores inicializando valores con null o de manera estandar
					Ventanas.Partida p=null;
					LogicaBatallas.ArraysPartida lb=new LogicaBatallas.ArraysPartida();
					LogicaBatallas.ElementosPartida p1=new LogicaBatallas.ElementosPartida();
					//Selecciona las unidades con el nombre elegido
					ArrayList<UnidadBD> Unidades=BD.UnidadBDSelectlocal(BD.usarBD(BD.initBD("Local")), "Partida='"+((ElementosPartida) comboBox.getSelectedItem()).getPartida()+"'");
					//Se reparten los soldados en dos equipos depende del flag de equipo que tengan
					ArrayList<UnidadBD> UnidadesAliadas1=new ArrayList<UnidadBD>();
					for(UnidadBD u:Unidades)if(u.getEquipo()==1){UnidadesAliadas1.add(u);}
					ArrayList<UnidadBD> UnidadesEnemigas1=new ArrayList<UnidadBD>();
					for(UnidadBD u:Unidades)if(u.getEquipo()==2){UnidadesEnemigas1.add(u);}
					//Se crean las listas definitivas que contienen los soldados que iran en el constructor de la partida
					ArrayList<UnidadAliada> UnidadesAliadas=new ArrayList<UnidadAliada>();
					ArrayList<UnidadEnemiga> UnidadesEnemigas=new ArrayList<UnidadEnemiga>();
					//Se clasifican las unidades dependiendo de su nombre y se les asigna valores
					for(UnidadBD u:UnidadesAliadas1){
						String nombre=null;
						nombre=u.getNombre();
						switch(nombre){
						case "Soldado":SoldadoRaso s=new SoldadoRaso(u.getCordX(),u.getCordY());
						s.setPartida(u.getPartida());
						s.setArmas(new String[] {"Fusil", "Pistola", "CCC" });
						s.setArma(u.getArma());
						s.setArmas(u.getArmas());
						s.setSalud(u.getSalud());
						s.setEquipo(u.getEquipo());
						s.setAcciones(u.getAcciones());
						UnidadesAliadas.add(s);
						break;
						case "Bazooka":Bazooka b=new Bazooka(u.getCordX(),u.getCordY());
						b.setPartida(u.getPartida());
						b.setArma(u.getArma());
						b.setArmas(new String[] {"Bazooka", "Pistola"});
						b.setArmas(u.getArmas());
						b.setSalud(u.getSalud());
						b.setEquipo(u.getEquipo());
						b.setAcciones(u.getAcciones());
						UnidadesAliadas.add(b);
						break;
						case "Francotirador":Francotirador f=new Francotirador(u.getCordX(),u.getCordY());
						f.setPartida(u.getPartida());
						f.setArma(u.getArma());
						f.setArmas(new String[] {"Rifle", "Pistola"});
						f.setSalud(u.getSalud());
						f.setEquipo(u.getEquipo());
						f.setAcciones(u.getAcciones());
						UnidadesAliadas.add(f);
						break;
						case "Tanque":Tanque t=new Tanque(u.getCordX(),u.getCordY());
						t.setPartida(u.getPartida());
						t.setArma(u.getArma());
						t.setArmas(new String[] {"Misil", "Ametralladora"});
						t.setSalud(u.getSalud());
						t.setEquipo(u.getEquipo());
						t.setAcciones(u.getAcciones());
						UnidadesAliadas.add(t);
						break;
						case "Semioruga":Semioruga se=new Semioruga(u.getCordX(),u.getCordY());
						se.setPartida(u.getPartida());
						se.setArma(u.getArma());
						se.setArmas(new String[] {"Ametralladora" });
						se.setSalud(u.getSalud());
						se.setEquipo(u.getEquipo());
						se.setAcciones(u.getAcciones());
						UnidadesAliadas.add(se);
						break;
						case "Spawn":Spawn sp=new Spawn(u.getCordX(),u.getCordY());
						sp.setPartida(u.getPartida());
						sp.setSalud(u.getSalud());
						sp.setEquipo(u.getEquipo());
						sp.setAcciones(u.getAcciones());
						UnidadesAliadas.add(sp);
						default:break;

						}
						
						
						
						
					}
					//Lo mismo para las unidades enemigas
					for(UnidadBD u:UnidadesEnemigas1){
						String nombre=null;
						nombre=u.getNombre();
						switch(nombre){
						case "Soldado":SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(u.getCordX(),u.getCordY());
						s.setPartida(u.getPartida());
						s.setArma(u.getArma());
						s.setArmas(u.getArmas());
						s.setSalud(u.getSalud());
						s.setEquipo(u.getEquipo());
						s.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(s);
						break;
						case "Bazooka":BazookaEnemigo b=new BazookaEnemigo(u.getCordX(),u.getCordY());
						b.setPartida(u.getPartida());
						b.setArma(u.getArma());
						b.setArmas(u.getArmas());
						b.setSalud(u.getSalud());
						b.setEquipo(u.getEquipo());
						b.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(b);
						break;
						case "Francotirador":FrancotiradorEnemigo f=new FrancotiradorEnemigo(u.getCordX(),u.getCordY());
						f.setPartida(u.getPartida());
						f.setArma(u.getArma());
						f.setArmas(u.getArmas());
						f.setSalud(u.getSalud());
						f.setEquipo(u.getEquipo());
						f.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(f);
						break;
						case "Tanque":TanqueEnemigo t=new TanqueEnemigo(u.getCordX(),u.getCordY());
						t.setPartida(u.getPartida());
						t.setArma(u.getArma());
						t.setArmas(u.getArmas());
						t.setSalud(u.getSalud());
						t.setEquipo(u.getEquipo());
						t.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(t);
						break;
						case "Semioruga":SemiorugaEnemigo se=new SemiorugaEnemigo(u.getCordX(),u.getCordY());
						se.setPartida(u.getPartida());
						se.setArma(u.getArma());
						se.setArmas(u.getArmas());
						se.setSalud(u.getSalud());
						se.setEquipo(u.getEquipo());
						se.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(se);
						break;
						case "Spawn":SpawnEnemigo sp=new SpawnEnemigo(u.getCordX(),u.getCordY());
						sp.setPartida(u.getPartida());
						sp.setSalud(u.getSalud());
						sp.setEquipo(u.getEquipo());
						sp.setAcciones(u.getAcciones());
						UnidadesEnemigas.add(sp);
						default:break;

						}
						
						
						
						
					}
					
					
					
					//Se asigna las listas definitivas al objeto lb
					lb.setListaEnemigos(UnidadesEnemigas);
					lb.setListaAliados(UnidadesAliadas);
					p1=BD.PartidaSelect1J(BD.usarBD(BD.initBD("Local")), "partida='"+((ElementosPartida) comboBox.getSelectedItem()).getPartida()+"'").get(0);//Coge una partida (local)
					//Se crea un tablero
					UnidadBD[][] tablero1=Ventanas.Partida.crearTablero();
					//Se colocan las unidades de las listas en el tablero
					for(UnidadAliada u:lb.getListaAliados()){tablero1[u.getCordX()][u.getCordY()]=u;}
					for(UnidadEnemiga u:lb.getListaEnemigos()){tablero1[u.getCordX()][u.getCordY()]=u;}
					
					//Se intenta crear la ventana de la partida con los valores que hemos obtenido
					try {
						p = new Ventanas.Partida(p1,lb);
						Partida.setTablero(tablero1);//Se le asigna el nuevo tablero con las unidades recuperadas
						p.setSize(965, 940);
						p.setResizable(false);
					} catch (IOException e) {
						e.printStackTrace();
					}
					setVisible(false);
					p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					p.setVisible(true);
					//Se repinta al crear la ventana
					p.repintar();
					
				}
			});
			btnJugar.setBounds(358, 681, 127, 23);
			 getContentPane().add(btnJugar);
			//Boton que vuelve a abrir el menu principal
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
			 //Boton que abre la ventana de crear partida local
			 JButton btnCrearPartida = new JButton("Crear partida");
			 btnCrearPartida.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		CrearPartidaLocal cp=new CrearPartidaLocal();
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
