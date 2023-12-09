package munchkin;
import java.util.ArrayList;
import java.util.List;


/*! @brief Class qui permet de modélisé une liste de joueurs */
public class Joueurs {
	/*--------------------- Attributs ---------------------*/
	
	private List<Joueur> listeJoueurs; // Liste des joueurs
	
	/*--------------------- Constructeurs ---------------------*/
	
	/*! @brief Constructeur par défaut
	 *  
	 * Comportement :
	 * Initialise une liste de 3 Joueurs par défaut.
	 */
	public Joueurs() {
		listeJoueurs = new ArrayList<Joueur>(3); // Initialise une liste de 3 Joueurs par défaut
		for(int i = 0; i < 3; ++i) { // Initialise les 3 Joueurs avec le constructeur par défaut de Joueur
			listeJoueurs.add(i, new Joueur());
		}
	}
	
	/*! @brief Constructeur utilisé par le jeu
	 *  @param plateau Le Board du jeu
	 *  @param nbJoueur Le nombre de joueurs
	 *  
	 * Comportement :
	 * Initialise une liste de nbJoueur Joueur en utilisant le plateau de jeu.
	 */
	public Joueurs(Board plateau, int nbJoueur) {
		listeJoueurs = new ArrayList<Joueur>(nbJoueur); // Initialise une liste de nbJoueur Joueurs
		for(int i = 0; i < 3; ++i) { // Initialise les 3 Joueurs avec le constructeur avec nom et plateau de Joueur
			listeJoueurs.add(i, new Joueur("Joueur " + String.valueOf(i), plateau));
		}
	}
	
	/*--------------------- Getter ---------------------*/

	/*! @brief Renvoie le joueur à l'index choisi
	 *  @param index L'index du joueur voulue
	 *  @return Renvoie le Joueur qui est a l'index choisi
	 *  
	 *  Comportement :
	 *  Renvoie le Joueur a l'index choisi.
	 */
	public Joueur getJoueur(int index) {
		return listeJoueurs.get(index);
	}
	
	/*--------------------- Method ---------------------*/

	/*! @brief Méthode qui vérifie si quelqu'un a gagner
	 *  @return L'index si quelqu'un a gagner, sinon -1
	 *  
	 *  Comportement : 
	 *  Itère à travers la liste de joueur et vérifie à l'aide de la méthode de Joueur isWinning(),
	 *  Si quelqu'un à gagner, si quelqu'un à gagner renvoie l'index sinon -1.
	 */
	public int isSomeoneWinning() {
		for(int i = 0; i < listeJoueurs.size(); ++i) { // Itère à travers la liste
			if(listeJoueurs.get(i).isWinning()) return i; // Si quelqu'un a gagner renvoie l'index du gagnant
		}
		return -1; // Si on ne trouve pas de gagnant renvoie -1
	}
}
