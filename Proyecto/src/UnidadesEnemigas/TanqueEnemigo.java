package UnidadesEnemigas;


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
		//Da�o en area cuando muere(?)
		// TODO Auto-generated method stub
		return 0;
	}

}
