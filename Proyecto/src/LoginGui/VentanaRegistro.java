package LoginGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LoginData.Usuario;
import LoginLogica.LoginManager;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField pswField;
	private JTextField txtNombreReal;

	/**
	 * Launch the application.
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
	 * Create the dialog.
	 * @param lm 
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
				JLabel lblUsuario = new JLabel("Usuario");
				pnlUsuario.add(lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				pnlUsuario.add(txtUsuario);
				txtUsuario.setColumns(10);
			}
		}
		{
			JPanel pnlContraseña = new JPanel();
			contentPanel.add(pnlContraseña);
			{
				JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
				pnlContraseña.add(lblContrasea);
			}
			{
				pswField = new JPasswordField();
				pswField.setColumns(10);
				pnlContraseña.add(pswField);
			}
		}
		{
			JPanel pnlNombreReal = new JPanel();
			contentPanel.add(pnlNombreReal);
			{
				JLabel lblNombreReal = new JLabel("Nombre Real: ");
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
				JButton okButton = new JButton("OK");
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
