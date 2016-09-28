package UnidadesEnemigas;



import java.awt.Image;
import Interfaces.Persona;


public class SoldadoRasoEnemigo extends UnidadEnemiga implements Persona{

	/**
	 * Atributos de los soldados normales:
	 * Armas (3) con su respectivo da�o de ataque y probabilidad de fallar
	 * Arraylist con los objetivos a su rango (para seleccionar al atacar)
	 * Salud
	 * Icono
	 * 
	 */



	//private Image image;
	//Cada unidad tiene que tener su propio icono en el juego
	//Hay que asignar en el constructor a cada unidad su icono

	
	public SoldadoRasoEnemigo(int cordX, int cordY) {
		super();
		//FIXME Un set image aqui(?)
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}


	
}