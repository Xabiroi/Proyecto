package UnidadesAmigas;


import Interfaces.Persona;
import Interfaces.Unidad;

public class Francotirador extends UnidadAliada implements Persona,Unidad{

	public Francotirador(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		
	}

}
