package UnidadesEnemigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Unidad;
import Interfaces.Vehiculo;


public class SemiorugaEnemigo extends UnidadEnemiga implements Vehiculo,Unidad{
	public SemiorugaEnemigo(int cordX, int cordY) {
	
		//Atributos de la unidad Semioruga
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 7;
		
	}

	@Override
	public int explotar() {
		// TODO Auto-generated method stub
		return 0;
	}
	


	//Método que pinta el Semioruga en el mapa
	private Image SemiorugaEnemigo = null;
	
		public void pintarSemiorugaEnemigo(Graphics g){
			if (SemiorugaEnemigo == null)
				SemiorugaEnemigo = getImage("SemiorugaEnemigo.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(SemiorugaEnemigo, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = SemiorugaEnemigo.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}
}
