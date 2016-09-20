package UnidadesEnemigas;

import java.awt.Image;
import java.util.ArrayList;

import LogicaBatallas.LogicaPartida;
import UnidadesAmigas.UnidadAliada;

public class UnidadEnemiga {
	protected String[] armas= new String[5]; 
	protected ArrayList<UnidadAliada> enemigos=new ArrayList<UnidadAliada>();
	protected int Salud=0;
	protected Image image;
	protected int cordX;
	protected int cordY;
	
	
	//Getters y setters
///////////////////////////////////////////////
	public String[] getArmas() {
		return armas;
	}


	public void setArmas(String[] armas) {
		this.armas = armas;
	}


	public ArrayList<UnidadAliada> getEnemigos() {
		return enemigos;
	}


	public void setEnemigos(ArrayList<UnidadAliada> enemigos) {
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
		for(UnidadAliada ua:LogicaPartida.getListaUnidadesAmigas()){
			this.enemigos.add(ua);
		}
		
		
		
		
		
	}


	public void Mover() {
		
		
	}

	public void CambiarArma() {
		
		
	}
}
