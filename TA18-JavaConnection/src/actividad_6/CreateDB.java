package actividad_6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDB {
	
	public void createDB() {
		//añadimos una conexión con el mainApp
		Connection c = mainApp.conexion;
		
		try {
			//Si existe la DB la borramos.
			String query = "DROP DATABASE IF EXISTS ta18_piezas_proveedores";
			Statement st = c.createStatement();
			st.executeUpdate(query);
			
			//Creamos la base de datos.
			query = "CREATE DATABASE ta18_piezas_proveedores";
			st.executeUpdate(query);
			
			//Hacemos uso de la base de datos.
			String querydb = "USE ta18_piezas_proveedores";
			Statement stdb = c.createStatement();
			stdb.executeUpdate(querydb);
			
			System.out.println("Base de datos creada.");
			
		}catch(SQLException ex) {
			Logger.getLogger(mainApp.class.getName()).log(Level.SEVERE,null,ex);
			System.out.println("No se ha podido crear la base de datos.");
		}
	}
}
