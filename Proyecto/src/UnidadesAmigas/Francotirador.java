package UnidadesAmigas;


import javax.swing.ImageIcon;

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
	
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        x = 55;
        y = 55;       
    }

}
