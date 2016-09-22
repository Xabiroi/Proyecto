package UnidadesAmigas;


import Interfaces.Persona;

public class Bazooka extends UnidadAliada implements Persona{
	
	public Bazooka(int cordX, int cordY) {
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
