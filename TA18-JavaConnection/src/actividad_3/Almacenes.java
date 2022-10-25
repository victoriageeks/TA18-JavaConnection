package actividad_3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Almacenes {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS almacenes;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE almacenes("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"lugar VARCHAR(100),"+
						"capacidad INT);";
			st.executeUpdate(query);
			
			System.out.println("Tabla creada.");
			
		}catch(SQLException ex) {
			System.out.println("No se ha podido crear la tabla.");
		}
		
	}
	
	public void insertTable() {
		Connection c = mainApp.conexion;
		
		try {
			String query = "INSERT INTO almacenes (lugar,capacidad) values"+
						"('tarragona',500),"+
						"('barcelona',1200),"+
						"('madrid',7300),"+
						"('girona',700);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}