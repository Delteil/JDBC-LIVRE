package jdbc.livre;

import java.util.Scanner;

public class MainCategorieLivre {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CategorieLivre categorie = new CategorieLivre();

		int choix = 0;
		String nom = null;

		while (choix != 99) {

			System.out.println("\" ***** Liste des catégories de livres ***** \r\n"
					+ "1. Afficher la liste des catégories\r\n" + "2. Ajouter une nouvelle catégorie\r\n"
					+ "3. Modifier une catégorie\r\n" + "4. Supprimer une catégorie\r\n" + "99. Fin - Sortir ");

			choix = Integer.parseInt(sc.nextLine());

			if (choix == 1) {

				categorie.afficheCategorieLivre();
				System.out.println();
			}

			if (choix == 2) {

				System.out.println("Veuillez saisir le nom de la categorie à ajouter");
				nom = sc.nextLine();

				categorie.insertCategorieLivre(nom);

				categorie.afficheCategorieLivre();
				System.out.println();

			}

			if (choix == 3) {

				System.out.println("Veuillez saisir le nom de la categorie à modifier");
				String oldName = sc.nextLine();
				System.out.println("Veuillez saisir le nom de la nouvelle categorie");
				String newName = sc.nextLine();

				categorie.updateCategorieLivre(oldName, newName);

				categorie.afficheCategorieLivre();
				System.out.println();

			}

			if (choix == 4) {

				System.out.println("Veuillez saisir l'identifiant de la categorie à supprimer");
				int id = Integer.parseInt(sc.nextLine());

				categorie.deleteCategorieLivre(id);

				categorie.afficheCategorieLivre();
				System.out.println();

			}
		}
		sc.close();
	}
}
