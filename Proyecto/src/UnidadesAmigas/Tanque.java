package UnidadesAmigas;


import Interfaces.Unidad;
import Interfaces.Vehiculo;

public class Tanque extends UnidadAliada implements Vehiculo,Unidad{
	public Tanque(int cordX, int cordY) {
		
		//Un set image aqui(?)
		Nombre="Tanque";
		arma="Misil";
		this.armas= new String[] {"Misil", "Ametralladora"};
		Salud = 170;
		this.x = cordX;
		this.y = cordY;
		this.coste =90;
		
	}

	@Override
	public int explotar() {
		//Da�o en area cuando muere(?)
		// TODO Auto-generated method stub
		return 0;
	}

}
