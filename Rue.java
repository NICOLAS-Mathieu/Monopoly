import java.util.ArrayList;

/**
 * Décrivez votre classe Rue ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Rue extends Propriete
{
    private int aPrixConstruction;
    private int aPrixHypotheque;
    private String aCouleur;
    private int aNbMaisons;
    private int aNbHotels;
    
    /**
     * Constructeur d'objets de classe Rue
     */
    public Rue(final int pNum, final String pDescription,
               final String pCouleur, final int pPrixDeVente,
               final ArrayList pLoyer, final int pPrixConstrucion, final int pPrixHypotheque,
               final Joueur pProprietaire)
    {
        // initialisation des variables d'instance
        super(pNum, pDescription, pPrixDeVente, pLoyer, pProprietaire);
        this.aCouleur = pCouleur;
        this.aNbMaisons = 0;
        this.aNbHotels = 0;
    }
    
    /**
     * Getteurs
     */
    public int getNbMaions()
    {
        return(this.aNbMaisons);
    }
    
    public int getNbHotels()
    {
        return(this.aNbHotels);
    }
    
    /**
     * Setteurs
     */
    public void setNbMaisons(final int pNbMaisons)
    {
        this.aNbMaisons = pNbMaisons;
    }
    
    public void setNbHotels(final int pNbHotels)
    {
        this.aNbHotels = pNbHotels;
    }
}
