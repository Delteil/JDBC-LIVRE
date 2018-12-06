package dev.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionLivre {

	public static void main(String[] args) {

		Connection connect = null;

		try {
			connect = ConnectionLivre.getConnection();

			System.out.println("Connexion établie !");

		} catch (Exception e) {
			
		} finally {
			try {
				connect.close();

			} catch (Exception e2) {

			}
		}
	}

	public static Connection getConnection() throws Exception {

		//DriverManager.setLogWriter(new PrintWriter(System.out));
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3306/formation";
		String user = "root";
		String password = "";

		return DriverManager.getConnection(url, user, password);
	}
}
