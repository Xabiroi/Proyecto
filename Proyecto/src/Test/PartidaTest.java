package Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import UnidadesAmigas.Spawn;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.TanqueEnemigo;
import Ventanas.Partida;
/**
 * Teste del metodo atacar
 * @author Xabier
 *
 */
public class PartidaTest {
	//Deberia de ser atacados los objetivos
	@Test
	public void ataque() throws IOException{


		Spawn se=new Spawn(1,1);
		TanqueEnemigo te=new TanqueEnemigo(1,2);
		Partida.getTablero()[1][1]=se;
		Partida.getTablero()[1][2]=te;
		Partida.UnidadActual=te;
		Partida.UnidadObjetivo=se;
		assertEquals(se.getSalud(),100);
		te.atacar(1, 1);
		assertEquals(se.getSalud(),85);
		

		Spawn s=new Spawn(0,0);
		SoldadoRasoEnemigo sre=new SoldadoRasoEnemigo(0,1);
		Partida.getTablero()[0][0]=s;
		Partida.getTablero()[0][1]=sre;
		Partida.UnidadActual=sre;
		Partida.UnidadObjetivo=se;
		sre.atacar(0, 0);
		assertEquals(se.getSalud(),75);
		
	}
	//El objetivo deberia estar fuera de alcance
	@Test
	public void ataque2() throws IOException{


		Spawn se=new Spawn(1,1);
		TanqueEnemigo te=new TanqueEnemigo(20,20);
		Partida.getTablero()[1][1]=se;
		Partida.getTablero()[20][20]=te;
		Partida.UnidadActual=te;
		Partida.UnidadObjetivo=se;
		te.atacar(1, 1);
		assertEquals(se.getSalud(),100);


		
		
	}
	
}
