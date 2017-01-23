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

public class VentanaContrase�a extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtContrase�a;
	private LoginManager lm;

	/**
	 * main que lanza la ventana de contrase�a
	 */
	public static void main(String[] args) {
		try {
			LoginManager lm = new LoginManager();
			VentanaContrase�a dialog = new VentanaContrase�a(lm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * crea dialogo para introdcir la contrase�a
	 * @param lm 
	 */
	public VentanaContrase�a(LoginManager lm) {
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
			txtContrase�a = new JTextField();
			contentPanel.add(txtContrase�a);
			txtContrase�a.setColumns(10);
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
						String contrase�a = lm.recuperarContrase�a(txtContrase�a.getText());
						if(contrase�a.length() > 0)
							JOptionPane.showMessageDialog(null, "Contrase�a: " + contrase�a); //label al lado de la casilla contrase�a
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
