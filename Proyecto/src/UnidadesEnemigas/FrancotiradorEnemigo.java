package UnidadesEnemigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Persona;
import Interfaces.Unidad;


public class FrancotiradorEnemigo extends UnidadEnemiga implements Persona,Unidad{

	public FrancotiradorEnemigo(int cordX, int cordY) {
		
		//Atributos de la unidad Francotirador
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}


	//Método que pinta el Francotirador enemigo en el mapa
	
	private Image FrancotiradorEnemigo = null;
	
		public void pintarFrancotiradorEnemigo(Graphics g){
			if (FrancotiradorEnemigo == null)
				FrancotiradorEnemigo = getImage("FrancotiradorEnemigo.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(FrancotiradorEnemigo, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = FrancotiradorEnemigo.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}
	
	
}
