package LogicaBatallas;

import java.util.ArrayList;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;

public class LogicaPartida {
	public ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	public ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();
	
	
	
	/**
	 * Listas de enemigos que comprueben coordenadas
	 * Se actualizan cada vez que una unidad es creada o muerta, al final de cada turno del jugador
	 * Los objetivos de cada persona seran alcanzables solo si se encuentran a unas coordenadas de distancia que variara depende del arma usada
	 * (Crear las armas como clases(?))
	 * 
	 * 
	 * @return
	 */
	

	public static ArrayList<UnidadEnemiga> getListaUnidadesEnemigas() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<UnidadAliada> getListaUnidadesAmigas() {
		// TODO Auto-generated method stub
		return null;
	}

}
