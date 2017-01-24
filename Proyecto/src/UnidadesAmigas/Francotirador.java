package UnidadesAmigas;



import Interfaces.Unidad;

public class Francotirador extends UnidadAliada implements Unidad{

	public Francotirador(int cordX, int cordY) {
		
		//Atributos de el soldado Francotirador
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		this.Distancia = 5;
		
	}
	

}
