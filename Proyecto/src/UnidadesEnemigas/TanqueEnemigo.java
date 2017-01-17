package UnidadesEnemigas;


import javax.swing.ImageIcon;

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
	
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        x = 55;
        y = 55;        
    }

}
