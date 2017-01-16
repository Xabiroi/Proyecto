package UnidadesEnemigas;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import LogicaBatallas.LogicaPartida;
import UnidadesAmigas.Bazooka;
import UnidadesAmigas.Francotirador;
import UnidadesAmigas.Semioruga;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Tanque;
import UnidadesAmigas.UnidadAliada;

public class UnidadEnemiga extends UnidadBD implements Unidad{
	protected ArrayList<UnidadAliada> enemigos=new ArrayList<UnidadAliada>();


	public UnidadEnemiga(){
		this.equipo=2;
		
	}
	
	
	
	
	//Getters y setters
///////////////////////////////////////////////
	
	


	public ArrayList<UnidadAliada> getEnemigos() {
		return enemigos;
	}


	public void setEnemigos(ArrayList<UnidadAliada> enemigos) {
		this.enemigos = enemigos;
	}


	
	///////////////////////////////////////////
	
	

	public void Objetivos() {
		

		
		
		for(UnidadAliada ua:LogicaPartida.getListaAliados()){
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
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Pistola")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("Rifle")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Bazooka")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Misil")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Ametralladora")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("CCC")){
				
				int x=ua.getCordX();
				int y=ua.getCordY();
				if(x1-x<100){
					if(y1-y<100){this.enemigos.add(ua);
					
					}	
				}
			
			}
			
			
		
			
			
		}

		
		
		
		
	}
	
	
	
	

	/**
	 * Metodo que dependiendo de que soldado se trate el que ataque
	 * variara en efectividad
	 * 
	 * 
	 * @param P punto donde se clicka para obtener el objetivo
	 */
	
	
	//FIXME poner un random de atacar o fallar para  que sea mas emocionante
	public void atacar(int x,int y){
		
		for(UnidadAliada ue:LogicaPartida.getListaAliados()){
			if(x==ue.getCordX()&&y==ue.getCordY()){
				
				if(ue instanceof SoldadoRaso){
					
				
				
				if(this.getArma().equals("Fusil")){
					ue.setSalud(ue.getSalud()-50);
					
					
					
				}
				if(this.getArma().equals("Rifle")){
					ue.setSalud(ue.getSalud()-70);
					
					
					
				}
				if(this.getArma().equals("Pistola")){
					ue.setSalud(ue.getSalud()-30);
					
					
					
				}
				if(this.getArma().equals("Bazooka")){
					ue.setSalud(ue.getSalud()-60);
					
					
					
				}
				if(this.getArma().equals("Misil")){
					ue.setSalud(ue.getSalud()-60);
					
					
					
				}
				if(this.getArma().equals("Ametralladora")){
					ue.setSalud(ue.getSalud()-80);
					
					
					
				}
				if(this.getArma().equals("CCC")){
					ue.setSalud(ue.getSalud()-30);
					
					
					
				}
				
				
				}
				if(ue instanceof Francotirador){
					
					
					
					if(this.getArma().equals("Fusil")){
						ue.setSalud(ue.getSalud()-70);
						
						
						
					}
					if(this.getArma().equals("Rifle")){
						ue.setSalud(ue.getSalud()-70);
						
						
						
					}
					if(this.getArma().equals("Pistola")){
						ue.setSalud(ue.getSalud()-40);
						
						
						
					}
					if(this.getArma().equals("Bazooka")){
						ue.setSalud(ue.getSalud()-60);
						
						
						
					}
					if(this.getArma().equals("Misil")){
						ue.setSalud(ue.getSalud()-760);
						
						
						
					}
					if(this.getArma().equals("Ametralladora")){
						ue.setSalud(ue.getSalud()-80);
						
						
						
					}
					if(this.getArma().equals("CCC")){
						ue.setSalud(ue.getSalud()-50);
						
						
						
					}
					
					
					}
				if(ue instanceof Bazooka){
					
					
					
					if(this.getArma().equals("Fusil")){
						ue.setSalud(ue.getSalud()-50);
						
						
						
					}
					if(this.getArma().equals("Rifle")){
						ue.setSalud(ue.getSalud()-80);
						
						
						
					}
					if(this.getArma().equals("Pistola")){
						ue.setSalud(ue.getSalud()-30);
						
						
						
					}
					if(this.getArma().equals("Bazooka")){
						ue.setSalud(ue.getSalud()-50);
						
						
						
					}
					if(this.getArma().equals("Misil")){
						ue.setSalud(ue.getSalud()-60);
						
						
						
					}
					if(this.getArma().equals("Ametralladora")){
						ue.setSalud(ue.getSalud()-80);
						
						
						
					}
					if(this.getArma().equals("CCC")){
						ue.setSalud(ue.getSalud()-40);
						
						
						
					}
					
					
					}
				if(ue instanceof Semioruga){
					
					
					
					if(this.getArma().equals("Fusil")){
						ue.setSalud(ue.getSalud()-20);
						
						
						
					}
					if(this.getArma().equals("Rifle")){
						ue.setSalud(ue.getSalud()-10);
						
						
						
					}
					if(this.getArma().equals("Pistola")){
						ue.setSalud(ue.getSalud()-5);
						
						
						
					}
					if(this.getArma().equals("Bazooka")){
						ue.setSalud(ue.getSalud()-90);
						
						
						
					}
					if(this.getArma().equals("Misil")){
						ue.setSalud(ue.getSalud()-100);
						
						
						
					}
					if(this.getArma().equals("Ametralladora")){
						ue.setSalud(ue.getSalud()-50);
						
						
						
					}
					if(this.getArma().equals("CCC")){
						ue.setSalud(ue.getSalud());
						
						
						
					}
					
					
					}
				if(ue instanceof Tanque){
					
					
					
					if(this.getArma().equals("Fusil")){
						ue.setSalud(ue.getSalud()-5);
						
						
						
					}
					if(this.getArma().equals("Rifle")){
						ue.setSalud(ue.getSalud()-5);
						
						
						
					}
					if(this.getArma().equals("Pistola")){
						ue.setSalud(ue.getSalud());
						
						
						
					}
					if(this.getArma().equals("Bazooka")){
						ue.setSalud(ue.getSalud()-70);
						
						
						
					}
					if(this.getArma().equals("Misil")){
						ue.setSalud(ue.getSalud()-80);
						
						
						
					}
					if(this.getArma().equals("Ametralladora")){
						ue.setSalud(ue.getSalud()-10);
						
						
						
					}
					if(this.getArma().equals("CCC")){
						ue.setSalud(ue.getSalud());
						
						
						
					}
					
					
					}
				
				
				
				
				
				//////////////////
			}
			
		}
	////////////////	
		
		
		
		
		
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
