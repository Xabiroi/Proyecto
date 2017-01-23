package UnidadesEnemigas;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

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
		
		//Atributos de la unidad Soldado raso
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}


	//Método que pinta el Soldado raso enemigo en el mapa
	private Image SoldadoRasoEnemigo = null;
	
		public void pintarSoldadoRasoEnemigo(Graphics g){
			if (SoldadoRasoEnemigo == null)
				SoldadoRasoEnemigo = getImage("SoldadoRasoEnemigo.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(SoldadoRasoEnemigo, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
		
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = SoldadoRasoEnemigo.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}

	
}
