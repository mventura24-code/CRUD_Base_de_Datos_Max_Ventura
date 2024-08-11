package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.MariaDbManager;

public class EstudiantesDao {

	public static void leerEstudiantes() {
		Connection conn = MariaDbManager.getConnection();
		if (conn != null) {
			try {

				String consulta = "Select *from colegio.estudiantes";

				PreparedStatement statement = conn.prepareStatement(consulta);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String pNombre = resultSet.getString("nombre");
					String pApellido = resultSet.getString("apellido");
					String pfechanac = resultSet.getString("fecha_nacimiento");
					String pgenero = resultSet.getString("genero");
					String pdireccion = resultSet.getString("direccion");
					String ptelefono = resultSet.getNString("telefono");
					String pmail = resultSet.getNString("correo_electronico");
					String pgrado = resultSet.getNString("grado");
					String pfecInscripcion = resultSet.getNString("fecha_inscripcion");
					System.out.println("ID: " + id + " Nombre: " + pNombre + " " + pApellido +
							" Nacio: "+ pfechanac + " género: "+ pgenero + " domicilio: "+ pdireccion+ 
							" telefono: "+ ptelefono+ " email: "+ pmail+ " grado: "+pgrado+ " Fecha inscripcion: "+
							pfecInscripcion);
				}
				resultSet.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error al leer estudiantes: " + e.getMessage());
			}
		} else {
			System.out.println("No se pudo establecer la conexión.");
		}

	}
}