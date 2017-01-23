package Interfaces;

import java.awt.Image;

public interface Unidad {
	//Atributos generales de las unidades
	public String getArma();
	public String getNombre();
	public String[] getArmas();
	public int getSalud() ;
	public Image getImage() ;
	public int getCordX() ;
	public int getCordY() ;
	public int getDistancia();

}
