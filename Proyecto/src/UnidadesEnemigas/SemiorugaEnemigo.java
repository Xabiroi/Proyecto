package UnidadesEnemigas;

import Interfaces.Unidad;



public class SemiorugaEnemigo extends UnidadEnemiga implements Unidad{
	public SemiorugaEnemigo(int cordX, int cordY) {
	
		//Atributos de la unidad Semioruga
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 7;
		
	}


}
