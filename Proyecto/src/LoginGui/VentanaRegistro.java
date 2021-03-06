package LoginGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BD;
import LoginData.Usuario;
import LoginLogica.LoginManager;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
/**
 * 
 * Ventana que sirve para registrar al usuario
 *
 */
public class VentanaRegistro extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField pswField;
	private JTextField txtNombreReal;

	/**
	 * Main de la ventana
	 */
	public static void main(String[] args) {
		try {
			LoginManager lm = new LoginManager();
			VentanaRegistro dialog = new VentanaRegistro(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor de la ventana de registro
	 * @param lm Login manager
	 */
	public VentanaRegistro(LoginManager lm) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 0, 0, 0));
		{
			JPanel pnlUsuario = new JPanel();
			contentPanel.add(pnlUsuario);
			{
				JLabel lblUsuario = new JLabel("Usuario"); //recoje el nombre de usuario
				pnlUsuario.add(lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				pnlUsuario.add(txtUsuario);
				txtUsuario.setColumns(10);
			}
		}
		{
			JPanel pnlContraseņa = new JPanel();
			contentPanel.add(pnlContraseņa);
			{
				JLabel lblContrasea = new JLabel("Contrase\u00F1a: "); //recoje la contraseņa
				pnlContraseņa.add(lblContrasea);
			}
			{
				pswField = new JPasswordField();
				pswField.setColumns(10);
				pnlContraseņa.add(pswField);
			}
		}
		{
			JPanel pnlNombreReal = new JPanel();
			contentPanel.add(pnlNombreReal);
			{
				JLabel lblNombreReal = new JLabel("Nombre Real: "); //recoje el nombre real de el usuario
				pnlNombreReal.add(lblNombreReal);
			}
			{
				txtNombreReal = new JTextField();
				txtNombreReal.setText("");
				pnlNombreReal.add(txtNombreReal);
				txtNombreReal.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK"); //boton de afirmacion
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Usuario u = null;
						if(txtNombreReal.getText().length() == 0){
							u = new Usuario(txtUsuario.getText(),
									new String(pswField.getPassword()));
						} else{
							u = new Usuario(txtUsuario.getText(),
									new String(pswField.getPassword()),
									txtNombreReal.getText());
							//Reistra al usuario en la base de datos local y remota
							Statement st=BD.usarBD(BD.initBDOnline("Remote"));
							Statement st1=BD.usarBD(BD.initBD("Local"));
									BD.usuarioInsert(st,u);
									BD.usuarioInsert(st1,u);
							
						}
						
						if(lm.registro(u)){
							JOptionPane.showMessageDialog(null, "Usuario Creado.");
						} else {
							JOptionPane.showMessageDialog(null, "Error al crear el usuario", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel"); //boton de calncelacion
				cancelButton.setActionCommand("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
