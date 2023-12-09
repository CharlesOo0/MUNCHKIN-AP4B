package munchkin;

/*! @brief Class qui permet de modélisé un plateau de jeu avec tout les decks */
public class Board {
	/*--------------------- Attributs ---------------------*/
	protected Deck defausseDonjon; // Defausse pour les cartes donjons
	protected Deck defausseTresor; // Defausse pour les cartes trésors
	protected Deck piocheDonjon; // pioche pour les cartes donjons
	protected Deck piocheTresor; // pioche pour les cartes trésors
	
	/*--------------------- Constructeurs ---------------------*/
	
	/*! @brief Constructeur par défaut
	 * 
	 * Comportement :
	 * Initialise tout les decks avec leur valeur par défaut idéal pour crée une partie !
	 * */
	public Board() {
		defausseDonjon = new Deck(); // Initialise une défausse
		defausseTresor = new Deck(); // Initialise une défausse
		piocheDonjon = new Deck(0); // Initialise un deck donjon avec le set UTBM
		piocheTresor = new Deck(1); // Initialise un deck trésor avec le set UTBM
	}
	
	/*! @brief Constructeur par défaut avec set de jeux CUSTOMISEE
	 * 
	 * Comportement :
	 * Initialise tout les decks avec leur valeur par défaut idéal pour crée une partie !
	 * */
	public Board(Carte deckDonjonCUSTOMISE[], Carte deckTresorCUSTOMISE[]) {
		defausseDonjon = new Deck(); // Initialise une défausse
		defausseTresor = new Deck(); // Initialise une défausse
		piocheDonjon = new Deck(0,deckDonjonCUSTOMISE, deckTresorCUSTOMISE); // Initialise un deck donjon avec un set de jeux customisé
		piocheTresor = new Deck(1,deckDonjonCUSTOMISE, deckTresorCUSTOMISE); // Initialise un deck trésor avec un set de jeux customisé
	}
	
	/*--------------------- Getters ---------------------*/
	
	/*! @brief Getter pour pioche donjon
	 * 
	 * Comportement :
	 * Retourne le deck donjon.
	 */
	public Deck getDonjon() {
		return piocheDonjon;
	}
	
	/*! @brief Getter pour pioche tresor
	 * 
	 * Comportement :
	 * Retourne le deck tresor.
	 */
	public Deck getTresor() {
		return piocheTresor;
	}
	
/*--------------------- Setters ---------------------*/
	
	/*! @brief Setter pour pioche donjon
	 * 
	 * Comportement :
	 * Affecte la defausse donjon au deck donjon et vide la defausse
	 */
	public void defaussePiocheDonjon() {
		piocheDonjon = defausseDonjon;
		defausseDonjon = new Deck(); // Reset la defausse
	}
	
	/*! @brief Setter pour pioche tresor
	 * 
	 * Comportement :
	 * Affecte la defausse tresor au deck tresor et vide la defausse
	 */
	public void defaussePiocheTresor() {
		piocheTresor = defausseTresor;
		defausseTresor = new Deck(); // Reset la defausse
	}
	
	/*! @brief Push une carte dans la defausse donjon 
	 *  @param carte La carte a push
	 * */
	public void addDefausseDonjon(Carte carte) {
		defausseDonjon.push(carte);
	}
	
	/*! @brief Push une carte dans la defausse tresor 
	 *  @param carte La carte a push
	 * */
	public void addDefausseTresor(Carte carte) {
		defausseTresor.push(carte);
	}
	
	/*--------------------- Method ---------------------*/
	
	/*! @brief Method qui permet de piocher une carte dans la pioche trésor
	 *  @return Renvoie la carte piocher par le deck 
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide met la defausse dans le deck et renvoie la première carte du deck
	 * sinon renvoie simplement la carte du dessus du deck en l'enlevant.
	 */
	public Carte drawPiocheTresor() {
		if (piocheTresor.isEmpty()) {
			defaussePiocheTresor();
			return piocheTresor.draw();
		} else {
			return piocheTresor.draw();
		}
	}
	
	/*! @brief Method qui permet de piocher une carte dans la pioche donjon
	 *  @return Renvoie la carte piocher par le deck 
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide met la defausse dans le deck et renvoie la première carte du deck
	 * sinon renvoie simplement la carte du dessus du deck en l'enlevant.
	 */
	public Carte drawPiocheDonjon() {
		if (piocheDonjon.isEmpty()) {
			defaussePiocheDonjon();
			return piocheDonjon.draw();
		} else {
			return piocheDonjon.draw();
		}
	}
	
	/*! @brief Method qui permet de piocher une carte dans la defausse donjon
	 *  @return Renvoie la carte piocher par le deck ou null si le deck est vide.
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide renvoie null pour le signifier à l'appelant,
	 * sinon renvoie la carte du dessus en l'enlevant.
	 */
	public Carte drawDefausseDonjon() {
		// If else abréger qui réalise ce qui est décris par le comportement.
		return (defausseDonjon.isEmpty()) ? null: defausseDonjon.draw();
	}
	
	/*! @brief Method qui permet de piocher une carte dans la defausse donjon
	 *  @return Renvoie la carte piocher par le deck ou null si le deck est vide.
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide renvoie null pour le signifier à l'appelant,
	 * sinon renvoie la carte du dessus en l'enlevant.
	 */
	public Carte drawDefausseTresor() {
		// If else abréger qui réalise ce qui est décris par le comportement.
		return (defausseTresor.isEmpty()) ? null: defausseTresor.draw();
	}
	
	/*! @brief Method qui permet de regarder la première carte de la defausse donjon
	 *  @return Renvoie la première carte du deck ou null si le deck est vide.
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide renvoie null pour le signifier à l'appelant,
	 * sinon renvoie la carte du dessus sans l'enlever.
	 */
	public Carte peekDefausseDonjon() {
		// If else abréger qui réalise ce qui est décris par le comportement.
		return (defausseDonjon.isEmpty()) ? null: defausseDonjon.peek();
	}
	
	/*! @brief Method qui permet de regarder la première carte de la defausse trésor
	 *  @return Renvoie la première carte du deck ou null si le deck est vide.
	 * 
	 * Comportement :
	 * Vérifie si le deck est vide,
	 * si le deck est vide renvoie null pour le signifier à l'appelant,
	 * sinon renvoie la carte du dessus sans l'enlever.
	 */
	public Carte peekDefausseTresor() {
		// If else abréger qui réalise ce qui est décris par le comportement.
		return (defausseTresor.isEmpty()) ? null: defausseTresor.peek();
	}
	
	/*! @brief Permet de savoir si la pioche donjon est vide
	 * 
	 * Comportement :
	 * Utilise la méthode isEmpty sur la pioche donjon.
	 */
	public boolean isEmptyPiocheDonjon() {
		return piocheDonjon.isEmpty();
	}
	
	/*! @brief Permet de savoir si la pioche tresor est vide
	 * 
	 * Comportement :
	 * Utilise la méthode isEmpty sur la pioche tresor.
	 */
	public boolean isEmptyPiocheTresor() {
		return piocheTresor.isEmpty();
	}
	
	/*! @brief Permet de savoir si la defausse donjon est vide
	 * 
	 * Comportement :
	 * Utilise la méthode isEmpty sur la defausse donjon.
	 */
	public boolean isEmptyDefausseDonjon() {
		return defausseDonjon.isEmpty();
	}
	
	/*! @brief Permet de savoir si la defausse tresor est vide
	 * 
	 * Comportement :
	 * Utilise la méthode isEmpty sur la defausse tresor.
	 */
	public boolean isEmptyDefausseTresor() {
		return defausseTresor.isEmpty();
	}
}
