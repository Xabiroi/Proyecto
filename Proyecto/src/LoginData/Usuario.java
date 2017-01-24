package LoginData;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private String nick;
	public Usuario() {}
	
	
	/**
	 * Constructor usuario
	 * @param usuario nombre
	 * @param contraseña contraseña personal
	 */
	public Usuario(String usuario, String contraseña) {
		super();
		this.nombre = usuario;
		this.contraseña = contraseña;
	}


	/**
	 * Constructor usuario
	 * @param usuario nombre
	 * @param contraseña contraseña personal
	 * @param nick para buscar diferencia en caso de usuarios con nombre similar
	 */
	public Usuario(String usuario, String contraseña, String nick) {
		super();
		this.nombre = usuario;
		this.contraseña = contraseña;
		this.nick = nick;
	}



	/**
	 * @return nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Cambia el nombre de usuario
	 * @param nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}
	/**Establece la contraseña
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
	/**Establece el nick del usuario
	 * @param nick del usuario
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

}
