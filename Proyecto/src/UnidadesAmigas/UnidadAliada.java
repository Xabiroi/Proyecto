package UnidadesAmigas;

import java.awt.Image;
import java.awt.Point;

import java.util.ArrayList;

import LogicaBatallas.LogicaPartida;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.UnidadEnemiga;

public class UnidadAliada {
	protected String Nombre;
	protected String[] armas= new String[5]; 
	protected String arma;
	protected ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();
	protected int Salud;
	protected Image image;
	protected int cordX;
	protected int cordY;
	
	
	
	//Getters y setters
///////////////////////////////////////////////
	
	
	
	
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


	public ArrayList<UnidadEnemiga> getEnemigos() {
		return enemigos;
	}


	public void setEnemigos(ArrayList<UnidadEnemiga> enemigos) {
		this.enemigos = enemigos;
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
		return cordX;
	}


	public void setCordX(int cordX) {
		this.cordX = cordX;
	}


	public int getCordY() {
		return cordY;
	}


	public void setCordY(int cordY) {
		this.cordY = cordY;
	}


	
	///////////////////////////////////////////
	
	public void Nombre(){
		
		
		
	}
	
	

	public void Objetivos() {
		

		
		
		for(UnidadEnemiga ue:LogicaPartida.getListaEnemigos()){
			/**
			 * Cada vez que vaya a atacar, se enumeran los enemigos al alcance, y a continuacion se muestran en una lista con sus puntos de salud
			 * A continuacion se procedera a restar puntos dependiendo del arma con la que se le haya atacado
			 * (Debilidades y multiplicadores de daño hay que aplicarlos mas tarde)
			 */
			
			
		///////////////////////////////////////////////////////////////
		//REAJUSTAR LAS COORDENADAS UNA VEZ HECHO EL MAPA DONDE SE JUEGA
		///////////////////////////////////////////////////////////////
			/**
			 * Lista de armas del campo de batalla con sus respectivos rangos
			 * Fusil:
			 * Pistola
			 * Rifle de francotirador
			 * Bazooka
			 * Misil tanque
			 * Ametralladora ligera
			 * CCC (melee)
			 * 
			 * 
			 */
			
			int x1=this.getCordX();
			int y1=this.getCordY();
			//Coordenadas del soldado aliado
			
			if(this.getArma().equals("Fusil")){
			
			
				
				//Si la distancia a la que esta el otro soldado es menor que la del alcance, se añade a la lista de enemigos
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Pistola")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("Rifle")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Bazooka")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Misil")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Ametralladora")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("CCC")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			
		
			
			
		}

		
		
		
		
	}
	
	
	
	
	public void atacar(Point P){
		
		for(UnidadEnemiga ue:LogicaPartida.getListaEnemigos()){
			if(P.getX()==ue.getCordX()&&P.getY()==ue.getCordY()){
				
				if(ue instanceof SoldadoRasoEnemigo){//Hay que crear las mismas clases de soldadorasoenemigo y asi en otra clase
					
				
				
				if(this.getArma().equals("Fusil")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				if(this.getArma().equals("Rifle")){
					ue.setSalud(ue.getSalud()-70);
					
					
					
				}
				if(this.getArma().equals("Pistola")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				if(this.getArma().equals("Bazooka")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				if(this.getArma().equals("Misil")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				if(this.getArma().equals("Ametralladora")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				if(this.getArma().equals("CCC")){
					ue.setSalud(ue.getSalud()-40);
					
					
					
				}
				
				
				}
				
				
				
				
				
				//////////////////
			}
			
		}
	////////////////	
		
		
		
		
		
	}
	
	
	
	
	
	
	

	public boolean Mover(Point P) {
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
		//Se obtienen coordenadas de la actual posicion
		int x=this.getCordX();
		int y=this.getCordY();
		
		//Se clicka en la posicion donde se quiere mover
		
		
		/*
	    public void mousePressed(MouseEvent e)
	      {
	        this.Puntoclickado = e.getPoint();
	      }
	      
		*/
		
		//Se restan para saber si el moviemiento esta permitidio o no
		
		
		
			//Este punto p sera creado al clickar en un sitio en el mapa
		
		
		/**
		 * 
		 * 
		 * PROVISIONAL
		 */
		
	
			int x1=(int) P.getX();
			int y1=(int) P.getY();
			if(x1-x<100){
				if(y1-y<100){
					for(UnidadEnemiga ue:LogicaPartida.getListaEnemigos()){
						if(this.getCordX()==ue.getCordX() && this.getCordY()==ue.getCordY()){
							
							/**
							 * Panel auxiliar de mensajes ingame (estaria bien)
							 * Aqui iria el mensaje de que no se puede mover a tal sitio
							 * 
							 * Devolveria falso si las coordenadas coincidieran
							 */
							return false;
						}
						
					}
					for(UnidadAliada ua:LogicaPartida.getListaAliados()){
						if(this.getCordX()==ua.getCordX() && this.getCordY()==ua.getCordY()){
							
							/**
							 * 
							 * Aqui iria el mensaje de que no se puede mover a tal sitio
							 * 
							 * Devolveria falso si las coordenadas coincidieran
							 */
							return false;
						}
						
					}
					
					//las coordenadas se devuelven al comprobar que no hay ningun objeto en ese lugar
					this.setCordX(x1);this.setCordY(y1);//Movimiento de la unidad con su respectivo cambio de coordenadas
					return true;
				}	
			}
			return false;
		
		
		
		
		
		
		
		
		
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
}
