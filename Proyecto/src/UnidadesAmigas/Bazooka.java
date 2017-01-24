package UnidadesAmigas;



import Interfaces.Unidad;

public class Bazooka extends UnidadAliada implements Unidad{
	
	public Bazooka(int cordX, int cordY) {
		
		//Atributos de el soldado Bazooka
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		this.Distancia = 5;
		
	}



}
