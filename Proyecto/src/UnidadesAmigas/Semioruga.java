package UnidadesAmigas;


import Interfaces.Vehiculo;

public class Semioruga extends UnidadAliada implements Vehiculo{
	public Semioruga(int cordX, int cordY) {
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
