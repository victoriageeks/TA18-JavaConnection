package actividad_9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Investigadores {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS investigadores;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE investigadores("+
						"DNI VARCHAR(8) PRIMARY KEY,"+
						"nom_apels VARCHAR(255),"+
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
			String query = "INSERT INTO investigadores (DNI,nom_apels,facultad) values"+
						"('39876501','Joel Exposito',1),"+
						"('39876502','Victoria Lavega',2),"+
						"('39876503','Selena Gomez',3),"+
						"('39876504','Justin Bieber',4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
