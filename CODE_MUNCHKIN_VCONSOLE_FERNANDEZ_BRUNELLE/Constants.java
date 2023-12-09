package munchkin;

public final class Constants {
	/*--------------------- CONSTANTES GLOBALE JOUEUR ---------------------*/
	public static final int NB_EQUIPEMENT_ = 5; // Le nombre d'équipements possible pour le joueur
	public static final int NIVEAU_MAX_ = 10; // Le niveau max du joueur
	public static final int CARTE_MAX_ = 5; // Le nombre de carte que le joueur peux tenir en main
	public static final int NB_CARTE_CHAQUE_PIOCHE_ = 2; // Le nombre de carte de chaque pioche nécessaire
	public static final String[] listeRace_ = {"Info","EDIM","GMC","IMSI","Energie","TC","Branche","Professeur","Moldu"}; // La liste des races du jeux
	public static final int CHANCE_FUITE_ = 3; // Le chiffre jusqu'au quel un jouer arrive a fuir un monstre avec un lancez de dé
	
	/*--------------------- CONSTANTES GLOBALE CARTE ---------------------*/
	public static final String[] listeTypeCarte_ = {"Monstre", "Equipement", "Race", "Malédiction"}; // Constante globale pour les types de cartes
	
	public static final String[] listeTypeEquipement_ = {"Chapeau", "T-Shirt", "Pantalon", "Chaussure","Arme"}; // Constante globale pour les types d'equipements
	
	public static final String[] listeEffetRace_ = {"Vos armes inflige trois fois plus deux dégats",
														"Votre chapeau vous protège trois fois mieux",
														"Votre T-shirt vous protège trois fois plus",
														"Votre Pantalon vous protège trois fois plus",
														"Vos chaussure vous protège trois fois plus",
														"Gagne 1 bonus d'attaque",
														"Gagne 2 bonus d'attaque",
														"Gagne 3 bonus d'attaque"
														}; // Constante globale pourla liste d'effet des races d'equipements
	
	public static final String[] listeEffetMalediction_ = {"Perd 1 niveau", 
															"Perd 2 niveau", 
															"Gagne 1 niveau", 
															"Gagne 2 niveau",
															"Gagne 1 bonus d'attaque",
															"Gagne 2 bonus d'attaque",
															"Vos armes inflige deux fois plus deux dégats",
															"Votre chapeau vous protège deux fois mieux",
															"Votre T-shirt vous protège deux fois plus",
															"Votre Pantalon vous protège deux fois plus",
															"Vos chaussure vous protège deux fois plus",
															"Rien ne ce passe",
															"Perd 1 bonus d'attaque",
															"Perd 2 bonus d'attaque",
															"Vos armes inflige deux fois moins deux dégats",
															"Votre chapeau vous protège deux fois moins bien",
															"Votre T-shirt vous protège deux fois moins",
															"Votre Pantalon vous protège deux fois moins",
															"Vos chaussure vous protège deux fois moins"
															}; // Constante globale pour la liste d'effet dan le jeu

	/*--------------------- CONSTANTES GLOBALE MAIN ---------------------*/	
	
	public static final String REGLE_DU_JEU_ = "Matériel :\n\t168 cartes, un dé.\n\nPréparation :\n\tLe jeu est prévue pour 3 à 6 joueurs, la première étape va être de devoir choisir à combien de joueurs vous allez vouloir jouer. Une fois spécifié le jeu va commencer. \n\nDéroulement :\n\tChaque joueur va devoir jouer à tour de role il pourra choisir de poser une carte équipement une malédiction ou bien de vendre de cartes. \nSi le joueur décide de vendre des cartes il faut que le cumule de ces dernières soit d'au moins 1000 pièces d'or afin de pouvoir acheté un niveau(Il peux acheter plusieurs niveaux, chaque niveau coute 1000 pièce d'or).\nUne fois que le joueur à fini cette phase il pioche une carte donjon, si cette carte donjon est un monstre il à le choix de la combattre ou bien de la fuir.\nSi il choisi le combat le joueur oppose au niveau du monstre son niveau + le bonus apporté par ces malédictions ou équipements si le joueur gagne le combat il remporte le nombre de trésor indiquer sur la carte monstre.\nSi le joueur fuis il à alors un pourcentage de fuite, à chaque echec de fuite le joueur perd une carte de ca main aléatoirement.\nSi le joueur n'a plus de carte il est très leger alors il arrive à fuir a tout les coups.\n\nCondition de Victoire :\n\tLe premier joueur qui parvient au niveau maximale soit 10 remporte la parti.";
	
	/*--------------------- CONSTANTES GLOBALE DECK ---------------------*/
	public static final Carte deckDonjonDefautUTBM_[] = { // Deck donjon avec l'extension UTBM par défaut 84 Cartes
			new Monstre("Professeur d'Anglais",2,1,1,1),
			new Monstre("Professeur d'Anglais",2,1,1,1),
			new Monstre("Professeur d'Anglais",2,1,1,1),
			new Monstre("Professeur de T2S",2,2,1,1),
			new Monstre("Professeur de T2S",2,2,1,1),
			
			new Monstre("Professeur de T2S",2,2,1,1),
			new Monstre("Professeur de Math",3,2,1,1),
			new Monstre("Professeur de Math",3,2,1,1),
			new Monstre("Professeur de Math",3,2,1,1),
			new Monstre("Professeur de Physique",4,2,1,1),
			
			new Monstre("Professeur de Physique",4,2,1,1),
			new Monstre("Professeur de Physique",4,2,1,1),
			new Monstre("Professeur d'Info",4,3,1,1),
			new Monstre("Professeur d'Info",4,3,1,1),
			new Monstre("Professeur d'Info",4,3,1,1),
			
			new Monstre("Bus Remplie",4,3,1,1),
			new Monstre("Bus Remplie",4,3,1,1),
			new Monstre("8H - 19H15",4,3,2,1),
			new Monstre("8H - 19H15",4,3,2,1),
			new Monstre("Batiment B",5,3,1,1),
			
			new Monstre("Batiment B",5,3,1,1),
			new Monstre("Amphi du batiment I",5,3,1,1),
			new Monstre("Amphi du batiment I",5,3,1,1),
			new Monstre("Examen de MBE",5,3,1,2),
			new Monstre("Examen de MBE",5,3,1,2),
			
			new Monstre("Examen d'IA41",5,3,2,2),
			new Monstre("Examen d'IA41",5,3,2,2),
			new Monstre("Examen d'IA41",5,3,2,2),
			new Monstre("Interface graphique JAVA",6,2,3,1),
			new Monstre("Interface graphique JAVA",6,2,3,1),
			
			new Monstre("Interface graphique JAVA",6,2,3,1),
			new Monstre("Cour de sport",4,2,1,1),
			new Monstre("Cour de sport",4,2,1,1),
			new Monstre("Cour de sport",4,2,1,1),
			new Monstre("Cour de sport",4,2,1,1),
			
			new Monstre("Examen de réseau",7,3,1,2),
			new Monstre("Examen de réseau",7,3,1,2),
			new Monstre("Examen de réseau",7,3,1,2),
			new Monstre("La branche info",7,4,2,1),
			new Monstre("La branche info",7,4,2,1),
			
			new Monstre("La branche info",7,4,2,1),
			new Monstre("Mr Montavo",7,1,3,3),
			new Monstre("Mr Montavo",7,1,3,3),
			new Monstre("Mr Montavo",7,1,3,3),
			new Monstre("Mr Montavo",7,1,3,3),
			
			new Monstre(),
			new Monstre("Examen de Mr. Tureberg",8,4,2,2),
			new Monstre("Examen de Mr. Tureberg",8,4,2,2),
			new Monstre("Examen de Mr. Zulo",8,4,1,2),
			new Monstre("Examen de Mr. Zulo",8,4,1,2),
			
			new Monstre("Mr. Gechter",14,10,1,3), // Monstre légendaire Mr. Gechter
			new Monstre("Mr. Lassabe",14,10,1,3), // Monstre légendaire Mr. Lassabe

			new Race("Le département Informatique vous fait de l'oeil",0),
			new Race("Le département EDIM vous fait de l'oeil",1),
			new Race("Le département GMC vous fait de l'oeil",2),
			new Race("Le département IMSI vous fait de l'oeil",3),
			new Race("Le département Energie vous fait de l'oeil",4),
			new Race("Devenir TC vous fait de l'oeil",5),
			new Race("Devenir Branche vous fait de l'oeil",6),
			new Race("Devenir Prof vous fait de l'oeil",7),
			
			new Malediction("Rate toutes ses CS",0),
			new Malediction("Rate toutes ses TM",0),
			new Malediction("Rate toutes ses T2S",0),
			new Malediction("Passe au jury",1),
			new Malediction("Passe au jury",1),
			
			new Malediction("Passe au jury",1),
			new Malediction("Pas assez d'argent pour le café",12),
			new Malediction("Mal dormi",12),
			new Malediction("Repas du CROUS ténébreux",12),
			new Malediction("Vous avez un F en AP4A",13),
			
			new Malediction("Vous avez un F en AP4B",13),
			new Malediction("Utilise les ordinateurs comme une grand-mère",14),
			new Malediction("Comprend absolument rien aux cours de réseau",14),
			new Malediction("Vous n'êtes pas aller chez le coiffeur depuis longtemps",15),
			new Malediction("Vous codez trop la lumière du jour vous manque",15),
			
			new Malediction("Le froid de Belfort vous à fait utilisez tout vos T-Shirt propre vous en mettez un sale",16),
			new Malediction("Vous oubliez votre blouse en tp",16),
			new Malediction("Vous n'avez plus de lessive vous ne pouvez plus lavez vos habits",17),
			new Malediction("Vous n'avez plus de lessive vous ne pouvez plus lavez vos habits",17),
			new Malediction("Vous oubliez vos chaussures de sécurité en tp",18),
			
			new Malediction("C'est le début de l'été vous mettez vos tongs",18),
			new Malediction("Le prof n'est pas la...",11),
			new Malediction("Le prof n'est pas la...",11),
			new Malediction("Le prof n'est pas la...",11)
			};
	
	public static final Carte deckTresorDefautUTBM_[] = { // Deck tresors avec l'etension UTBM par défaut 84 Cartes
			new Equipement("Casque hyperX cloud 2",0,1,500), // Set Info
			new Equipement("T-shirt Z-event",1,1,300),
			new Equipement("Caleçon pikachu",2,1,500),
			new Equipement("Chaussette Dragon Ball Z",3,1,100),
			new Equipement("Souris logitech",4,2,300),
			
			new Equipement("Casquette de maquétteur",0,2,300), // Set EDIM
			new Equipement("T-shirt à fleurs",1,1,100),
			new Equipement("Pantalon de velour",2,1,500),
			new Equipement("Doc Marteens",3,1,500),
			new Equipement("Gommette",4,1,300),
			
			new Equipement("Lunette de labo",0,1,100), // Set GMC
			new Equipement("Blouse",1,2,300),
			new Equipement("Pantalon Carhart",2,1,500),
			new Equipement("Vans",3,1,500),
			new Equipement("Imprimante 3D",4,1,300),
			
			new Equipement("Casque de sécurité",0,1,500), // Set IMSI
			new Equipement("Gilet jaune",1,2,100),
			new Equipement("Pantalon de sécurité",2,1,300),
			new Equipement("Chaussure de securité",3,1,300),
			new Equipement("Fraiseuse",4,1,500),
			
			new Equipement("Echarpe EDF",0,1,300), // Set Energie
			new Equipement("T-shirt Tesla",1,1,500),
			new Equipement("Pantalon en caoutchouc",2,1,300),
			new Equipement("Chaussette Arc-En-Ciel",3,2,300),
			new Equipement("Cable en cuivre",4,1,500),
			
			new Equipement("Boucle d'oreille stylé",0,1,300), // Set Gala Femme
			new Equipement("Robe de gala",1,1,500),
			new Equipement("Collant",2,1,300),
			new Equipement("Talon haut",3,1,500),
			new Equipement("Bouteille de champagne",4,2,100),
			
			new Equipement("Noeud papillon",0,2,100), // Set Gala Homme
			new Equipement("Veste de costume",1,1,500),
			new Equipement("Pantalon de costume",2,1,500),
			new Equipement("Mocassin",3,1,300),
			new Equipement("Bouteille de vin",4,1,300),
			
			new Equipement("Mortardboard (Chapeau diplomé)",0,1,500), // Set diplomée
			new Equipement("Echarpe de diplomé",1,1,500),
			new Equipement("Pantlalon classe",2,2,300),
			new Equipement("Chaussure classe",3,1,100),
			new Equipement("Diplome d'ingénieur",4,1,300),
			
			new Equipement("Calot",0,2,500), // Set CROUS
			new Equipement("Tablier",1,1,300),
			new Equipement("Pantalon de cuisine",2,1,300),
			new Equipement("Chaussure de cuisine",3,1,500),
			new Equipement("Spatule",4,1,100),
			
			new Equipement("Lunette",0,2,300), // Set Legendaire Gechter
			new Equipement("Chemise à carreau",1,1,500),
			new Equipement("Pantalon en Jean",2,1,300),
			new Equipement("Richelieu",3,1,500),
			new Equipement("Humour",4,3,500),
			
			new Equipement("Grosse lunette",0,2,500), // Set Legendaire Enora
			new Equipement("Manteau long noir",1,3,500),
			new Equipement("Pantalon noir",2,1,300),
			new Equipement("VEJA à scratch",3,1,300),
			new Equipement("Machine à coudre",4,1,500),
			
			new Equipement("Casquette celtics",0,1,500), // Set Legendaire Charles
			new Equipement("Doudoune grise",1,1,500),
			new Equipement("Jogging nike",2,3,300),
			new Equipement("New Balance 530",3,1,300),
			new Equipement("Sacoche",4,3,500),
			
			new Malediction("Valide toutes ses CS",2),
			new Malediction("Valide toutes ses TM",2),
			new Malediction("Valide toutes ses T2S",2),
			new Malediction("Pistonner par Ghislain",3),
			new Malediction("Pistonner par Ghislain",3),
			
			new Malediction("Pistonner par Ghislain",3),
			new Malediction("Prend un café noisette",4),
			new Malediction("Bien dormi",4),
			new Malediction("Repas du CROUS excellent",4),
			new Malediction("Vous avez un A en AP4A",5),
			
			new Malediction("Vous avez un A en AP4B",5),
			new Malediction("Manipulez une souris comme personne",6),
			new Malediction("Votre entrainement à brancher des cables RJ45 vous rend plus fort",6),
			new Malediction("Votre calvitie prend du terrain",7),
			new Malediction("Le stress des examens vous fait perdre vos cheveux",7),
			
			new Malediction("Vous tombez sur un sweat UTBM",8),
			new Malediction("Vous participez à un questionnaire et gagner un T-Shirt etu-Campus",8),
			new Malediction("Il fait trop froid a belfort vous mettez votre dessous de ski",9),
			new Malediction("Il fait trop froid a belfort vous mettez votre dessous de ski",9),
			new Malediction("Vous tombez sur des chaussures de securité neuve",10),
			
			new Malediction("L'été est fini vous rangez vos tong",10),
			new Malediction("Vous allez en cour...",11),
			new Malediction("Vous allez en cour...",11),
			new Malediction("Vous allez en cour...",11)
			};

	
	
	/*--------------------- Constructeur ---------------------*/
	
	/*! @brief Constructeur par défaut
	 * 
	 * Comportement :
	 * Masque est private pour empecher l'instanciation, 
	 * On utilise également AssertionError pour catch l'erreur qui serait crée par une tentative d'instanciation.
	 */
    private Constants() {
        throw new AssertionError();
    }
}
