package Ventanas;
//CLase que representa el objeto de colision en el mapa
public class Colision extends BD.UnidadBD{
	//Las colisiones del mapa son de tipo 0 (default) y los de tipo 1 seran los puestos por el algoritmo de pathfinding
	private int Tipo=0; 
	
	//Getters y setters
 public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	//Constructor de colisiones
	public Colision(){
	}
	public Colision(int tipo){
	this.Tipo=tipo;
	}
}