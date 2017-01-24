package LogicaBatallas;

import java.util.ArrayList;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;
/**
 * Clase que contiene los arrays de soldados
 * 
 *
 */
public class ArraysPartida{
	/**
	 * Lista de unidades enemigas
	 */
	public ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	/**
	 * Lista de unidades aliadas
	 */
	public ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();

/**
 * Devuelve la lista de unidades enemigas
 * @return ArrayList con las unidades enemigas
 */
	public ArrayList<UnidadEnemiga> getListaEnemigos() {
		return ListaEnemigos;
	}
	/**
	 * Sustituye la lista de enemigos por la pasada por parametro
	 * @param listaEnemigos ArrayList de unidades enemigas
	 */
	public void setListaEnemigos(ArrayList<UnidadEnemiga> listaEnemigos) {
		ListaEnemigos = listaEnemigos;
	}
	/**
	 * Devuelve la lista de unidades aliadas
	 * @return ArrayList con las unidades aliadas
	 */
	public ArrayList<UnidadAliada> getListaAliados() {
		return ListaAliados;
	}
	/**
	 * Sustituye la lista de aliados por la pasada por parametro
	 * @param listaAliados ArrayList de unidades aliadas
	 */
	public void setListaAliados(ArrayList<UnidadAliada> listaAliados) {
		ListaAliados = listaAliados;
	}

}
