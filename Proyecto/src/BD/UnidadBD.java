package BD;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import BD.UnidadBD;
import Ventanas.Colision;

import javax.swing.JOptionPane;

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


	public void Mover(int x,int y) {
		
		/**Mover básico que se cambiara por un algoritmo de pathfinding mas complicado en caso de tener tiempo, sino--->
		 * Comprobar que 
		 * 
		 * Obtener coordenadas de donde esta y a donde se clicka con el mouse
		 * El movimiento estara limitado dependiendo de la unidad, permitiendo solo mover una cantidad de x y de y
		 * Habria que ajustar el hitbox dependiendo de las dimensiones de las imagenes de los soldados y reajustar los calculos de movimiento en base a las coordenadas
		 * 
		 * 
		 * 
		 */
		
		UnidadBD u=this;
		
		UnidadBD[][] aux=Ventanas.Partida.getTablero();
		if(aux[x][y]==null){
		aux[u.getCordX()][u.getCordY()]=null; 
		u.setCordX(x);
		u.setCordY(y);
		aux[x][y]=u;
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
//Si el algoritmo devuelve null abrir una ventana de error
public UnidadBD[][] AlgoritmoPathfinding(int Movimientos,int x,int y,int xdest,int ydest, UnidadBD[][] Aux){
	if(Aux[xdest][ydest] instanceof Colision){return null;}
	UnidadBD[][] aAux=Aux;
	ArrayList<Point> ap=comprobar(aAux, x, y);
	for(Point p:ap){

	if(Movimientos==0){
		//
		if(this.getCordX()==x && this.getCordY()==y){this.Mover(x, y);limpiarColisiones(aAux);return aAux;}
	}
	else if(Math.abs(x-this.getCordX())>Movimientos || Math.abs(y-this.getCordY())>Movimientos){//TODO no se puede mover(una ventana)//Si devolviera null se pararia el aloritmo pero hay que comprobar si se para el FOR	
	}
	else if(Math.abs(x-this.getCordX())+Math.abs(y-this.getCordY())>Movimientos){//TODO no se puede mover(una ventana o algo)		
	}
	
	else{

		if(p==null){return null;}
		//comprobar
		if(p.getX()==x &&p.getY()==y){this.Mover(x, y);limpiarColisiones(aAux);return aAux;}
		//sino colocar colision y avanzar//Al inicio colision tipo 1 para saber que es el inicio
		else if((p.getX()!=x ||p.getY()!=y)){

				aAux[(int) p.getX()][(int) p.getY()]=aAux[x][y];
			
			aAux[x][y]=new Colision(1);
			//aAux[][]=;
			AlgoritmoPathfinding(Movimientos-1,(int)p.getX(),(int)p.getY(),xdest,ydest,aAux);

		}

				
				

		
		}
	}
	
	limpiarColisiones(aAux);
	return aAux;//FIXME en la parte donde se implemente Ventanas.Partida.setTablero(aAux);

}


/*
 *Se podria optimizar para priorizar los puntos que esten mas cerca con un algoritmo de ordenacion en cuanto a proximidad 
 * 
 * 
 */
		public ArrayList<Point> comprobar(UnidadBD[][] a,int x,int y){
			
			ArrayList<Point> array=new ArrayList<Point>();
			try{
			if(a[x+1][y]==null){array.add(new Point(x+1,y));}
			if(a[x-1][y]==null){array.add(new Point(x-1,y));}
			if(a[x][y+1]==null){array.add(new Point(x,y+1));}
			if(a[x][y-1]==null){array.add(new Point(x,y-1));}
			}catch(NullPointerException e){return null;}
			return array;
		}
//FIXME cambiar todavia el metodo (No tocar)
public void limpiarColisiones(UnidadBD[][] a){
	for(int i=0;i<a.length;i++){
		for(int j=0;j<a[0].length;j++){
			if(a[i][j] instanceof Colision && ((Colision) a[i][j]).getTipo()==1){
				a[i][j]=null;
				
			}
		}
	}
	
	
}
	
/**
 * Parte de ventanas:
 * -Mostrar la lista de armas
 * -Elegir una
 * -Pasar por parametro el string
 * -Cambiar arma
 * 
 */
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
