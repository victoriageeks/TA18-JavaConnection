package actividad_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainApp {

	static Connection conexion;
	public static void main(String[] args) {
		CreateDB cdb = new CreateDB();
		Fabricantes f = new Fabricantes();
		Articulos a = new Articulos();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.147:3306?useTimezone=true&serverTimezone=UTC","remote","yyxIMZgn3:b");
			System.out.println("Servidor conectado.");
			
			cdb.createDB();
			
			f.createTable();
			f.insertTable();
			
			a.createTable();
			a.insertTable();
			
			closeConnection();
			
		}catch(SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar a mi base de datos.");
			System.out.println(ex);
		}
	}
	
	//Método que finaliza la conexión a mysql
	public static void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexión con mi base de datos.");
		}catch(SQLException ex) {
			Logger.getLogger(mainApp.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}

}
