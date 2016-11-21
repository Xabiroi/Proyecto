package LoginData;

public class Usuario {
	
	private String nombre;
	private String contrase�a;
	private String nick;
	//FIXME a�adir arraylist de partidas locales y online para la base de datos(?)
	public Usuario() {}
	
	
	
	public Usuario(String usuario, String contrase�a) {
		super();
		this.nombre = usuario;
		this.contrase�a = contrase�a;
	}



	public Usuario(String usuario, String contrase�a, String nick) {
		super();
		this.nombre = usuario;
		this.contrase�a = contrase�a;
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
	 * @return the contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**
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
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

}
