package munchkin;

import java.util.*;

/*! @brief Class qui permet de modélisé un joueur */
public class Joueur {
	/*--------------------- Attributs ---------------------*/
	
	// Constantes
	public static final int NB_EQUIPEMENT = Constants.NB_EQUIPEMENT_; // Le nombre d'équipement possible du joueurs 5 pour chapeau, t-shirt, pantalon, chaussure, arme. (Voir classe Constants pour connaitre la valeur)
	public static final int NIVEAU_MAX = Constants.NIVEAU_MAX_; // Le niveau max du joueur (Voir classe Constants pour connaitre la valeur)
	public static final int NB_CARTE_CHAQUE_PIOCHE = Constants.NB_CARTE_CHAQUE_PIOCHE_; // Le nombre de carte de chaque pioche qu'il va falloir piocher
	public static final String[] listeRace = Constants.listeRace_; // La liste des races du jeux (Voir classe Constants pour plus de détail)
	
	// Attribut qui définissent le joueur
	protected String nom; // Nom du joueur
	protected int race; // La race du joueur
	protected List<Integer> effet; // La liste des malédictions actif sur le joueurs
	protected Equipement[] equipements; // La liste des equipements du joueurs
	protected List<Carte> main; // Les cartes en mains par le joueur
	protected int niveau; // Niveau du joueur
	Dice dice; // Un dé
	
	// Modificateur / Effet sur le joueur
	protected static int CARTE_MAX = Constants.CARTE_MAX_; // Le nombre de carte maximum que le joueur peux avoir en main (Voir classe Constants pour connaitre la valeur)
	protected static float MULTIPLICATEUR_ARME = 1;
	protected static float MULTIPLICATEUR_CHAPEAU = 1;
	protected static float MULTIPLICATEUR_T_SHIRT = 1;
	protected static float MULTIPLICATEUR_CHAUSSURE = 1;
	protected static float MULTIPLICATEUR_PANTALON = 1;
	protected static int BONUS_DEGAT = 0;


	/*--------------------- Constructeur ---------------------*/
	
	/*! @brief Le constructeur par défaut
	 * 
	 * Comportement : 
	 * Initialise notre joueur avec des valeurs par défauts.
	 */
	public Joueur() {
		nom = "Joueur";
		race = 0; // Par défaut le joueur est de la race 0 (voir class Constants)
		effet = new ArrayList<Integer>(); // Initialise notre liste d'effet à vide
		equipements = new Equipement[NB_EQUIPEMENT]; // Initialise notre liste d'equipements à vide
		for (int i = 0; i < NB_EQUIPEMENT; i++) {
		    equipements[i] = new Equipement(); // Crée une nouvelle instance d'Equipement pour chaque emplacement du tableau
		}
		main = new ArrayList<Carte>(); // Initialise notre main à vide
		niveau = 1; // Par défaut le niveau est 1
		dice = new Dice(); // Initialise le dé
	}
	
	/*! @brief Le constructeur utilisé par le jeu
	 *  @param nom_ Le nom du joueur
	 *  @param board Le plateau avec les différents deck
	 * 
	 * Comportement : 
	 * Initialise notre joueur avec des valeurs par défauts.
	 * Sauf pour la valeur de nom et de main.
	 * nom utilise l'argument nom_ pour s'initialiser.
	 * main utilise les deux decks pour s'initialiser.
	 */
	public Joueur(String nom_, Board board) {
		nom = nom_;
		race = 0; // Par défaut le joueur est de la race 0 (voir class Constants)
		effet = new ArrayList<Integer>(); // Initialise notre liste d'effet à vide
		equipements = new Equipement[NB_EQUIPEMENT]; // Initialise notre liste d'equipements à vide
		for (int i = 0; i < NB_EQUIPEMENT; i++) {
		    equipements[i] = new Equipement(); // Crée une nouvelle instance d'Equipement pour chaque emplacement du tableau
		}
		main = new ArrayList<Carte>(); // Initialise notre main
		for (int i = 0; i < NB_CARTE_CHAQUE_PIOCHE; i++) { // Pioche NB_CARTE_CHAQUE_PIOCHE de chaques pioches et les met dans la main du joueur
			main.add(board.drawPiocheTresor());
			main.add(board.drawPiocheDonjon());
		}
		niveau = 1; // Par défaut le niveau est 1
		dice = new Dice(); // Initialise le dé
	}

	/*--------------------- Getters ---------------------*/

	/*! @brief Permet de récupérer la valeur du bonus du joueur après tous les effets appliquées à ce dernier.
	 *  @return Renvoie le bonus du joueur
	 * 
	 * Comportement :
	 * Ajoute le niveau et tout les bonus conférer par les équipements et par les effets à une variable bonus que l'on renvoie.
	 */
	public int getBonus() {
		int bonus = niveau; // Bonus égale niveau dans un premier temps
		for(int i = 0; i < NB_EQUIPEMENT; i++) { // Puis la somme des bonus de chaque équipement
			switch(i) {
			case 0:
				bonus += equipements[i].getBonus()*MULTIPLICATEUR_CHAPEAU;
				break;
			case 1:
				bonus += equipements[i].getBonus()*MULTIPLICATEUR_T_SHIRT;
				break;
			case 2:
				bonus += equipements[i].getBonus()*MULTIPLICATEUR_PANTALON;
				break;
			case 3:
				bonus += equipements[i].getBonus()*MULTIPLICATEUR_CHAUSSURE;
				break;
			case 4:
				bonus += equipements[i].getBonus()*MULTIPLICATEUR_ARME;
				break;
			default:
				//Erreur
				break;
			}
			// Rajouter altération si on veux ici
		}
		
		bonus += BONUS_DEGAT; 
		// Rajouter autre altération si on veux ici
		return bonus;
	}
	
	/*! @brief Getter pour l'attribut niveau */
	public int getNiveau() {
		return niveau;
	}
	
	/*! @brief Permet de récuperer une carte de la main pour la jouer
	 *  @param index L'index de carte à récupérer
	 * 
	 * Comportement :
	 * Mémorise la carte dans une variable tmp,
	 * Efface la carte de la main,
	 * Renvoie la variable tmp.
	 */
	public Carte getCard(int index) {
		Carte tmp = main.get(index); // Memorise la carte
		main.remove(index); // Enleve la carte de la main
		return tmp; // Retourne la carte
	}
	
	/*! Getter pour l'attribut main */
	public List<Carte> getMain() {
		return main;
	}
	
	/*--------------------- Setters ---------------------*/

	/*! @brief Permet d'enlever l'effet d'une race sur le joueur
	 *  @param race_ La race qui contient l'effet qu'il faut enlever
	 *  
	 *  Comportement : 
	 *  Utilise l'index donnée pour reconnaître l'effet qu'il faut enlever.
	 *  Avec un switch retrouve le bonne effet et l'enleve du joueur.
	 */
	public void unsetRace(int race_) {
		switch(race_) {
		case 0:
			// Enleve effet race 1
			MULTIPLICATEUR_ARME = 1;
			break;
		case 1:
			// Enleve effet race 2
			MULTIPLICATEUR_CHAPEAU = 1;
			break;
		case 2:
			// Enleve effet race 3
			MULTIPLICATEUR_T_SHIRT = 1;
			break;
		case 3:
			// Enleve effet race 4
			MULTIPLICATEUR_PANTALON = 1;
			break;
		case 4:
			// Enleve effet race 1
			MULTIPLICATEUR_CHAUSSURE = 1;
			break;
		case 5:
			// Enleve effet race 2
			BONUS_DEGAT = 0;
			break;
		case 6:
			// Enleve effet race 3
			BONUS_DEGAT = 0;
			break;
		case 7:
			// Enleve effet race 4
			BONUS_DEGAT = 0;
			break;
		default:
			// Erreur
			break;
		}
		return;
	}
	
	/*! @brief Method qui permet de changer la race d'un joueur.
	 *  @param race_ Index de la nouvelle race à affecter au joueur
	 *  
	 *  Comportement :
	 *  Dans un premier temps enleve l'effet de la race actuelle du joueur à l'aide de unsetRace.
	 *  Puis affecte race_ comme la nouvelle race du joueur.
	 *  Pour finir affecte le nouvelle effet de la nouvelle race.
	 */
	public void setRace(int race_) {
		unsetRace(race); // Désactive l'effet de la race du joueur
		race = race_; // Lui affecte la nouvelle race
		switch(race) {
		case 0:
			// Active effet race 1
			MULTIPLICATEUR_ARME = 3;
			break;
		case 1:
			// Active effet race 2
			MULTIPLICATEUR_CHAPEAU = 3;
			break;
		case 2:
			// Active effet race 3
			MULTIPLICATEUR_T_SHIRT = 3;
			break;
		case 3:
			// Active effet race 4
			MULTIPLICATEUR_PANTALON = 3;
			break;
		case 4:
			// Active effet race 1
			MULTIPLICATEUR_CHAUSSURE = 3;
			break;
		case 5:
			// Active effet race 2
			BONUS_DEGAT = 1;
			break;
		case 6:
			// Active effet race 3
			BONUS_DEGAT = 2;
			break;
		case 7:
			// Active effet race 4
			BONUS_DEGAT = 3;
			break;
		default:
			// Erreur
			break;
		}
		
		return;
	}
	
	/*! @brief Methode qui permet d'enlever un effet actif sur un joueur
	 *  @param effet_ Index de l'effet à enlever
	 *   
	 * Comportement :
	 * Dans un premier temps vérifie que l'effet est présent dans la liste des effets actifs.
	 * Si ce n'est pas le cas met fin au programme car n'a rien à faire.
	 * Sinon enleve l'effet de la liste des effets actifs,
	 * et désactive l'effet sur le joueur.
	 */
	public void unsetEffect(int effet_) {
		if (!effet.contains(effet_)) { // Si l'effet n'est pas présent dans la liste d'effet actif
			return; // Alors n'a rien à faire donc met fin au programme
		}
		
		// Sinon enleve l'effet de la liste 
		effet.remove(effet_);
		// Et on desactive l'effet sur le joueur
		switch(effet_) {
		case 0:
			// Effet 1
			niveau += 1;
			break;
		case 1:
			// Effet 2
			niveau += 2;
			break;
		case 2:
			// Effet 3
			niveau -= 1;
			break;
		case 3:
			// Effet 4
			niveau -= 2;
			break;
		case 4:
			// Effet 13
			BONUS_DEGAT -= 1;
		case 5:
			// Effet 14
			BONUS_DEGAT -= 2;
		case 6:
			// Effet 5
			MULTIPLICATEUR_ARME = 1;
			break;
		case 7:
			// Effet 6
			MULTIPLICATEUR_CHAPEAU = 1;
			break;
		case 8:
			// Effet 7
			MULTIPLICATEUR_T_SHIRT = 1;
			break;
		case 9:
			// Effet 8
			MULTIPLICATEUR_PANTALON= 1;
			break;
		case 10:
			// Effet 9
			MULTIPLICATEUR_CHAUSSURE = 1;
			break;
		case 11:
			// Effet 10
			// Rien ne ce passe
			break;
		case 12:
			// Effet 11
			BONUS_DEGAT += 1;
			break;
		case 13:
			// Effet 12
			BONUS_DEGAT += 2;
			break;
		case 14:
			// Effet 5
			MULTIPLICATEUR_ARME = 1;
			break;
		case 15:
			// Effet 6
			MULTIPLICATEUR_CHAPEAU = 1;
			break;
		case 16:
			// Effet 7
			MULTIPLICATEUR_T_SHIRT = 1;
			break;
		case 17:
			// Effet 8
			MULTIPLICATEUR_PANTALON= 1;
			break;
		case 18:
			// Effet 9
			MULTIPLICATEUR_CHAUSSURE = 1;
		default:
			// Erreur
			break;
		}		
		
	}
	
	/*! @brief Method qui permet d'appliquer un nouvelle effet sur le joueur
	 *  @param effet_ Index de l'effet à appliquer
	 *  @return Renvoie true si l'effet n'était pas déjà appliquer false sinon
	 *  
	 *  Comportement :
	 *  Dans un premier temps vérifie que l'effet ne soit pas déjà actif sur le joueur si c'est le cas retourne false.
	 *  Sinon ajoute l'effet à la liste d'effet actif.
	 *  Et applique l'effet sur le joueur puis renvoie true pour signifier que l'effet à bien était appliqué.
	 */
	public boolean setEffect(int effet_) {
		if (effet.contains(effet_)) { // Si le joueur possède déjà l'effet alors on ne l'applique pas
			return false; // Met fin à la méthode
		}
		
		// Sinon on ajoute l'effet à la liste d'effet actif sur le joueur
		effet.add(effet_);
		// Et on applique l'effet sur le joueur
		switch(effet_) {
		case 0:
			// Effet 1
			if (niveau - 1 <= 1) {
				niveau = 1;
			} else {
				niveau = niveau - 1;
			}
			break;
		case 1:
			// Effet 2
			if (niveau - 2 <= 1) {
				niveau = 1;
			} else {
				niveau = niveau - 2;
			}
			break;
		case 2:
			// Effet 3
			niveau += 1;
			break;
		case 3:
			// Effet 4
			niveau += 2;
			break;
		case 4:
			// Effet 13
			BONUS_DEGAT += 1;
		case 5:
			// Effet 14
			BONUS_DEGAT += 2;
		case 6:
			// Effet 5
			MULTIPLICATEUR_ARME = 2;
			break;
		case 7:
			// Effet 6
			MULTIPLICATEUR_CHAPEAU = 2;
			break;
		case 8:
			// Effet 7
			MULTIPLICATEUR_T_SHIRT = 2;
			break;
		case 9:
			// Effet 8
			MULTIPLICATEUR_PANTALON= 2;
			break;
		case 10:
			// Effet 9
			MULTIPLICATEUR_CHAUSSURE = 2;
			break;
		case 11:
			// Effet 10
			// Rien ne ce passe
			break;
		case 12:
			// Effet 11
			BONUS_DEGAT -= 1;
			break;
		case 13:
			// Effet 12
			BONUS_DEGAT -= 2;
			break;
		case 14:
			// Effet 5
			MULTIPLICATEUR_ARME = 1/2;
			break;
		case 15:
			// Effet 6
			MULTIPLICATEUR_CHAPEAU = 1/2;
			break;
		case 16:
			// Effet 7
			MULTIPLICATEUR_T_SHIRT = 1/2;
			break;
		case 17:
			// Effet 8
			MULTIPLICATEUR_PANTALON= 1/2;
			break;
		case 18:
			// Effet 9
			MULTIPLICATEUR_CHAUSSURE = 1/2;
		default:
			// Erreur
			break;
		}
		
		return true; // L'effet à bien pue etre appliqué
	}
	
	/*! @brief Method qui permet de remplacer un equipement équiper
	 *  @param equ Le nouvelle equipement à mettre
	 *  @return Renvoie l'ancienne équipement
	 *  
	 *  Comportement :
	 *  Memoire l'ancienne equipement en mémoire,
	 *  Puis le remplace par le nouveau,
	 *  Et renvoie l'ancienne equipement.
	 */
	public Equipement setEquipement(Equipement equ) {
		Equipement temp = equipements[equ.getTypeEquipement()]; // Garde en mémoire l'ancienne équipement pour la défausse
		equipements[equ.getTypeEquipement()] = equ; // Affecte equ au bon type d'équipement
		return temp; // Renvoie l'ancienne équipement
	}
	
	/*! @brief Permet de modifier le niveau
	 *  @param ajout La valeur que l'on va ajouter au niveau actuelle
	 *  
	 *  Comportement :
	 *  Ajoute ajout au niveau du joueur.
	 */
	public void setNiveau(int ajout) {
		if(niveau + ajout < 1) { // Si le niveau tombe en dessous de 1
			niveau = 1; // On met le niveau a 1, car le joueur ne peux pas aller en dessous de 1
		}else { // Sinon
			niveau += ajout; // On ajoute le niveau
		}
	}
	
	/*! @brief Methode qui permet d'ajouter une carte dans la main du joueur
	 *  @param carte La carte a ajouter
	 *  
	 * Comportement :
	 * Ajoute simplement la carte dans la main avec la méthode add de la librairie List.
	 */
	public void addCard(Carte carte) {
		main.add(carte);
	}
	
	/*--------------------- Method ---------------------*/
	
	/*! @brief Methode qui permet de savoir si le joueur à trop de carte dans ca main
	 *  @return Renvoie true si la main dépasse false sinon.
	 *  
	 * Comportement :
	 * Vérifie simplement si la taille de la main dépasse la taille maximum ( 5 par défaut).
	 */
	public boolean mainFull() {
		return main.size() > CARTE_MAX;
	}
	
	/*! @brief Permet de savoir si un joueur gagne le combat contre un monstre
	 *  @param monstre_ Le monstre que le joueur doit combattre
	 *  
	 *  Comportement :
	 * Compare le niveau du joueur et du monstre.
	 */
	public boolean fightMonster(Monstre monstre_) {
		return niveau > monstre_.getNiveauMonstre();
	}
	
	/*! @brief Method qui permet d'affucher l'objet
	 * 
	 * Comportement : 
	 * Affiche la main du joueur.
	 */
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(nom)
	      .append("\nNiveau : ").append(niveau)
	      .append("\nRace : ").append(listeRace[race])
	      .append("\nEffets : ").append(effet)
	      .append("\nEquipements : ").append(Arrays.toString(equipements)) // Iterate through the array
	      .append("\nMain : ").append(main)
	      .append("\n");
	    return sb.toString();
	}
	
	/*! @brief Method qui permet d'afficher la main d'un joueur
	 * 
	 * Comportement :
	 * Itère à travers la main du joueur et affiche chaque carte
	 */
	public void afficherMain() {
		System.out.println("Voici votre main :\n");
		for(int i = 0; i < main.size(); ++i) { // Itère à travers la main
			main.get(i).displayCard(); // Affiche chaque carte
		}
	}
	
	/*! @brief Methode qui permet de savoir si le joueur à gagner
	 *  @return True si le joueur a gagner False sinon
	 *  
	 *  Comportement :
	 *  Permet de savoir si le joueur ) ganger en regardant si il a atteint le niveau maximale.
	 */
	public boolean isWinning() {
		return niveau >= NIVEAU_MAX;
	}
	
	/*! @brief Methode qui permet au joueur de lancé un dé
	 *  @return le resultat du dé une fois lancé
	 * 
	 * Comportement :
	 * Le joueur lance un dé pour tenter de fuir un combat si le joueur obtient moins de 3 ou 3,
	 * alors il arrive à fuire le monstre sinon il n'y arrive pas
	 */
	public int tryFlee() {
		return dice.roll();
	}

}
