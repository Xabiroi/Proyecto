package LogicaBatallas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;

public class LogicaPartida{
	public static ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	public static ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();
	
	
	
	
	
	/*
	 * Listas de enemigos que comprueben coordenadas
	 * Se actualizan cada vez que una unidad es creada o muerta, al final de cada ataque o turno del jugador
	 * Los objetivos de cada persona seran alcanzables solo si se encuentran a unas coordenadas de distancia que variara depende del arma usada
	 */
	//FIXME METER TODO ESTO EN PARTIDA PARA LOS ACCESOS DE METODOS
	public static void actualizar(){
		//añadir los nuevos soldados creados en el turno/quitar los muertos
		/*
		Partida.this.dineroAliado=+50;
		Partida.dineroEnemigo=+50;
		*/
	}
	
	
	
	//FIXME Funcion que se pondra en la ventana, adelanto (pasar parametro un boton clickado? y luego el getText)
	public static void Turno(){
		actualizar();
		
		
		
	//Turno aliado
		boolean terminadoUnidadAliada=false;
		for(UnidadAliada ua:ListaAliados){
			//FIXME Centrar la camara en la unidad
			//FIXME Mostrar ventana de opciones(?)
			
			String[] acciones=new String[]{"Mover","Atacar","Cambiar Arma","Finalizar"};
			
			String respuesta="";
			//FIXME La opcion seleccionada se pasa por una funcion o por codigo de ventana
			switch(respuesta){
			
			case  "Mover":
				
				//ua.Mover();
				//Se quita la opcion de mover del listado de acciones despues de ejecutarlo
				acciones=new String[]{"Atacar","Cambiar Arma","Finalizar"};
				break;
			case  "Atacar":
				ua.Objetivos();
				//ua.atacar(P);
				acciones=new String[]{"Finalizar"};

				break;
			case  "Cambiar Arma":
				String[] a=ua.getArmas();
				//Enseñar una ventana donde pueda elegir el arma
				//Enviar un string de su arma
				//Ejemplo de lo que obtendriamos
				String arma="Rifle";
				ua.setArma(arma);
				acciones=new String[]{"Atacar","Finalizar"};

				
				break;
			case  "Finalizar":
				break;
			
			
			
			
			
			
			}
			
			
			
		}
		
		
		
		boolean terminadoUnidadEnemiga=false;
		//Turno enemigo
		for(UnidadEnemiga ua:ListaEnemigos){
			//FIXME Centrar la camara en la unidad
			//FIXME Mostrar ventana de opciones(?)
			
			String[] acciones=new String[]{"Mover","Atacar","Cambiar Arma","Finalizar"};
			
			String respuesta="";
			//FIXME La opcion seleccionada se pasa por una funcion o por codigo de ventana
			switch(respuesta){
			
			case  "Mover":
				
				//ua.Mover();
				//Se quita la opcion de mover del listado de acciones despues de ejecutarlo
				acciones=new String[]{"Atacar","Cambiar Arma","Finalizar"};
				break;
			case  "Atacar":
				ua.Objetivos();
				//ua.atacar(P);
				acciones=new String[]{"Finalizar"};

				break;
			case  "Cambiar Arma":
				String[] a=ua.getArmas();
				//Enseñar una ventana donde pueda elegir el arma
				//Enviar un string de su arma
				//Ejemplo de lo que obtendriamos
				String arma="Rifle";
				ua.setArma(arma);
				acciones=new String[]{"Atacar","Finalizar"};

				
				break;
			case  "Finalizar":
				//Se crea el dialogo de si se quiere finalizar turno, y depende de la respuesta si o no
				//PRUEBA FIXME
				int input = JOptionPane.showOptionDialog(null, "Finalizar turno?", "Aviso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if(input == JOptionPane.OK_OPTION)
				{
					
				    break;
				}
				
				
				break;
			
			
			
				}
			
			
			}
		
	}
	
	
	
	
	
	
	
	

	public static ArrayList<UnidadEnemiga> getListaEnemigos() {
		return ListaEnemigos;
	}
	public void setListaEnemigos(ArrayList<UnidadEnemiga> listaEnemigos) {
		ListaEnemigos = listaEnemigos;
	}
	public static ArrayList<UnidadAliada> getListaAliados() {
		return ListaAliados;
	}
	public void setListaAliados(ArrayList<UnidadAliada> listaAliados) {
		ListaAliados = listaAliados;
	}


	
	

}
