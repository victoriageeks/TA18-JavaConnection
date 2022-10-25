package actividad_8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Venta {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS ventas;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE ventas("+
						"cajero INT,"+
						"maquina INT,"+
						"producto INT,"+
						"FOREIGN KEY(cajero) REFERENCES cajeros(codigo),"+
						"FOREIGN KEY(maquina) REFERENCES maquinas_registradoras(codigo),"+
						"FOREIGN KEY(producto) REFERENCES productos(codigo)"+
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
			String query = "INSERT INTO ventas (cajero,maquina,producto) values"+
						"(1,1,1),"+
						"(2,2,2),"+
						"(3,3,3),"+
						"(4,4,4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}