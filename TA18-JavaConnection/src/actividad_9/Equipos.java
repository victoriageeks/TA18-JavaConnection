package actividad_9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipos {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS equipos;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE equipos("+
						"num_serie CHAR(4) PRIMARY KEY,"+
						"nombre VARCHAR(100),"+
						"facultad INT,"+
						"FOREIGN KEY(facultad) REFERENCES facultad(codigo)"+
						");";
			
			st.executeUpdate(query);
			
			System.out.println("Tabla creada.");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("No se ha podido crear la tabla.");
		}
		
	}
	
	
	public void insertTable() {
		Connection c = mainApp.conexion;
		
		try {
			String query = "INSERT INTO equipos (num_serie,nombre,facultad) values"+
						"('001A','equipo1',1),"+
						"('002B','equipo2',2),"+
						"('003C','equipo3',3),"+
						"('004D','equipo4',4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
