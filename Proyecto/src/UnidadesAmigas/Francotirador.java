package UnidadesAmigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Persona;
import Interfaces.Unidad;

public class Francotirador extends UnidadAliada implements Persona,Unidad{

	public Francotirador(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		this.Distancia = 5;
		
	}
	

/***
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        x = 26;
        y = 26;        
    }
    **/
	
	private Image Francotirador = null;
	
		public void pintarFrancotirador(Graphics g){
			if (Francotirador == null)
				Francotirador = getImage("Francotirador.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(Francotirador, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = Francotirador.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}

}
