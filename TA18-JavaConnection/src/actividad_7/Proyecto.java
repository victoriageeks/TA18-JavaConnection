package actividad_7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Proyecto {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS proyecto;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE proyecto("+
						"id CHAR(4) PRIMARY KEY,"+
						"nombre varchar(255),"+
						"horas INT"+
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
			String query = "INSERT INTO proyecto (id,nombre,horas) values"+
						"('001A','proyecto1',10),"+
						"('002B','proyecto2',12),"+
						"('003C','proyecto3',8),"+
						"('004D','proyecto4',11);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
