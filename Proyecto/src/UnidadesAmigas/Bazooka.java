package UnidadesAmigas;


import Interfaces.Persona;
import Interfaces.Unidad;

public class Bazooka extends UnidadAliada implements Persona,Unidad{
	
	public Bazooka(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		
	}

}
