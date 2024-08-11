package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbManager {
	
	private static final String URL = "jdbc:mariadb://localhost:3307/colegio";
    private static final String USER = "root";
    private static final String PASSWORD = "ventura";
    
    private static Connection connection;
    
    public static Connection getConnection() {
        //Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa.");
            return connection; 
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el controlador JDBC" + e.toString());
            return null;
    }
}

   public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

