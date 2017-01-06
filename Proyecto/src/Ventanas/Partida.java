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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BD.UnidadBD;

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
	public static UnidadBD[][] tablero=null;//TODO array que tenga los componentes, y su equivalente en gridlayout para que sea utilizable


	public static UnidadBD[][] getTablero() {
		return tablero;
	}

	public static void setTablero(UnidadBD[][] tablero) {
		Partida.tablero = tablero;
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
		setBounds(100, 100, 675, 473);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 114, 155, 492);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnMover = new JButton("Mover");
		btnMover.setBounds(30, 25, 101, 46);
		panel.add(btnMover);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(30, 82, 101, 46);
		panel.add(btnAtacar);
		
		JButton btnTerminar = new JButton("Finalizar Unidad");
		btnTerminar.setBounds(30, 196, 115, 56);
		panel.add(btnTerminar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(30, 298, 101, 23);
		panel.add(btnGuardar);
		
		JButton btnCambiarArma = new JButton("Cambiar arma");
		btnCambiarArma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCambiarArma.setBounds(30, 139, 101, 46);
		panel.add(btnCambiarArma);
		
		JButton btnFinalizarTurno = new JButton("Finalizar Turno");
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
		UnidadBD unidadactual=new UnidadBD();
		textFieldPropietario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO meter el array o el gridlayout y comprobar si hay alguna unidad
				 Pattern pat = Pattern.compile(".Enemigo$");
			     Matcher mat = pat.matcher(unidadactual.getClass().getName());
			     
				try {
					 
						e.getX();
						e.getY();
						
					//TODO meter la parte de gridbuttonpanel en transparente para saber las colisiones y las coordenadas
					//unidadactual=...
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
		textFieldUnidad.setText(unidadactual.getNombre());
		textFieldUnidad.setEditable(false);
		panel_2.add(textFieldUnidad);
		textFieldUnidad.setColumns(10);
		
		JLabel lblPs = new JLabel("PS:");
		lblPs.setBounds(337, 11, 46, 14);
		panel_2.add(lblPs);
		
		textFieldPS = new JTextField();
		textFieldPS.setBounds(393, 8, 86, 20);
		textFieldPS.setText(""+unidadactual.getSalud());
		textFieldPS.setEditable(false);
		panel_2.add(textFieldPS);
		textFieldPS.setColumns(10);
		
		JLabel lblArma = new JLabel("Arma:");
		lblArma.setBounds(489, 11, 46, 14);
		panel_2.add(lblArma);
		
		textFieldArma = new JTextField();
		textFieldArma.setBounds(545, 8, 86, 20);
		textFieldArma.setEditable(false);
		textFieldArma.setText(unidadactual.getArma());
		panel_2.add(textFieldArma);
		textFieldArma.setColumns(10);
		

		String arg = "Resources.Mapa.png";
		    
		
		//PRUEBA

        setBounds(154, 114, 1200, 800);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(createGridPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

	
		
		
		
		
		
		
		
		
		/*ORIGINAL

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(154, 114, 1200, 800);
	    ImageIcon icon = new ImageIcon(arg); 
	    JLabel label = new JLabel(); 
	    label.setIcon(icon); 
	    panel_3.add(label);
		getContentPane().add(panel_3);
		
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Xabier\\git\\Proyectoprog3\\Proyecto\\src\\Resources\\Mapa.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		panel_3.add(picLabel);
		
	*/
		
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
	            gb.setOpaque(false);
	            gb.setText("P"); //Cambiando esto se consigue en invisible (para el mapa y eso)
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

	
	//Array mapa un ejemplo para las colisiones TODO (el mapa seria un 50x50 o alo asi, lueo se ajusta al tamaño)
	int[][][] myMap ={   
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} },
	{ {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14}, {1,14} }
	  };
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
}
