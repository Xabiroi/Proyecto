package Ventanas;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import LogicaBatallas.ElementosPartida;
import LogicaBatallas.LogicaPartida;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Spawn;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.SpawnEnemigo;
import UnidadesEnemigas.TanqueEnemigo;

public class PartidaTest {

	@Before
	public void Preparar() {

	}

	@Test
	public void ataque() throws IOException{

		
		//SoldadoRaso sr=new SoldadoRaso(0,0);
		//SpawnEnemigo se=new SpawnEnemigo(0,31);
		Spawn se=new Spawn(1,1);
		TanqueEnemigo te=new TanqueEnemigo(1,2);
		Partida.getTablero()[1][1]=se;
		Partida.getTablero()[1][2]=te;
		Partida.UnidadActual=te;
		Partida.UnidadObjetivo=se;
		System.out.println("Antes del ataque:");
		System.out.println("Spawn:"+se.getSalud());
		System.out.println("Tanque:"+te.getSalud());
		System.out.println("------------");
		te.atacar(1, 1);
		System.out.println("Despues del ataque:");
		System.out.println("Spawn:"+se.getSalud());
		System.out.println("Tanque:"+te.getSalud());
		System.out.println("------------");
		

		Spawn s=new Spawn(0,0);
		SoldadoRasoEnemigo sre=new SoldadoRasoEnemigo(0,1);
		Partida.getTablero()[0][0]=s;
		Partida.getTablero()[0][1]=sre;
		Partida.UnidadActual=sre;
		Partida.UnidadObjetivo=se;
		System.out.println("Antes del ataque:");
		System.out.println("Spawn:"+se.getSalud());
		System.out.println("Soldado:"+sre.getSalud());
		System.out.println("------------");
		sre.atacar(0, 0);
		System.out.println("Despues del ataque:");
		System.out.println("Spawn:"+se.getSalud());
		System.out.println("Soldado:"+sre.getSalud());
		System.out.println("------------");
		
		
	}
	
}
