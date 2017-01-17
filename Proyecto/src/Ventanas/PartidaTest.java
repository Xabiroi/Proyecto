package Ventanas;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import LogicaBatallas.ElementosPartida;
import LogicaBatallas.LogicaPartida;
import UnidadesAmigas.SoldadoRaso;
import UnidadesEnemigas.TanqueEnemigo;

public class PartidaTest {

	@Before
	public void Preparar() {

	}

	@Test
	public void ataque() throws IOException{
		Partida p=new Partida(new ElementosPartida(), new LogicaPartida());
		SoldadoRaso sr=new SoldadoRaso(0,0);
		TanqueEnemigo te=new TanqueEnemigo(0,1);
		Partida.getTablero()[0][0]=sr;
		Partida.getTablero()[0][1]=te;
		Partida.UnidadActual=sr;
		Partida.UnidadObjetivo=te;
		System.out.println("Antes del ataque:");
		System.out.println("Soldado:"+sr.getSalud());
		System.out.println("Tanque:"+te.getSalud());
		System.out.println("------------");
		sr.atacar(0, 1);
		System.out.println("Despues del ataque:");
		System.out.println("Soldado:"+sr.getSalud());
		System.out.println("Tanque:"+te.getSalud());
		System.out.println("------------");
		
		
	}
	
}
