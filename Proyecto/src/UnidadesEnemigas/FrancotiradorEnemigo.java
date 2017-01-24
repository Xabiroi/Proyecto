package UnidadesEnemigas;

import Interfaces.Unidad;


public class FrancotiradorEnemigo extends UnidadEnemiga implements Unidad{

	public FrancotiradorEnemigo(int cordX, int cordY) {
		
		//Atributos de la unidad Francotirador
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}


	
}
