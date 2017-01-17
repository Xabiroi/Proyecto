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
