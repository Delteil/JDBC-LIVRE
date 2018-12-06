package jdbc.livre;

public interface ICategorieDAO {

	void afficheCategorieLivre();

	void insertCategorieLivre(String nom);

	void updateCategorieLivre(String oldName, String newName);

	void deleteCategorieLivre(int id);
}
