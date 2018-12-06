package jdbc.livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import dev.jdbc.ConnectionLivre;

public class CategorieLivre implements ICategorieDAO {

	Connection connect = null;
	Statement statement = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	int result = 0;

	public void afficheCategorieLivre() {

		try {
			connect = ConnectionLivre.getConnection();

			// Création d'un objet Statement permettant de réaliser des requêtes sur la base
			// de données

			statement = connect.createStatement();

			// L'objet ResultSet contient le résultat de la requête SQL

			resultSet = statement.executeQuery("SELECT * FROM categorie");

			// On récupère les MetaData dans le ResultSet

			ResultSetMetaData resultMetaData = resultSet.getMetaData();

			System.out.println("\r\n====");

			// On affiche le nom des colonnes
			for (int i = 1; i <= resultMetaData.getColumnCount(); i++) {

				System.out.print("\t" + resultMetaData.getColumnName(i).toUpperCase() + "\t");
			}
			System.out.println();

			while (resultSet.next()) {

				System.out.println("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("nom_categorie"));
			}

			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connect.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public void insertCategorieLivre(String nom) {

		try {
			connect = ConnectionLivre.getConnection();
// On crée la requête
			String query = "INSERT INTO categorie (nom_categorie) VALUES (?) ";
// On crée l'objet avec la requête en paramètre
			prepareStatement = connect.prepareStatement(query);
// On remplace le premier paramètre "?" (dans cette requête il n'y a qu'un seul pararamètre par le nom de la classe
			prepareStatement.setString(1, nom);
//On fait executer la requète = retour de la requète
			result = prepareStatement.executeUpdate();
// On affiche la requête exécutée
			// System.out.println(prepareStatement.toString());

		} catch (Exception e) {

		} finally {
			try {
				prepareStatement.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateCategorieLivre(String oldName, String newName) {

		try {

			connect = ConnectionLivre.getConnection();

// On crée la requête
			String query = "UPDATE categorie SET nom_categorie = ? WHERE nom_categorie = ?";
			prepareStatement = connect.prepareStatement(query);

// On remplace le premier paramètre "?" (dans cette requête il n'y a qu'un seul pararamètre par le nom de la classe
			prepareStatement.setString(2, oldName);
			prepareStatement.setString(1, newName);

//On fait executer la requète

			result = prepareStatement.executeUpdate();

			if (result == 0) {
				System.out.println(" **** la categorie n'existe pas **** ");
			}
		} catch (Exception e) {

		} finally {
			try {
				prepareStatement.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteCategorieLivre(int id) {

		try {

			connect = ConnectionLivre.getConnection();
			String query = "DELETE from categorie WHERE id = ?";
			prepareStatement = connect.prepareStatement(query);
			
			prepareStatement.setInt(1, id);
			result = prepareStatement.executeUpdate();

			if (result == 0) {
				System.out.println(" **** la categorie n'existe pas **** ");
			}

		} catch (Exception e) {
		} finally {
			try {
				prepareStatement.close();
				connect.close();
			} catch (Exception e2) {
			}
		}
	}
}
