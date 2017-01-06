package UnidadesAmigas;

import javax.swing.JOptionPane;

import BD.UnidadBD;
import LogicaBatallas.ElementosPartida;

public class Spawn extends UnidadBD{
public Spawn(){
}
public UnidadBD[][] CrearSoldadoRaso(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=35){a[31][1]=new SoldadoRaso(31,1);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=35){a[30][1]=new SoldadoRaso(30,1);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=35){a[29][1]=new SoldadoRaso(29,1);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=35){a[28][1]=new SoldadoRaso(28,1);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=35){a[28][0]=new SoldadoRaso(28,0);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearBazooka(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){a[31][1]=new Bazooka(31,1);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){a[30][1]=new Bazooka(30,1);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){a[29][1]=new Bazooka(29,1);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){a[28][1]=new Bazooka(28,1);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){a[28][0]=new Bazooka(28,0);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearFrancotirador(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){a[31][1]=new Francotirador(31,1);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){a[30][1]=new Francotirador(30,1);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){a[29][1]=new Francotirador(29,1);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){a[28][1]=new Francotirador(28,1);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){a[28][0]=new Francotirador(28,0);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearTanque(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=90){a[31][1]=new Tanque(31,1);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=90){a[30][1]=new Tanque(30,1);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=90){a[29][1]=new Tanque(29,1);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=90){a[28][1]=new Tanque(28,1);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=90){a[28][0]=new Tanque(28,0);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearSemioruga(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=70){a[31][1]=new Semioruga(31,1);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=70){a[30][1]=new Semioruga(30,1);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=70){a[29][1]=new Semioruga(29,1);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=70){a[28][1]=new Semioruga(28,1);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=70){a[28][0]=new Semioruga(28,0);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}








}
