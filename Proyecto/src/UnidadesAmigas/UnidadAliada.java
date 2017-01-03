package UnidadesAmigas;

import java.awt.Image;
import java.awt.Point;

import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import LogicaBatallas.LogicaPartida;
import UnidadesEnemigas.BazookaEnemigo;
import UnidadesEnemigas.FrancotiradorEnemigo;
import UnidadesEnemigas.SemiorugaEnemigo;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.TanqueEnemigo;
import UnidadesEnemigas.UnidadEnemiga;
import Ventanas.Partida;

public class UnidadAliada extends UnidadBD implements Unidad{
	protected ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();
	
	
	public UnidadAliada(){
		this.equipo=1;
		
	}
	

	
	
	////FIXME 
	/* Ejemplo
	 * private void initSoldado() {
        
        ImageIcon ii = new ImageIcon("SoldadoRaso.png");
        image = ii.getImage();
        x = 40;
        y = 60;        
    }
	 * 
	 * 
	 * 
	 * 
	 * 
	 *  public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
	 * 
	 */
	
	
	
	
	
	
	
	
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
	
	
	public int getDistancia() {
		return Distancia;
	}


	public void setDistancia(int distancia) {
		Distancia = distancia;
	}

	
	///////////////////////////////////////////
	
	
	
	

	public void Objetivos() {//ArrayList<UnidadEnemiga>(?)
		

		
		
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
				if(x1-x<5){
					if(y1-y<5){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Pistola")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<3){
					if(y1-y<3){this.enemigos.add(ue);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("Rifle")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<7){
					if(y1-y<7){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Bazooka")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<5){
					if(y1-y<5){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Misil")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<7){
					if(y1-y<7){this.enemigos.add(ue);
					
					}	
				}
			
			}
			
			else if(this.getArma().equals("Ametralladora")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<5){
					if(y1-y<5){this.enemigos.add(ue);
					
					}	
				}
			
			
			}
			
			else if(this.getArma().equals("CCC")){
				
				int x=ue.getCordX();
				int y=ue.getCordY();
				if(x1-x<2){
					if(y1-y<2){this.enemigos.add(ue);
					
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
		
		for(UnidadEnemiga ue:LogicaPartida.getListaEnemigos()){
			if(x==ue.getCordX()&&y==ue.getCordY()){
				
				if(ue instanceof SoldadoRasoEnemigo){
					
				
				
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
				if(ue instanceof FrancotiradorEnemigo){
					
					
					
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
				if(ue instanceof BazookaEnemigo){
					
					
					
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
				if(ue instanceof SemiorugaEnemigo){
					
					
					
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
				if(ue instanceof TanqueEnemigo){
					
					
					
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
	

	
	

}
