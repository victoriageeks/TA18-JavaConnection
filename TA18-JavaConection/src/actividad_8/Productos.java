package actividad_8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Productos{
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS productos;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE productos("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100),"+
						"precio INT"+
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
			String query = "INSERT INTO productos (nombre,precio) values"+
						"('producto1',50),"+
						"('producto2',20),"+
						"('producto3',30),"+
						"('producto4',40);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}