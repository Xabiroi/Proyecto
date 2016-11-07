package LoginData;

public class Usuario {
	
	private String usuario;
	private String contraseña;
	private String nick;
	//FIXME añadir arraylist de partidas locales y online para la base de datos(?)
	public Usuario() {}
	
	
	
	public Usuario(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}



	public Usuario(String usuario, String contraseña, String nick) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nick = nick;
	}



	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**
	 * @param contraseña Cambiar la contraseña a la que especifiquemos
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	/**
	 * @return Nick del usuario
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

}
