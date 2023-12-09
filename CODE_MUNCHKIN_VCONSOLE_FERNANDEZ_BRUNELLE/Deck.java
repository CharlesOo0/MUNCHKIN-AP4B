package munchkin;
import java.util.*;

/*! @brief Class qui permet de modélisé un deck de cartes */
public class Deck {
	/*--------------------- Attributs ---------------------*/
	protected static final Carte deckDonjonDefautUTBM[] = Constants.deckDonjonDefautUTBM_; // Deck donjon avec l'extension UTBM par défaut (Voir classe Constants pour connaitre la valeur)
	protected static final Carte deckTresorDefautUTBM[] = Constants.deckTresorDefautUTBM_; // Deck tresors avec l'etension UTBM par défaut (Voir classe Constants pour connaitre la valeur)

	protected String nomDeck; // Le nom du packet, utile pour différencier pile Trésor, pile Donjon.
	protected Stack<Carte> deck; // Le deck de cartes.
	protected int nbCarte; // Le nombres de cartes dans le paquet

	
	/*--------------------- Constructeurs ---------------------*/
	
	/*! @brief Le constructeur par défaut
	 * 
	 * Comportement :
	 * Initialise une défausse
	 * */
	public Deck() {
		nomDeck = "Défausse";
		deck = new Stack<Carte>(); // Initialise le deck
		nbCarte = 0;
	}
	
	/*! @brief Le constructeur par recopie
	 * 
	 * Comportement :
	 * Initialise un deck à partir d'un autre deck.
	 * */
	public Deck(Deck deck_) {
		nomDeck = deck_.nomDeck;
		deck = deck_.deck; // Initialise le deck
		nbCarte = deck_.nbCarte;
	}
	
	/*! @brief Le constructeur par affectation
	 * 
	 * Comportement :
	 * Initialise un deck à partir de valeur donnée.
	 * Peux recommandé, à utiliser pour jouer avec des cartes customisé.
	 * Mais dans ce cas la il est préférable d'utiliser le constructeur fait pour les sets de jeux "MODEE".
	 * */
	public Deck(String nomDeck_, Stack<Carte> deck_, int nbCarte_) {
		nomDeck = nomDeck_;
		deck = deck_; // Initialise le deck
		nbCarte = nbCarte_;
	}
	
	/*! @brief Le constructeur par défaut deck Donjon / Trésor
	 *  @param optionConstruction Un entier 0/1/2 qui permet de connaître le choix de construction du deck.
	 * 
	 * Comportement :
	 * Construit le deck avec des valeurs par défauts qui varie selon le choix de construction choisi.
	 * Si 0 on initialise un deck de carte Donjon,
	 * Si 1 on initialise un deck de carte Trésor,
	 * Sinon initialise une défausse.
	 * */
	public Deck(int optionConstruction) {
		
		if (optionConstruction == 0) { // Si l'option choisi est 0
			
			nomDeck = "Donjon"; // Le nom du deck est donjon
			nbCarte = deckDonjonDefautUTBM.length; //  la taille du deck est celle du deck donjon UTBM
			deck = new Stack<Carte>(); // Initialise le deck
			for(int i=0; i<nbCarte; ++i) { // On push toutes les cartes du deck donjon UTBM dans notre pile
				deck.push(deckDonjonDefautUTBM[i]);
			}
			
			Collections.shuffle(deck); // Mélange le deck
			
		}else if(optionConstruction == 1) { // Si l'option choisi est 1
			
			nomDeck = "Trésor"; // Le nom du deck est trésor
			nbCarte = deckTresorDefautUTBM.length; //  la taille du deck est celle du deck trésor UTBM
			deck = new Stack<Carte>(); // Initialise le deck
			for(int i=0; i<nbCarte; ++i) { // On push toutes les cartes du deck trésor UTBM dans notre pile
				deck.push(deckTresorDefautUTBM[i]);
			}
			
			Collections.shuffle(deck); // Mélange le deck
			
		}else { // Sinon
			nomDeck = "Défausse"; // Le nom du deck est défausse
			deck = new Stack<Carte>(); // Initialise le deck			
			nbCarte = 0; // Elle commence avec 0 carte de manière logique
		}
		
	}
	
	/*! @brief Le constructeur par défaut deck Donjon / Trésor VERSION AVEC CARTES CUSTOMISEES
	 *  @param optionConstruction Un entier 0/1/2 qui permet de connaître le choix de construction du deck.
	 * 
	 * Comportement :
	 * Construit le deck avec des valeurs par défauts qui varie selon le choix de construction choisi.
	 * Si 0 on initialise un deck de carte Donjon,
	 * Si 1 on initialise un deck de carte Trésor,
	 * Sinon initialise une défausse.
	 * */
	public Deck(int optionConstruction, Carte deckDonjonCUSTOMISE[], Carte deckTresorCUSTOMISE[]) {
		
		if (optionConstruction == 0) { // Si l'option choisi est 0
			
			nomDeck = "Donjon"; // Le nom du deck est donjon
			nbCarte = deckDonjonDefautUTBM.length; //  la taille du deck est celle du deck donjon UTBM
			deck = new Stack<Carte>(); // Initialise le deck
			for(int i=0; i<nbCarte; ++i) { // On push toutes les cartes du deck donjon UTBM dans notre pile
				deck.push(deckDonjonDefautUTBM[i]);
			}
			
			Collections.shuffle(deck); // Mélange le deck
			
		}else if(optionConstruction == 1) { // Si l'option choisi est 1
			
			nomDeck = "Donjon"; // Le nom du deck est trésor
			nbCarte = deckTresorDefautUTBM.length; //  la taille du deck est celle du deck trésor UTBM
			deck = new Stack<Carte>(); // Initialise le deck
			for(int i=0; i<nbCarte; ++i) { // On push toutes les cartes du deck trésor UTBM dans notre pile
				deck.push(deckTresorDefautUTBM[i]);
			}
			
			Collections.shuffle(deck); // Mélange le deck
			
		}else { // Sinon
			nomDeck = "Défausse"; // Le nom du deck est défausse
			deck = new Stack<Carte>(); // Initialise le deck			
			nbCarte = 0; // Elle commence avec 0 carte de manière logique
		}
		
	}
	
	/*--------------------- Setter ---------------------*/
	
	/*! @brief Methode push pour le deck */
	public void push(Carte carte) {
		deck.push(carte);
	}
	
	/*--------------------- Method ---------------------*/
	
	/*! @brief Cette method permet d'afficher le deck
	 * 
	 * Comprotement :
	 * Utilise les methods toString présentes dans Stack nativement et celle implémenté pour la class Carte,
	 * pour afficher le deck.
	 * */
	public void displayDeck() {
		System.out.println(nbCarte +" Cartes, "+ nomDeck + " :\n" + deck.toString());
	}
	
	/*! @brief Cette methode permet de voir la première carte du deck
	 *  @return Renvoie la première carte du deck, si le deck est vide renvoie null
	 *  
	 * Comportement :
	 * Si le deck n'est pas vide renvoie la première carte du deck sans l'enlever du deck,
	 * Sinon renvoie null.
	 */
	public Carte peek() {
		// If else abréger pour réalisé ce que décris le comportement
		return (deck.isEmpty()) ? null : deck.peek();
	}
	
	/*! @brief Cette methode permet de piocher la première carte du deck
	 *  @return Renvoie la première carte du deck, si le deck est vide renvoie null
	 *  
	 * Comportement :
	 * Si le deck n'est pas vide renvoie la première carte du deck en enlevant la carte du deck,
	 * Sinon renvoie null.
	 */
	public Carte draw() {
		// If else abréger pour réalisé ce que décris le comportement
		if (deck.isEmpty()) {
			return null;
		} else {
			nbCarte -= 1;
			return deck.pop();
		}
	}
	
	/*! @brief cette méthode permet de mélanger le deck
	 * 
	 * Comportement :
	 * Utilise la méthode shuffle présente dans collections pour mélanger le deck.
	 * */
	public void shuffle() {
		Collections.shuffle(deck); // Mélange le deck
	}
	
	/*! @brief Method qui permet de savoir si un deck est vide
	 *  @return true si le deck est vide sinon false
	 * 
	 * Comportement :
	 * Utilise isEmpty qui est natif au type Stack pour savoir si le Stack deck est vide.
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}
	
	/*! @brief Methode toString permettant de retourner un deck sous la forme d'un chaîne de caractère
	 * 
	 *  Comportement :
	 *  Itère à travers toutes les cartes du deck et affiche leurn nom.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(); // Crée notre string
		sb.append("Deck " + nomDeck +" :\n");
		sb.append("["); // Rajoute le crochet de début de deck
		for (int i = 0; i < deck.size(); ++i) { // Itère à travers le deck
			sb.append(deck.get(i)); // Rajoute le nom de la carte
			if (i != deck.size()-1) sb.append(", "); // Rajoute une ,
		}
		sb.append("]"); // Rajoute le crochet de fin de deck
			
		return sb.toString();
	}
}
