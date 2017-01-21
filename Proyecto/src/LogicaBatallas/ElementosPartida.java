package LogicaBatallas;

import java.util.Calendar;

public class ElementosPartida {
	protected String Partida;
	protected String usuario;
	protected String usuario2;
	protected long fechaPartida;
	protected LogicaPartida lp;
	protected int dineroAliado=200;
	protected int dineroEnemigo=200;
	protected int puntuacionAliado=0;
	protected int puntuacionEnemigo=0;
	protected int Turno=0;
	
	//constructor partida multijugador, dos usuarios
	public ElementosPartida(String usuario, String usuario2, String NombrePartida) {
		super();
		this.Partida=NombrePartida;
		this.usuario = usuario;
		this.usuario2=usuario2;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		this.fechaPartida = mYear+(mMonth+1)*10000+mDay*1000000;
		this.lp = new LogicaPartida();
		this.Turno=0;
	}
	//constructor partida local, con el mismo usuario
	public ElementosPartida(String usuario,String NombrePartida) {
		this.usuario = usuario;
		this.usuario2=null;
		this.Partida=NombrePartida;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		this.fechaPartida = mYear+(mMonth+1)*10000+mDay*1000000;
		this.lp=new LogicaPartida();
		this.Turno=0;
	}
	//CArgar partida multijugador, dos usuarios
	public ElementosPartida(String usuario, String usuario2,long fechaPartida, String NombrePartida,LogicaPartida lp,int Turno) {
		
		this.Partida=NombrePartida;
		this.usuario = usuario;
		this.usuario2=usuario2;
		this.fechaPartida = fechaPartida;
		this.lp = lp;
		this.Turno=Turno;
	}
	//Cargar partida local, con el mismo usuario
	public ElementosPartida(String usuario, long fechaPartida,String NombrePartida,LogicaPartida lp,int Turno) {
		this.usuario = usuario;
		this.usuario2=null;
		this.Partida=NombrePartida;
		this.fechaPartida = fechaPartida;
		this.lp=lp;
		this.Turno=Turno;
	}
	
	
	public int getTurno() {
		return Turno;
	}
	public void setTurno(int turno) {
		Turno = turno;
	}
	public ElementosPartida() {
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
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
	public String getUsuario2() {
		return usuario2;
	}
	public void setUsuario2(String usuario2) {
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
