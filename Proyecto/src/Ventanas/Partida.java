package Ventanas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BD.UnidadBD;
import UnidadesAmigas.SoldadoRaso;
import UnidadesEnemigas.SoldadoRasoEnemigo;

public class Partida extends JDialog{

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
	private LogicaBatallas.LogicaPartida lp;
	private LogicaBatallas.ElementosPartida p;



	public static UnidadBD[][] tablero=//32x32, hay que meter manualmente las colisiones
	
	{  
	{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0) },
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
	{ new Colision(0), null, null, null, null, null, null, null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), null, null, null, null, null, null, new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0), new Colision(0) }
	  };

			/*Como queda con las colisiones a modo de array
		{  
		{ *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, *, a },
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
		{ a, *, *, *, *, *, *, *, *, *, *, *, *, a, a, a, a, a, a, *, *, *, *, *, *, a, a, a, a, a, a, a }
		  };
	*/
	
	
//TODO array que tenga los componentes, y su equivalente en gridlayout para que sea utilizable
	private int xobj,yobj;
	private UnidadBD UnidadActual=new UnidadBD();//FIXME de prueba
	private UnidadBD UnidadObjetivo=new UnidadBD();

	public static void setTablero(UnidadBD[][] tablero1) {
		tablero = tablero1;
	}

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida window = new Partida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	//FIXME Falta por determinar bien el constructor
	public Partida(LogicaBatallas.ElementosPartida p,LogicaBatallas.LogicaPartida lp) throws IOException {
		this.p=p;
		this.lp=lp;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
		
		
		//FIXME se necesita cambiar los listeners con cada uno su codigo (los x,y,xobj,yobje para ajustarlos bien)
		/*
		 *
		*Como quitar las acciones del panel cuando el elemento seleccionado sea una unidad finalizada
		*/ 
	
	
		final JButton btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) { 
				btnMover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)  {
					
						if(tablero[xobj][yobj]==null){System.out.println("Es null");UnidadActual.Mover(xobj, yobj);}//Habria que meter el algoritmo de pathfinding (todavia con el simple)}//FIXME cambiar esto
			        System.out.println("se ha movido la unidad a las coordenadas X="+xobj+" y="+yobj);
			        System.out.println("Count of listeners: " + ((JButton) arg0.getSource()).getActionListeners().length);//Cuantos actionlistener hay activos
				}
				});
			
			
				
				
				
				 
			}
		});
		btnMover.setBounds(30, 25, 101, 46);
		panel.add(btnMover);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {

		    }
		});
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
				if(tablero[xobj][yobj]==null){}
				else{UnidadActual.atacar(xobj,yobj);
		        System.out.println("se ha atacado a la unidad de las coordenadas X="+xobj+" y="+yobj);}
		    }
		});
		btnAtacar.setBounds(30, 82, 101, 46);
		panel.add(btnAtacar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnGuardar.setBounds(30, 298, 101, 23);
		panel.add(btnGuardar);
		
		JButton btnCambiarArma = new JButton("Cambiar arma");
		btnCambiarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)  {
			}
		});
		btnCambiarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCambiarArma.setBounds(30, 139, 101, 46);
		panel.add(btnCambiarArma);
		
		JButton btnFinalizarTurno = new JButton("Finalizar Turno");
		btnFinalizarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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

				 Pattern pat = Pattern.compile(".Enemigo$");
			     Matcher mat = pat.matcher(UnidadActual.getNombre());
			     
				try {
					 
						
					//TODO no estoy seguro de si esto funciona
						if (mat.matches()) {
							textFieldPropietario.setText("Usuario 2");
					     } else {
					    	 textFieldPropietario.setText("Usuario 1");
					     }
						
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
        getContentPane().add(createGridPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	
	}
	

	
	/////////////TODO LO DE GRIDPANEL
	
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
	    			   if(e.getButton() == MouseEvent.BUTTON1)
	        	    {
	    				   if(tablero[col][row] instanceof UnidadBD){
	    				   UnidadActual=tablero[col][row];xobj=col;yobj=row;}
	    				   else{xobj=col;yobj=row;}
	        	      System.out.println("Click izquierdo col="+col+" row="+row);
	        	      }
	    				
	        	        
	        	    else if(e.getButton() == MouseEvent.BUTTON3)
	        	    {
	        	    	if(tablero[col][row]!=null || tablero[col][row] instanceof UnidadBD){
	        	    	UnidadObjetivo=tablero[col][row];xobj=col;yobj=row;}
	        	    	else{}
	        	    	System.out.println("Click derecho col="+col+" row="+row);
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
	                JButton gb =Partida.this.getGridButton(row, col);
	                System.out.println("r" + row + ",c" + col
	                    + " " + (b == gb)
	                    + " " + (b.equals(gb)));
	            }
	        });
	        return b;
	    }


	
	
	public LogicaBatallas.LogicaPartida getLp() {
		return lp;
	}

	public void setLp(LogicaBatallas.LogicaPartida lp) {
		this.lp = lp;
	}

	public LogicaBatallas.ElementosPartida getP() {
		return p;
	}

	public void setP(LogicaBatallas.ElementosPartida p) {
		this.p = p;
	}


	public UnidadBD getUnidadActual() {
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

	public UnidadBD getUnidadObjetivo() {
		return UnidadObjetivo;
	}

	public void setUnidadObjetivo(UnidadBD unidadObjetivo) {
		UnidadObjetivo = unidadObjetivo;
	}

	public static UnidadBD[][] getTablero() {
		// TODO Auto-generated method stub
		return tablero;
	}
}
