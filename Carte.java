
/**
 * Décrivez votre classe Carte ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Carte
{
    private int aPrix;
    private int aDeplacement;
    private String aDescription;
    private int aAction;

    /**
     * Constructeur d'objets de classe CarteCommunaute
     */
    public Carte(final int pPrix, final int pDeplacement, final String pDescription, final int pAction)
    {
        this.aPrix = pPrix;
        this.aDeplacement = pDeplacement;
        this.aDescription = pDescription;
        this.aAction = pAction;
    }

    public int getPrix()
    {
        return this.aPrix;
    }
    
    public int getDeplacement()
    {
        return this.aDeplacement;
    }
    
    public String getDescription()
    {
        return this.aDescription;
    }


}
