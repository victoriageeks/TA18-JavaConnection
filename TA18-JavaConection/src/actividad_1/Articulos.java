package actividad_1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Articulos {

	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS articulos;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE articulos("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100),"+
						"precio INT,"+
						"fabricante INT,"+
						"FOREIGN KEY(fabricante) REFERENCES fabricantes(codigo)"+
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
			String query = "INSERT INTO articulos (nombre,precio,fabricante) values"+
						"('articulo1',12,1),"+
						"('articulo2',15,2),"+
						"('articulo3',20,3),"+
						"('articulo4',10,4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}