package actividad_8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cajeros {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS cajeros;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cajeros("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nom_apels VARCHAR(255)"+
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
			String query = "INSERT INTO cajeros (nom_apels) values"+
						"('Joel Exposito'),"+
						"('Victoria Lavega'),"+
						"('Selena Gomez'),"+
						"('Justin Bieber');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}