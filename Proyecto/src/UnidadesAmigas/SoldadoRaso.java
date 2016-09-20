package UnidadesAmigas;



import java.awt.Image;
import java.util.ArrayList;


import Interfaces.Persona;
import UnidadesEnemigas.UnidadEnemiga;

public class SoldadoRaso extends UnidadAliada implements Persona{

	/**
	 * Atributos de los soldados normales:
	 * Armas (3) con su respectivo daño de ataque y probabilidad de fallar
	 * Arraylist con los objetivos a su rango (para seleccionar al atacar)
	 * Salud
	 * Icono
	 * 
	 */
	private String[] armas= new String[] {"Rifle", "Pistola", "CQC" }; //Rango medio, corto y cuerpo a cuerpo
	private ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();//Lista que se actualizara cada vez que se haga un movimiento
	private int Salud=100;//Salud base de los soldados raso
	private Image image;//Icono que tendra en el juego cada soldado raso (sin variacion de momento)
	protected int cordX;//Coordenadas de la situacion del soldado
	protected int cordY;
	
	//Getters y setters
	
	
	
	public String[] getArmas() {
		return armas;
	}
	public void setArmas(String[] armas) {
		this.armas = armas;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	

	

}
