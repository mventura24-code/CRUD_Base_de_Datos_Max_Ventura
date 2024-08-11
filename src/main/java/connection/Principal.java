package connection;

import dao.EstudiantesDao;

public class Principal {

	public static void main(String[] args) {
		MariaDbManager.getConnection();
		EstudiantesDao leer = new EstudiantesDao();
		leer.leerEstudiantes();
		MariaDbManager.closeConnection();
		
				
	}

}
