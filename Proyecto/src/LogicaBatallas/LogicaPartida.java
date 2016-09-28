package LogicaBatallas;

import java.util.ArrayList;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;

public class LogicaPartida {
	public static ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	public static ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();
	public static int dineroAliado=200;
	public static int dineroEnemigo=200;
	
	
	
	/*
	 * Listas de enemigos que comprueben coordenadas
	 * Se actualizan cada vez que una unidad es creada o muerta, al final de cada ataque o turno del jugador
	 * Los objetivos de cada persona seran alcanzables solo si se encuentran a unas coordenadas de distancia que variara depende del arma usada
	 */
	
	public static void actualizar(){
		//a�adir los nuevos soldados creados en el turno/quitar los muertos
		
	}
	
	
	
	//FIXME Funcion que se pondra en la ventana, adelanto
	public static void Turno(){
		actualizar();
		dineroAliado=+50;
		dineroEnemigo=+50;
		
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
				//Ense�ar una ventana donde pueda elegir el arma
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
				//Ense�ar una ventana donde pueda elegir el arma
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
		
	}
	
	
	
	
	
	
	
	

	public static ArrayList<UnidadEnemiga> getListaEnemigos() {
		return ListaEnemigos;
	}
	public static void setListaEnemigos(ArrayList<UnidadEnemiga> listaEnemigos) {
		ListaEnemigos = listaEnemigos;
	}
	public static ArrayList<UnidadAliada> getListaAliados() {
		return ListaAliados;
	}
	public static void setListaAliados(ArrayList<UnidadAliada> listaAliados) {
		ListaAliados = listaAliados;
	}
	public static int getDineroAliado() {
		return dineroAliado;
	}

	public static int getDineroEnemigo() {
		return dineroEnemigo;
	}

	
	

}
