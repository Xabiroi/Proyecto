package UnidadesEnemigas;

import javax.swing.JOptionPane;

import BD.UnidadBD;
import LogicaBatallas.ElementosPartida;

public class SpawnEnemigo {
	/*
r0,c30 true true
r1,c30 true true
r2,c30 true true
r3,c30 true true
r3,c31 true true
	 * 
	 */

public UnidadBD[][] CrearSoldadoRasoEnemigo(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[0][30]==null && ep.getDineroEnemigo()>=35){a[0][1]=new SoldadoRasoEnemigo(0,30);return a;}
	else if(a[1][30]==null && ep.getDineroEnemigo()>=35){a[1][1]=new SoldadoRasoEnemigo(1,30);return a;}
	else if(a[2][30]==null && ep.getDineroEnemigo()>=35){a[2][1]=new SoldadoRasoEnemigo(2,30);return a;}
	else if(a[3][30]==null && ep.getDineroEnemigo()>=35){a[3][1]=new SoldadoRasoEnemigo(3,30);return a;}
	else if(a[3][31]==null && ep.getDineroEnemigo()>=35){a[3][0]=new SoldadoRasoEnemigo(3,31);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearBazookaEnemigo(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[0][30]==null && ep.getDineroEnemigo()>=50){a[0][30]=new BazookaEnemigo(0,30);return a;}
	else if(a[1][30]==null && ep.getDineroEnemigo()>=50){a[1][30]=new BazookaEnemigo(1,30);return a;}
	else if(a[2][30]==null && ep.getDineroEnemigo()>=50){a[2][30]=new BazookaEnemigo(2,30);return a;}
	else if(a[3][30]==null && ep.getDineroEnemigo()>=50){a[3][30]=new BazookaEnemigo(3,30);return a;}
	else if(a[3][31]==null && ep.getDineroEnemigo()>=50){a[3][31]=new BazookaEnemigo(3,31);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearFrancotiradorEnemigo(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[0][30]==null && ep.getDineroEnemigo()>=50){a[0][30]=new FrancotiradorEnemigo(0,30);return a;}
	else if(a[1][30]==null && ep.getDineroEnemigo()>=50){a[1][30]=new FrancotiradorEnemigo(1,30);return a;}
	else if(a[2][30]==null && ep.getDineroEnemigo()>=50){a[2][30]=new FrancotiradorEnemigo(2,30);return a;}
	else if(a[3][30]==null && ep.getDineroEnemigo()>=50){a[3][30]=new FrancotiradorEnemigo(3,30);return a;}
	else if(a[3][31]==null && ep.getDineroEnemigo()>=50){a[3][31]=new FrancotiradorEnemigo(3,31);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearTanqueEnemigo(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[0][30]==null && ep.getDineroEnemigo()>=90){a[0][30]=new TanqueEnemigo(0,30);return a;}
	else if(a[1][30]==null && ep.getDineroEnemigo()>=90){a[1][30]=new TanqueEnemigo(1,30);return a;}
	else if(a[2][30]==null && ep.getDineroEnemigo()>=90){a[2][30]=new TanqueEnemigo(2,30);return a;}
	else if(a[3][30]==null && ep.getDineroEnemigo()>=90){a[3][30]=new TanqueEnemigo(3,30);return a;}
	else if(a[3][31]==null && ep.getDineroEnemigo()>=90){a[3][31]=new TanqueEnemigo(3,31);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}
public UnidadBD[][] CrearSemiorugaEnemigo(ElementosPartida ep){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[0][30]==null && ep.getDineroEnemigo()>=70){a[0][30]=new SemiorugaEnemigo(0,30);return a;}
	else if(a[1][30]==null && ep.getDineroEnemigo()>=70){a[1][30]=new SemiorugaEnemigo(1,30);return a;}
	else if(a[2][30]==null && ep.getDineroEnemigo()>=70){a[2][30]=new SemiorugaEnemigo(2,30);return a;}
	else if(a[3][30]==null && ep.getDineroEnemigo()>=70){a[3][30]=new SemiorugaEnemigo(3,30);return a;}
	else if(a[3][31]==null && ep.getDineroEnemigo()>=70){a[3][31]=new SemiorugaEnemigo(3,31);return a;}
	
	else{ int input = JOptionPane.showOptionDialog(null, "No se puede crear la unidad, despeje la zona", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

	if(input == JOptionPane.OK_OPTION)
	{}
		
		
		return a;}
}



}
