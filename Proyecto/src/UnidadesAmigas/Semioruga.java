package UnidadesAmigas;


import Interfaces.Unidad;
import Interfaces.Vehiculo;

public class Semioruga extends UnidadAliada implements Vehiculo,Unidad{
	public Semioruga(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Semioruga";
		arma="Ametralladora";
		this.armas= new String[] {"Ametralladora" };
		Salud = 120;
		this.x = cordX;
		this.y = cordY;
		this.coste =70;
		this.Distancia = 7;
		
	}

	@Override
	public int explotar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
