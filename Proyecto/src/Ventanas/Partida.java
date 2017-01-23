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

public class Partida extends JDialog implements Runnable{

	/**
	 * 
	 */
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
	private JButton btnAtacar;
	private JButton btnFinalizarTurno;
	private JButton btnGuardar;
	private LogicaBatallas.ArraysPartida lp;
	private static LogicaBatallas.ElementosPartida p;
	public static UnidadBD[][] tablero=crearTablero();
	private gridpanel gp=new gridpanel();

	public static ElementosPartida getPartida() {
		return p;
	}
	private ArraysPartida getArrays() {
		return lp;
	}
	public static UnidadBD[][] crearTablero() {
		UnidadBD[][] tab={  
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new SpawnEnemigo(0,31) },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, null, null, null, null, new Colision(0) },
				{ null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, null, null, null, null, null, null, new Colision(0), null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, new Colision(0) },
				{ null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, null, null, null, new Colision(0), null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null },
				{ new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, new Colision(0), null, null, null, new Colision(0), null, null, null, new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null },
				{ new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null },
				{ new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, null, null },
				{ null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, null, null, new Colision(0), null, null },
				{ null, null, new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, null, null, null, null, new Colision(0), null, null },
				{ null, null, new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, new Colision(0), null, null, new Colision(0), null, null },
				{ null, new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, new Colision(0), new Colision(0), null, null, null, null, new Colision(0), null, null, null, null, null },
				{ new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null },
				{ new Colision(0), new Colision(0), null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, new Colision(0), null, null },
				{ null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, new Colision(0), null, null },
				{ null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), null, null, new Colision(0), new Colision(0), null, null, null, null },
				{ null, null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, new Colision(0), null, null, null, new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) },
				{ null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0) },
				{ null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null },
				{ new Colision(0), null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, new Colision(0), null, null },
				{ new Colision(0), null, null, new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, new Colision(0), null, null },
				{ null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0) },
				{ null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, new Colision(0), null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0) },
				{ null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, new Colision(0), null, null, null, null, new Colision(0), null, null, null, new Colision(0), null, new Colision(0), new Colision(0), null, null, null, new Colision(0), null, null, new Colision(0), null, null, new Colision(0), new Colision(0), new Colision(0) },
				{ null, null, null, null, null, null, null, new Colision(0), null, null, null, null, null, null, null, null, null, null, null, new Colision(0), null, null, new Colision(0), new Colision(0), new Colision(0), null, new Colision(0), null, new Colision(0), new Colision(0), new Colision(0), new Colision(0) },
				{ null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, null, new Colision(0), null, null, null, new Colision(0), null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) },
				{ new Colision(0), null, null, null, null, new Colision(0), new Colision(0), null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) },
				{ new Colision(0), null, null, null, null, null, null, null, new Colision(0), new Colision(0), null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) },
				{ new Spawn(31,0), null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) }
				  };
		return tab;
	}
	public static void setPartida(ElementosPartida p1) {
		p=p1;;
	}
	
	
		/*Como queda con las colisiones a modo de array
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
	
	
//TODO array que tenga los componentes, y su equivalente en gridlayout para que sea utilizable
	private int xobj,yobj;
	static UnidadBD UnidadActual=new UnidadBD();//FIXME de prueba 
	static UnidadBD UnidadObjetivo=new UnidadBD();//FIXME cambiar la visibilidad del package acaso(?)

	public static void setUnidadActual(ElementosPartida p1) {
		p=p1;;
	}
	public static void setTablero(UnidadBD[][] tablero1) {
		tablero = tablero1;
	}

	public Partida(LogicaBatallas.ElementosPartida p,LogicaBatallas.ArraysPartida lp) throws IOException {
		Partida.p=p;
		this.lp=lp;
		this.initialize();
	}

	 Runnable myRunnable = new Runnable(){

		 public void run(){
					repintar2();
					repintar();
				}
	   };

	
	/*
	  public static RefrecarPantalla refrescarPantalla;
		public static class RefrecarPantalla extends Thread{
			private boolean X = true;
			public void Stop(){
				X = false;

			}
			public void run(){

				int decimas = 0;
				while (X){
					decimas++;
					if (decimas %10 == 0){ //un segundo
						repintar();
					}
				}

			}
		}

	*/
		public void repintar2(){
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
			for(int i=0;i<Partida.getTablero().length;i++){
				for(int j=0;j<Partida.getTablero()[0].length;j++){
					if(Partida.getTablero()[i][j]==null){Partida.this.getGp().getGridButton(i,j).setIcon(null);}
				}
				
			}
			
			
			
			
		}
		
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
	
	
	
	

	private void initialize() throws IOException {
		new JFrame();
		setBounds(100, 100, 330, 141);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 114, 155, 492);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		

	
		btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) { 
				Thread thread = new Thread(myRunnable);

						if(tablero[xobj][yobj]==null){
							try{
								UnidadBD[][] tablero1=getTablero();
								
								int x=UnidadActual.getCordX();
								int y=UnidadActual.getCordY();
								
							//	UnidadBD reserva=UnidadActual;
							//	UnidadBD reserva2=UnidadActual;
							
								
						tablero=UnidadActual.AlgoritmoPathfinding(UnidadActual.getDistancia(), UnidadActual.getCordX(), UnidadActual.getCordY(), xobj, yobj, tablero);
						if(tablero[xobj][yobj]==UnidadActual)
						tablero[x][y]=null;
						
						   thread.start();
							try {
								thread.join();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}catch(NullPointerException e){System.out.println("ERROR QUE HAcE DESAPARECER A ESTOS");}//FIXME quitar
					//	UnidadActual.setAcciones(UnidadActual.getAcciones()-1);}			

					}
			
			
				 
			}
		});
		btnMover.setBounds(30, 25, 101, 46);
		panel.add(btnMover);
		
		btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
			actualiza();
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					    
					    setVisible(false); //FIXME poner aqui el codigo de BD remoto
					    if(p.getUsuario2()!=null){
					    BD.PartidaEliminar(BD.usarBD(BD.initBD("Local")), p);
					    MenuPrincipal mp=new MenuPrincipal();
					    mp.setVisible(true);
					    }
					    else{
						    BD.PartidaLocalEliminar(BD.usarBD(BD.initBD("Local")), p);
						    MenuPrincipal mp=new MenuPrincipal();
						    mp.setVisible(true);
						    }
					}
					actualiza();
		        System.out.println("se ha atacado a la unidad de las coordenadas X="+xobj+" y="+yobj);} //FIXME quitar
			}
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
						// TODO Auto-generated catch block
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
					UnidadActual.setAcciones(UnidadActual.getAcciones()-1);
		        System.out.println("se ha atacado a la unidad de las coordenadas X="+xobj+" y="+yobj);}
			}
			
				
		    }
		});
		btnAtacar.setBounds(30, 82, 101, 46);
		panel.add(btnAtacar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(p.getUsuario2()==null){
					
					
				BD.PartidaUpdate1J(BD.usarBD(BD.initBD("Local")),p);
				BD.SoldadosLocalEliminar(BD.usarBD(BD.initBD("Local")),p);
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsertLocal(BD.usarBD(BD.initBD("Local")),u);}
				setVisible(false);
				MenuPrincipal mp=new MenuPrincipal();
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
				}
				
				else{
					
				BD.PartidaUpdate(BD.usarBD(BD.initBD("Local")),p);
				BD.SoldadosEliminar(BD.usarBD(BD.initBD("Local")),p);
				for(UnidadBD u:lp.getListaAliados()){
					BD.UnidadesInsert(BD.usarBD(BD.initBD("Local")),u);}
				for(UnidadBD u:lp.getListaEnemigos()){
					BD.UnidadesInsert(BD.usarBD(BD.initBD("Local")),u);}
				setVisible(false);
				MenuPrincipal mp=new MenuPrincipal();
				mp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				mp.setVisible(true);
					}
			}
		});
		btnGuardar.setBounds(30, 298, 101, 23);
		panel.add(btnGuardar);
		
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
				catch(NullPointerException e){System.out.println("NO SE HA ELEGIDO NINGUNA PERSONA");}//FIXME cambiar por una alerta(?)
			}
		});
		btnCambiarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCambiarArma.setBounds(30, 139, 101, 46);
		panel.add(btnCambiarArma);
		
		btnFinalizarTurno = new JButton("Finalizar Turno");
		btnFinalizarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread thread = new Thread(myRunnable);
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
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
				if(Partida.p.getTurno()==0){textFieldPropietario.setText(p.getUsuario2());
			Partida.p.setTurno(1);JOptionPane.showMessageDialog(null, "Turno terminado");//FIXME meter en el crearpartidalocal que el usuario 2 tenga el nombre que insertes
				//FIXME sera para comprobar los turnos de los diferentes jugadores
				//no se deshabilitara el boton de finalizar turno para ver si se puede hacer deshabilitar y habilitar los botones al pasar de turno
					if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario2())){
						btnAtacar.setEnabled(true);
						btnGuardar.setEnabled(true);
						btnMover.setEnabled(true);
						btnCambiarArma.setEnabled(true);
						
//FIXME enablear/disablear el boton de finalizar turno tambien, pero hasta que se haga pruebas no
					}
				else if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario())){
						btnAtacar.setEnabled(false);
						btnGuardar.setEnabled(false);
						btnMover.setEnabled(false);
						btnCambiarArma.setEnabled(false);

					}
				else if(p.getUsuario2()==null){
					btnAtacar.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnMover.setEnabled(true);
					btnCambiarArma.setEnabled(true);

				}
				
					
				}
				else{Partida.p.setTurno(0);textFieldPropietario.setText(p.getUsuario());JOptionPane.showMessageDialog(null, "Turno terminado");
				if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario2())){
					btnAtacar.setEnabled(false);
					btnGuardar.setEnabled(false);
					btnMover.setEnabled(false);
					btnCambiarArma.setEnabled(false);

				
				}
				else if(Juego.getLM().getUsuario().getNombre().equals(p.getUsuario())){
					btnAtacar.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnMover.setEnabled(true);
					btnCambiarArma.setEnabled(true);

				}
				else if(p.getUsuario2()==null){
					btnAtacar.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnMover.setEnabled(true);
					btnCambiarArma.setEnabled(true);

				}

				}UnidadActual=new UnidadBD();UnidadObjetivo=new UnidadBD(); //Para no poder mover los soldados seleccionados anteriormente
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
        getContentPane().add(gp.createGridPanel());
        pack();//FIXME
        setLocationRelativeTo(null);
        setVisible(true);
	
	}
	
	private void actualiza(){

		
		
		textFieldJugador2.setText(p.getUsuario2());
		textFieldPuntosJ1.setText(""+p.getPuntuacionAliado());
		textFieldPuntosJ2.setText(""+p.getPuntuacionEnemigo());
		textFieldJugador1.setText(p.getUsuario());
		textFieldArma.setText(UnidadActual.getArma());
		textFieldPS.setText(""+UnidadActual.getSalud());
		textFieldUnidad.setText(UnidadActual.getNombre());
		
		if(p.getTurno()==0){
			
		if(UnidadActual.getAcciones()>0 && p.getUsuario().equals(LoginManager.getUsuario().getNombre())){btnMover.setEnabled(true);
		btnAtacar.setEnabled(true);
		btnCambiarArma.setEnabled(true);
		
		}else{btnMover.setEnabled(false);
		btnAtacar.setEnabled(false);
		btnCambiarArma.setEnabled(false);}
		
		textFieldPropietario.setText(p.getUsuario());}
		
		
		else if(p.getTurno()==1){
			if(p.getUsuario2()!=null){
			if(UnidadActual.getAcciones()>0 && p.getUsuario2().equals(LoginManager.getUsuario().getNombre())){
			btnMover.setEnabled(true);
			btnAtacar.setEnabled(true);
			btnCambiarArma.setEnabled(true);}
			
			else{btnMover.setEnabled(false);
			btnAtacar.setEnabled(false);
			btnCambiarArma.setEnabled(false);}
			}
			
			else{if(UnidadActual.getAcciones()>0){
				btnMover.setEnabled(true);
				btnAtacar.setEnabled(true);
				btnCambiarArma.setEnabled(true);}else{
				btnMover.setEnabled(false);
				btnAtacar.setEnabled(false);
				btnCambiarArma.setEnabled(false);}
			}
	
			
			textFieldPropietario.setText(p.getUsuario2());}
		
		
		textFieldDineroJ2.setText(""+p.getDineroEnemigo());
		textFieldDineroJ1.setText(""+p.getDineroAliado());
		textFieldPartida.setText(p.getPartida());
	}
	

	
	
	
	
	
	
	
	
	
	
	public class gridpanel implements Runnable{
		

	private static final int N = 32;
    private final List<JButton> list = new ArrayList<JButton>();


    private JButton getGridButton(int r, int c) {
        int index = r * N + c;
        return list.get(index);
    }
	
	 private JPanel createGridPanel() {
	    	final Image image=requestImage();
	    	 JPanel p = new JPanel(new GridLayout(32, 32)){
	    		/**
				 * 
				 */
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
	            gb.addMouseListener(new MouseAdapter() {
	    			@Override
	    			public void mouseClicked(MouseEvent e) {
	    				actualiza();
	    				if(tablero[row][col] instanceof UnidadAliada)gb.setText("X");//FIXME QUITAR ESTO; SOLO ES PARA PRUEBAS
	    				else if(tablero[row][col] instanceof UnidadEnemiga)gb.setText("Y");
	    				else if(tablero[row][col] instanceof Colision)gb.setText("C");
	    				else if(tablero[row][col]==null)gb.setText("P");
	    				
	    				
	    			   if(e.getButton() == MouseEvent.BUTTON1)
	        	    {
	    				   if(Partida.p.getTurno()==0){
	    				   if(tablero[row][col] instanceof UnidadAliada && !(tablero[row][col] instanceof Spawn)){UnidadActual=tablero[row][col];xobj=row;yobj=col;}
	    				   else if(tablero[row][col] instanceof Colision){}
	    				   else if(tablero[row][col] instanceof UnidadEnemiga){}
	    				   else if(tablero[row][col] instanceof Spawn && Partida.p.getUsuario().equals(LoginManager.getUsuario().getNombre())){
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
	    					     
	    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((Spawn) tablero[31][0]).CrearSoldadoRaso(Partida.p,lp);}
	    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((Spawn) tablero[31][0]).CrearFrancotirador(Partida.p,lp);}
	    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((Spawn) tablero[31][0]).CrearBazooka(Partida.p,lp);}
	    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((Spawn) tablero[31][0]).CrearSemioruga(Partida.p,lp);}
	    					     else if(SoldadoCreado.equals("Tanque")){tablero=((Spawn) tablero[31][0]).CrearTanque(Partida.p,lp);}
	    				   	}catch(NullPointerException e1){}
	    					  }	   
	    				   
	    				   
	    				   else{xobj=row;yobj=col;}
	        	      System.out.println("Click izquierdo col="+col+" row="+row);
	        	      actualiza();
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
		    					     
		    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSoldadoRasoEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((SpawnEnemigo) tablero[0][31]).CrearFrancotiradorEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((SpawnEnemigo) tablero[0][31]).CrearBazookaEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSemiorugaEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Tanque")){tablero=((SpawnEnemigo) tablero[0][31]).CrearTanqueEnemigo(Partida.p,lp);repintar();}
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
		    					     
		    					     if(SoldadoCreado.equals("Soldado raso")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSoldadoRasoEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Francotirador")){tablero=((SpawnEnemigo) tablero[0][31]).CrearFrancotiradorEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Bazooka")){tablero=((SpawnEnemigo) tablero[0][31]).CrearBazookaEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Semioruga")){tablero=((SpawnEnemigo) tablero[0][31]).CrearSemiorugaEnemigo(Partida.p,lp);repintar();}
		    					     else if(SoldadoCreado.equals("Tanque")){tablero=((SpawnEnemigo) tablero[0][31]).CrearTanqueEnemigo(Partida.p,lp);repintar();}
		    					}catch(NullPointerException e1){}
		    				   }

		    				   else{xobj=row;yobj=col;}
		        	      System.out.println("Click izquierdo col="+col+" row="+row);
		        	      actualiza();
		        	      }
	        	    }  
	    				   
	        	        
	        	    else if(e.getButton() == MouseEvent.BUTTON3)
	        	    {

	        	 	   if(Partida.p.getTurno()==0){
	        	 		  if(tablero[row][col] instanceof SpawnEnemigo){ UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	        	 		  else if(tablero[row][col] instanceof UnidadEnemiga){
	    				   UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    				   else if(tablero[row][col] instanceof Colision){}
	    				   else{xobj=row;yobj=col;}
	        	      System.out.println("Click derecho col="+col+" row="+row);
	        	      actualiza();
	    				   }else if(Partida.p.getTurno()==1){
	    					   if(tablero[row][col] instanceof SpawnEnemigo){ UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    					   else if(tablero[row][col] instanceof UnidadAliada){
		    				   UnidadObjetivo=tablero[row][col];xobj=row;yobj=col;}
	    					   else if(tablero[row][col] instanceof Colision){}
		    				   else{xobj=row;yobj=col;}
		        	      System.out.println("Click derecho col="+col+" row="+row);
		        	      actualiza();
		        	      }
	        	    }	   				
	    			}
	    		});
	            gb.setOpaque(false);
	            gb.setText("P"); //FIXME Cambiando esto se consigue en invisible (para el mapa y eso)
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

	 
	  private BufferedImage requestImage() {
	        BufferedImage image = null;

	        try {
	        	image = ImageIO.read(Partida.class.getResourceAsStream("/resources/MapaPartida.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return image;
	    }
	
	   private JButton createGridButton(final int row, final int col) {
	        final JButton b = new JButton("r" + row + ",c" + col);
	        b.addActionListener(new ActionListener() {   	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new Thread().start();
	            }
	        });

	        return b;
	    }
	   //FIXME Prueba


		private boolean X = true;
		public void Stop(){
			X = false;

		}
		public void run(){
			while (X){
				try {
					wait(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					for(int i=0;i<32;i++){
						for(int j=0;j<32;j++){
							if(Partida.getTablero()[i][j]==null){getGridButton(i,j).setIcon(null);}
							else if(Partida.getTablero()[i][j] instanceof SoldadoRaso){getGridButton(i,j).setIcon(new ImageIcon(getClass().getResource("/resources/SoldadoRaso.png")));getGridButton(i, j).repaint();}
							
						}
					}
					//this.repaint();
				}
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
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}





}
