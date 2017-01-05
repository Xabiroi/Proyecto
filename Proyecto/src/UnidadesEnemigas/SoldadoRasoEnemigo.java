package UnidadesEnemigas;



import java.awt.Image;

import javax.swing.ImageIcon;

import Interfaces.Persona;
import Interfaces.Unidad;



public class SoldadoRasoEnemigo extends UnidadEnemiga implements Persona,Unidad{

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

	
	public SoldadoRasoEnemigo(int cordX, int cordY) {
		
		//FIXME Un set image aqui(?)
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}

	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        //x = 40;
        //y = 60;        
    }
	
}
