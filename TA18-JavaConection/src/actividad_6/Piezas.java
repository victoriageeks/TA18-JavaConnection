package actividad_6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Piezas {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS piezas;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE piezas("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100));";
			
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
			String query = "INSERT INTO piezas (nombre) values"+
						"('pieza1'),"+
						"('pieza2'),"+
						"('pieza3'),"+
						"('pieza4');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
