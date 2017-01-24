package UnidadesEnemigas;


import Interfaces.Unidad;

public class BazookaEnemigo extends UnidadEnemiga implements Unidad{
	
	public BazookaEnemigo(int cordX, int cordY) {
		
		//Atributos de la unidad Bazooka
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}
	


}
