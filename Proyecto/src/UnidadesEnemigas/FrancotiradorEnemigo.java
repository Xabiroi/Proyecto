package UnidadesEnemigas;


import Interfaces.Persona;

public class FrancotiradorEnemigo extends UnidadEnemiga implements Persona{

	public FrancotiradorEnemigo(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}

}