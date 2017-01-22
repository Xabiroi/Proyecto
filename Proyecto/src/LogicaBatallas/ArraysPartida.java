package LogicaBatallas;

import java.util.ArrayList;

import UnidadesAmigas.UnidadAliada;
import UnidadesEnemigas.UnidadEnemiga;

public class ArraysPartida{
	public ArrayList<UnidadEnemiga> ListaEnemigos=new ArrayList<UnidadEnemiga>();
	public ArrayList<UnidadAliada> ListaAliados=new ArrayList<UnidadAliada>();


	public ArrayList<UnidadEnemiga> getListaEnemigos() {
		return ListaEnemigos;
	}
	public void setListaEnemigos(ArrayList<UnidadEnemiga> listaEnemigos) {
		ListaEnemigos = listaEnemigos;
	}
	public ArrayList<UnidadAliada> getListaAliados() {
		return ListaAliados;
	}
	public void setListaAliados(ArrayList<UnidadAliada> listaAliados) {
		ListaAliados = listaAliados;
	}

}
