package munchkin;

import java.util.Random;

/*! @brief Class qui permet de modélisé un dé */
public class Dice {
	/*--------------------- Attributs ---------------------*/
	protected int face; // Le nombre de face du dé
    protected Random random; // Moteur aléatoire

	/*--------------------- Constructeurs ---------------------*/
    
    /*! @brief Constructeur par défaut
     * 
     * Comprotement : 
     * Initialise un dé à 6 faces par défaut.
     */
    public Dice() {
        face = 6;
        random = new Random();
    }
    
    /*! @brief Constructeur avec choix utilisateurs
     * 
     * Comprotement : 
     * Initialise un dé à face_ faces.
     */
    public Dice(int face_) {
        if (face_ <= 0) {
            throw new IllegalArgumentException("Le nombre de faces doit être supérieur à zéro.");
        }
        face = face_;
        random = new Random();
    }

	/*--------------------- Method ---------------------*/

    /*! @brief Method qui permet de lancer le dé
     *  @return Le numéro obtenue après avoir lancé le dé
     * 
     * Comprotement : 
     * Utilise un moteur random pour initialisé un chiffre de 1 à face_
     */
    public int roll() {
        return random.nextInt(face) + 1; // Ajoute 1 pour obtenir des valeurs de 1 à sides inclus
    }

}
