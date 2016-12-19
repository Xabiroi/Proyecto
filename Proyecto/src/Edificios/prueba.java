package Edificios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LoginLogica.LoginManager;
public class prueba extends JDialog {
/**
 * 
 */
private static final long serialVersionUID = 1L;
private final JPanel contentPanel = new JPanel();
private JTextField txtContraseña;
private LoginManager lm;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	try {
		prueba dialog = new prueba();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Create the dialog.
 * @param lm 
 */
public prueba() {
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setLayout(new FlowLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	
	//FIXME image = ImageIO.read(new File("image name and path"));
	setBounds(100, 100, 744, 561);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	getContentPane().setLayout(null);
	
	JButton btnUn_jugador = new JButton("Local");
	btnUn_jugador.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnUn_jugador.setBounds(256, 200, 173, 23);
	 getContentPane().add(btnUn_jugador);
	
	JButton btnMultijuador = new JButton("Multijuador");
	btnMultijuador.setBounds(256, 246, 173, 23);
	 getContentPane().add(btnMultijuador);
	
	JButton btnOpciones = new JButton("Opciones");
	btnOpciones.setBounds(256, 294, 173, 23);
	 getContentPane().add(btnOpciones);
	
	JButton btnSalir = new JButton("Salir");
	btnSalir.setBounds(256, 353, 173, 23);
	 getContentPane().add(btnSalir);
	
	JLabel lbldWars = new JLabel("2D WARS");
	lbldWars.setFont(new Font("Tekton Pro", Font.BOLD | Font.ITALIC, 40));
	lbldWars.setBounds(256, 60, 173, 119);
	 getContentPane().add(lbldWars);
}

}
