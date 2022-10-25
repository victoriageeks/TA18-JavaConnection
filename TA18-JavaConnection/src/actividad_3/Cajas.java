package actividad_3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Cajas {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS cajas;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE cajas("+
						"num_ref CHAR(5),"+
						"contenido VARCHAR(100),"+
						"valor INT,"+
						"almacen INT,"+
						"FOREIGN KEY(almacen) REFERENCES almacenes(codigo)"+
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
			String query = "INSERT INTO cajas (num_ref,contenido,valor,almacen) values"+
						"('001A','contenido1',500,1),"+
						"('002B','contenido2',600,2),"+
						"('003C','contenido3',700,3),"+
						"('004D','contenido4',900,4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}