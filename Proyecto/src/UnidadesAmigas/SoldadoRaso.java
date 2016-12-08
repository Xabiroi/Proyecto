package UnidadesAmigas;



import java.awt.Image;
import Interfaces.Persona;
import Interfaces.Unidad;


public class SoldadoRaso extends UnidadAliada implements Persona,Unidad{

	/**
	 * Atributos de los soldados normales:
	 * Armas (3) con su respectivo daño de ataque y probabilidad de fallar
	 * Arraylist con los objetivos a su rango (para seleccionar al atacar)
	 * Salud
	 * Icono
	 * 
	 */



	//private Image image;
	//Cada unidad tiene que tener su propio icono en el juego
	//Hay que asignar en el constructor a cada unidad su icono

	
	public SoldadoRaso(int cordX, int cordY) {
		//FIXME Un set image aqui(?)
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.coste =35;
		
	}


	
//TODO Prueba
	public static void main(String[] args) {
		SoldadoRaso x=new SoldadoRaso(0,0);
		System.out.println("Patata");
	}
	

}
