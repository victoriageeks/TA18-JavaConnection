package actividad_6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Suministra {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS suministra;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE suministra("+
						"codigo_pieza INT,"+
						"id_proveedor CHAR(4),"+
						"precio INT,"+
						"FOREIGN KEY(codigo_pieza) REFERENCES piezas(codigo),"+
						"FOREIGN KEY(id_proveedor) REFERENCES proveedores(id)"+
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
			String query = "INSERT INTO suministra (codigo_pieza,id_proveedor,precio) values"+
						"(1,'001A',50),"+
						"(2,'002B',60),"+
						"(3,'003C',70),"+
						"(4,'004D',80);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
