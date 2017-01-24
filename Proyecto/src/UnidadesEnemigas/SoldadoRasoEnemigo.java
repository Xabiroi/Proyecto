package UnidadesEnemigas;




import Interfaces.Unidad;



public class SoldadoRasoEnemigo extends UnidadEnemiga implements Unidad{


	public SoldadoRasoEnemigo(int cordX, int cordY) {
		
		//Atributos de la unidad Soldado raso
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}


	
}
