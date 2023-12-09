package munchkin;

/*! @brief Class qui permet de modélisé une carte de type Race */
public class Race extends Carte {
	/*--------------------- Attributs ---------------------*/
	private int effet;
	
	/*--------------------- Constructeur ---------------------*/	
	
	/*! @brief Constructeur par défaut
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs par défauts.
	 * */
	public Race() {
		nom = "Race";
		type = 2; // 2 Car quand on crée une carte race le type est forcément race
		effet = 0; // Effet 1 par défaut
	}
	
	/*! @brief Constructeur par affectation
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs données.
	 * */
	public Race(String nom_, int effet_) {
		nom = nom_;
		type = 2; // 2 Car quand on crée une carte race le type est forcément race
		effet = effet_;
		
	}
	
	/*! @brief Constructeur par recopie
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec un autre objet carte donnée.
	 * */
	public Race(Race carte) {
		nom = carte.nom;
		type = carte.type;
		effet = carte.effet;
	}

	/*--------------------- Setter ---------------------*/	
	
	/*! @brief Getter de l'attribut effet */
	public int getEffect(){
		return effet;
	}
	
	/*--------------------- Method ---------------------*/	

	/*! @brief Methode qui permet d'afficher proprement la carte
	 * 
	 * Comportement : 
	 * Affiche tout les attributs de la cartes.
	 * */
	public void displayCard() {
		System.out.println("Nom : "+ nom + "\nType : " + 
				listeTypeCarte[type] + "\nEffet : " + 
				listeEffetRace[effet] + "\n");
	} 
}
