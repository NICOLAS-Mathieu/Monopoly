
import java.util.Random;

/**
 * Décrivez votre classe De ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class De
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aNbDe;

    /**
     * Constructeur d'objets de classe De
     */
    public De()
    {
        aNbDe = 1;
    }

    public int lanceDe()
    {
        Random random = new Random();
        aNbDe =+ random.nextInt(6);
        return aNbDe;
    }
}
