package UnidadesAmigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Persona;
import Interfaces.Unidad;

public class Bazooka extends UnidadAliada implements Persona,Unidad{
	
	public Bazooka(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Bazooka";
		arma="Bazooka";
		this.armas= new String[] {"Bazooka", "Pistola"};
		Salud = 60;
		this.x = cordX;
		this.y = cordY;
		this.coste =50;
		this.Distancia = 5;
		
	}
	
	
	
	private Image Bazooka = null;
	
	public void pintarBazoka(Graphics g){
		if (Bazooka == null)
			Bazooka = getImage("Bazooka.png");
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Bazooka, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
	}
	
	public Image getImage(String path){
		
		Image tempImage = null;
		try{
			URL imageURL = Bazooka.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		}
		//en caso de que la imagen no exista
		catch (Exception e){
			System.out.println("imagen no existente" + e.getMessage());
			
		}
		return tempImage;
	}


}
