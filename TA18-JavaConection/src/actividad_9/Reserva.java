package actividad_9;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Reserva {
	public void createTable() {
		Connection c = mainApp.conexion;
		
		try {		
			String query = "DROP TABLE IF EXISTS reserva;";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			query = "CREATE TABLE reserva("+
						"DNI VARCHAR(8),"+
						"num_serie CHAR(4),"+
						"comienzo DATE,"+
						"fin DATE,"+
						"FOREIGN KEY(DNI) REFERENCES investigadores(DNI),"+
						"FOREIGN KEY(num_serie) REFERENCES equipos(num_serie)"+
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
			String query = "INSERT INTO reserva (DNI,num_serie,comienzo,fin) values"+
						"('39876501','001A','2022-10-15','2022-10-17'),"+
						"('39876502','002B','2022-10-17','2022-10-19'),"+
						"('39876503','003C','2022-10-20','2022-10-24'),"+
						"('39876504','004D','2022-10-29','2022-10-31');";
			
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			System.out.println("Datos insertados correctamente.");
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error al insertar los datos.");
		}
	}
}