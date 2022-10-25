package actividad_7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Asignado_a {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS asignado_a;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE asignado_a("+
						"cientifico VARCHAR(8),"+
						"proyecto CHAR(4),"+
						"FOREIGN KEY(cientifico) REFERENCES cientificos(DNI),"+
						"FOREIGN KEY(proyecto) REFERENCES proyecto(id)"+
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
			String query = "INSERT INTO asignado_a (cientifico,proyecto) values"+
						"('39878091','001A'),"+
						"('39878092','002B'),"+
						"('39878093','003C'),"+
						"('39878094','004D');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
