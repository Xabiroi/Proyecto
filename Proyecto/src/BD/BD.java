package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import LogicaBatallas.ElementosPartida;
import LoginData.Usuario;



public class BD {

private static Exception lastError = null;  // Información de último error SQL ocurrido
	
	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
//FIXME Poner otro metodo para las conexiones en la abse de datos remota
	public static Connection initBD( String nombreBD ) {
		try {
		    try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nombreBD+"?autoReconnect=true&useSSL=false","root","root");
			log( Level.INFO, "Conectada base de datos " + nombreBD, null );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Devuelve statement para usar la base de datos
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en uso de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuario " +
					"(nombre char(30) not null primary key, "
					+ "contraseña char(30) not null,"
					+ " nick char(30) not null)");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table partidaLocal " 
					+"(usuario1 char(30) not null references usuario(nombre) on delete cascade,"
					+ "Partida char(30),"
					+ "Turno integer,"
					+ "dineroAliado integer,"
					+ "dineroEnemigo integer,"
					+ "puntuacionAliado integer,"
					+ "puntuacionEnemigo integer, "
					+ "fechapartida bigint,"
					+ "primary key(Partida))");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table partidaMultijugador " 
					+"(usuario1 char(30) not null references usuario(nombre) on delete cascade,"
					+ "usuario2 char(30) not null references usuario(nombre) on delete cascade,"
					+ "Partida char(30),"
					+ "Turno integer,"
					+ "dineroAliado integer,"
					+ "dineroEnemigo integer,"
					+ "puntuacionAliado integer,"
					+ "puntuacionEnemigo integer, "
					+ "fechapartida bigint,"
					+ "primary key(Partida))");
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table soldados "
					+ "(Partida char(30) not null references partidaMultijugador(Partida) on delete cascade,"
					+ " nombre char(30),"
					+ " acciones integer,"
					+ " arma char(30),"
					+ " salud char(30),"
					+ " distancia integer,"
					+ " equipo integer,"
					+ " coordX integer,"
					+ " coordY integer)");
				
				
				
	
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			try {
				statement.executeUpdate("create table soldadosLocal "
					+ "(Partida char(30) not null references partidaLocal(Partida) on delete cascade,"
					+ " nombre char(30),"
					+ " acciones integer,"
					+ " arma char(30),"
					+ " salud char(30),"
					+ " distancia integer,"
					+ " equipo integer,"
					+ " coordX integer,"
					+ " coordY integer)");
				
				
				
	
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			
			log( Level.INFO, "Creada base de datos", null );
			return statement;
			
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en creación de base de datos", e );
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE MËTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists usuario");
			statement.executeUpdate("drop table if exists partidaMultijugador");
			statement.executeUpdate("drop table if exists partidaLocal");
			statement.executeUpdate("drop table if exists soldados");
			statement.executeUpdate("drop table if exists soldadosLocal");
			log( Level.INFO, "Reiniciada base de datos", null );
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en reinicio de base de datos", e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
			log( Level.INFO, "Cierre de base de datos", null );
		} catch (SQLException e) {
			lastError = e;
			log( Level.SEVERE, "Error en cierre de base de datos", e );
			e.printStackTrace();
		}
	}
	
	/** Devuelve la información de excepción del último error producido por cualquiera 
	 * de los métodos de gestión de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}
	
	
	
	
	
	
	
	
	
	

	/////////////////////////////////////////////////////////////////////
	//                      Operaciones de usuario                     //
	/////////////////////////////////////////////////////////////////////
	
	/** Añade un usuario a la tabla abierta de BD, usando la sentencia INSERT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a añadir en la base de datos
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean usuarioInsert( Statement st, Usuario u ) {
		String sentSQL = "";
		try {

			sentSQL = "insert into usuario values(" +
					"'" + secu(u.getNombre()) + "', " +
					"'" + secu(u.getContraseña()) + "', " +
					"'" + secu(u.getNick()) +"')";

			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean PartidaInsert( Statement st, ElementosPartida p ) {
		String sentSQL = "";
		try {

			sentSQL = "insert into partidaMultijugador values(" +
					"'" + secu(p.getUsuario()) + "', " +
					"'" + secu(p.getUsuario2()) + "', " +
					"'" + secu(p.getPartida()) + "', " +
					"'" + secu(""+p.getTurno()) + "', " +
					"'" + secu(""+p.getDineroAliado()) + "', " +
					"'" + secu(""+p.getDineroEnemigo()) + "', " +
					"'" + secu(""+p.getPuntuacionAliado()) + "', " +
					"'" + secu(""+p.getPuntuacionEnemigo()) + "', " +
					"'" + secu(""+p.getFechaPartida()) +"')";

			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean Partida1JInsert( Statement st, ElementosPartida p ) {
		String sentSQL = "";
		try {

			sentSQL = "insert into partidaLocal values(" +
					"'" + secu(p.getUsuario()) + "', " +
					"'" + secu(p.getPartida()) + "', " +
					"'" + secu(""+p.getTurno()) + "', " +
					"'" + secu(""+p.getDineroAliado()) + "', " +
					"'" + secu(""+p.getDineroEnemigo()) + "', " +
					"'" + secu(""+p.getPuntuacionAliado()) + "', " +
					"'" + secu(""+p.getPuntuacionEnemigo()) + "', " +
					"'" + secu(""+p.getFechaPartida()) +"')";

			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	

	public static boolean UnidadesInsert( Statement st, UnidadBD s) {
		String sentSQL = "";
		try {

			sentSQL = "insert into soldados values(" +
					"'" + secu(s.getPartida()) + "', " +
					"'" + secu(s.getNombre()) + "', " +
					"'" + secu(""+s.getAcciones()) + "', " +
					"'" + secu(s.getArma()) + "', " +
					"'" + secu(""+s.getSalud()) + "', " +
					"'" + secu(""+s.getDistancia()) + "', " +
					"'" + secu(""+s.getEquipo()) + "', " +
					"'" + secu(""+s.getCordX()) + "', " +
					"'" + secu(""+s.getCordY()) +"')";

			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean UnidadesInsertLocal( Statement st, UnidadBD s) {
		String sentSQL = "";
		try {

			sentSQL = "insert into soldadosLocal values(" +
					"'" + secu(s.getPartida()) + "', " +
					"'" + secu(s.getNombre()) + "', " +
					"'" + secu(""+s.getAcciones()) + "', " +
					"'" + secu(s.getArma()) + "', " +
					"'" + secu(""+s.getSalud()) + "', " +
					"'" + secu(""+s.getDistancia()) + "', " +
					"'" + secu(""+s.getEquipo()) + "', " +
					"'" + secu(""+s.getCordX()) + "', " +
					"'" + secu(""+s.getCordY()) +"')";

			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que añadir 1 - error si no
				log( Level.SEVERE, "Error en insert de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}


	/** Realiza una consulta a la tabla abierta de usuarios de la BD, usando la sentencia SELECT de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param codigoSelect	Sentencia correcta de WHERE (sin incluirlo) para filtrar la búsqueda (vacía si no se usa)
	 * @return	lista de usuarios cargados desde la base de datos, null si hay cualquier error
	 */
	public static ArrayList<Usuario> usuarioSelect( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<Usuario> ret = new ArrayList<>();
		try {
			sentSQL = "select * from usuario";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			// System.out.println( sentSQL );  // Para ver lo que se hace en consola
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNick( rs.getString( "nick" ) );
				u.setContraseña( rs.getString( "contraseña" ) );
				u.setNombre( rs.getString( "nombre" ) );
				ret.add( u );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de usuario\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	

	public static ArrayList<ElementosPartida> PartidaSelect( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<ElementosPartida> ret = new ArrayList<>();
		try {
			sentSQL = "select * from partidaMultijugador";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			// System.out.println( sentSQL );  // Para ver lo que se hace en consola
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				ElementosPartida p = new ElementosPartida();
				p.setDineroAliado(Integer.parseInt(rs.getString("dineroAliado")));
				p.setDineroEnemigo(Integer.parseInt(rs.getString("dineroEnemigo")));
				p.setFechaPartida(Integer.parseInt(rs.getString("fechapartida")));
				p.setPartida(rs.getString("Partida"));
				p.setTurno(Integer.parseInt(rs.getString("Turno")));
				p.setPuntuacionAliado(Integer.parseInt(rs.getString("puntuacionAliado")));
				p.setPuntuacionEnemigo(Integer.parseInt(rs.getString("puntuacionEnemigo")));
				p.setUsuario(rs.getString("usuario1"));
				p.setUsuario2(rs.getString("usuario2"));
				ret.add( p );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de usuario\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<ElementosPartida> PartidaSelect1J( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<ElementosPartida> ret = new ArrayList<>();
		try {
			sentSQL = "select * from partidaLocal";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				ElementosPartida p = new ElementosPartida();
				p.setDineroAliado(Integer.parseInt(rs.getString("dineroAliado")));
				p.setDineroEnemigo(Integer.parseInt(rs.getString("dineroEnemigo")));
				p.setFechaPartida(Integer.parseInt(rs.getString("fechapartida")));
				p.setPartida(rs.getString("Partida"));
				p.setTurno(Integer.parseInt(rs.getString("Turno")));
				p.setPuntuacionAliado(Integer.parseInt(rs.getString("puntuacionAliado")));
				p.setPuntuacionEnemigo(Integer.parseInt(rs.getString("puntuacionEnemigo")));
				p.setUsuario(rs.getString("usuario1"));
				ret.add( p );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de usuario\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
//FIXME hacer el separador de arrays dependiendo del numero de equipo
	public static ArrayList<UnidadBD> UnidadBDSelect( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<UnidadBD> ret = new ArrayList<>();
		try {
			sentSQL = "select * from soldados";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			// System.out.println( sentSQL );  // Para ver lo que se hace en consola
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				UnidadBD u = new UnidadBD();
				u.setPartida(rs.getString("Partida"));
				u.setArma(rs.getString("arma"));
				u.setAcciones(Integer.parseInt(rs.getString("acciones")));
				u.setCordX(Integer.parseInt(rs.getString("coordX")));
				u.setCordY(Integer.parseInt(rs.getString("coordY")));
				u.setEquipo(Integer.parseInt(rs.getString("equipo")));
				u.setNombre(rs.getString("nombre"));
				u.setSalud(Integer.parseInt(rs.getString("salud")));
				u.setDistancia(Integer.parseInt(rs.getString("distancia")));
				ret.add( u );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de unidades\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	public static ArrayList<UnidadBD> UnidadBDSelectlocal( Statement st, String codigoSelect ) {
		String sentSQL = "";
		ArrayList<UnidadBD> ret = new ArrayList<>();
		try {
			sentSQL = "select * from soldadoslocal";
			if (codigoSelect!=null && !codigoSelect.equals(""))
				sentSQL = sentSQL + " where " + codigoSelect;
			// System.out.println( sentSQL );  // Para ver lo que se hace en consola
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				UnidadBD u = new UnidadBD();
				u.setPartida(rs.getString("Partida"));
				u.setArma(rs.getString("arma"));
				u.setAcciones(Integer.parseInt(rs.getString("acciones")));
				u.setCordX(Integer.parseInt(rs.getString("coordX")));
				u.setCordY(Integer.parseInt(rs.getString("coordY")));
				u.setEquipo(Integer.parseInt(rs.getString("equipo")));
				u.setNombre(rs.getString("nombre"));
				u.setSalud(Integer.parseInt(rs.getString("salud")));
				u.setDistancia(Integer.parseInt(rs.getString("distancia")));
				ret.add( u );
			}
			rs.close();
			log( Level.INFO, "BD\t" + sentSQL, null );
			return ret;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			log( Level.SEVERE, "Error en BD en tipo de unidades\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}
	
	/** Modifica un usuario en la tabla abierta de BD, usando la sentencia UPDATE de SQL
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @param u	Usuario a modificar en la base de datos. Se toma su nick como clave
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean usuarioUpdate( Statement st, Usuario u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "update usuario set" +
					" password='" + u.getContraseña() + "', " +
					" nombre='" + u.getNombre() + "' " +
					" where nick='" + u.getNick() + "'";
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	
//Sirve para el local y multijugador ya que solo actualiza el dinero y la puntuacion
	
	public static boolean PartidaUpdate( Statement st, ElementosPartida p ) {
		String sentSQL = "";
		try {
			//FIXME
			
			sentSQL = "update partidaMultijugador set" +

					" Turno=" + p.getTurno() + ", " +
					" dineroAliado=" + p.getDineroAliado() + ", " +
					" dineroEnemigo=" + p.getDineroEnemigo() + ", " +
					" puntuacionAliado='" + p.getPuntuacionAliado() + "', " +
					" puntuacionEnemigo='" + p.getPuntuacionEnemigo() + "', " +
					" fechapartida='" + p.getFechaPartida() + "'" +
					" where Partida='" + p.getPartida() + "';";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean PartidaUpdate1J( Statement st, ElementosPartida p ) {
		String sentSQL = "";
		try {
			//FIXME
			
			sentSQL = "update partidaLocal set" +

					" Turno=" + p.getTurno() + ", " +
					" dineroAliado=" + p.getDineroAliado() + ", " +
					" dineroEnemigo=" + p.getDineroEnemigo() + ", " +
					" puntuacionAliado='" + p.getPuntuacionAliado() + "', " +
					" puntuacionEnemigo='" + p.getPuntuacionEnemigo() + "', " +
					" fechapartida='" + p.getFechaPartida() + "'" +
					" where Partida='" + p.getPartida() + "';";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	

	public static boolean UnidadBDUpdate( Statement st, UnidadBD u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "update soldados set" +
					" arma='" + u.getArma() + "', " +
					" salud=" + u.getSalud() + ", " +
					" acciones=" + u.getAcciones() + ", " +
					" distancia=" + u.getDistancia() + ", " +
					" equipo=" + u.getEquipo() + ", " +
					" coordX=" + u.getCordX() + ", " +
					" coordY='" + u.getCordY() + "'" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean UnidadBDUpdateLocal( Statement st, UnidadBD u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "update soldadosLocal set" +
					" arma='" + u.getArma() + "', " +
					" salud=" + u.getSalud() + ", " +
					" acciones=" + u.getAcciones() + ", " +
					" distancia=" + u.getDistancia() + ", " +
					" equipo=" + u.getEquipo() + ", " +
					" coordX=" + u.getCordX() + ", " +
					" coordY='" + u.getCordY() + "'" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	

	public static boolean PartidaEliminar( Statement st, ElementosPartida u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "delete from partidaMultijugador" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean PartidaLocalEliminar( Statement st, ElementosPartida u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "delete from partidaLocal" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean SoldadosLocalEliminar( Statement st, ElementosPartida u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "delete from soldadosLocal" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}
	public static boolean SoldadosEliminar( Statement st, ElementosPartida u ) {
		String sentSQL = "";
		try {
			
			sentSQL = "delete from soldados" +
					" where Partida='" + u.getPartida() + "'";
			// System.out.println( sentSQL );  // para ver lo que se hace en consola
			int val = st.executeUpdate( sentSQL );
			log( Level.INFO, "BD modificada " + val + " fila\t" + sentSQL, null );
			if (val!=1) {  // Se tiene que modificar 1 - error si no
				log( Level.SEVERE, "Error en update de BD\t" + sentSQL, null );
				return false;  
			}
			return true;
		} catch (SQLException e) {
			log( Level.SEVERE, "Error en BD\t" + sentSQL, e );
			lastError = e;
			e.printStackTrace();
			return false;
		}
	}


	
	
	/////////////////////////////////////////////////////////////////////
	//                      Métodos privados                           //
	/////////////////////////////////////////////////////////////////////

	// Devuelve el string "securizado" para volcarlo en SQL
	// (Implementación 1) Sustituye ' por '' y quita saltos de línea
	// (Implementación 2) Mantiene solo los caracteres seguros en español
	private static String secu( String string ) {
		// Implementación (1)
		// return string.replaceAll( "'",  "''" ).replaceAll( "\\n", "" );
		// Implementación (2)
		StringBuffer ret = new StringBuffer();
		for (char c : string.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZñÑáéíóúüÁÉÍÓÚÚ.,:;-_(){}[]-+*=<>'\"¿?¡!&%$@#/\\0123456789".indexOf(c)>=0) ret.append(c);
		}
		return ret.toString();
	}
	

	/////////////////////////////////////////////////////////////////////
	//                      Logging                                    //
	/////////////////////////////////////////////////////////////////////
	
	private static Logger logger = null;
	// Método público para asignar un logger externo
	/** Asigna un logger ya creado para que se haga log de las operaciones de base de datos
	 * @param logger	Logger ya creado
	 */
	public static void setLogger( Logger logger ) {
		BD.logger = logger;
	}
	// Método local para loggear (si no se asigna un logger externo, se asigna uno local)
	private static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto local:
			logger = Logger.getLogger( BD.class.getName() );  // Nombre del logger - el de la clase
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() + ".log.xml" ) );  // Y saca el log a fichero xml
				logger.addHandler( new FileHandler( "bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
	
	
	
}