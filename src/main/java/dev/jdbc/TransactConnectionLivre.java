package dev.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactConnectionLivre {

	public static void main(String[] args) {
		
		try {
			updateData();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public static void updateData() throws SQLException {
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			
			connect = ConnectionLivre.getConnection();
			connect.setAutoCommit(false); // pour ne pas commiter automatiquement
						
			// Création d'un objet Statement permettant de réaliser des requêtes sur la base de données
			statement = connect.createStatement();
			
			// On crée la requête
			String query = "UPDATE categorie SET nom_categorie = 'Policier' WHERE id = 1";
			
			Integer update = statement.executeUpdate(query);
			System.out.println("Résultat de la requête UPDATE => " + update.intValue());
			
			// On crée la requête
			query = "UPDATE categorie SET nom_categorie = 'Thriller' WHERE id = 1";
			
			update = statement.executeUpdate(query);
			System.out.println("Résultat de la requête UPDATE => " + update.intValue());

			// les requêtes qui n'ont pas été annulées sont validées
			connect.commit();

		} catch (Exception e) {
			connect.rollback();
			e.printStackTrace();
		}finally {
			statement.close();
			connect.close();
		}
		
		
		
		

	}
}
