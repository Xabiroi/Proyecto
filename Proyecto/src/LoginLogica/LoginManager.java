package LoginLogica;

import java.util.ArrayList;

import javax.naming.AuthenticationNotSupportedException;

import LoginData.Usuario;

public class LoginManager implements ILogin {

	private ArrayList<Usuario> aUsuarios = new ArrayList<Usuario>();
	
	public LoginManager(){	}
	
	/**
	 * M�todo que hace el login y lo comprueba con el array
	 */
	@Override
	public boolean login(String usuario, String contrase�a) {
		boolean resultado = false;
		// recorrer el array buscando el nombre de usuario y la contrase�a
		for(Usuario u : aUsuarios){
			if(u.getUsuario().equals(usuario) &&
					u.getContrase�a().equals(contrase�a)){
				resultado = true;
				break;
			}				
		}		
		return resultado;
		
	}

	@Override
	public boolean registro(Usuario u) {
		boolean registrado = false;
		// TODO Auto-generated method stub
		for(Usuario u1 : aUsuarios){
			if(u1.getUsuario().equals(u.getUsuario())){
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
	 * M�todo que devuelve la contrase�a de un usuario dado.
	 */
	@Override
	public String recuperarContrase�a(String usuario) {
		String contrase�a = null;
		// TODO Auto-generated method stub
		for(Usuario u1 : aUsuarios){
			if(u1.getUsuario().equals(usuario)){
				contrase�a = u1.getContrase�a();
				break;
			}
		}
		return contrase�a;
	}

	public static void main(String[] args) {
		LoginManager lm = new LoginManager();
		
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario("a","a");
		Usuario u2 = new Usuario("b","b");
		
		// Prueba registro
		System.out.println(lm.registro(u1));
		System.out.println(lm.registro(u1));
		System.out.println(lm.registro(u2));
		
		//  Prueba login
		System.out.println("Pruebas login\n============");
		System.out.println(lm.login(u1.getUsuario(), u1.getContrase�a()));
		System.out.println(lm.login(u1.getUsuario(), "fallo"));
		System.out.println(lm.login("c","c"));
		
		// Prueba recuperarContrase�a
		
		System.out.println("Pruebas contrase�a\n============");
		System.out.println(lm.recuperarContrase�a(u1.getUsuario()));
		System.out.println(lm.recuperarContrase�a("c"));
		
		

	}

}
