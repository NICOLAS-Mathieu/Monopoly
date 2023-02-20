package pkg_game;

import java.util.Random;

/**
 * Décrivez votre classe De ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class De
{
    private int aNbDe;

    /**
     * Constructeur d'objets de classe De
     */
    public De()
    {
        aNbDe = 0;
    }

    public int lanceDe()
    {
        Random random = new Random();
        aNbDe =+ random.nextInt(1,7);
        return aNbDe;
    }

    public int getNbDe()
    {
        return aNbDe;
    }

}
