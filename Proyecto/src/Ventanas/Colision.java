package Ventanas;

public class Colision extends BD.UnidadBD{
	private int Tipo=0; //IMPORTANTE para el algoritmo de pathfinding se colocaran los de tipo uno para no repetir camino, y si no encuentra camino
	//con un for se quitan todos del tipo 1
	
 public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

public Colision(){}
}
