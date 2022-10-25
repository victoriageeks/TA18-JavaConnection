package actividad_1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Fabricantes {

	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS fabricantes;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE fabricantes("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100));";
			st.executeUpdate(query);
			
			System.out.println("Tabla creada.");
			
		}catch(SQLException ex) {
			System.out.println("No se ha podido crear la tabla.");
		}
		
	}
	
	public void insertTable() {
		Connection c = mainApp.conexion;
		
		try {
			String query = "INSERT INTO fabricantes (nombre) values"+
						"('Joel'),"+
						"('Bárbara'),"+
						"('Victoria'),"+
						"('Selena');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
