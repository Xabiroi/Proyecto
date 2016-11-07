package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

public class MenuPrincipal {

	private JFrame frame;
	private BufferedImage image;

	   

	 
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
		frame = new JFrame();
		//FIXME image = ImageIO.read(new File("image name and path"));
		frame.setBounds(100, 100, 744, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUn_jugador = new JButton("Un jugador");
		btnUn_jugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUn_jugador.setBounds(256, 200, 173, 23);
		frame.getContentPane().add(btnUn_jugador);
		
		JButton btnMultijuador = new JButton("Multijuador");
		btnMultijuador.setBounds(256, 246, 173, 23);
		frame.getContentPane().add(btnMultijuador);
		
		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(256, 294, 173, 23);
		frame.getContentPane().add(btnOpciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(256, 353, 173, 23);
		frame.getContentPane().add(btnSalir);
		
		JLabel lbldWars = new JLabel("2D WARS");
		lbldWars.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 40));
		lbldWars.setBounds(256, 60, 173, 119);
		frame.getContentPane().add(lbldWars);
	}
}
