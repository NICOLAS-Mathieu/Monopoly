
/**
 * Décrivez votre classe Carte ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Carte
{
    private int aPrix;
    private boolean aDeplacement;
    private String aDescription;

    /**
     * Constructeur d'objets de classe CarteCommunaute
     */
    public Carte(int pPrix, boolean pDeplacement, String pDescription)
    {
        this.aPrix = pPrix;
        this.aDeplacement = pDeplacement;
        this.aDescription = pDescription;
    }

    public int getPrix()
    {
        return this.aPrix;
    }
    
    public boolean getDeplacement()
    {
        return this.aDeplacement;
    }
    
    public String getDescription()
    {
        return this.aDescription;
    }
}
