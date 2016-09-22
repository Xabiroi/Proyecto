package UnidadesEnemigas;


import Interfaces.Vehiculo;

public class TanqueEnemigo extends UnidadEnemiga implements Vehiculo{
	public TanqueEnemigo(int cordX, int cordY) {
		super();
		//Un set image aqui(?)
		Nombre="Tanque";
		arma="Misil";
		this.armas= new String[] {"Misil", "Ametralladora"};
		Salud = 170;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}

	@Override
	public int explotar() {
		//Daño en area cuando muere(?)
		// TODO Auto-generated method stub
		return 0;
	}

}
