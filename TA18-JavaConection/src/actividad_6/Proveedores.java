package actividad_6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedores {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS proveedores;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE proveedores("+
						"id CHAR(4) PRIMARY KEY,"+
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
			String query = "INSERT INTO proveedores (id,nombre) values"+
						"('001A','proveedor1'),"+
						"('002B','proveedor2'),"+
						"('003C','proveedor3'),"+
						"('004D','proveedor4');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
