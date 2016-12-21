package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MenuPrincipal extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	//private BufferedImage image;

	   

	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
		initialize();
	}
	
	
	
	
	
/*
	 FIXME
	   protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
	    }

	}
	 
	 //TODO probar este codigo de fondo de pantalla
 ImageIcon background = new ImageIcon("Background/background.png");
JLabel label = new JLabel();
label.setBounds(0, 0, x, y);
label.setIcon(background);

JPanel panel = new JPanel();
panel.setLayout(null);
panel.add(label);
	 */
	 
	 
	 
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {

		//FIXME image = ImageIO.read(new File("image name and path"));
		setBounds(100, 100, 744, 561);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnUn_jugador = new JButton("Local");
		btnUn_jugador.setBounds(256, 200, 173, 23);
		 btnUn_jugador.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Menu1Jugador m1j=new Menu1Jugador();
					setVisible(false);
					m1j.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					m1j.setVisible(true);
				}
			});
		 getContentPane().add(btnUn_jugador);
		
		
		JButton btnMultijuador = new JButton("Multijuador");
		btnMultijuador.setBounds(256, 246, 173, 23);
		btnMultijuador.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuMultijugador mm=new MenuMultijugador();
					setVisible(false);
					mm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					mm.setVisible(true);
				}
			});
		 getContentPane().add(btnMultijuador);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(256, 294, 173, 23);
		btnOpciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuOpciones mo=new MenuOpciones();
					setVisible(false);
					mo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					mo.setVisible(true);
				}
			});
		 getContentPane().add(btnOpciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(256, 353, 173, 23);
		btnSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					setVisible(false);
					getDefaultCloseOperation();
				}
			});
		 getContentPane().add(btnSalir);
		
		JLabel lbldWars = new JLabel("2D WARS");
		lbldWars.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 40));
		lbldWars.setBounds(256, 60, 173, 119);
		 getContentPane().add(lbldWars);
	}

}
