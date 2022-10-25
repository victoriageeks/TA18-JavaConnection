package actividad_5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Directores {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS directores;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE directores("+
						"DNI VARCHAR(8) PRIMARY KEY,"+
						"nom_apels VARCHAR(255),"+
						"DNI_jefe VARCHAR(8),"+
						"despacho INT,"+
						"FOREIGN KEY(despacho) REFERENCES despachos(numero),"+
						"FOREIGN KEY(DNI_jefe) REFERENCES directores(DNI)"+
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
			String query = "INSERT INTO directores (DNI,nom_apels,DNI_jefe,despacho) values"+
						"('38909761','joel exposito','38909761',1),"+
						"('38909762','victoria lavega','38909762',2),"+
						"('38909763','bárbara recasens',null,3),"+
						"('38909764','justin bieber',null,4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
