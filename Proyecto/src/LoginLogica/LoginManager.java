package LoginLogica;

import java.util.ArrayList;

import LoginData.Usuario;

public class LoginManager implements ILogin {

	private static ArrayList<Usuario> aUsuarios = new ArrayList<Usuario>();
	
	public LoginManager(){	}
	
	/**
	 * Metodo que nos devuelve el usuario que esta logueado
	 * @return Usuario
	 */
	public static Usuario getUsuario(){return aUsuarios.get(0);}
	
	/**
	 * Método que hace el login y lo comprueba con el array de usuarios
	 */
	@Override
	public boolean login(String usuario, String contraseña) {
		boolean resultado = false;
		// recorrer el array buscando el nombre de usuario y la contraseña
		for(Usuario u : aUsuarios){
			if(u.getNombre().equals(usuario) &&
					u.getContraseña().equals(contraseña)){
				resultado = true;
				break;
			}				
		}		
		return resultado;
		
	}
	/**
	 * Registra el usuario
	 * 
	 */
	@Override
	public boolean registro(Usuario u) {
		boolean registrado = false;
	
		for(Usuario u1 : aUsuarios){
			if(u1.getNombre().equals(u.getNombre())){
				return registrado;
			}
		}
		if(!registrado){
			aUsuarios.add(u);
			registrado = true;
		}
		return registrado;
	}

	/**
	 * Método que devuelve la contraseña de un usuario dado
	 */
	 // NO IMPLEMENTADO
	 
	@Override
	public String recuperarContraseña(String usuario) {
		String contraseña = null;
		// TODO Auto-generated method stub
		for(Usuario u1 : aUsuarios){
			if(u1.getNombre().equals(usuario)){
				contraseña = u1.getContraseña();
				break;
			}
		}
		return contraseña;
	}
	


	public static void main(String[] args) {
		LoginManager lm = new LoginManager();
		Usuario u1 = new Usuario("a","a");
		Usuario u2 = new Usuario("b","b");
		
		// Prueba registro
		System.out.println(lm.registro(u1));
		System.out.println(lm.registro(u1));
		System.out.println(lm.registro(u2));
		
		//  Prueba login
		System.out.println("Pruebas login\n============");
		System.out.println(lm.login(u1.getNombre(), u1.getContraseña()));
		System.out.println(lm.login(u1.getNombre(), "fallo"));
		System.out.println(lm.login("c","c"));
		
		// Prueba recuperarContraseña
		
		System.out.println("Pruebas contraseña\n============");
		System.out.println(lm.recuperarContraseña(u1.getNombre()));
		System.out.println(lm.recuperarContraseña("c"));
		
		

	}


}
