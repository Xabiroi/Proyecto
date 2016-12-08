package BD;

import java.awt.Image;

public class UnidadBD {
	protected String Nombre;
	protected String[] armas= new String[5]; 
	protected String arma;
	protected int Salud;
	protected Image image;
	protected int x;
	protected int y;
	protected int coste;
	//protected int dx;
	//protected int dy;
	protected String Partida;
	
	
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

	public String getPartida() {
		return Partida;
	}

	public void setPartida(String partida) {
		Partida = partida;
	}


}
