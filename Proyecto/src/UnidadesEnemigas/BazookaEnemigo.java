package UnidadesEnemigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Persona;
import Interfaces.Unidad;

public class BazookaEnemigo extends UnidadEnemiga implements Persona,Unidad{
	
	public BazookaEnemigo(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.x = cordX;
		this.y = cordY;
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
	
	private Image BazookaEnemigo = null;
	
		public void pintarBazookaEnemigo(Graphics g){
			if (BazookaEnemigo == null)
				BazookaEnemigo = getImage("BazookaEnemigo.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(BazookaEnemigo, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = BazookaEnemigo.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}

}
