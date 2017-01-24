package UnidadesAmigas;


import Interfaces.Unidad;


public class Semioruga extends UnidadAliada implements Unidad{
	public Semioruga(int cordX, int cordY) {
		
		//Atributos de la unidad Semioruga
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.x = cordX;
		this.y = cordY;
		this.coste =70;
		this.Distancia = 7;
		
	}

}
