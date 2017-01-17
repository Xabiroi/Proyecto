package UnidadesEnemigas;

import java.util.ArrayList;

import BD.UnidadBD;
import Interfaces.Unidad;
import UnidadesAmigas.Bazooka;
import UnidadesAmigas.Francotirador;
import UnidadesAmigas.Semioruga;
import UnidadesAmigas.SoldadoRaso;
import UnidadesAmigas.Tanque;
import UnidadesAmigas.UnidadAliada;

public class UnidadEnemiga extends UnidadBD implements Unidad{
	protected ArrayList<UnidadAliada> enemigos=new ArrayList<UnidadAliada>();


	public UnidadEnemiga(){
		this.equipo=1;
		
	}
	
	
	
	
	//Getters y setters
///////////////////////////////////////////////
	
	




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
				if(Ventanas.Partida.getUnidadObjetivo() instanceof Francotirador){
					
					
					
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
				if(Ventanas.Partida.getUnidadObjetivo() instanceof Bazooka){
					
					
					
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
				if(Ventanas.Partida.getUnidadObjetivo() instanceof Semioruga){
					
					
					
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
				if(Ventanas.Partida.getUnidadObjetivo() instanceof Tanque){
					
					
					
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
