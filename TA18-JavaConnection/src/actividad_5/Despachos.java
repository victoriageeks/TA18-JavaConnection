package actividad_5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Despachos {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS despachos;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE despachos("+
						"numero INT PRIMARY KEY AUTO_INCREMENT,"+
						"capacidad INT);";
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
			String query = "INSERT INTO despachos (capacidad) values"+
						"(50),"+
						"(65),"+
						"(55),"+
						"(70);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}