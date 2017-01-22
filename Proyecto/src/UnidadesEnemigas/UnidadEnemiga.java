package UnidadesEnemigas;

import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import UnidadesAmigas.Bazooka;
import UnidadesAmigas.Francotirador;
import UnidadesAmigas.Semioruga;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Spawn;
import UnidadesAmigas.Tanque;
import UnidadesAmigas.UnidadAliada;

public class UnidadEnemiga extends UnidadBD implements Unidad{
	protected ArrayList<UnidadAliada> aliados=new ArrayList<UnidadAliada>();
	public UnidadEnemiga(){
		this.equipo=2 ;
		
	}
	
	//Getters y setters
///////////////////////////////////////////////


public ArrayList<UnidadAliada> getAliados() {
return aliados;
}


public void setAliados(ArrayList<UnidadAliada> aliados) {
this.aliados = aliados;
}


	


	
	

	/**
	 * Metodo que dependiendo de que soldado se trate el que ataque
	 * variara en efectividad
	 * 
	 * 
	 * @param P punto donde se clicka para obtener el objetivo
	 */
	
	
	//FIXME poner un random de atacar o fallar para  que sea mas emocionante
	@Override
	public void atacar(int x,int y){
		
		if(Ventanas.Partida.getTablero()[x][y] instanceof UnidadAliada){
			
				
				if(Ventanas.Partida.getUnidadObjetivo() instanceof SoldadoRaso){
					
				
				
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
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof Francotirador){
					
					
					
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
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof Bazooka){
					
					
					
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
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof Semioruga){
							
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
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof Tanque){
					
					
					
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
				else if(Ventanas.Partida.getUnidadObjetivo() instanceof Spawn){
					
					
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
