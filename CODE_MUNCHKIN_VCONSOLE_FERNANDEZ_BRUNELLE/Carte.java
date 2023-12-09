package munchkin;

/*! @brief Class qui permet de modélisé une carte */
abstract class Carte {
	/*--------------------- Attributs ---------------------*/
	protected static final String[] listeTypeCarte = Constants.listeTypeCarte_; // Constante globale pour les types de cartes (Voir classe Constants pour connaitre la valeur)
	protected static final String[] listeTypeEquipement = Constants.listeTypeEquipement_; // Constante globale pour les types d'equipements (Voir classe Constants pour connaitre la valeur)
	protected static final String[] listeEffetRace = Constants.listeEffetRace_; // Constante globale pour les types d'equipements (Voir classe Constants pour connaitre la valeur)
	protected static final String[] listeEffetMalediction = Constants.listeEffetMalediction_; // Constante globale pour les types d'equipements (Voir classe Constants pour connaitre la valeur)


	protected String nom; // Nom de la carte
	protected int type; // 0, 1, 2, 3 = Monstre, Equipement, Race, Malédiction
	
	/*--------------------- Constructeur ---------------------*/	
	
	/*! @brief Constructeur par défaut
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs par défauts.
	 * */
	public Carte() {
		nom = "Casquette de développeur";
		type = 1; 
	}
	
	/*! @brief Constructeur par affectation
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs données.
	 * */
	public Carte(String nom_, int type_) {
		nom = nom_;
		type = type_; 
	}
	
	/*! @brief Constructeur par recopie
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec un autre objet carte donnée.
	 * */
	public Carte(Carte carte) {
		nom = carte.nom;
		type = carte.type; 
	}
	
	/*--------------------- Getter ---------------------*/	
	
	/*! @brief Getter de l'attribut type */
	public int getType() {
		return type;
	}
	
	/*--------------------- Method ---------------------*/	

	public abstract void displayCard(); /* Methode abstract qui permet d'afficher la carte */
	
	/*! @brief toString permet de transformer l'objet en une chaine de caractère qui le décrit
	 * @return Renvoie le nom de la carte sous forme de string
	 * 
	 * Comportement : 
	 * Renvoie seulement le nom de la carte cette méthod sert uniquement quand en veux afficher un deck proprement.
	 * */
	public String toString() {
		return nom;
	}
	
}
