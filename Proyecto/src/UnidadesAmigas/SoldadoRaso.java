package UnidadesAmigas;




import Interfaces.Unidad;


public class SoldadoRaso extends UnidadAliada implements Unidad{

	/**
	 * Atributos de los soldados normales:
	 * Armas (3) con su respectivo daño de ataque y probabilidad de fallar
	 * Arraylist con los objetivos a su rango (para seleccionar al atacar)
	 * Salud
	 * Icono
	 * 
	 */

	public SoldadoRaso(int cordX, int cordY) {
		//Atributos de la unidad Soldado raso
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.coste =35;
		this.Distancia = 5;
		
	}



}
