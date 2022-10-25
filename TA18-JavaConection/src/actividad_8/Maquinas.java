package actividad_8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Maquinas {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS maquinas_registradoras;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE maquinas_registradoras("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"piso INT"+
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
			String query = "INSERT INTO maquinas_registradoras (piso) values"+
						"(1),"+
						"(2),"+
						"(3),"+
						"(4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
