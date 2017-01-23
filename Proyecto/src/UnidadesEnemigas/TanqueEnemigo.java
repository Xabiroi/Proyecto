package UnidadesEnemigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Unidad;
import Interfaces.Vehiculo;


public class TanqueEnemigo extends UnidadEnemiga implements Vehiculo,Unidad{
	public TanqueEnemigo(int cordX, int cordY) {
		//Un set image aqui(?)
		Nombre="Tanque";
		arma="Misil";
		this.armas= new String[] {"Misil", "Ametralladora"};
		Salud = 170;
		this.x = cordX;
		this.y= cordY;
		this.Distancia = 7;
		
	}

	@Override
	public int explotar() {
		//Daño en area cuando muere(?)
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	private Image TanqueEnemigo = null;
	
		public void pintarTanqueEnemigo(Graphics g){
			if (TanqueEnemigo == null)
				TanqueEnemigo = getImage("TanqueEnemigo.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(TanqueEnemigo, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
			
			Image tempImage = null;
			try{
				URL imageURL = TanqueEnemigo.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}
}
