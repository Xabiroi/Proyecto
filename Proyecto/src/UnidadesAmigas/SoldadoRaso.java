package UnidadesAmigas;



import java.awt.Image;
import Interfaces.Persona;

public class SoldadoRaso extends UnidadAliada implements Persona{

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

	
	public SoldadoRaso(int salud,int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola", "CQC" };
		Salud = salud;
		this.cordX = cordX;
		this.cordY = cordY;
	}


	

	public static void main(String[] args) {
		SoldadoRaso x=new SoldadoRaso(100,0,0);
		System.out.println("Patata");
	}
	

}
