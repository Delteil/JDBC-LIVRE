package jdbc.livre;

public class Categorie {
	
	// attributs de la classe Categorie
	
	protected int id;
	protected String nom_categorie = "";
	
	// génération du constructeur
	
	/**
	 * 
	 * @param id
	 * @param nom_categorie
	 */
	
	public Categorie(int id, String nom_categorie) {
		this.id = id;
		this.nom_categorie = nom_categorie;
	}

	// méthode toString
	
	@Override
	public String toString() {
		return "Categorie [id = " + id + ", nom_categorie = " + nom_categorie + "]";
	}
	
	// getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}

}
