package Ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.BD;
import BD.UnidadBD;
import LogicaBatallas.ArraysPartida;
import LogicaBatallas.ElementosPartida;
import LoginLogica.LoginManager;
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
 * Clase que contiene la ventana y metodos para jugar (botones principales)
 *
 */
public class Partida extends JDialog{

	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldPartida;
	private JTextField textFieldJugador1;
	private JTextField textFieldJugador2;
	private JTextField textFieldPuntosJ1;
	private JTextField textFieldPuntosJ2;
	private JTextField textFieldDineroJ1;
	private JTextField textFieldDineroJ2;
	private JTextField textFieldPropietario;
	private JTextField textFieldUnidad;
	private JTextField textFieldPS;
	private JTextField textFieldArma;
	private JButton btnCambiarArma;
	private JButton btnMover;
	private JButton btnSalir;
	private JButton btnAtacar;
	private JButton btnFinalizarTurno;
	private JButton btnGuardar;
	private LogicaBatallas.ArraysPartida lp;//Elementos importantes
	private static LogicaBatallas.ElementosPartida p;
	public static UnidadBD[][] tablero=crearTablero();//Tablero donde se juega
	private gridpanel gp=new gridpanel();//gridpanel en el que se basan las mecanicas del juego
/**
 * 
 * @return Objeto ElementosPartida actual
 */
	public static ElementosPartida getPartida() {
		return p;
	}
	/**
	 * 
	 * @return Objeto ArraysPartida actual
	 */
	private ArraysPartida getArrays() {
		return lp;
	}
	/**
	 * Metodo que devuelve el tablero original
	 * @return tablero de 32x32 sin unidades
	 */
	public static UnidadBD[][] crearTablero() {
		UnidadBD[][] tab={  
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new SpawnEnemigo(0,31) },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, null, null, null, null, new Colision( ) },
				{ null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, null, null, null, null, null, null, new Colision( ), null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, new Colision( ) },
				{ null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, null, null, null, new Colision( ), null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null },
				{ new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, new Colision( ), null, null, null, new Colision( ), null, null, null, new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null },
				{ new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null },
				{ new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, null, null },
				{ null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, null, null, new Colision( ), null, null },
				{ null, null, new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, null, null, null, null, new Colision( ), null, null },
				{ null, null, new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, new Colision( ), null, null, new Colision( ), null, null },
				{ null, new Colision( ), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, new Colision( ), new Colision( ), null, null, null, null, new Colision( ), null, null, null, null, null },
				{ new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null },
				{ new Colision( ), new Colision( ), null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, new Colision( ), null, null },
				{ null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, new Colision( ), null, null },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), null, null, new Colision( ), new Colision( ), null, null, null, null },
				{ null, null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, new Colision( ), null, null, null, new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ) },
				{ null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, new Colision( ), null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ) },
				{ null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, null },
				{ new Colision( ), null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, new Colision( ), null, null },
				{ new Colision( ), null, null, new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, new Colision( ), null, null },
				{ null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ) },
				{ null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, new Colision( ), null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ) },
				{ null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, new Colision( ), null, null, null, null, new Colision( ), null, null, null, new Colision( ), null, new Colision( ), new Colision( ), null, null, null, new Colision( ), null, null, new Colision( ), null, null, new Colision( ), new Colision( ), new Colision( ) },
				{ null, null, null, null, null, null, null, new Colision( ), null, null, null, null, null, null, null, null, null, null, null, new Colision( ), null, null, new Colision( ), new Colision( ), new Colision( ), null, new Colision( ), null, new Colision( ), new Colision( ), new Colision( ), new Colision( ) },
				{ null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, null, new Colision( ), null, null, null, new Colision( ), null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ) },
				{ new Colision( ), null, null, null, null, new Colision( ), new Colision( ), null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ) },
				{ new Colision( ), null, null, null, null, null, null, null, new Colision( ), new Colision( ), null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ) },
				{ new Spawn(31,0), null, null, null, null, null, null, null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), null, null, null, null, null, null, new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ), new Colision( ) }
				  };
		return tab;
	}
	/**
	 * Establece el objeto pasado por parametro como el objeto 
	 * ElementosPartida de la partida actual
	 * @param p1 Objeto ElementosPartida
	 */
	public static void setPartida(ElementosPartida p1) {
		p=p1;;
	}
	
	
		/*Como queda con las colisiones a modo de array  A=colision
		{  
		{ *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, s },
		{ *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, a, a, *, *, a, *, *, *, *, *, *, *, *, a },
		{ *, *, *, *, *, *, *, *, *, *, *, a, *, *, *, *, *, *, *, *, a, *, a, a, *, *, *, *, *, *, *, a },
		{ *, *, *, *, *, *, *, *, *, *, *, a, *, *, *, *, *, a, *, *, a, a, a, *, *, *, *, *, *, *, *, * },
		{ *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, a, a, a, a, a, *, *, *, *, *, * },
		{ a, a, a, *, *, *, *, *, *, a, *, *, *, a, *, *, *, a, a, *, a, a, a, a, a, a, *, *, *, *, *, * },
		{ a, a, a, a, *, *, *, *, *, *, *, *, *, *, *, *, *, a, a, *, a, a, a, a, a, a, *, *, *, *, *, * },
		{ a, a, a, a, a, a, a, a, a, *, *, *, *, a, *, *, *, a, a, a, a, a, a, *, *, a, *, *, *, *, *, * },
		{ *, *, *, *, a, a, a, a, a, a, *, *, *, *, *, *, *, a, a, a, a, a, a, *, *, *, *, *, *, *, *, * },
		{ *, *, *, *, a, a, *, *, *, a, a, a, *, *, *, a, a, a, a, a, a, a, *, *, *, *, *, *, *, *, *, * },
		{ *, *, *, *, a, a, *, *, *, a, a, a, *, *, *, a, a, a, a, a, *, *, a, *, *, *, *, *, *, a, *, * },
		{ *, *, a, *, *, *, *, a, a, *, a, a, *, *, *, *, *, *, *, *, *, *, a, *, *, *, *, *, *, a, *, * },
		{ *, *, a, *, *, *, *, a, a, *, a, a, *, *, *, *, *, *, *, *, a, a, *, *, *, *, a, *, *, a, *, * },
		{ *, a, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, a, *, *, a, a, *, *, *, *, a, *, *, *, *, * },
		{ a, a, *, *, *, *, *, *, *, *, *, *, *, a, a, a, a, *, *, *, a, a, *, *, *, *, *, *, *, *, *, * },
		{ a, a, *, *, *, *, *, a, a, a, *, *, a, *, *, *, *, *, *, *, a, a, *, *, *, *, *, *, *, a, *, * },
		{ *, *, *, *, *, *, *, a, a, a, *, *, a, *, *, *, *, a, a, a, a, *, *, *, *, *, *, *, *, a, *, * },
		{ *, *, *, *, *, *, *, *, *, *, *, *, *, a, *, *, *, a, a, a, a, *, a, a, *, *, a, a, *, *, *, * },
		{ *, *, *, *, a, a, a, *, *, *, *, *, *, a, *, *, *, a, *, *, *, *, a, a, *, *, *, a, a, a, a, a },
		{ *, *, *, *, a, a, a, a, *, a, *, *, *, *, *, *, *, *, *, *, *, *, a, *, *, *, *, *, *, a, a, a },
		{ *, *, *, *, *, a, a, a, a, a, *, *, *, *, *, *, *, *, a, a, *, *, *, *, *, *, *, *, *, *, *, * },
		{ *, *, *, *, *, *, a, a, a, a, a, *, *, *, *, a, a, a, a, a, *, *, *, *, *, *, *, *, *, *, *, * },
		{ a, *, *, *, *, *, *, a, a, a, a, *, *, *, *, a, a, a, a, *, *, *, a, a, a, a, a, a, *, a, *, * },
		{ a, *, *, a, *, *, *, *, a, a, *, *, *, *, *, *, *, a, a, *, *, *, *, *, a, a, a, a, *, a, *, * },
		{ *, *, *, a, a, a, *, *, *, *, *, *, *, *, *, *, *, a, a, a, *, *, *, *, a, a, *, *, *, a, a, a },
		{ *, a, a, a, a, a, *, *, *, *, *, *, *, *, *, *, a, *, a, a, *, *, *, *, *, *, *, *, *, a, a, a },
		{ *, a, a, a, a, *, *, a, *, *, *, *, a, *, *, *, a, *, a, a, *, *, *, a, *, *, a, *, *, a, a, a },
		{ *, *, *, *, *, *, *, a, *, *, *, *, *, *, *, *, *, *, *, a, *, *, a, a, a, *, a, *, a, a, a, a },
		{ *, *, *, *, *, a, a, *, *, *, *, *, *, a, a, *, *, *, *, a, *, *, *, a, *, *, a, a, a, a, a, a },
	//	{ a, *, *, *, *, a, a, *, a, a, *, *, *, a, a, *, *, *, *, *, *, *, *, *, *, *, a, a, a, a, a, a },
		{ a, *, *, *, *, *, *, *, a, a, *, *, *, a, a, a, a, a, *, *, *, *, *, *, *, a, a, a, a, a, a, a },
		{ s, *, *, *, *, *, *, *, *, *, *, *, *, a, a, a, a, a, a, *, *, *, *, *, *, a, a, a, a, a, a, a }
		  };
	*/
	
	
	//Atributos que son la base del juego
	private int xobj,yobj;//coordenadas donde se clicka
	public static UnidadBD UnidadActual=new UnidadBD();//Unidad que se esta controlando actualmente
	public static UnidadBD UnidadObjetivo=new UnidadBD();//Unidad a la que se desea atacar

	/**
	 * Metodo que cambia el tablero de la partida actual
	 * @param tablero1 tablero de dos dimensiones de unidadBD
	 */
	public static void setTablero(UnidadBD[][] tablero1) {
		tablero = tablero1;
	}
/**
 * Constructor de Partida
 * @param p ElementosPartida que lleva informacion
 * @param lp ArraysPartida que lleva las unidades
 * @throws IOException
 */
	public Partida(LogicaBatallas.ElementosPartida p,LogicaBatallas.ArraysPartida lp) throws IOException {
		Partida.p=p;
		this.lp=lp;
		this.initialize();
	}

	 Runnable myRunnable = new Runnable(){
/**
 * Hilo con dos metodos de repintar para que no haya errores
 */
		 public void run(){
					repintar2();
					repintar();
				}
	   };

	/**
	 * Metodo repintar que asigna imagenes a los botones segun las coordenadas que tengan (provienen de los arrays de soldados)
	 */
		public void repintar2(){
			//Recupera los soldados y los divide en dos grupos
			ArraysPartida a=getArrays();
			ArrayList<UnidadAliada> ua=a.getListaAliados();
			ArrayList<UnidadEnemiga> ue=a.getListaEnemigos();

			for(UnidadAliada u:ua){
				
				if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof SoldadoRaso){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/SoldadoRaso.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof Francotirador){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/Francotirador.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof Bazooka){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/Bazooka.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof Tanque){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/Tanque.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof Semioruga){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/Semioruga.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				
				

			}
			for(UnidadEnemiga u:ue){
				if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof SoldadoRasoEnemigo){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/SoldadoRasoEnemigo.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof FrancotiradorEnemigo){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/FrancotiradorEnemigo.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof BazookaEnemigo){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/BazookaEnemigo.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof TanqueEnemigo){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/TanqueEnemigo.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}
				else if(Partida.getTablero()[u.getCordX()][u.getCordY()] instanceof SemiorugaEnemigo){Partida.this.getGp().getGridButton(u.getCordX(),u.getCordY()).setIcon(new ImageIcon(getClass().getResource("/resources/SemiorugaEnemigo.png")));Partida.this.getGp().getGridButton(u.getCordX(), u.getCordY()).repaint();}

			}
			//Elimina los botones que no tengan soldados en su posicion
			for(int i=0;i<Partida.getTablero().length;i++){
				for(int j=0;j<Partida.getTablero()[0].length;j++){
					if(Partida.getTablero()[i][j]==null){Partida.this.getGp().getGridButton(i,j).setIcon(null);}
				}
				
			}
			
			
			
			
		}
		/**
		 * Metodo de repintar que comprueba que todos los botones tengan asignado el valor que deberia segun los soldados que haya en el tablero
		 */
	public void repintar(){
		for(int i=0;i<Partida.getTablero().length;i++){
			for(int j=0;j<Partida.getTablero()[0].length;j++){
				if(Partida.getTablero()[i][j]==null){Partida.this.getGp().getGridButton(i,j).setIcon(null);}
				else if(Partida.getTablero()[i][j] instanceof SoldadoRaso){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/SoldadoRaso.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof Francotirador){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/Francotirador.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof Bazooka){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/Bazooka.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof Tanque){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/Tanque.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof Semioruga){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/Semioruga.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof SoldadoRasoEnemigo){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/SoldadoRasoEnemigo.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof FrancotiradorEnemigo){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/FrancotiradorEnemigo.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof BazookaEnemigo){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/BazookaEnemigo.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof TanqueEnemigo){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/TanqueEnemigo.png")));Partida.this.getGp().getGridButton(i, j).repaint();}
				else if(Partida.getTablero()[i][j] instanceof SemiorugaEnemigo){Partida.this.getGp().getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/SemiorugaEnemigo.png")));Partida.this.getGp().getGridButton(i, j).repaint();}           
			
			}
		}
	}
	
	
	
	
/**
 * Inicializa el panel de partida
 * @throws IOException
 */
	private void initialize() throws IOException {
		new JFrame();
		setBounds(100, 100, 330, 141);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 114, 155, 492);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		

	//Boton que aplica el algoritmo de pathfinding y actualiza el tablero con el hilo
		btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				Thread thread = new Thread(myRunnable);

						if(tablero[xobj][yobj]==null){
							try{				
								int x=UnidadActual.getCordX();
								int y=UnidadActual.getCordY();
						tablero=UnidadActual.AlgoritmoPathfinding(UnidadActual.getDistancia(), UnidadActual.getCordX(), UnidadActual.getCordY(), xobj, yobj, tablero);
						if(tablero[xobj][yobj]==UnidadActual)
						tablero[x][y]=null;
						   thread.start();
							try {
								thread.join();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							}catch(NullPointerException e){}
					}
			}
		});
		btnMover.setBounds(30, 25, 101, 46);
		panel.add(btnMover);
		//Boton atacar que depende de cual sea el objetivo ataca o no
		btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
			actualiza();
			//Si el turno es el del jugador 1, solo podra atacar a al otro jugador
			//No recibe a sus unidades como objetivo
			if(p.getTurno()==0){
				if(tablero[xobj][yobj]==null){}
				else if(tablero[xobj][yobj] instanceof Colision){}
				else if(tablero[xobj][yobj] instanceof UnidadEnemiga){
					UnidadObjetivo=tablero[xobj][yobj];
					UnidadActual.atacar(xobj,yobj);
					UnidadActual.setAcciones(UnidadActual.getAcciones()-1);
					actualiza();
					Thread thread = new Thread(myRunnable);
					thread.start();
					try {
						thread.join();
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					//En caso de destruir el spawn enemigo,se da la partida por ganada
					if(Ventanas.Partida.getUnidadObjetivo().getSalud()<=0 && Ventanas.Partida.getUnidadObjetivo() instanceof SpawnEnemigo){
						JFrame frame=new JFrame();
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
				                "Has ganado!","Felicidades!",
				                JOptionPane.PLAIN_MESSAGE,
				                JOptionPane.QUESTION_MESSAGE,
				                null,
				                options,
				                options[0]);
					    
					    setVisible(false); 
					    //Diferencia de si se esta jugando en local o en multijugador
					    //Se comprueba el segundo usuario
					    if(p.getUsuario2()!=null){
					    BD.PartidaEliminar(BD.usarBD(BD.initBDOnline("Remoto")), p);
					    MenuPrincipal mp=new MenuPrincipal();
					    mp.setVisible(true);
					    }
					    else{
						    BD.PartidaLocalEliminar(BD.usarBD(BD.initBD("Local")), p);
						    MenuPrincipal mp=new MenuPrincipal();
						    mp.setVisible(true);
						    }
					}
					
					//Se reduce la cantidad de acciones que puede hacer
					UnidadActual.setAcciones(UnidadActual.getAcciones()-1);
					//actualiza los valores de la aprtida
					actualiza();
		        } 
			}
			//Este caso es lo contrario a lo que pasaria al turno 0
			else if(p.getTurno()==1){
				if(tablero[xobj][yobj]==null){}
				else if(tablero[xobj][yobj] instanceof Colision){}
				else if(tablero[xobj][yobj] instanceof UnidadAliada){
					UnidadObjetivo=tablero[xobj][yobj];
					UnidadActual.atacar(xobj,yobj);
					actualiza();
					Thread thread = new Thread(myRunnable);
					thread.start();
					try {
						thread.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if(Ventanas.Partida.getUnidadObjetivo().getSalud()<=0 && Ventanas.Partida.getUnidadObjetivo() instanceof Spawn){
						JFrame frame=new JFrame();
						Object[] options = {"OK"};
					    int n = JOptionPane.showOptionDialog(frame,
				                "Has ganado!","Felicidades!",
				                JOptionPane.PLAIN_MESSAGE,
				                JOptionPane.QUESTION_MESSAGE,
				                null,
				                options,
				                options[0]);
					    setVisible(false);
					    BD.PartidaEliminar(BD.usarBD(BD.initBD("Local")), p);
					    MenuPrincipal mp=new MenuPrincipal();
					    mp.setVisible(true);

					}
					//Se reduce la cantidad de acciones que puede hacer
					UnidadActual.setAcciones(UnidadActual.getAcciones()-1);
					//actualiza los valores de la aprtida
					actualiza();
		       }
			}
			
				
		    }
		});
		btnAtacar.setBounds(30, 82, 101, 46);
		panel.add(btnAtacar);
		//Boton que hace guardar la partida
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				//Distincion entre local y multijugador
				if(p.getUsuario2()==null){
					
				//Se actualizan los valores	
				BD.PartidaUpdate1J(BD.usarBD(BD.initBD("Local")),p);
				//Se eliminan todos los soldados relacionados con esa partida
				BD.SoldadosLocalEliminar(BD.usarBD(BD.initBD("Local")),p);
				//Se insertan los nuevos soldados (aliera tramites de comprobacion y update en caso de que sigan vivos)
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				//Se vuelve al menu principal
				setVisible(false);
				MenuPrincipal mp=new MenuPrincipal();
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
				}
				
				else{
					//Lo mismo pero para un partida multijugador
				BD.PartidaUpdate(BD.usarBD(BD.initBDOnline("Remoto")),p);
				BD.SoldadosEliminar(BD.usarBD(BD.initBDOnline("Remoto")),p);
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsert(BD.usarBD(BD.initBDOnline("Remoto")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsert(BD.usarBD(BD.initBDOnline("Remoto")),u);}
				setVisible(false);
				MenuPrincipal mp=new MenuPrincipal();
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
					}
			}
		});
		btnGuardar.setBounds(30, 298, 101, 23);
		panel.add(btnGuardar);
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				if(p.getUsuario2()==null){
					setVisible(false);
					Menu1Jugador mj=new Menu1Jugador();
					mj.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					mj.setVisible(true);}
				else{	setVisible(false);
				MenuMultijugador mm=new MenuMultijugador();
				mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mm.setVisible(true);
					
				}
			}
		});
		btnSalir.setBounds(30, 400, 101, 23);
		panel.add(btnSalir);
		//Boton que permite cambiar de arma, dependiendo de la situacion
		btnCambiarArma = new JButton("Cambiar arma");
		btnCambiarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				try{
				 JFrame frame = new JFrame("Cambiar Arma");
				 String[] armas =UnidadActual.getArmas();
				    String arma = (String) JOptionPane.showInputDialog(frame, 
				        "Elija el arma",
				        "Armas",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        armas, 
				        armas[0]);
				    tablero[UnidadActual.getCordX()][UnidadActual.getY()].setArma(arma);
				    UnidadActual.setAcciones(UnidadActual.getAcciones()-1);
				    	}
				catch(NullPointerException e){}
			}
		});
		btnCambiarArma.setBounds(30, 139, 101, 46);
		panel.add(btnCambiarArma);
		//Boton que finaliza turno y deja jugar al jugador siguiente
		btnFinalizarTurno = new JButton("Finalizar Turno");
		btnFinalizarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				if(p.getUsuario2()==null){
					if(p.getTurno()==0){p.setTurno(1);
					BD.PartidaUpdate1J(BD.usarBD(BD.initBD("Local")),p);
					p.setTurno(0);
					}else{p.setTurno(0);
						BD.PartidaUpdate1J(BD.usarBD(BD.initBD("Local")),p);
						p.setTurno(1);
					}
					
				//Se eliminan todos los soldados relacionados con esa partida
				BD.SoldadosLocalEliminar(BD.usarBD(BD.initBD("Local")),p);
				//Se insertan los nuevos soldados (aliera tramites de comprobacion y update en caso de que sigan vivos)
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				}
				
				else{
					//Lo mismo pero para un partidamultijugador
					if(p.getTurno()==0){p.setTurno(1);
					BD.PartidaUpdate(BD.usarBD(BD.initBDOnline("Local")),p);
					p.setTurno(0);
					}else{p.setTurno(0);
						BD.PartidaUpdate(BD.usarBD(BD.initBDOnline("Local")),p);
						p.setTurno(1);
					}
					
				

				BD.SoldadosEliminar(BD.usarBD(BD.initBDOnline("Remoto")),p);
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsert(BD.usarBD(BD.initBDOnline("Remoto")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsert(BD.usarBD(BD.initBDOnline("Remoto")),u);}
					}
				
				Thread thread = new Thread(myRunnable);
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				p.setDineroAliado(p.getDineroAliado()+50);
				p.setDineroEnemigo(p.getDineroEnemigo()+50);
				for(int i=0;i<tablero.length;i++){
					for(int j=0;j<tablero[0].length;j++){
						if(tablero[i][j] instanceof UnidadAliada || tablero[i][j] instanceof UnidadEnemiga){tablero[i][j].setAcciones(2);}
					}
				}
			
				actualiza();
				if(Partida.p.getTurno()==0){
					if(p.getUsuario2()!=null){textFieldPropietario.setText(p.getUsuario2());}else{textFieldPropietario.setText("J2 Local");}
			Partida.p.setTurno(1);JOptionPane.showMessageDialog(null, "Turno terminado");
				//Ccomprobar los turnos de los diferentes jugadores
					if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario2())){
						btnAtacar.setEnabled(true);
						btnAtacar.setFocusable(true);
						btnGuardar.setEnabled(true);
						btnGuardar.setFocusable(true);
						btnMover.setEnabled(true);
						btnMover.setFocusable(true);
						btnCambiarArma.setEnabled(true);
						btnCambiarArma.setFocusable(true);
						btnFinalizarTurno.setEnabled(true);
						btnFinalizarTurno.setFocusable(true);

					}
				else if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario())){
					if(p.getUsuario2()!=null){
						btnAtacar.setEnabled(false);
						btnAtacar.setFocusable(false);
						btnGuardar.setEnabled(false);
						btnGuardar.setFocusable(false);
						btnMover.setEnabled(false);
						btnMover.setFocusable(false);
						btnCambiarArma.setEnabled(false);
						btnCambiarArma.setFocusable(false);
						btnFinalizarTurno.setEnabled(false);
						btnFinalizarTurno.setFocusable(false);
					}//CAMBIO
					else{btnAtacar.setEnabled(true);
					btnAtacar.setFocusable(true);
					btnGuardar.setEnabled(true);
					btnGuardar.setFocusable(true);
					btnMover.setEnabled(true);
					btnMover.setFocusable(true);
					btnCambiarArma.setEnabled(true);
					btnCambiarArma.setFocusable(true);
					btnFinalizarTurno.setEnabled(true);
					btnFinalizarTurno.setFocusable(true);
						
					}
					}
				else if(p.getUsuario2()==null){
					btnAtacar.setEnabled(true);
					btnAtacar.setFocusable(true);
					btnGuardar.setEnabled(true);
					btnGuardar.setFocusable(true);
					btnMover.setEnabled(true);
					btnMover.setFocusable(true);
					btnCambiarArma.setEnabled(true);
					btnCambiarArma.setFocusable(true);
					btnFinalizarTurno.setEnabled(true);
					btnFinalizarTurno.setFocusable(true);
					

				}
					UnidadActual=new UnidadBD();UnidadObjetivo=new UnidadBD(); //Para no poder mover los soldados seleccionados anteriormente
					
				}
				
				
				//Turno 1
				else{Partida.p.setTurno(0);textFieldPropietario.setText(p.getUsuario());JOptionPane.showMessageDialog(null, "Turno terminado");
				if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario2())){
					btnAtacar.setEnabled(false);
					btnAtacar.setFocusable(false);
					btnGuardar.setEnabled(false);
					btnGuardar.setFocusable(false);
					btnMover.setEnabled(false);
					btnMover.setFocusable(false);
					btnCambiarArma.setEnabled(false);
					btnCambiarArma.setFocusable(false);
					btnFinalizarTurno.setEnabled(false);
					btnFinalizarTurno.setFocusable(false);
					

				
				}
				else if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario())){
					btnAtacar.setEnabled(true);
					btnAtacar.setFocusable(true);
					btnGuardar.setEnabled(true);
					btnGuardar.setFocusable(true);
					btnMover.setEnabled(true);
					btnMover.setFocusable(true);
					btnCambiarArma.setEnabled(true);
					btnCambiarArma.setFocusable(true);
					btnFinalizarTurno.setEnabled(true);
					btnFinalizarTurno.setFocusable(true);
					

				}
				else if(p.getUsuario2()==null){
					btnAtacar.setEnabled(true);
					btnAtacar.setFocusable(true);
					btnGuardar.setEnabled(true);
					btnGuardar.setFocusable(true);
					btnMover.setEnabled(true);
					btnMover.setFocusable(true);
					btnCambiarArma.setEnabled(true);
					btnCambiarArma.setFocusable(true);
					btnFinalizarTurno.setEnabled(true);
					btnFinalizarTurno.setFocusable(true);
					
				}

				}UnidadActual=new UnidadBD();UnidadObjetivo=new UnidadBD(); //Para no poder mover los soldados seleccionados anteriormente
				//Se actualizan los valores	
				
				}
		});

		
		
		
		btnFinalizarTurno.setBounds(28, 335, 103, 56);
		panel.add(btnFinalizarTurno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1067, 71);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Partida:");
		lblNewLabel.setBounds(52, 11, 60, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblJugador = new JLabel("Jugador 1:");
		lblJugador.setBounds(250, 11, 66, 14);
		panel_1.add(lblJugador);
		
		JLabel lblJugador_1 = new JLabel("Jugador 2:");
		lblJugador_1.setBounds(250, 42, 66, 14);
		panel_1.add(lblJugador_1);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(445, 11, 45, 14);
		panel_1.add(lblPuntos);
		
		JLabel lblPuntos_1 = new JLabel("Puntos:");
		lblPuntos_1.setBounds(445, 42, 45, 14);
		panel_1.add(lblPuntos_1);
		
		JLabel lblDineroJ1 = new JLabel("Dinero:");
		lblDineroJ1.setBounds(651, 11, 60, 14);
		panel_1.add(lblDineroJ1);
		
		JLabel lblDineroJ2 = new JLabel("Dinero:");
		lblDineroJ2.setBounds(651, 42, 40, 14);
		panel_1.add(lblDineroJ2);
		
		textFieldDineroJ1 = new JTextField();
		textFieldDineroJ1.setBounds(701, 8, 86, 20);
		textFieldDineroJ1.setText(""+p.getDineroAliado());
		textFieldDineroJ1.setEditable(false);
		panel_1.add(textFieldDineroJ1);
		textFieldDineroJ1.setColumns(10);
		
		textFieldDineroJ2 = new JTextField();
		textFieldDineroJ2.setText(""+p.getDineroEnemigo());
		textFieldDineroJ2.setEditable(false);
		textFieldDineroJ2.setBounds(701, 39, 86, 20);
		panel_1.add(textFieldDineroJ2);
		textFieldDineroJ2.setColumns(10);
		
		textFieldPartida = new JTextField();
		textFieldPartida.setBounds(100, 8, 86, 20);
		textFieldPartida.setText(p.getPartida());
		textFieldPartida.setEditable(false);
		panel_1.add(textFieldPartida);
		textFieldPartida.setColumns(10);
		
		textFieldJugador1 = new JTextField();
		textFieldJugador1.setText(p.getUsuario());
		textFieldJugador1.setEditable(false);
		textFieldJugador1.setBounds(312, 8, 86, 20);
		panel_1.add(textFieldJugador1);
		textFieldJugador1.setColumns(10);
		
		textFieldJugador2 = new JTextField();
		textFieldJugador2.setBounds(312, 36, 86, 20);
		textFieldJugador2.setText(p.getUsuario2());
		textFieldJugador2.setEditable(false);
		panel_1.add(textFieldJugador2);
		textFieldJugador2.setColumns(10);
		
		textFieldPuntosJ1 = new JTextField();
		textFieldPuntosJ1.setBounds(500, 8, 86, 20);
		textFieldPuntosJ1.setText(""+p.getPuntuacionAliado());
		textFieldPuntosJ1.setEditable(false);
		panel_1.add(textFieldPuntosJ1);
		textFieldPuntosJ1.setColumns(10);
		
		textFieldPuntosJ2 = new JTextField();
		textFieldPuntosJ2.setText(""+p.getPuntuacionEnemigo());
		textFieldPuntosJ2.setEditable(false);
		textFieldPuntosJ2.setBounds(500, 39, 86, 20);
		panel_1.add(textFieldPuntosJ2);
		textFieldPuntosJ2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 70, 1067, 45);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(10, 11, 62, 14);
		panel_2.add(lblPropietario);
		
		textFieldPropietario = new JTextField();
		textFieldPropietario.setBounds(72, 8, 86, 20);
		textFieldPropietario.setEditable(false);
		textFieldPropietario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(p.getTurno()==0){textFieldPropietario.setText(p.getUsuario());}
				else{textFieldPropietario.setText(p.getUsuario2());}
			}
		});
	
		panel_2.add(textFieldPropietario);
		textFieldPropietario.setColumns(10);
		
		JLabel lblUnidad = new JLabel("Unidad:");
		lblUnidad.setBounds(185, 11, 46, 14);
		panel_2.add(lblUnidad);
		
		textFieldUnidad = new JTextField();
		textFieldUnidad.setBounds(241, 8, 86, 20);
		textFieldUnidad.setText(UnidadActual.getNombre());
		textFieldUnidad.setEditable(false);
		panel_2.add(textFieldUnidad);
		textFieldUnidad.setColumns(10);
		
		JLabel lblPs = new JLabel("PS:");
		lblPs.setBounds(337, 11, 46, 14);
		panel_2.add(lblPs);
		
		textFieldPS = new JTextField();
		textFieldPS.setBounds(393, 8, 86, 20);
		textFieldPS.setText(""+UnidadActual.getSalud());
		textFieldPS.setEditable(false);
		panel_2.add(textFieldPS);
		textFieldPS.setColumns(10);
		
		JLabel lblArma = new JLabel("Arma:");
		lblArma.setBounds(489, 11, 46, 14);
		panel_2.add(lblArma);
		
		textFieldArma = new JTextField();
		textFieldArma.setBounds(545, 8, 86, 20);
		textFieldArma.setEditable(false);
		textFieldArma.setText(UnidadActual.getArma());
		panel_2.add(textFieldArma);
		textFieldArma.setColumns(10);	    


        setBounds(154, 114, 1200, 800);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Crea el gridpanel que contendra los botones
        getContentPane().add(gp.createGridPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	
	}
	/**
	 * Metodo que actualiza los valores de la partida
	 * y deja los botones inhabilitados para los que no tengan
	 * acciones disponibles
	 */
	private void actualiza(){
		textFieldJugador2.setText(p.getUsuario2());
		textFieldPuntosJ1.setText(""+p.getPuntuacionAliado());
		textFieldPuntosJ2.setText(""+p.getPuntuacionEnemigo());
		textFieldJugador1.setText(p.getUsuario());
		textFieldArma.setText(UnidadActual.getArma());
		textFieldPS.setText(""+UnidadActual.getSalud());
		textFieldUnidad.setText(UnidadActual.getNombre());
		
		if(p.getTurno()==0){
			
		if(UnidadActual.getAcciones()>0 && p.getUsuario().equals(LoginManager.getUsuario().getNombre())){btnAtacar.setEnabled(true);
		btnAtacar.setFocusable(true);
		btnGuardar.setEnabled(true);
		btnGuardar.setFocusable(true);
		btnMover.setEnabled(true);
		btnMover.setFocusable(true);
		btnCambiarArma.setEnabled(true);
		btnCambiarArma.setFocusable(true);
		btnFinalizarTurno.setEnabled(true);
		btnFinalizarTurno.setFocusable(true);}
		
		else if(p.getUsuario2().equals(LoginManager.getUsuario().getNombre())){
			btnAtacar.setEnabled(false);
			btnAtacar.setFocusable(false);
			btnGuardar.setEnabled(false);
			btnGuardar.setFocusable(false);
			btnMover.setEnabled(false);
			btnMover.setFocusable(false);
			btnCambiarArma.setEnabled(false);
			btnCambiarArma.setFocusable(false);
			btnFinalizarTurno.setEnabled(false);
			btnFinalizarTurno.setFocusable(false);
}

		
		else{btnAtacar.setEnabled(false);
		btnAtacar.setFocusable(false);
		btnGuardar.setEnabled(false);
		btnGuardar.setFocusable(false);
		btnMover.setEnabled(false);
		btnMover.setFocusable(false);
		btnCambiarArma.setEnabled(false);
		btnCambiarArma.setFocusable(false);
		}
		
		textFieldPropietario.setText(p.getUsuario());}
		
		
		else if(p.getTurno()==1){
			if(p.getUsuario2()!=null){
			if(UnidadActual.getAcciones()>0 && p.getUsuario2().equals(LoginManager.getUsuario().getNombre())){
				btnAtacar.setEnabled(true);
				btnAtacar.setFocusable(true);
				btnGuardar.setEnabled(true);
				btnGuardar.setFocusable(true);
				btnMover.setEnabled(true);
				btnMover.setFocusable(true);
				btnCambiarArma.setEnabled(true);
				btnCambiarArma.setFocusable(true);
				btnFinalizarTurno.setEnabled(true);
				btnFinalizarTurno.setFocusable(true);
}
			else if(p.getUsuario().equals(LoginManager.getUsuario().getNombre())){btnAtacar.setEnabled(false);
			btnAtacar.setFocusable(false);
			btnGuardar.setEnabled(false);
			btnGuardar.setFocusable(false);
			btnMover.setEnabled(false);
			btnMover.setFocusable(false);
			btnCambiarArma.setEnabled(false);
			btnCambiarArma.setFocusable(false);
			btnFinalizarTurno.setEnabled(false);
			btnFinalizarTurno.setFocusable(false);}
			
			else{btnAtacar.setEnabled(false);
			btnAtacar.setFocusable(false);
			btnGuardar.setEnabled(false);
			btnGuardar.setFocusable(false);
			btnMover.setEnabled(false);
			btnMover.setFocusable(false);
			btnCambiarArma.setEnabled(false);
			btnCambiarArma.setFocusable(false);
			}
			}
			
			else{if(UnidadActual.getAcciones()>0){
				btnAtacar.setEnabled(true);
				btnAtacar.setFocusable(true);
				btnGuardar.setEnabled(true);
				btnGuardar.setFocusable(true);
				btnMover.setEnabled(true);
				btnMover.setFocusable(true);
				btnCambiarArma.setEnabled(true);
				btnCambiarArma.setFocusable(true);
				btnFinalizarTurno.setEnabled(true);
				btnFinalizarTurno.setFocusable(true);
}else{
	btnAtacar.setEnabled(false);
	btnAtacar.setFocusable(false);
	btnGuardar.setEnabled(false);
	btnGuardar.setFocusable(false);
	btnMover.setEnabled(false);
	btnMover.setFocusable(false);
	btnCambiarArma.setEnabled(false);
	btnCambiarArma.setFocusable(false);
	btnFinalizarTurno.setEnabled(false);
	btnFinalizarTurno.setFocusable(false);
}
			}
	
			
			textFieldPropietario.setText(p.getUsuario2());}
		
		
		textFieldDineroJ2.setText(""+p.getDineroEnemigo());
		textFieldDineroJ1.setText(""+p.getDineroAliado());
		textFieldPartida.setText(p.getPartida());
	}
	

	
	
	
	
	
	
	
	
	/**
	 * 
	 * Clase que se encara del panel de botones
	 */
	
	public class gridpanel{
		

	private static final int N = 32;
    private final List<JButton> list = new ArrayList<JButton>();


    private JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }
	
	 private JPanel createGridPanel() {
	    	final Image image=requestImage();
	    	 JPanel p = new JPanel(new GridLayout(32, 32)){
				private static final long serialVersionUID = 1L;

				@Override
	    	    protected void paintComponent(Graphics g) {
	    	        super.paintComponent(g);
	    	        g.drawImage(image, 0, 0, null);
	    	    }
	    	};
	    	p.setBounds(154, 114, 800, 800);
	        for (int i = 0; i < 32 * 32; i++) {
	            int row = i / 32;
	            int col = i % 32;
	            JButton gb = createGridButton(row, col);
	            //añade btones que cambian de utilidad cuando se es clickado encima de ellos bien con el click derecho o el izquierdo
	            gb.addMouseListener(new MouseAdapter() {
	    			@Override
	    			public void mouseClicked(MouseEvent e) {
	    				actualiza();
	    			   if(e.getButton() == MouseEvent.BUTTON1)
	        	    {
	    				   if(Partida.p.getTurno()==0){
	    				   if(tablero[row][col] instanceof UnidadAliada && !(tablero[row][col] instanceof Spawn)){UnidadActual=tablero[row][col];xobj=row;yobj=col;}
	    				   else if(tablero[row][col] instanceof Colision){}
	    				   else if(tablero[row][col] instanceof UnidadEnemiga){}
	    				   else if(tablero[row][col] instanceof Spawn && Partida.p.getUsuario().equals(LoginManager.getUsuario().getNombre())){
	    					  try{
	    						  //El spawn crea unidades
	    					   final String[] soldados = { "Soldado raso", "Francotirador", "Bazooka", "Semioruga","Tanque" };
	    					     JFrame frame = new JFrame("Crear Soldados");
	    					     String SoldadoCreado = (String) JOptionPane.showInputDialog(frame, 
	    					         "¿Que soldado desea crear?",
	    					         "Cuartel general",
	    					         JOptionPane.QUESTION_MESSAGE, 
	    					         null, 
	    					         soldados, 
	    					         soldados[0]);
	    					     //Se crean unidades al lado del spawn
	    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((Spawn) tablero[31][0]).CrearSoldadoRaso(Partida.p,lp);repintar2();}
	    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((Spawn) tablero[31][0]).CrearFrancotirador(Partida.p,lp);repintar2();}
	    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((Spawn) tablero[31][0]).CrearBazooka(Partida.p,lp);repintar2();}
	    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((Spawn) tablero[31][0]).CrearSemioruga(Partida.p,lp);repintar2();}
	    					     else if(SoldadoCreado.equals("Tanque")){tablero=((Spawn) tablero[31][0]).CrearTanque(Partida.p,lp);repintar2();}
	    				   	}catch(NullPointerException e1){}
	    					  }	   
	    				   
	    				   
	    				   else{xobj=row;yobj=col;}
	        	      actualiza();
	        	      //Lo mismo pero para el enemigo
	    				   }else if(Partida.p.getTurno()==1){
	    					   if(tablero[row][col] instanceof UnidadEnemiga && !(tablero[row][col] instanceof SpawnEnemigo)){
		    				   UnidadActual=tablero[row][col];xobj=row;yobj=col;}
	    					   else if(tablero[row][col] instanceof Colision){}
	    					   else if(tablero[row][col] instanceof UnidadAliada){}
		    				   else if(tablero[row][col] instanceof SpawnEnemigo && Partida.p.getUsuario2()==null){
		    					   try{
		    					   final String[] soldados = { "Soldado raso", "Francotirador", "Bazooka", "Semioruga","Tanque" };
		    					     JFrame frame = new JFrame("Crear Soldados");
		    					     String SoldadoCreado = (String) JOptionPane.showInputDialog(frame, 
		    					         "¿Que soldado desea crear?",
		    					         "Cuartel general",
		    					         JOptionPane.QUESTION_MESSAGE, 
		    					         null, 
		    					         soldados, 
		    					         soldados[0]);
		    					     
		    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSoldadoRasoEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((SpawnEnemigo) tablero[0][31]).CrearFrancotiradorEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((SpawnEnemigo) tablero[0][31]).CrearBazookaEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSemiorugaEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Tanque")){tablero=((SpawnEnemigo) tablero[0][31]).CrearTanqueEnemigo(Partida.p,lp);repintar2();}
		    					}catch(NullPointerException e1){}
		    				   }
		    				   else if(tablero[row][col] instanceof SpawnEnemigo && Partida.p.getUsuario2().equals(LoginManager.getUsuario().getNombre())){
		    					   try{
		    					   final String[] soldados = { "Soldado raso", "Francotirador", "Bazooka", "Semioruga","Tanque" };
		    					     JFrame frame = new JFrame("Crear Soldados");
		    					     String SoldadoCreado = (String) JOptionPane.showInputDialog(frame, 
		    					         "¿Que soldado desea crear?",
		    					         "Cuartel general",
		    					         JOptionPane.QUESTION_MESSAGE, 
		    					         null, 
		    					         soldados, 
		    					         soldados[0]);
		    					     
		    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSoldadoRasoEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((SpawnEnemigo) tablero[0][31]).CrearFrancotiradorEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((SpawnEnemigo) tablero[0][31]).CrearBazookaEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSemiorugaEnemigo(Partida.p,lp);repintar2();}
		    					     else if(SoldadoCreado.equals("Tanque")){tablero=((SpawnEnemigo) tablero[0][31]).CrearTanqueEnemigo(Partida.p,lp);repintar2();}
		    					}catch(NullPointerException e1){}
		    				   }

		    				   else{xobj=row;yobj=col;}
		        	      actualiza();
		        	      }
	        	    }  
	    				   
	        	        //En caso de que se haga click derecho la funcion es diferente
	        	    else if(e.getButton() == MouseEvent.BUTTON3)
	        	    {

	        	 	   if(Partida.p.getTurno()==0){
	        	 		  if(tablero[row][col] instanceof SpawnEnemigo){ UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	        	 		  else if(tablero[row][col] instanceof UnidadEnemiga){
	    				   UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    				   else if(tablero[row][col] instanceof Colision){}
	    				   else{xobj=row;yobj=col;}
	        	      actualiza();
	    				   }else if(Partida.p.getTurno()==1){
	    					   if(tablero[row][col] instanceof SpawnEnemigo){ UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    					   else if(tablero[row][col] instanceof UnidadAliada){
		    				   UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    					   else if(tablero[row][col] instanceof Colision){}
		    				   else{xobj=row;yobj=col;}
		        	      actualiza();
		        	      }
	        	    }	   				
	    			}
	    		});
	            gb.setOpaque(false);
	            gb.setText(""); //Botones vacios e invisibles
	            gb.setBorder(null);
	            gb.setBorderPainted(false);
	            gb.setContentAreaFilled(false);
	            list.add(gb);
	            Dimension d=new Dimension(100,100);
	            p.setPreferredSize(d);
	            p.add(gb);
	        }

	        return p;
	    }

	 /**
	  * Se le asigna la imagen del mapa al panel
	  * @return imagen del mapa
	  */
	  private BufferedImage requestImage() {
	        BufferedImage image = null;

	        try {
	        	image = ImageIO.read(Partida.class.getResourceAsStream("/resources/MapaPartida.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return image;
	    }
	/**
	 * Crea los botones que se usaran en el panel
	 * @param row fila donde esta el boton
	 * @param col columna donde esta el boton
	 * @return boton creado
	 */
	   private JButton createGridButton(final int row, final int col) {
	        final JButton b = new JButton("r" + row + ",c" + col);
	        return b;
	    }


	}
	   
	
	public LogicaBatallas.ArraysPartida getLp() {
		return lp;
	}

	public void setLp(LogicaBatallas.ArraysPartida lp) {
		this.lp = lp;
	}

	public LogicaBatallas.ElementosPartida getP() {
		return p;
	}

	public void setP(LogicaBatallas.ElementosPartida p) {
		Partida.p = p;
	}


	public static UnidadBD getUnidadActual() {
		return UnidadActual;
	}

	public void setUnidadActual(UnidadBD unidadActual) {
		UnidadActual = unidadActual;
	}


	public int getXobj() {
		return xobj;
	}

	public void setXobj(int xobj) {
		this.xobj = xobj;
	}

	public int getYobj() {
		return yobj;
	}

	public void setYobj(int yobj) {
		this.yobj = yobj;
	}

	public static UnidadBD getUnidadObjetivo() {
		return UnidadObjetivo;
	}

	public void setUnidadObjetivo(UnidadBD unidadObjetivo) {
		UnidadObjetivo = unidadObjetivo;
	}

	public static UnidadBD[][] getTablero() {
		return tablero;
	}
	public JButton getBtnCambiarArma() {
		return btnCambiarArma;
	}
	public void setBtnCambiarArma(JButton btnCambiarArma) {
		this.btnCambiarArma = btnCambiarArma;
	}
	public JButton getBtnMover() {
		return btnMover;
	}
	public void setBtnMover(JButton btnMover) {
		this.btnMover = btnMover;
	}
	public JButton getBtnAtacar() {
		return btnAtacar;
	}
	public void setBtnAtacar(JButton btnAtacar) {
		this.btnAtacar = btnAtacar;
	}
	public JButton getBtnFinalizarTurno() {
		return btnFinalizarTurno;
	}
	public void setBtnFinalizarTurno(JButton btnFinalizarTurno) {
		this.btnFinalizarTurno = btnFinalizarTurno;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	public gridpanel getGp() {
		return gp;
	}
	public void setGp(gridpanel gp) {
		this.gp = gp;
	}




}
