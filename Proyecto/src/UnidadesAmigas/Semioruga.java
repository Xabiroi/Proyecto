package UnidadesAmigas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import Interfaces.Unidad;
import Interfaces.Vehiculo;

public class Semioruga extends UnidadAliada implements Vehiculo,Unidad{
	public Semioruga(int cordX, int cordY) {
		
		//Atributos de la unidad Semioruga
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.x = cordX;
		this.y = cordY;
		this.coste =70;
		this.Distancia = 7;
		
	}

	
	//Método que señala el daño que hace el Semioruga al explotar
	@Override
	public int explotar() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	//Método que pinta la unidad Semioriga en el mapa
	
	private Image Semioruga = null;
	
		public void pintarSemioruga(Graphics g){
			if (Semioruga == null)
				Semioruga = getImage("Semioruga.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(Semioruga, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = Semioruga.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}

}
