package actividad_7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cientificos {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS cientificos;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cientificos("+
						"DNI VARCHAR(8) PRIMARY KEY,"+
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
			String query = "INSERT INTO cientificos (DNI,nom_apels) values"+
						"('39878091','Joel Exposito'),"+
						"('39878092','Victoria Lavega'),"+
						"('39878093','Selena Gomez'),"+
						"('39878094','Justin Bieber');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}

