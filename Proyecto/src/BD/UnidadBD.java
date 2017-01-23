package BD;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import BD.UnidadBD;
import Ventanas.Colision;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Clase principal de la que descienden todos los elementos del tablero
 * @author Xabier
 *
 */
public class UnidadBD implements Cloneable{
	protected String Nombre;
	protected String[] armas= new String[5]; 
	protected String arma;
	protected int Salud;
	protected Image image;
	protected int x;
	protected int y;
	protected int coste; //Coste de crear el soldado
	protected int Distancia; //Puntos de movimiento
	protected String Partida; //Nombre
	protected int equipo; //1 o 0
	protected int acciones=2;

//Getters y setters

	public int getAcciones() {
		return acciones;
	}


	public void setAcciones(int acciones) {
		this.acciones = acciones;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getCoste() {
		return coste;
	}


	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	/**
	 * Comprueba si la unidad objetivo ha muerto, y le añade cinco puntos al marcador
	 */

	public void comprobarMuerto(){
		if(Ventanas.Partida.getUnidadObjetivo().getSalud()<=0){
		UnidadBD[][] a=Ventanas.Partida.tablero;
		a[Ventanas.Partida.getUnidadObjetivo().getCordX()][Ventanas.Partida.getUnidadObjetivo().getCordY()]=null;
		Ventanas.Partida.setTablero(a);
		if(Ventanas.Partida.getPartida().getTurno()==0)
		Ventanas.Partida.getPartida().setPuntuacionAliado(Ventanas.Partida.getPartida().getPuntuacionAliado()+5);
		else if(Ventanas.Partida.getPartida().getTurno()==1)
		Ventanas.Partida.getPartida().setPuntuacionAliado(Ventanas.Partida.getPartida().getPuntuacionEnemigo()+5);
		}
	}
	/**
	 * 
	 * Ataca a la unidad objetivo
	 * si esta fuera del alcance salta error
	 * @param x coordenada x del objetivo
	 * @param y coordenada y del objetivo
	 */
	public void ataca(int x,int y){
		if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<x){
			if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<x){
		Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-y);}else{ 
			JFrame frame=new JFrame();
		Object[] options = {"OK"};
	    int n = JOptionPane.showOptionDialog(frame,
                "El objetivo esta fuera del alcance ","Cuidado",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
	   Ventanas.Partida.getUnidadActual().setAcciones(Ventanas.Partida.getUnidadActual().getAcciones()+1);}
		comprobarMuerto();
		}else{ 
		JFrame frame=new JFrame();
		Object[] options = {"OK"};
	    int n = JOptionPane.showOptionDialog(frame,
                "El objetivo esta fuera del alcance","Cuidado",
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);}
	}
	
	/**
	 * Metodo de mover basico
	 * @param x coordenada x del objetivo
	 * @param y coordenada y del objetivo
	 */
	public void Mover(int x,int y) {
	
		UnidadBD u=this;
		
		UnidadBD[][] aux=Ventanas.Partida.getTablero();
		if(aux[x][y]==null){
		aux[x][y]=u;
		aux[u.getCordX()][u.getCordY()]=null; 
		u.setCordX(x);
		u.setCordY(y);
		
		Ventanas.Partida.setTablero(aux);
		}else{int input = JOptionPane.showOptionDialog(null, "Elija otra posicion valida", "Aviso", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		
		if(input == JOptionPane.OK_OPTION)
		{JOptionPane.getRootFrame().repaint();;}
			
		  
		}
			//TODO que salte una ventana de que no puede, o una alerta de sonido
		
			

	}
	/**
	 * 
	 * @param Movimientos Cuantos movimientos de casilla tiene disponible la unidad
	 * @param x Coordenada x de donde esta el objeto(para la recursividad al mover el objeto)
	 * @param y Coordenada y de donde esta el objeto(para la recursividad al mover el objeto)
	 * @param xdest x destino a donde se quiere mover
	 * @param ydest y destino a donde se quiere mover
	 * @param Aux array que se pasa por parametro para no interferir en el tablero en las sucesivas llamadas recursivas
	 * 
	 * 
	 */


public UnidadBD[][] AlgoritmoPathfinding(int Movimientos,int x,int y,int xdest,int ydest, UnidadBD[][] Aux){
	if(Aux[xdest][ydest] instanceof Colision){return null;}
	UnidadBD[][] aAux=Aux;
	ArrayList<Point> ap=comprobar(aAux, x, y);
	for(Point p:ap){

	if(Movimientos==0){
		//
		if(xdest==x && ydest==y){
			aAux[xdest][ydest]=this;
		aAux[this.getCordX()][this.getCordY()]=null;
		this.setCordX(xdest);this.setCordY(ydest);
		this.setAcciones(this.getAcciones()-1);
		limpiarColisiones(aAux);return aAux;}
		
		else{return Ventanas.Partida.getTablero();}
	}

	else{

		if((int)p.getX()==xdest && (int)p.getY()==ydest){
			aAux[xdest][ydest]=this;
			aAux[x][y]=null;
			this.setCordX(xdest);
			this.setCordY(ydest);
			this.setAcciones(this.getAcciones()-1);
			limpiarColisiones(aAux);
			return aAux;}
		

		else if(((int)p.getX()!=xdest || (int)p.getY()!=ydest)){

			if(aAux[x][y]==null)
			aAux[x][y]=new Colision(1);

			aAux=AlgoritmoPathfinding(Movimientos-1,(int)p.getX(),(int)p.getY(),xdest,ydest,aAux);

		}

				
				

		
		}
	}
	
	limpiarColisiones(aAux);
	
	return aAux;//FIXME en la parte donde se implemente Ventanas.Partida.setTablero(aAux);

}
/**
 * Metodo que comprueba si las coordenadas de los puntos cardinales estan libre de obstaculos
 * @param a array de closiones
 * @param x coordenada centro
 * @param y coordenada centro
 * @return array de puntos posibles sin obstaculos
 */
		public ArrayList<Point> comprobar(UnidadBD[][] a,int x,int y){
			
			ArrayList<Point> array=new ArrayList<Point>();
			try{
			if(a[x+1][y]==null){array.add(new Point(x+1,y));}}catch(ArrayIndexOutOfBoundsException e){}
			try{
			if(a[x-1][y]==null){array.add(new Point(x-1,y));}}catch(ArrayIndexOutOfBoundsException e){}
			try{
			if(a[x][y+1]==null){array.add(new Point(x,y+1));}}catch(ArrayIndexOutOfBoundsException e){}
			try{
			if(a[x][y-1]==null){array.add(new Point(x,y-1));}}catch(ArrayIndexOutOfBoundsException e){}
			return array;
		}
/**
 * Metodo que limpia las colisiones puestas por el aloritmo de pathfinding
 * @param a array que representa el tablero
 */
public void limpiarColisiones(UnidadBD[][] a){
	for(int i=0;i<a.length;i++){
		for(int j=0;j<a[0].length;j++){
			if(a[i][j] instanceof Colision && ((Colision) a[i][j]).getTipo()==1){
				a[i][j]=null;
				
			}
		}
	}
	
	
}

	public void CambiarArma(String arma) {
		this.setArma(arma);
		
	}
	public void atacar(int x,int y) {
		
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}

	public String getArma() {
		return arma;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String[] getArmas() {
		return armas;
	}


	public void setArmas(String[] armas) {
		this.armas = armas;
	}


	public int getSalud() {
		return Salud;
	}


	public void setSalud(int salud) {
		Salud = salud;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getCordX() {
		return x;
	}


	public void setCordX(int cordX) {
		this.x = cordX;
	}


	public int getCordY() {
		return y;
	}


	public void setCordY(int cordY) {
		this.y = cordY;
	}

	public String getPartida() {
		return Partida;
	}

	public void setPartida(String partida) {
		Partida = partida;
	}
	
	public int getDistancia() {
		return Distancia;
	}


	public void setDistancia(int distancia) {
		distancia = Distancia;
	}


}
