package LoginGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LoginLogica.LoginManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaContraseña extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtContraseña;
	private LoginManager lm;

	/**
	 * main que lanza la ventana de contraseña
	 */
	public static void main(String[] args) {
		try {
			LoginManager lm = new LoginManager();
			VentanaContraseña dialog = new VentanaContraseña(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * crea dialogo para introdcir la contraseña
	 * @param lm 
	 */
	public VentanaContraseña(LoginManager lm) {
		this.setLm(lm);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblUsuario = new JLabel("Usuario:"); //label al lado de la casilla usuario
			contentPanel.add(lblUsuario);
		}
		{
			txtContraseña = new JTextField();
			contentPanel.add(txtContraseña);
			txtContraseña.setColumns(10);
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
						String contraseña = lm.recuperarContraseña(txtContraseña.getText());
						if(contraseña.length() > 0)
							JOptionPane.showMessageDialog(null, "Contraseña: " + contraseña); //label al lado de la casilla contraseña
						else
							JOptionPane.showMessageDialog(null, "Error el usuario no existe", "Error", JOptionPane.ERROR_MESSAGE); //mensage de error si el usuaro intruducido es erroneo
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
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	public LoginManager getLm() {
		return lm;
	}

	public void setLm(LoginManager lm) {
		this.lm = lm;
	}

}
