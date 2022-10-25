package actividad_4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Salas {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS salas;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE salas("+
						"codigo INT PRIMARY KEY AUTO_INCREMENT,"+
						"nombre VARCHAR(100),"+
						"pelicula INT,"+
						"FOREIGN KEY(pelicula) REFERENCES peliculas(codigo)"+
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
			String query = "INSERT INTO salas (nombre,pelicula) values"+
						"('sala1',1),"+
						"('sala2',2),"+
						"('sala3',3),"+
						"('sala4',4);";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}
