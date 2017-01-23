package UnidadesAmigas;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

import Interfaces.Persona;
import Interfaces.Unidad;


public class SoldadoRaso extends UnidadAliada implements Persona,Unidad{

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




	public SoldadoRaso(int cordX, int cordY) {
		//FIXME Un set image aqui(?)
		Nombre="Soldado";
		arma="Fusil";
		this.armas= new String[] {"Fusil", "Pistola", "CCC" };//CCC=combate cuerpo a cuerpo
		Salud = 100;
		this.x = cordX;
		this.y = cordY;
		this.coste =35;
		this.Distancia = 5;
		
	}


	private ImageIcon initCraft() {
        
        ImageIcon ii = new ImageIcon("SoldadoRaso.png");
		return ii;               
    }
 
	
	
	private Image SoldadoRaso = null;
	
		public void pintarSoldadoRaso(Graphics g){
			if (SoldadoRaso == null)
				SoldadoRaso = getImage("SoldadoRaso.png");
		
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(SoldadoRaso, x, y, 26, 26, null); //x e y diran donde se coloca el soldado
		}
	
		public Image getImage(String path){
		
			Image tempImage = null;
			try{
				URL imageURL = SoldadoRaso.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			}
			//en caso de que la imagen no exista
			catch (Exception e){
				System.out.println("imagen no existente" + e.getMessage());
			
			}
			return tempImage;
	}



	
//FIXME Prueba quitar
	public static void main(String[] args) {
		SoldadoRaso x=new SoldadoRaso(0,0);
		System.out.println("Patata");
	}
	

}
