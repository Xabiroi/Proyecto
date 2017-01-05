package UnidadesAmigas;


import javax.swing.ImageIcon;

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
	
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        //x = 40;
        //y = 60;        
    }

}
