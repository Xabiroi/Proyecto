package UnidadesEnemigas;


import Interfaces.Unidad;
import Interfaces.Vehiculo;


public class SemiorugaEnemigo extends UnidadEnemiga implements Vehiculo,Unidad{
	public SemiorugaEnemigo(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}

	@Override
	public int explotar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
