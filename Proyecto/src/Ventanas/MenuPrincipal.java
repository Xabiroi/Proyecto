package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuPrincipal extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	 
	/**
	 * Lanza el Main
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
	 * Crea la ventana
	 */
	public MenuPrincipal() {
		initialize();
	}
	
	/**
	 * Inicializa el contenido de la ventana
	 */
	
	private void initialize() {

		//FIXME image = ImageIO.read(new File("image name and path"));
		setBounds(100, 100, 744, 561);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		//Boton que abre la ventana de Menu1Jugador
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
		
		//Boton que abre la ventana de MenuMultijugador
		JButton btnMultijuador = new JButton("Multijugador");
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
		 //Boton que termina la aplicacion
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(256, 353, 173, 23);
		btnSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);

				}
			});
		 getContentPane().add(btnSalir);
		
		JLabel lbldWars = new JLabel("2D WARS");
		lbldWars.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 40));
		lbldWars.setBounds(256, 60, 173, 119);
		 getContentPane().add(lbldWars);
	}

}
