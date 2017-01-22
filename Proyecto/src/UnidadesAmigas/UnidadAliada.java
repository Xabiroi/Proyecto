package UnidadesAmigas;

import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import UnidadesEnemigas.BazookaEnemigo;
import UnidadesEnemigas.FrancotiradorEnemigo;
import UnidadesEnemigas.SemiorugaEnemigo;
import UnidadesEnemigas.SoldadoRasoEnemigo;
import UnidadesEnemigas.SpawnEnemigo;
import UnidadesEnemigas.TanqueEnemigo;
import UnidadesEnemigas.UnidadEnemiga;

public class UnidadAliada extends UnidadBD implements Unidad{
	protected ArrayList<UnidadEnemiga> enemigos=new ArrayList<UnidadEnemiga>();
	
	
	public UnidadAliada(){
		this.equipo=1 ;
		
	}

	
	//Getters y setters
///////////////////////////////////////////////


	public ArrayList<UnidadEnemiga> getEnemigos() {
		return enemigos;
	}


	public void setEnemigos(ArrayList<UnidadEnemiga> enemigos) {
		this.enemigos = enemigos;
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
						ataca(5,50);				
					}
					else if(this.getArma().equals("Rifle")){
						ataca(7,70);	
					}
					else if(this.getArma().equals("Pistola")){
						ataca(3,30);
					}
					else if(this.getArma().equals("Bazooka")){
						ataca(5,60);			
					}
					else if(this.getArma().equals("Misil")){
						ataca(7,60);				
					}
					else if(this.getArma().equals("Ametralladora")){
						ataca(5,80);	
					}
					else if(this.getArma().equals("CCC")){
						ataca(2,30);	
					}
					
				
				
				}
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof FrancotiradorEnemigo){
					
					
					
					
					if(this.getArma().equals("Fusil")){
						ataca(5,70);
					}
					else if(this.getArma().equals("Rifle")){
						ataca(7,70);
					}
					else if(this.getArma().equals("Pistola")){
						ataca(3,40);
					}
					else if(this.getArma().equals("Bazooka")){
						ataca(5,60);
					}
					else if(this.getArma().equals("Misil")){
						ataca(7,70);
					}
					else if(this.getArma().equals("Ametralladora")){
						ataca(5,80);

					}
					else if(this.getArma().equals("CCC")){
						ataca(2,50);
						
					}
					
					
					}
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof BazookaEnemigo){
					
					
					
					if(this.getArma().equals("Fusil")){
						ataca(5,50);
					}
					else if(this.getArma().equals("Rifle")){
						ataca(7,80);
					}
					else if(this.getArma().equals("Pistola")){
						ataca(3,30);
					}
					else if(this.getArma().equals("Bazooka")){
						ataca(5,50);
					}
					else if(this.getArma().equals("Misil")){
						ataca(7,60);				
					}
					else if(this.getArma().equals("Ametralladora")){
						ataca(5,80);				
					}
					else if(this.getArma().equals("CCC")){
						ataca(2,40);
					}
					
					
					
					}
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof SemiorugaEnemigo){
					
					
					
				if(this.getArma().equals("Fusil")){
					ataca(5,20);
				}
				else if(this.getArma().equals("Rifle")){
					ataca(7,10);
				}
				else if(this.getArma().equals("Pistola")){
					ataca(3,5);				
				}
				else if(this.getArma().equals("Bazooka")){
					ataca(5,90);				
				}
				else if(this.getArma().equals("Misil")){
					ataca(7,100);
				}
				else if(this.getArma().equals("Ametralladora")){
					ataca(5,50);
				}
				else if(this.getArma().equals("CCC")){					
				}
				
					
					}
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof TanqueEnemigo){
					
					
					if(this.getArma().equals("Fusil")){
						ataca(5,5);	
					}
					else if(this.getArma().equals("Rifle")){
						ataca(7,5);
					}
					else if(this.getArma().equals("Pistola")){			
					}
					else if(this.getArma().equals("Bazooka")){
						ataca(5,70);
					}
					else if(this.getArma().equals("Misil")){
						ataca(7,80);
					}
					else if(this.getArma().equals("Ametralladora")){
						ataca(5,10);
					}
					else if(this.getArma().equals("CCC")){		
					}
					
					}
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof SpawnEnemigo){
					
					
					if(this.getArma().equals("Fusil")){
						ataca(5,10);	
					}
					else if(this.getArma().equals("Rifle")){
						ataca(7,10);
					}
					else if(this.getArma().equals("Pistola")){
						ataca(3,5);
					}
					else if(this.getArma().equals("Bazooka")){
						ataca(5,15);
					}
					else if(this.getArma().equals("Misil")){
						ataca(7,15);
					}
					else if(this.getArma().equals("Ametralladora")){
						ataca(5,10);
					}
					else if(this.getArma().equals("CCC")){		
					}
					
					}
				

		}
	
		
	}
	

	
	

}
