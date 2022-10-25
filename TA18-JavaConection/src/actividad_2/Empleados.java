package actividad_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Empleados {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS empleados;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE empleados("+
						"DNI VARCHAR(8) PRIMARY KEY,"+
						"nombre VARCHAR(100),"+
						"apellidos VARCHAR(255),"+
						"departamento INT,"+
						"FOREIGN KEY(departamento) REFERENCES departamentos(codigo)"+
						");";
			st.executeUpdate(query);
			
			System.out.println("Tabla creada.");
			
		}catch(SQLException ex) {
			System.out.println("No se ha podido crear la tabla.");
		}
		
	}
	
	public void insertTable() {
		Connection c = mainApp.conexion;
		
		try {
			String query = "INSERT INTO empleados (DNI,nombre,apellidos,departamento) values"+
						"('39878901','Joel','Exposito',1),"+
						"('39878902','Victoria','Lavega',2),"+
						"('39878903','Bárbara','Recasens',3),"+
						"('39878904','Selena','Gomez',4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
	
}