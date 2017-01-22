package UnidadesAmigas;

import javax.swing.JOptionPane;

import BD.UnidadBD;
import LogicaBatallas.ArraysPartida;
import LogicaBatallas.ElementosPartida;

public class Spawn extends UnidadAliada{
public Spawn(int x, int y){
	Nombre="Spawn";
	Salud = 100;
	this.x = x;
	this.y = y;
}

public UnidadBD[][] CrearSoldadoRaso(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=35){SoldadoRaso s=new SoldadoRaso(31,1);s.setPartida(ep.getPartida());a[31][1]=s;a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=35){SoldadoRaso s=new SoldadoRaso(30,1);a[30][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=35){SoldadoRaso s=new SoldadoRaso(29,1);a[29][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=35){SoldadoRaso s=new SoldadoRaso(28,1);a[28][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=35){SoldadoRaso s=new SoldadoRaso(28,0);a[28][0]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearBazooka(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){Bazooka s=new Bazooka(31,1);a[31][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){Bazooka s=new Bazooka(30,1);a[30][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){Bazooka s=new Bazooka(29,1);a[29][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){Bazooka s=new Bazooka(28,1);a[28][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){Bazooka s=new Bazooka(28,0);a[28][0]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearFrancotirador(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){Francotirador s=new Francotirador(31,1);a[31][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){Francotirador s=new Francotirador(30,1);a[30][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){Francotirador s=new Francotirador(29,1);a[29][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){Francotirador s=new Francotirador(28,1);a[28][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){Francotirador s=new Francotirador(28,0);a[28][0]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearTanque(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=90){Tanque s=new Tanque(31,1);a[31][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=90){Tanque s=new Tanque(30,1);a[30][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=90){Tanque s=new Tanque(29,1);a[29][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=90){Tanque s=new Tanque(28,1);a[28][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=90){Tanque s=new Tanque(28,0);a[28][0]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearSemioruga(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=70){Semioruga s=new Semioruga(31,1);a[31][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=70){Semioruga s=new Semioruga(30,1);a[30][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=70){Semioruga s=new Semioruga(29,1);a[29][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=70){Semioruga s=new Semioruga(28,1);a[28][1]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=70){Semioruga s=new Semioruga(28,0);a[28][0]=s;s.setPartida(ep.getPartida());a1.getListaAliados().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}








}
