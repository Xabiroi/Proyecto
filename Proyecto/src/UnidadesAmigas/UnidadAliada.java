package UnidadesAmigas;

import java.awt.Image;
import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import UnidadesEnemigas.BazookaEnemigo;
import UnidadesEnemigas.FrancotiradorEnemigo;
import UnidadesEnemigas.SemiorugaEnemigo;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.TanqueEnemigo;
import UnidadesEnemigas.UnidadEnemiga;

public class UnidadAliada extends UnidadBD implements Unidad{
	protected ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();
	
	
	public UnidadAliada(){
		this.equipo=0 ;
		
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


	/**
	 * Metodo que dependiendo de que soldado se trate el que ataque
	 * variara en efectividad
	 * 
	 * 
	 * 
	 */
	
	
	//FIXME poner un random de atacar o fallar para  que sea mas emocionante
	@Override
	public void atacar(int x,int y){
		
		if(Ventanas.Partida.getTablero()[x][y] instanceof UnidadEnemiga){
			
				
				if(Ventanas.Partida.getUnidadObjetivo() instanceof SoldadoRasoEnemigo){
					
				
				
				if(this.getArma().equals("Fusil")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-50);
					
					
					
				}
				else if(this.getArma().equals("Rifle")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-70);
					
					
					
				}
				else if(this.getArma().equals("Pistola")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<3)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<3)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-30);
					
					
					
				}
				else if(this.getArma().equals("Bazooka")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-60);
					
					
					
				}
				else if(this.getArma().equals("Misil")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-60);
					
					
					
				}
				else if(this.getArma().equals("Ametralladora")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-80);
					
					
					
				}
				else if(this.getArma().equals("CCC")){
					if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<2)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<2)
					Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-30);
					
					
					
				}
				
				
				}
				if(Ventanas.Partida.getUnidadObjetivo() instanceof FrancotiradorEnemigo){
					
					
					
					if(this.getArma().equals("Fusil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-70);
						
						
						
					}
					else if(this.getArma().equals("Rifle")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-70);
						
						
						
					}
					else if(this.getArma().equals("Pistola")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<3)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<3)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-40);
						
						
						
					}
					else if(this.getArma().equals("Bazooka")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-60);
						
						
						
					}
					else if(this.getArma().equals("Misil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-760);
						
						
						
					}
					else if(this.getArma().equals("Ametralladora")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
						if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-80);
						
						
						
					}
					else if(this.getArma().equals("CCC")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<2)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<2)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-50);
						
						
						
					}
					
					
					}
				if(Ventanas.Partida.getUnidadObjetivo() instanceof BazookaEnemigo){
					
					
					
					if(this.getArma().equals("Fusil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-50);
						
						
						
					}
					else if(this.getArma().equals("Rifle")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-80);
						
						
						
					}
					else if(this.getArma().equals("Pistola")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<3)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<3)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-30);
						
						
						
					}
					else if(this.getArma().equals("Bazooka")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-50);
						
						
						
					}
					else if(this.getArma().equals("Misil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-60);
						
						
						
					}
					else if(this.getArma().equals("Ametralladora")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-80);
						
						
						
					}
					else if(this.getArma().equals("CCC")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<2)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<2)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-40);
						
						
						
					}
					
					
					}
				if(Ventanas.Partida.getUnidadObjetivo() instanceof SemiorugaEnemigo){
					
					
					
					if(this.getArma().equals("Fusil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-20);
						
						
						
					}
					else if(this.getArma().equals("Rifle")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-10);
						
						
						
					}
					else if(this.getArma().equals("Pistola")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<3)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<3)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-5);
						
						
						
					}
					else if(this.getArma().equals("Bazooka")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-90);
						
						
						
					}
					else if(this.getArma().equals("Misil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-100);
						
						
						
					}
					else if(this.getArma().equals("Ametralladora")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-50);
						
						
						
					}
					else if(this.getArma().equals("CCC")){					
					}
					
					
					}
				if(Ventanas.Partida.getUnidadObjetivo() instanceof TanqueEnemigo){
					
					
					
					if(this.getArma().equals("Fusil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-5);
						
						
						
					}
					else if(this.getArma().equals("Rifle")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-5);
						
						
						
					}
					else if(this.getArma().equals("Pistola")){			
					}
					else if(this.getArma().equals("Bazooka")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-70);
						
						
						
					}
					else if(this.getArma().equals("Misil")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<7)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<7)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-80);
						
						
						
					}
					else if(this.getArma().equals("Ametralladora")){
						if(Math.abs(Ventanas.Partida.getUnidadObjetivo().getCordX()-this.getCordX())<5)
							if(Ventanas.Partida.getUnidadObjetivo().getCordY()-this.getCordY()<5)
						Ventanas.Partida.getUnidadObjetivo().setSalud(Ventanas.Partida.getUnidadObjetivo().getSalud()-10);
						
						
						
					}
					else if(this.getArma().equals("CCC")){		
					}
					
					
					}
				

		}
	
		
	}
	

	
	

}
