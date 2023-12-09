package munchkin;

/*! @brief Class qui permet de modélisé une carte de type Equipement */
class Equipement extends Carte {
	/*--------------------- Attributs ---------------------*/
	private int bonus;
	private int pieceOr;
	private int typeEquipement;
	
	/*--------------------- Constructeur ---------------------*/	
	
	/*! @brief Constructeur par défaut
	 *  
	 * Comportement :
	 * Initialise l'objet équipement avec des valeurs par défauts.
	 * Quand ce dernier est initialisé de cette manière il compte comme un équipement null.
	 * */
	public Equipement() {
		nom = "Pas d'équipement";
		type = 1; // 1 Car quand on crée une carte equipement le type est forcément equipement
		bonus = 0; // Aucun bonus par défaut
		pieceOr = 0; // 100 pièce d'or par défaut
		typeEquipement = 0; // Equipement 1 par défaut
	}
	
	/*! @brief Constructeur par affectation
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs données.
	 * */
	public Equipement(String nom_, int typeEquipement_, int bonus_, int pieceOr_) {
		nom = nom_;
		type = 1; // 1 Car quand on crée une carte equipement le type est forcément equipement
		bonus = bonus_;
		pieceOr = pieceOr_;
		typeEquipement = typeEquipement_;
	}
	
	/*! @brief Constructeur par recopie
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec un autre objet carte donnée.
	 * */
	public Equipement(Equipement carte) {
		nom = carte.nom;
		type = carte.type; 
		bonus = carte.bonus;
		pieceOr = carte.pieceOr;
		typeEquipement = carte.typeEquipement;
	}
	
	/*--------------------- Getters ---------------------*/	

	/*! @brief Getters qui permet de récupérer la valeur de bonus
	 */
	public int getBonus() {
		return bonus;
	}
	
	/*! @brief Getters qui permet de récupérer la valeur de pieceOr
	 */
	public int getPieceOr() {
		return pieceOr;
	}
	
	/*! @brief Getters qui permet de récupérer la valeur de typeEquipement
	 */
	public int getTypeEquipement() {
		return typeEquipement;
	}
	
	/*--------------------- Method ---------------------*/	

	/*! @brief Methode qui permet d'afficher proprement la carte
	 * 
	 * Comportement : 
	 * Affiche tout les attributs de la cartes.
	 * */
	public void displayCard() {
		System.out.println("Nom : "+ nom + 
				"\nType : " + listeTypeCarte[type] + 
				"\nType d'équipement : " + listeTypeEquipement[typeEquipement] + 
				"\nBonus : " + bonus + 
				"\nPièces d'or : " + pieceOr + "\n");
	} 

}

