package LogicaBatallas;

import java.util.ArrayList;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;

public class LogicaPartida {
	public static ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	public static ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();
	public static int dineroAliado;
	public static int dineroEnemigo;
	
	
	/**
	 * Listas de enemigos que comprueben coordenadas
	 * Se actualizan cada vez que una unidad es creada o muerta, al final de cada turno del jugador
	 * Los objetivos de cada persona seran alcanzables solo si se encuentran a unas coordenadas de distancia que variara depende del arma usada
	 * (Crear las armas como clases(?))
	 * 
	 * 
	 * @return
	 */
	
	

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
	public static void setDineroAliado(int dineroAliado) {
		LogicaPartida.dineroAliado = dineroAliado;
	}
	public static int getDineroEnemigo() {
		return dineroEnemigo;
	}
	public static void setDineroEnemigo(int dineroEnemigo) {
		LogicaPartida.dineroEnemigo = dineroEnemigo;
	}
	
	

}
