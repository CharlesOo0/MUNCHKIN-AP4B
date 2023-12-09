package munchkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	/*--------------------- Constantes ---------------------*/	
	
	public static final String REGLE_DU_JEU = Constants.REGLE_DU_JEU_; // Les règles du jeu sous forme de chaine de caractère
	public static final Carte[] deckDonjonDefautUTBM = Constants.deckDonjonDefautUTBM_; // Deck donjon par défaut utbm
	public static final Carte[] deckTresorDefautUTBM = Constants.deckTresorDefautUTBM_; // Deck trésor par défaut utbm
	public static final int CHANCE_FUITE = Constants.CHANCE_FUITE_; // Chance de pouvoir echapper a un monstre
	public static final int CARTE_MAX = Constants.CARTE_MAX_;
	
	/*--------------------- Scanner et Clear de la console et Couleur ---------------------*/
		
	public static final Scanner scanner = new Scanner(System.in); // Scanner pour récupérer les entrées

    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";
	
	/*! @brief Fonction utiliser pour "clear" la console
	 * 
	 * Comportement :
	 * Cette fonction ne clear pas vraiment la console elle se contente d'aller 50 fois à la ligne,
	 * A noter qu'il est compliquer de clear la console en java pour plusieurs raison,
	 * La première etant que si le code est lancée sur un IDE la plupart du temps les clears conventionnelle ne marcheront pas,
	 * La deuxième etant que si on crée un processus avec process builder pour lancer un "cls" et bien on ne peux pas s'assurer que tout les utilisateurs soit sur Windows
	 * et qu'ils exécutent le code depuis un terminal Windows même chose pour linux et autre os,
	 * Et la dernière étant qu'il est contre instinctif de clear un stream et comme java ce base sur un stream pour afficher ces données clear la console devient compliqué.
	 */
	public static void clearConsole() {
		for (int i = 0; i < 15; i++) System.out.println(); // Va à la ligne 50 fois
	}
	
	/*--------------------- Affichage menu ---------------------*/
	
	/*! @brief Permet de savoir quel page il faut afficher
	 *  @param pageAfficher Un int qui représente la page à afficher doit être entre 0 et 3
	 * 
	 * Comportement :
	 * Un simple switch qui permet de retrouver la bonne page à afficher,
	 * Le cas par défaut ne fais rien.
	 */
	public static void menuChoixPage(int pageAfficher) {
		switch(pageAfficher) {
		case 0: // Cas 0, affiche la page avec le choix jouer
			menuPageJouer();
			break;
		case 1: // Cas 1, affiche la page avec le choix regle
			menuPageRegle();
			break;
		case 2: // Cas 2, affiche la page avec le choix liste des cartes
			menuPageCarte();
			break;
		case 3: // Cas 3, affiche la page avec le choix quitter
			menuPageQuitter();
			break;
		default: // Cas par défaut rien ne ce passe
			break;
		}
	}
	
	/*! @brief Fonction qui affiche la page menu avec le choix Jouer */
	public static void menuPageJouer() { 
		clearConsole(); // Clear la console
		System.out.println("\t\tMunchkin\n\t"+red+"->Jouer\n\t"+reset+"Regle\n\tCartes\n\tQuitter\n\nUtilisez Z et S pour vous déplacez et ENTRER pour valider votre choix : ");
	}
	
	/*! @brief Fonction qui affiche la page menu avec le choix Regle */
	public static void menuPageRegle() {
		clearConsole(); // Clear la console
		System.out.println("\t\tMunchkin\n\tJouer\n\t"+red+"->Regle\n\t"+reset+"Cartes\n\tQuitter\n\nUtilisez Z et S pour vous déplacez et ENTRER pour valider votre choix : ");
	}
	
	/*! @brief Fonction qui affiche la page menu avec le choix liste des cartes */
	public static void menuPageCarte() {
		clearConsole(); // Clear la console
		System.out.println("\t\tMunchkin\n\tJouer\n\tRegle\n\t"+red+"->Cartes"+reset+"\n\tQuitter\n\nUtilisez Z et S pour vous déplacez et ENTRER pour valider votre choix : ");
	}
	
	/*! @brief Fonction qui affiche la page menu avec le choix Quitter */
	public static void menuPageQuitter() { 
		clearConsole(); // Clear la console
		System.out.println("\t\tMunchkin\n\tJouer\n\tRegle\n\tCartes\n\t"+red+"->Quitter\n\n"+reset+"Utilisez Z et S pour vous déplacez et ENTRER pour valider votre choix : ");
	}

	/*! @brief Fonction qui permet de connaître la page à afficher selon le choix du jouer
	 *  @param choix Un caractère le choix du joueur
	 *  @param currentMenu Un entier le menu actuelle dans lequel ce situe le joueur
	 *  @return Retourne un entier le numéro de la nouvelle page ou -1 
	 * 
	 * Comportement :
	 * Utilise un switch avec le choix du joueur qu'on passe en lowerCase, 
	 * Si le choix est 'Z' alors le on affiche la page avec le choix selectionner au dessus du choix actuelle sauf si le choix est le plus haut alors on laisse l'affichage de la page de base,
	 * Meme chose si le choix est 'Q' mais vers le bas,
	 * Dans le cas par défaut on retourne -1 pour dire que le joueur veut quitter en soit ce cas est unreachable.
	 */
	public static int afficheMenu(char choix, int currentMenu) {
		switch(Character.toLowerCase(choix)) { // lowerCase le choix du joueur
		case 'z': // Si z
			if(currentMenu == 0) { // et que currentMenu est déjà le menu le plus haut
				menuChoixPage(currentMenu); // alors on ne change pas l'affichage
				return currentMenu; // On retourne la meme page
			}else { // et que currentMenu n'est pas le plus haut
				menuChoixPage(currentMenu-1); // alors on monte d'un cran
				return currentMenu - 1; // On retourne la page d'haut dessus
			}
		case 's': // Si s
			if(currentMenu == 3) { // et que currentMenu est déjà le menu le plus bas
				menuChoixPage(currentMenu); // alors on ne change pas l'affichage
				return currentMenu; // On retourne la meme page
			}else { // et que currentMenu n'est pas le plus bas
				menuChoixPage(currentMenu+1); // alors on descend d'un cran
				return currentMenu + 1; // On retourne la page d'en dessous
			}
		default: // Cas par défault retourne -1 pour dire que si ni z ni s n'est choisi alors il y à un problème
			return -1; // Unreachable en soit
		}
	}

	
	/*--------------------- Boucle de jeu ---------------------*/

	
	/* Main qui assemble tout nos objets pour pouvoir jouer */
	public static void main(String[] args) {
		
		/*--------- MENU DU JEU ---------*/
		char choix = 'z'; // Le choix du joueur initialiser à z pour afficher le menu par défaut
		int currentMenu = 0; // La page du menu dans lequelle le joueur ce trouve par défaut il est dans la page 0 soit pageMenuJouer
		boolean joueurJoue = false;
		while(true && !joueurJoue) { // Boucle infini, le joueur choisi ce qu'il veux faire
			currentMenu = afficheMenu(choix, currentMenu); // Au début affiche le menu choisi
			try { // Tente de scanner le premier charactère de la ligne suivante
				choix = scanner.nextLine().charAt(0); 
			}catch(StringIndexOutOfBoundsException e) { // Si on à une erreur le joueur a appuyer sur entrée donc il à selectionner on choix
				
				switch(currentMenu) { // Selon son choix on réagis
				
				case 0: // Le joueur veux jouer on lui demande a combien de personne il veux jouer :
					joueurJoue = true; // Le joueur joue donc on sors de la boucle infini
					break;
					
				case 1: // Le joueur veux voir les règles
					
					clearConsole(); // Clear la console
					System.out.println(REGLE_DU_JEU + "\n\nAppuyez sur ENTRER pour revenir au menu."); // Affiche les règle
					try { // Scanner ce que le joueur rentre pour bloquer sur l'affichage des regles
						scanner.nextLine().charAt(0);  // Quoi que ce soit qu'il rentre on le sors d'ici
						break;
					}catch(StringIndexOutOfBoundsException f) { // Si il ne rentre rien on le sors quand même
						break;
					}
					
				case 2: // Le joueur veux voir la liste des cartes
					clearConsole(); // Clear la console
					System.out.println(new Deck(0)); // Affiche les decks donjon et tresors UTBM ceux de bases
					System.out.println(new Deck(1) + "\n\nAppuyez sur ENTRER pour revenir au menu."); // Affiche les decks donjon et tresors UTBM ceux de bases
					try { // Scanner ce que le joueur rentre pour bloquer sur l'affichage des regles
						scanner.nextLine().charAt(0);  // Quoi que ce soit qu'il rentre on le sors d'ici
						break;
					}catch(StringIndexOutOfBoundsException f) { // Si il ne rentre rien on le sors quand même
						break;
					}
					
				case 3: // Le joueur quitte
					clearConsole(); // Clear la console
					System.out.println("\nA bientot !");
					scanner.close(); // Ferme le scanner à la fin
					return; // L'utilisateur choisi de quitter
					
				default: // Erreur met fin au programme
					clearConsole(); // Clear la console
					System.out.println("Erreur");
					scanner.close(); // Ferme le scanner à la fin
					return; // L'utilisateur choisi de quitter
				}
			}
			
		}
		/*--------- MENU DU JEU ---------*/
	
		/*--------- DEMANDE LE NOMBRE DE JOUEUR ---------*/
		clearConsole(); // Clear la console
		int nbJoueur;	
		do {
			clearConsole(); // Clear la console
            System.out.println("Combien de joueurs (entre 3 et 6) ?\n");

            // Vérifie si le prochain élément dans l'entrée est un entier
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez saisir un nombre entier valide.");
                scanner.next(); // Nettoie le scanner
            }

            // Récupère l'entier saisi par l'utilisateur
            nbJoueur = scanner.nextInt();

        } while (nbJoueur < 3 || nbJoueur > 6);
		/*--------- DEMANDE LE NOMBRE DE JOUEUR ---------*/
		
		// Initialise la partie
		Board plateau = new Board(); // Prépare le plateau
		Joueurs listeJoueur = new Joueurs(plateau,nbJoueur); // Initialise une liste de joueurs de taille nbJoueur
		
		int indexJoueur = 0; // Initialise notre index qui va nous permettre de parcourir notre liste de joueurs
		int currentChoice; // Permet à des controles d'acquisition de fonctionner
		
		while(listeJoueur.isSomeoneWinning() == -1) { // Tant qu'aucun joueur n'a gagner
			
			/*--------- PHASE DE PRE-JEU ---------*/
			clearConsole();
			System.out.println("\nTour Joueur " + (indexJoueur + 1) + " :");
			listeJoueur.getJoueur(indexJoueur).afficherMain(); // Affiche la main du joueur
			scanner.nextLine();
			
			List<Carte> choixDeposageCarte = new ArrayList<>(); // La liste des choix du joueurs
			List<Carte> choixVente = new ArrayList<>(); // La liste des choix du joueurs
			int pieceOr; // Variable pour la vente de carte
			do {
			    System.out.println("Sélectionnez les cartes que vous voulez jouer en entrant des chiffres 0, 1, 2, ...\nVous avez selectionnez "+ choixDeposageCarte +".\nAppuyez sur ENTREZ pour valider");

			    // Lire la ligne entière
			    String userInput = scanner.nextLine();

			    // Si l'utilisateur appuie sur Entrée sans entrer de valeur, sortir de la boucle
			    if (userInput.trim().isEmpty()) {
			        break;
			    }

			    // Vérifier si l'entrée est un entier
			    try {
			    	currentChoice = Integer.parseInt(userInput); // Convertie le string entier
			        if (currentChoice >= 0 && currentChoice <= listeJoueur.getJoueur(indexJoueur).getMain().size()) { // Si l'entier est dans l'intervalle
				    	if (choixDeposageCarte.contains(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice))) { // Si la liste contient déjà l'entier
				    		choixDeposageCarte.remove(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice)); // On l'enlève
				    	} else { // Sinon
				    		choixDeposageCarte.add(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice));
				    	}
				    }
			    } catch (NumberFormatException e) {
			        System.out.println("Veuillez saisir un nombre entier valide.");
			        continue; // Recommencer la boucle
			    }

			    // Vérifier la plage valide
			} while (true);
			
			// Joue les cartes selectionner par le joueur
			for(int i = 0; i < choixDeposageCarte.size(); ++i) {
				Carte carteDuJoueur = choixDeposageCarte.get(i); // Choisi la bonne carte
				switch(carteDuJoueur.getType()) {
				case 0: // Cas monstre
					Monstre monstre = (Monstre) carteDuJoueur;
					if (listeJoueur.getJoueur(indexJoueur).getBonus() > monstre.getNiveauMonstre()) { // Si le joueur gagne le combat alors
		        		for(int j = 0; j < monstre.getNbTresor(); ++j) { // Pioche autant de fois qu'indiquez sur la carte monstre
		        			listeJoueur.getJoueur(indexJoueur).addCard(plateau.drawPiocheTresor()); // Pioche carte trésor et l'ajoute a la main
		        		}
		        		if (listeJoueur.getJoueur(indexJoueur).getMain().size() > CARTE_MAX) { // Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
			        		do { 
			    			    System.out.println("Vous avez trop de carte sélectionnez les cartes que vous voulez vendre en entrant des chiffres 0, 1, 2, ...\nVous avez selectionnez "+ choixDeposageCarte +".\nAppuyez sur ENTREZ pour valider");
	
			    			    // Lire la ligne entière
			    			    String userInput = scanner.nextLine();
	
			    			    // Si l'utilisateur appuie sur Entrée sans entrer de valeur, sortir de la boucle
			    			    if (userInput.trim().isEmpty()) {
			    			        break;
			    			    }
	
			    			    // Vérifier si l'entrée est un entier
			    			    try {
			    			    	currentChoice = Integer.parseInt(userInput); // Convertie le string entier
			    			        if (currentChoice >= 0 && currentChoice <= listeJoueur.getJoueur(indexJoueur).getMain().size() && listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice).getType() == 1) { // Si l'entier est dans l'intervalle
			    				    	if (choixVente.contains(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice))) { // Si la liste contient déjà l'entier
			    				    		choixVente.remove(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice)); // On l'enlève
			    				    	} else { // Sinon
			    				    		choixVente.add(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice));
			    				    	}
			    				    }
			    			    } catch (NumberFormatException e) {
			    			        System.out.println("Veuillez saisir un nombre entier valide.");
			    			        continue; // Recommencer la boucle
			    			    }
	
			    			    // Vérifier la plage valide
			    			} while (true);
			        		
			        		pieceOr = 0;
			        		for(int j = 0; j < choixVente.size(); ++j) {
			        			Equipement equipementVente = (Equipement) choixVente.get(j); // Récupère l'équipement
			        			pieceOr += equipementVente.getPieceOr();
			        			
			        			listeJoueur.getJoueur(indexJoueur).getMain().remove(choixVente.get(j)); // Enleve la carte de la main.
			        		}
			        		listeJoueur.getJoueur(indexJoueur).setNiveau(pieceOr % 1000); // Pour tout les paliers de 1000 pièces d'or gagne un niveau le reste va à la poubelle
		        		}// Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
		        	}else { // S'il perd alors :
		        		int deResultat = listeJoueur.getJoueur(indexJoueur).tryFlee(); // Il lance un dé pour tenter de fuire
		        		if (deResultat > CHANCE_FUITE){ // Sinon il echoue et perd des niveaux
		        			listeJoueur.getJoueur(indexJoueur).setNiveau(-monstre.getNiveauMonstre()); // Enleve le niveau de défaite du monstre au niveau du joueur
		        		}
		        	}
					break;
				case 1: // Cas equipement
					Equipement equipement = (Equipement) carteDuJoueur; // Récupère la carte Equipement
					plateau.addDefausseTresor(listeJoueur.getJoueur(indexJoueur).setEquipement(equipement));
					
					break;
				case 2: // Cas race
					Race race = (Race) carteDuJoueur; // Récupère la carte Race
					listeJoueur.getJoueur(indexJoueur).setRace(race.getEffect()); // Récupère l'effet de la nouvelle race et l'applique au joueur.
					plateau.addDefausseDonjon(carteDuJoueur); // Ajoute la carte a la defausse
					break;
				case 3: // Cas malédiction
					Malediction malediction = (Malediction) carteDuJoueur; // Récupère la carte malédiction
					listeJoueur.getJoueur(indexJoueur).setEffect(malediction.getEffect()); // Récupère l'effet de la malediction et l'applique au joueur.
					plateau.addDefausseDonjon(carteDuJoueur); // Ajoute la carte a la defausse
					break;
				default:
					// Impossible
					break;
				}
				listeJoueur.getJoueur(indexJoueur).getMain().remove(choixDeposageCarte.get(i)); // Enleve la carte de la main.
			}

			listeJoueur.getJoueur(indexJoueur).afficherMain(); // Affiche la main du joueur
			System.out.println("Appuyez sur Entrer pour continuer.\n");
	        try {
	            scanner.nextLine(); // Bloque le programme jusqu'à ce que l'utilisateur appuie sur Entrer
	        } catch (Exception e) {
	            // Gérer les exceptions, si nécessaire
	        }
			/*--------- PHASE DE PRE-JEU ---------*/
			
			/*------------------ PHASE DE JEU ------------------*/
			clearConsole(); // Clear la console
			System.out.println("C'est au joueur " + (indexJoueur + 1) + " de jouer, Phase 1 piocher une carte Donjon, vous piochez la carte et tomber sur :\n");
			Carte cartePiocher = plateau.drawPiocheDonjon(); // Pioche la carte dans le deck donjon
			cartePiocher.displayCard(); // Affiche la carte proprement
			
			switch(cartePiocher.type) {
			
			case 0: // Cas ou la carte est une carte Monstre
				// Cast la carte en monstre 
				Monstre monstre = (Monstre) cartePiocher;
				// Demande à l'utilisateur de saisir 'C' pour combattre ou 'F' pour fuir
		        do {
		            System.out.println("\nEntrez 'C' pour combattre le monstre, ou 'F' pour tenter de le fuir : ");

		            // Vérifie si le prochain élément dans l'entrée est un caractère
		            while (!scanner.hasNext()) {
		                System.out.println("Veuillez saisir un caractère valide.");
		                scanner.next(); // Nettoie le scanner
		            }

		            // Récupère le premier caractère de la saisie de l'utilisateur
		            choix = scanner.next().charAt(0);
		            scanner.nextLine(); // Consomme la nouvelle ligne

		        } while (choix != 'C' && choix != 'F');
		        
		        clearConsole(); // Clear la console
		        if(choix == 'C') { // Si l'utilisateur choisi de combattre
		        	
		        	if (listeJoueur.getJoueur(indexJoueur).getBonus() > monstre.getNiveauMonstre()) { // Si le joueur gagne le combat alors
		        		System.out.println("Vous combattez le monstre et gagnez, vous piocher donc " + monstre.getNbTresor() + " trésors.");
		        		for(int i = 0; i < monstre.getNbTresor(); ++i) { // Pioche autant de fois qu'indiquez sur la carte monstre
		        			listeJoueur.getJoueur(indexJoueur).addCard(plateau.drawPiocheTresor()); // Pioche carte trésor et l'ajoute a la main
		        		}
		        		
		        		if (listeJoueur.getJoueur(indexJoueur).getMain().size() > CARTE_MAX) { // Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
			        		do { 
			    			    System.out.println("Vous avez trop de carte sélectionnez les cartes que vous voulez vendre en entrant des chiffres 0, 1, 2, ...\nVous avez selectionnez "+ choixDeposageCarte +".\nAppuyez sur ENTREZ pour valider");
	
			    			    // Lire la ligne entière
			    			    String userInput = scanner.nextLine();
	
			    			    // Si l'utilisateur appuie sur Entrée sans entrer de valeur, sortir de la boucle
			    			    if (userInput.trim().isEmpty()) {
			    			        break;
			    			    }
	
			    			    // Vérifier si l'entrée est un entier
			    			    try {
			    			    	currentChoice = Integer.parseInt(userInput); // Convertie le string entier
			    			        if (currentChoice >= 0 && currentChoice <= listeJoueur.getJoueur(indexJoueur).getMain().size() && listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice).getType() == 1) { // Si l'entier est dans l'intervalle
			    				    	if (choixVente.contains(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice))) { // Si la liste contient déjà l'entier
			    				    		choixVente.remove(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice)); // On l'enlève
			    				    	} else { // Sinon
			    				    		choixVente.add(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice));
			    				    	}
			    				    }
			    			    } catch (NumberFormatException e) {
			    			        System.out.println("Veuillez saisir un nombre entier valide.");
			    			        continue; // Recommencer la boucle
			    			    }
	
			    			    // Vérifier la plage valide
			    			} while (true);
			        		
			        		pieceOr = 0;
			        		for(int j = 0; j < choixVente.size(); ++j) {
			        			Equipement equipementVente = (Equipement) choixVente.get(j); // Récupère l'équipement
			        			pieceOr += equipementVente.getPieceOr();
			        			
			        			listeJoueur.getJoueur(indexJoueur).getMain().remove(choixVente.get(j)); // Enleve la carte de la main.
			        		}
			        		listeJoueur.getJoueur(indexJoueur).setNiveau(pieceOr % 1000); // Pour tout les paliers de 1000 pièces d'or gagne un niveau le reste va à la poubelle
		        		}// Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
		        	}else { // S'il perd alors :
		        		int deResultat = listeJoueur.getJoueur(indexJoueur).tryFlee(); // Il lance un dé pour tenter de fuire
		        		System.out.println("Vous tentez de combattre le monstre mais perdez vous essayez donc de fuir.\nVous lancez le dé et obtenez : " + deResultat);
		        		if (deResultat <= CHANCE_FUITE){ // S'il obtient un chiffre <= 3 il arrive à fuir il ne perd rien et ne gagne rien
		        			System.out.println("Vous réussissez à fuir et ne perdait pas de niveau car vous avec tirez un chiffre inférieur ou égale à trois.");
		        		}else{ // Sinon il echoue et perd des niveaux
		        			System.out.println("Vous n'arrivez pas à fuir vous avez tirez un chiffre supérieur à 3, vous perdez donc le nombre de niveau indiquez sur la carte monstre.\n(Vous ne pouvez pas tomber en dessous du niveau 1)");
		        			listeJoueur.getJoueur(indexJoueur).setNiveau(-monstre.getNiveauMonstre()); // Enleve le niveau de défaite du monstre au niveau du joueur
		        			System.out.println("Voici votre nouveau niveau : " + listeJoueur.getJoueur(indexJoueur).getNiveau());
		        		}
		        	}
		        	
		        }else { // Si l'utilisateur choisi de fuire alors
		        	int deResultat = listeJoueur.getJoueur(indexJoueur).tryFlee(); // Il lance un dé pour tenter de fuire
	        		System.out.println("Vous essayez de fuir.\nVous lancez le dé et obtenez : " + deResultat);
	        		if (deResultat <= CHANCE_FUITE){ // S'il obtient un chiffre <= 3 il arrive à fuir il ne perd rien et ne gagne rien
	        			System.out.println("Vous réussissez à fuir et ne perdait pas de niveau car vous avec tirez un chiffre inférieur ou égale à trois.");
	        		}else{ // Sinon il echoue et perd des niveaux
	        			System.out.println("Vous n'arrivez pas à fuir vous avez tirez un chiffre supérieur à 3, vous perdez donc le nombre de niveau indiquez sur la carte monstre.\n(Vous ne pouvez pas tomber en dessous du niveau 1)");
	        			listeJoueur.getJoueur(indexJoueur).setNiveau(-monstre.getNiveauMonstre()); // Enleve le niveau de défaite du monstre au niveau du joueur
	        			System.out.println("Voici votre nouveau niveau : " + listeJoueur.getJoueur(indexJoueur).getNiveau());
	        		}
		        }
		        
		        plateau.addDefausseDonjon(cartePiocher); // Ajoute la carte piocher a la defausse
		        
		        System.out.println("Appuyez sur Entrer pour continuer.\n");
		        try {
		            scanner.nextLine(); // Bloque le programme jusqu'à ce que l'utilisateur appuie sur Entrer
		        } catch (Exception e) {
		            // Gérer les exceptions, si nécessaire
		        }
		        
				break;
				
			case 2: // Cas ou la carte est une carte Race
				Race race = (Race) cartePiocher; // Récupère la carte malédiction
				System.out.println("Vous avez tirez une carte race...");
				System.out.println(listeJoueur.getJoueur(indexJoueur)); // Affiche le joueur
				
				do {
		            System.out.println("\nEntre 'O' pour la jouer directement ou 'N' pour la mettre dans votre main.");

		            // Vérifie si le prochain élément dans l'entrée est un caractère
		            while (!scanner.hasNext()) {
		                System.out.println("Veuillez saisir un caractère valide.");
		                scanner.next(); // Nettoie le scanner
		            }

		            // Récupère le premier caractère de la saisie de l'utilisateur
		            choix = scanner.next().charAt(0);
		            scanner.nextLine(); // Consomme la nouvelle ligne

		        } while (choix != 'O' && choix != 'N');
				
				if(choix == 'O') { // Si le joeur veux jouer ca carte directement :
					System.out.println("Ces effets s'applique immédiatement sur vous...");
					listeJoueur.getJoueur(indexJoueur).setRace(race.getEffect()); // Récupère l'effet de la nouvelle race et l'applique au joueur.
					plateau.addDefausseDonjon(cartePiocher); // Ajoute la carte a la defausse
				}else { // Si le joueur ne veux pas jouer ca carte directement :
					listeJoueur.getJoueur(indexJoueur).addCard(cartePiocher); // Ajoute la carte dans ca main
					if (listeJoueur.getJoueur(indexJoueur).getMain().size() > CARTE_MAX) { // Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
		        		do { 
		    			    System.out.println("Vous avez trop de carte sélectionnez les cartes que vous voulez vendre en entrant des chiffres 0, 1, 2, ...\nVous avez selectionnez "+ choixDeposageCarte +".\nAppuyez sur ENTREZ pour valider");

		    			    // Lire la ligne entière
		    			    String userInput = scanner.nextLine();

		    			    // Si l'utilisateur appuie sur Entrée sans entrer de valeur, sortir de la boucle
		    			    if (userInput.trim().isEmpty()) {
		    			        break;
		    			    }

		    			    // Vérifier si l'entrée est un entier
		    			    try {
		    			    	currentChoice = Integer.parseInt(userInput); // Convertie le string entier
		    			        if (currentChoice >= 0 && currentChoice <= listeJoueur.getJoueur(indexJoueur).getMain().size() && listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice).getType() == 1) { // Si l'entier est dans l'intervalle
		    				    	if (choixVente.contains(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice))) { // Si la liste contient déjà l'entier
		    				    		choixVente.remove(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice)); // On l'enlève
		    				    	} else { // Sinon
		    				    		choixVente.add(listeJoueur.getJoueur(indexJoueur).getMain().get(currentChoice));
		    				    	}
		    				    }
		    			    } catch (NumberFormatException e) {
		    			        System.out.println("Veuillez saisir un nombre entier valide.");
		    			        continue; // Recommencer la boucle
		    			    }

		    			    // Vérifier la plage valide
		    			} while (true);
		        		
		        		pieceOr = 0;
		        		for(int j = 0; j < choixVente.size(); ++j) {
		        			Equipement equipementVente = (Equipement) choixVente.get(j); // Récupère l'équipement
		        			pieceOr += equipementVente.getPieceOr();
		        			
		        			listeJoueur.getJoueur(indexJoueur).getMain().remove(choixVente.get(j)); // Enleve la carte de la main.
		        		}
		        		listeJoueur.getJoueur(indexJoueur).setNiveau(pieceOr % 1000); // Pour tout les paliers de 1000 pièces d'or gagne un niveau le reste va à la poubelle
	        		}// Choisi les cartes qu'ils veux vendre -------------------------------------------------------------------------------------
				}
				
				
				System.out.println("Appuyez sur Entrer pour continuer.\n");
			    try {
			        scanner.nextLine(); // Bloque le programme jusqu'à ce que l'utilisateur appuie sur Entrer
			    } catch (Exception e) {
			        // Gérer les exceptions, si nécessaire
			    }
				break;
				
			case 3: // Cas ou la carte est une carte Malediction
				Malediction malediction = (Malediction) cartePiocher; // Récupère la carte malédiction
				System.out.println("Vous avez tirez une carte malédiction...");
				System.out.println("Ces effets s'applique immédiatement sur vous...");
				listeJoueur.getJoueur(indexJoueur).setEffect(malediction.getEffect()); // Récupère l'effet de la malediction et l'applique au joueur.
				plateau.addDefausseDonjon(cartePiocher); // Ajoute la carte a la defausse
				
				System.out.println("Appuyez sur Entrer pour continuer.\n");
			    try {
			        scanner.nextLine(); // Bloque le programme jusqu'à ce que l'utilisateur appuie sur Entrer
			    } catch (Exception e) {
			        // Gérer les exceptions, si nécessaire
			    }
				break;
				
			default:
				// Erreur endroit inateignable
				break;
			}
			/*------------------ PHASE DE JEU ------------------*/
			
			
			/*----------- CONDITION POUR LA BOUCLE -----------*/
			if(indexJoueur == nbJoueur-1) { // Si on a fais tout les joueurs
				indexJoueur = 0; // Alors on reviens au joueur de départ
			}else { // Sinon
				++indexJoueur; // On passe au joueur suivant
			}
			/*----------- CONDITION POUR LA BOUCLE -----------*/
		}
		
		/*----------- ECRAN DE FIN -----------*/
		System.out.println("La partie est terminez bien jouez le joueur qui a gagner est :" + (listeJoueur.isSomeoneWinning()+1));
		System.out.println("Merci d'avoir jouer !");
		/*----------- ECRAN DE FIN -----------*/
		
		scanner.close(); // Ferme le scanner à la fin du main
	} 
	
}
