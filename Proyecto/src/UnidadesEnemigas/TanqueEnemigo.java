package UnidadesEnemigas;


import Interfaces.Unidad;


public class TanqueEnemigo extends UnidadEnemiga implements Unidad{
	public TanqueEnemigo(int cordX, int cordY) {
		//Atributos de la unidad Tanque
		Nombre="Tanque";
		arma="Misil";
		this.armas= new String[] {"Misil", "Ametralladora"};
		Salud = 170;
		this.x = cordX;
		this.y= cordY;
		this.Distancia = 7;
		
	}


}
