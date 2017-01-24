package Test;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import LogicaBatallas.ElementosPartida;
import Ventanas.Partida;
import LogicaBatallas.ArraysPartida;
/**
 * 
 * Test que genera la ventana de mapa
 *
 */
public class testVentana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testVentana window = new testVentana();
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
	public testVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Partida j = null;
		try {
			j = new Partida(new ElementosPartida(), new ArraysPartida());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(false);
		j.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		j.setVisible(true);
	}

}
