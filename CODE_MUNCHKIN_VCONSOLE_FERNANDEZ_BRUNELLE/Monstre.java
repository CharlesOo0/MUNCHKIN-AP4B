package munchkin;

/*! @brief Class qui permet de modélisé une carte de type Monstre */
class Monstre extends Carte {
	/*--------------------- Attributs ---------------------*/
	private int niveauMonstre;
	private int nbTresor;
	private int niveauPerdu;
	private int niveauGagner;
	
	/*--------------------- Constructeur ---------------------*/	
	
	/*! @brief Constructeur par défaut
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs par défauts.
	 * */
	public Monstre() {
		nom = "Monstre";
		type = 0;
		niveauMonstre = 0;
		nbTresor = 0;
		niveauPerdu = 0;
		niveauGagner = 0;
	}
	
	/*! @brief Constructeur par affectation
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec des valeurs données.
	 * */
	public Monstre(String nom_, int niveauMonstre_, int nbTresor_, int niveauPerdu_, int niveauGagner_) {
		nom = nom_;
		type = 0;  // 0 Car quand on crée une carte monstre le type est forcément monstre
		niveauMonstre = niveauMonstre_;
		nbTresor = nbTresor_;
		niveauPerdu = niveauPerdu_;
		niveauGagner= niveauGagner_;
	}
	
	/*! @brief Constructeur par recopie
	 *  
	 * Comportement :
	 * Initialise l'objet carte avec un autre objet carte donnée.
	 * */
	public Monstre(Monstre carte) {
		nom = carte.nom;
		type = carte.type; 
		niveauMonstre = carte.niveauMonstre;
		nbTresor = carte.nbTresor;
		niveauPerdu = carte.niveauPerdu;
		niveauGagner= carte.niveauGagner;
	}

	/*--------------------- Getter ---------------------*/		
	
	/*! @brief Getter de l'attribut niveauMonstre */
	public int getNiveauMonstre() {
		return niveauMonstre;
	}
	
	/*! @brief Getter qui permet de récupérer le nombre de trésor que fait gagner le monstre */
	public int getNbTresor() {
		return nbTresor;
	}
	
	/*! @brief Getter qui permet de récupérer le nombre de niveau que le monstre fait gagner */
	public int getNiveauGagner() {
		return niveauGagner;
	}
	
	/*! @brief Getter qui permet de récupérer le nombre de niveau que le monstre fait perdre */
	public int getNiveauPerdu() {
		return niveauPerdu;
	}
	
	/*--------------------- Method ---------------------*/	

	/*! @brief Methode qui permet d'afficher proprement la carte
	 * 
	 * Comportement : 
	 * Affiche tout les attributs de la cartes.
	 * */
	public void displayCard() {
		System.out.println("Nom : "+ nom + "\nType : " + 
				listeTypeCarte[type] + "\nNiveau du Monstre : " + 
				niveauMonstre + "\nNombre de trésor à gagné : " + 
				nbTresor + "\nSi défaite perte de " + 
				niveauPerdu + " niveau(x)\nSi victoire gain de " + 
				niveauGagner + " niveau(x)\n" );
	} 
	
}

