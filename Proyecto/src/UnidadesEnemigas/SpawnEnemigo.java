package UnidadesEnemigas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import BD.UnidadBD;
import LogicaBatallas.ArraysPartida;
import LogicaBatallas.ElementosPartida;

public class SpawnEnemigo extends UnidadEnemiga{
	public SpawnEnemigo(int x, int y){
		Nombre="Spawn";
		Salud = 100;
		this.x = x;
		this.y = y;
	}


public UnidadBD[][] CrearSoldadoRasoEnemigo(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=35){SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(0,30);a[0][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=35){SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(1,30);a[1][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=35){SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(2,30);a[2][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=35){SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(3,30);a[3][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=35){SoldadoRasoEnemigo s=new SoldadoRasoEnemigo(3,31);a[3][31]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-35);return a;}
	
	else{JFrame frame=new JFrame();
	Object[] options = {"OK"};
    int n = JOptionPane.showOptionDialog(frame,
            "No se puede crear la unidad","Cuidado",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);}

		return a;}

public UnidadBD[][] CrearBazookaEnemigo(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){BazookaEnemigo s=new BazookaEnemigo(0,30);a[0][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){BazookaEnemigo s=new BazookaEnemigo(1,30);a[1][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){BazookaEnemigo s=new BazookaEnemigo(2,30);a[2][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){BazookaEnemigo s=new BazookaEnemigo(3,30);a[3][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){BazookaEnemigo s=new BazookaEnemigo(3,31);a[3][31]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	
	else{JFrame frame=new JFrame();
	Object[] options = {"OK"};
    int n = JOptionPane.showOptionDialog(frame,
            "No se puede crear la unidad","Cuidado",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);}

		return a;}
public UnidadBD[][] CrearFrancotiradorEnemigo(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=50){FrancotiradorEnemigo s=new FrancotiradorEnemigo(0,30);a[0][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=50){FrancotiradorEnemigo s=new FrancotiradorEnemigo(1,30);a[1][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=50){FrancotiradorEnemigo s=new FrancotiradorEnemigo(2,30);a[2][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=50){FrancotiradorEnemigo s=new FrancotiradorEnemigo(3,30);a[3][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=50){FrancotiradorEnemigo s=new FrancotiradorEnemigo(3,31);a[3][31]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-50);return a;}
	
	else{JFrame frame=new JFrame();
	Object[] options = {"OK"};
    int n = JOptionPane.showOptionDialog(frame,
            "No se puede crear la unidad","Cuidado",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);}

		return a;}
public UnidadBD[][] CrearTanqueEnemigo(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=90){TanqueEnemigo s=new TanqueEnemigo(0,30);a[0][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=90){TanqueEnemigo s=new TanqueEnemigo(1,30);a[1][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=90){TanqueEnemigo s=new TanqueEnemigo(2,30);a[2][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=90){TanqueEnemigo s=new TanqueEnemigo(3,30);a[3][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=90){TanqueEnemigo s=new TanqueEnemigo(3,31);a[3][31]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-90);return a;}
	
	else{JFrame frame=new JFrame();
	Object[] options = {"OK"};
    int n = JOptionPane.showOptionDialog(frame,
            "No se puede crear la unidad","Cuidado",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);}

		return a;}
public UnidadBD[][] CrearSemiorugaEnemigo(ElementosPartida ep,ArraysPartida a1){
	UnidadBD[][] a=Ventanas.Partida.getTablero();
	if(a[31][1]==null && ep.getDineroAliado()>=70){SemiorugaEnemigo s=new SemiorugaEnemigo(0,30);a[0][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[30][1]==null && ep.getDineroAliado()>=70){SemiorugaEnemigo s=new SemiorugaEnemigo(1,30);a[1][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[29][1]==null && ep.getDineroAliado()>=70){SemiorugaEnemigo s=new SemiorugaEnemigo(2,30);a[2][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[28][1]==null && ep.getDineroAliado()>=70){SemiorugaEnemigo s=new SemiorugaEnemigo(3,30);a[3][30]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	else if(a[28][0]==null && ep.getDineroAliado()>=70){SemiorugaEnemigo s=new SemiorugaEnemigo(3,31);a[3][31]=s;s.setPartida(ep.getPartida());a1.getListaEnemigos().add(s);Ventanas.Partida.getPartida().setDineroAliado(Ventanas.Partida.getPartida().getDineroAliado()-70);return a;}
	
	else{JFrame frame=new JFrame();
	Object[] options = {"OK"};
    int n = JOptionPane.showOptionDialog(frame,
            "No se puede crear la unidad","Cuidado",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);}

		return a;}


}
