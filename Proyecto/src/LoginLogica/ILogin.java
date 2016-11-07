package LoginLogica;

import LoginData.Usuario;

public interface ILogin {
	public boolean login(String usuario, String contrase�a);
	public boolean registro(Usuario u);
	public String recuperarContrase�a(String usuario);
}
