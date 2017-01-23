package Ventanas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import BD.BD;
import BD.UnidadBD;
import UnidadesAmigas.Bazooka;
import UnidadesAmigas.Francotirador;
import UnidadesAmigas.Semioruga;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Tanque;
import UnidadesAmigas.UnidadAliada;
//Tests que prueban diferentes funciones
public class MenuMultijugadorTest {

	@Test
	public void test() {
		 ArrayList<LogicaBatallas.ElementosPartida> a=BD.PartidaSelect( BD.usarBD(BD.initBD("Local")),"");
		assertEquals(6,a.size());//El valor 6 aqui sera diferente dependiendo de las partidas que haya actualmente
		
		ArrayList<UnidadBD> Unidades=BD.UnidadBDSelect(BD.usarBD(BD.initBD("Local")), "Partida='avsb'");
		assertEquals(14,Unidades.size());
	}
	@Test
	public void test1() {
		
		ArrayList<UnidadBD> UnidadesAliadas1=new ArrayList<UnidadBD>();
		UnidadBD a=new UnidadBD();
		UnidadBD b1=new UnidadBD();
		a.setNombre("Soldado");
		b1.setNombre("Francotirador");

		UnidadesAliadas1.add(a);
		UnidadesAliadas1.add(b1);
		ArrayList<UnidadAliada> UnidadesAliadas=new ArrayList<UnidadAliada>();
	for(UnidadBD u:UnidadesAliadas1){
		String nombre=null;
		nombre=u.getNombre();
		switch(nombre){
		case "Soldado":SoldadoRaso s=new SoldadoRaso(u.getCordX(),u.getCordY());
		s.setArma(u.getArma());
		s.setArmas(u.getArmas());
		s.setSalud(u.getSalud());
		s.setEquipo(u.getEquipo());
		s.setAcciones(u.getAcciones());
		UnidadesAliadas.add(s);
		break;
		case "Bazooka":Bazooka b=new Bazooka(u.getCordX(),u.getCordY());
		b.setArma(u.getArma());
		b.setArmas(u.getArmas());
		b.setSalud(u.getSalud());
		b.setEquipo(u.getEquipo());
		b.setAcciones(u.getAcciones());
		UnidadesAliadas.add(b);
		break;
		case "Francotirador":Francotirador f=new Francotirador(u.getCordX(),u.getCordY());
		f.setArma(u.getArma());
		f.setArmas(u.getArmas());
		f.setSalud(u.getSalud());
		f.setEquipo(u.getEquipo());
		f.setAcciones(u.getAcciones());
		UnidadesAliadas.add(f);
		break;
		case "Tanque":Tanque t=new Tanque(u.getCordX(),u.getCordY());
		t.setArma(u.getArma());
		t.setArmas(u.getArmas());
		t.setSalud(u.getSalud());
		t.setEquipo(u.getEquipo());
		t.setAcciones(u.getAcciones());
		UnidadesAliadas.add(t);
		break;
		case "Semioruga":Semioruga se=new Semioruga(u.getCordX(),u.getCordY());
		se.setArma(u.getArma());
		se.setArmas(u.getArmas());
		se.setSalud(u.getSalud());
		se.setEquipo(u.getEquipo());
		se.setAcciones(u.getAcciones());
		UnidadesAliadas.add(se);
		break;
		default:break;

		}
	}
	assertEquals(UnidadesAliadas.size(),2);
	assertEquals(UnidadesAliadas.get(0).getNombre(),"Soldado");
	}
	
	
	
	
	
	
	
	
	
	
}
