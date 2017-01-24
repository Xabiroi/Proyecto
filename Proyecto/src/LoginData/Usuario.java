package LoginData;

public class Usuario {
	
	private String nombre;
	private String contrase�a;
	private String nick;
	public Usuario() {}
	
	
	/**
	 * Constructor usuario
	 * @param usuario nombre
	 * @param contrase�a contrase�a personal
	 */
	public Usuario(String usuario, String contrase�a) {
		super();
		this.nombre = usuario;
		this.contrase�a = contrase�a;
	}


	/**
	 * Constructor usuario
	 * @param usuario nombre
	 * @param contrase�a contrase�a personal
	 * @param nick para buscar diferencia en caso de usuarios con nombre similar
	 */
	public Usuario(String usuario, String contrase�a, String nick) {
		super();
		this.nombre = usuario;
		this.contrase�a = contrase�a;
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
	 * @return contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**Establece la contrase�a
	 * @param contrase�a Cambiar la contrase�a a la que especifiquemos
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
