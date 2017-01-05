package UnidadesEnemigas;


import javax.swing.ImageIcon;

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
	
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        //x = 40;
        //y = 60;        
    }

}
