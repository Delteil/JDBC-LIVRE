package dev.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class StateConnectionLivre {

	public static void main(String[] args) {

		readData();

	}

	public static void readData() {
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

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
		} 
		finally {
			try {
				resultSet.close();
				statement.close();
				connect.close();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
