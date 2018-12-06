package dev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareSateConnectionLivre {

	public static void main(String[] args) {

		readData(1,6);

	}

	public static void readData(Integer id1, Integer id2) {

		Connection connect = null;
		PreparedStatement prepareStatement = null;

		try {

			connect = ConnectionLivre.getConnection();

			// On crée la requête
			String query = "SELECT * FROM categorie WHERE id = ? OR nom_categorie = ?";

			// On crée l'objet avec la requête en paramètre
			prepareStatement = connect.prepareStatement(query);

			// On remplace le premier paramètre (dans cette requête il n'y a qu'un seul
			// praramètre par le nom de la classe
			prepareStatement.setInt(1, id1);
			prepareStatement.setInt(2, id2);

			ResultSet resultSet = prepareStatement.executeQuery();

			// On affiche la requête exécutée
			System.out.println(prepareStatement.toString());

			while (resultSet.next()) {
				System.out
						.print("\t" + resultSet.getInt("id") + "\t\t" + resultSet.getString("nom_categorie") + "\r\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
