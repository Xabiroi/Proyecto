package BD;

import static org.junit.Assert.*;

import org.junit.Test;

import UnidadesAmigas.SoldadoRaso;

public class UnidadBDTest {

	@Test
	public void test() {
		SoldadoRaso u=new SoldadoRaso(0,0);
		u.setNombre("Soldado");
		UnidadBD[][] tabla=Ventanas.Partida.crearTablero();
		tabla[0][0]=u;
		tabla=u.AlgoritmoPathfinding(u.getDistancia(), 0, 0, 2, 2, tabla);
		assertEquals(tabla[2][2].getNombre(),"Soldado");
	}
	@Test
	public void test1() {
		SoldadoRaso u=new SoldadoRaso(0,0);
		u.setNombre("Soldado");
		UnidadBD[][] tabla=Ventanas.Partida.crearTablero();
		tabla[0][0]=u;
		tabla=u.AlgoritmoPathfinding(u.getDistancia(), 0, 0, 6, 6, tabla);
		try{
		assertEquals(tabla[6][6].getNombre(),null);}catch(NullPointerException e){}
		assertEquals(tabla[0][0].getNombre(),"Soldado");
	}
	@Test
	public void test2() {
		SoldadoRaso u=new SoldadoRaso(0,0);
		u.setNombre("Soldado");
		UnidadBD[][] tabla=Ventanas.Partida.crearTablero();
		tabla[0][0]=u;
		tabla=u.AlgoritmoPathfinding(u.getDistancia(), 0, 0, 2, 3, tabla);
		assertEquals(tabla[2][3].getNombre(),"Soldado");
	}
	//Desaparicion de unidades
	@Test
	public void test3() {
		SoldadoRaso u=new SoldadoRaso(31,1);
		u.setNombre("Soldado");
		UnidadBD[][] tabla=Ventanas.Partida.crearTablero();
		tabla[31][1]=u;
		tabla=u.AlgoritmoPathfinding(u.getDistancia(), 31, 2, 31, 1, tabla);
		assertEquals(tabla[31][1].getNombre(),"Soldado");
	}

}
