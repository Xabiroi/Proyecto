package LoginData;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private String nick;
	//FIXME añadir arraylist de partidas locales y online para la base de datos(?)
	public Usuario() {}
	
	
	
	public Usuario(String usuario, String contraseña) {
		super();
		this.nombre = usuario;
		this.contraseña = contraseña;
	}



	public Usuario(String usuario, String contraseña, String nick) {
		super();
		this.nombre = usuario;
		this.contraseña = contraseña;
		this.nick = nick;
	}



	/**
	 * @return the usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
