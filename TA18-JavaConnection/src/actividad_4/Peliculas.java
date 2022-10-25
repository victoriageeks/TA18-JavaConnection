package actividad_4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Peliculas {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS peliculas;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE peliculas("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100),"+
						"calificacion_edad INT);";
			st.executeUpdate(query);
			
			System.out.println("Tabla creada.");
			
		}catch(SQLException ex) {
			System.out.println("No se ha podido crear la tabla.");
		}
		
	}
	
	public void insertTable() {
		Connection c = mainApp.conexion;
		
		try {
			String query = "INSERT INTO peliculas (nombre,calificacion_edad) values"+
						"('Shadow Hunters',16),"+
						"('Shin Chan',7),"+
						"('Shrek',7),"+
						"('Hombres de negro',12);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}