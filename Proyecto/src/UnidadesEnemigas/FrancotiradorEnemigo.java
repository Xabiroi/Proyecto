package UnidadesEnemigas;


import javax.swing.ImageIcon;

import Interfaces.Persona;
import Interfaces.Unidad;


public class FrancotiradorEnemigo extends UnidadEnemiga implements Persona,Unidad{

	public FrancotiradorEnemigo(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Francotirador";
		arma="Rifle";
		this.armas= new String[] {"Rifle", "Pistola"};
		Salud = 70;
		this.x = cordX;
		this.y = cordY;
		this.Distancia = 5;
		
	}

	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        x = 26;
        y = 26;                
    }
	
}
