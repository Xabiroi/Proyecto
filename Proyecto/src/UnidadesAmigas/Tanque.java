package UnidadesAmigas;


import Interfaces.Unidad;


public class Tanque extends UnidadAliada implements Unidad{
	public Tanque(int cordX, int cordY) {
		
		//Atributos de la unidad tanque
		Nombre="Tanque";
		arma="Misil";
		this.armas= new String[] {"Misil", "Ametralladora"};
		Salud = 170;
		this.x = cordX;
		this.y = cordY;
		this.coste =90;
		this.Distancia = 7;
		
	}


}
