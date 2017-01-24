package LoginLogica;

import LoginData.Usuario;
/**
 * Interfaz aplicada al login
 *
 *
 */
public interface ILogin {
	public boolean login(String usuario, String contraseña);
	public boolean registro(Usuario u);
	public String recuperarContraseña(String usuario);
}
