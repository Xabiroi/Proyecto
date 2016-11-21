package LogicaBatallas;

import LoginData.Usuario;

public class Partida {
	protected String Partida;
	protected Usuario usuario;
	protected Usuario usuario2;
	protected long fechaPartida;
	protected LogicaPartida lp;
	protected int dineroAliado=200;
	protected int dineroEnemigo=200;
	protected int puntuacionAliado=0;
	protected int puntuacionEnemigo=0;
	
	//constructor partida multijugador, dos usuarios
	public Partida(Usuario usuario, Usuario usuario2,long fechaPartida, String NombrePartida) {
		super();
		this.Partida=NombrePartida;
		this.usuario = usuario;
		this.usuario2=usuario2;
		this.fechaPartida = fechaPartida;
		this.lp = new LogicaPartida();
	}
	//constructor partida local, con el mismo usuario
	public Partida(Usuario usuario, long fechaPartida,String NombrePartida) {
		this.usuario = usuario;
		this.Partida=NombrePartida;
		this.fechaPartida = fechaPartida;
		this.lp=new LogicaPartida();
	}
	//constructor partida multijugador, dos usuarios
	public Partida(Usuario usuario, Usuario usuario2,long fechaPartida, String NombrePartida,LogicaPartida lp) {
		
		this.Partida=NombrePartida;
		this.usuario = usuario;
		this.usuario2=usuario2;
		this.fechaPartida = fechaPartida;
		this.lp = lp;
	}
	//constructor partida local, con el mismo usuario
	public Partida(Usuario usuario, long fechaPartida,String NombrePartida,LogicaPartida lp) {
		this.usuario = usuario;
		this.Partida=NombrePartida;
		this.fechaPartida = fechaPartida;
		this.lp=lp;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public long getFechaPartida() {
		return fechaPartida;
	}
	public void setFechaPartida(long fechaPartida) {
		this.fechaPartida = fechaPartida;
	}
	public String getPartida() {
		return Partida;
	}
	public void setPartida(String partida) {
		Partida = partida;
	}
	public Usuario getUsuario2() {
		return usuario2;
	}
	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}
	public LogicaPartida getLp() {
		return lp;
	}
	public void setLp(LogicaPartida lp) {
		this.lp = lp;
	}
	public int getDineroAliado() {
		return dineroAliado;
	}
	public void setDineroAliado(int dineroAliado) {
		this.dineroAliado = dineroAliado;
	}
	public int getDineroEnemigo() {
		return dineroEnemigo;
	}
	public void setDineroEnemigo(int dineroEnemigo) {
		this.dineroEnemigo = dineroEnemigo;
	}
	public int getPuntuacionAliado() {
		return puntuacionAliado;
	}
	public void setPuntuacionAliado(int puntuacionAliado) {
		this.puntuacionAliado = puntuacionAliado;
	}
	public int getPuntuacionEnemigo() {
		return puntuacionEnemigo;
	}
	public void setPuntuacionEnemigo(int puntuacionEnemigo) {
		this.puntuacionEnemigo = puntuacionEnemigo;
	}
}
