package UnidadesAmigas;

import java.awt.Image;
import java.util.ArrayList;

import LogicaBatallas.LogicaPartida;
import UnidadesEnemigas.UnidadEnemiga;

public class UnidadAliada {
	
	protected String[] armas= new String[5]; 
	protected String arma;
	protected ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();
	protected int Salud=0;
	protected Image image;
	protected int cordX;
	protected int cordY;
	
	
	//Getters y setters
///////////////////////////////////////////////
	public String getArma() {
		return arma;
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
	
	
	
	

	public void Atacar() {
		

		
		
		for(UnidadEnemiga ue:LogicaPartida.getListaUnidadesEnemigas()){
			
			
			
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
			 * CQC (melee)
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
			
			else if(this.getArma().equals("CQC")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			
		////////////////////////////////////////
			
			
		}


		
		
		
	}


	public void Mover() {
		/**Mover básico que se cambiara por un algoritmo de pathfinding mas complicado en caso de tener tiempo, sino--->
		 * Comprobar que 
		 * 
		 * Obtener coordenadas de donde esta y a donde se clicka con el mouse
		 * El movimiento estara limitado dependiendo de la unidad, permitiendo solo mover una cantidad de x y de y
		 * 
		 * 
		 * 
		 * 
		 */
		
		int x=this.getCordX();
		int y=this.getCordY();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public void CambiarArma() {
		
		
	}
}
