package UnidadesEnemigas;


import Interfaces.Persona;

public class BazookaEnemigo extends UnidadEnemiga implements Persona{
	
	public BazookaEnemigo(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}

}
