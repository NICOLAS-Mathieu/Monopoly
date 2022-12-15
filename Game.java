import java.util.ArrayList;

/**
 * Décrivez votre classe Game ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Game
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Plateau aPlateau;
    private ArrayList aJoueurs;

    /**
     * Constructeur d'objets de classe Game
     */
    public Game()
    {
        // initialisation des variables d'instance
        this.aPlateau = new Plateau();
        this.aJoueurs = new ArrayList();
    }
}
