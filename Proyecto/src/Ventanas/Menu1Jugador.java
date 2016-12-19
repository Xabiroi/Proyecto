package Ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Menu1Jugador extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
	 * Create the application.
	 */
	public Menu1Jugador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		///////////////
		/* FIXME
		PARTE DE BASES DE DATOS 
		//Para hacer las listas de las partidas utilizar el comando de select 
		 * 
		 * 
		String [] namelist = new String[gameinfo.length];
		for (int i=0; i<gameinfo.length; i++)
			namelist[i] = gameinfo[i][0];
		list = new JList(namelist);
		list.setFont(new Font("Helvetica",Font.BOLD,15));
		JScrollPane list_pane = new JScrollPane(list);
		list_pane.setPreferredSize(new Dimension(270,300));
		
		
		
		//Para que cada vez que se elija una partida se haga la de list listener
		 *Hay que cambiar todo esto obviamente FIXME
		 * 	list.addListSelectionListener(new ListSelectionListener() {
			 public void valueChanged(ListSelectionEvent e) {
			 	int idx = list.getSelectedIndex();
				if (idx < 0) return;
				desc_area.setText(
						formatText(readTextFile(gameinfo[idx][2]),35)
						+"\n\nPress Esc or Shift-Esc to quit."
				);
				grab.setIcon(new ImageIcon(Launcher.class.getClassLoader().
					getResource(gameinfo[idx][3])));
			 }
		} );
		
		
		*/
			
			setBounds(100, 100, 1193, 802);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Partida local");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblNewLabel.setBounds(498, 62, 241, 60);
			 getContentPane().add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(114, 209, 200, 35);
			 getContentPane().add(comboBox);
			
			JLabel lblPartidas = new JLabel("Partidas");
			lblPartidas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPartidas.setBounds(114, 184, 93, 14);
			 getContentPane().add(lblPartidas);
			
			JLabel lblFecha = new JLabel("Fecha:");
			lblFecha.setBounds(615, 219, 33, 14);
			 getContentPane().add(lblFecha);
			
			JLabel lblUsuario = new JLabel("Jugador 1:");
			lblUsuario.setBounds(580, 257, 68, 14);
			 getContentPane().add(lblUsuario);
			
			JLabel lblUsuario_1 = new JLabel("Jugador 2:");
			lblUsuario_1.setBounds(580, 370, 68, 14);
			 getContentPane().add(lblUsuario_1);
			
			JLabel lblDinero = new JLabel("Dinero");
			lblDinero.setBounds(640, 294, 46, 14);
			 getContentPane().add(lblDinero);
			
			JLabel lblPuntos = new JLabel("Puntos");
			lblPuntos.setBounds(640, 319, 33, 14);
			 getContentPane().add(lblPuntos);
			
			JLabel lblDinero_1 = new JLabel("Dinero");
			lblDinero_1.setBounds(640, 417, 33, 14);
			 getContentPane().add(lblDinero_1);
			
			JLabel lblPuntos_1 = new JLabel("Puntos");
			lblPuntos_1.setBounds(640, 442, 33, 14);
			 getContentPane().add(lblPuntos_1);
			
			textField = new JTextField();
			textField.setBounds(696, 291, 86, 20);
			 getContentPane().add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(696, 316, 86, 20);
			 getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(696, 414, 86, 20);
			 getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(696, 439, 86, 20);
			 getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(653, 367, 86, 20);
			 getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(653, 254, 86, 20);
			 getContentPane().add(textField_5);
			textField_5.setColumns(10);
			
			textField_6 = new JTextField();
			textField_6.setBounds(651, 216, 86, 20);
			 getContentPane().add(textField_6);
			textField_6.setColumns(10);
			
			JButton btnJugar = new JButton("JUGAR!");
			btnJugar.setBounds(413, 681, 89, 23);
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Partida p=new Partida();
					setVisible(false);
					p.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					p.setVisible(true);
					setVisible(false);
					getDefaultCloseOperation();
				}
			});
			 getContentPane().add(btnJugar);
			
			JButton btnVolver = new JButton("Volver");
			btnVolver.setBounds(597, 681, 89, 23);
			 getContentPane().add(btnVolver);
		}

}
