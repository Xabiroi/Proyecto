package UnidadesEnemigas;


import javax.swing.ImageIcon;

import Interfaces.Unidad;
import Interfaces.Vehiculo;


public class SemiorugaEnemigo extends UnidadEnemiga implements Vehiculo,Unidad{
	public SemiorugaEnemigo(int cordX, int cordY) {
	
		//Un set image aqui(?)
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
	
	@SuppressWarnings("unused")
	private void initCraft() {
        
        ImageIcon ii = new ImageIcon("craft.png");
        image = ii.getImage();
        //x = 40;
        //y = 60;        
    }

}
