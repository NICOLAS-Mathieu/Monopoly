
/**
 * Décrivez votre classe Rue ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Rue extends Propriete
{
    private int aPrixConstruction;
    private String aCouleur;
    private int aNbMaisons;
    private int aNbHotels;
    
    /**
     * Constructeur d'objets de classe Rue
     */
    public Rue(final int pNum, final String pDescription,
               final String pCouleur, final int pPrixDeVente,
               final int[] pLoyer, final int pPrixConstruction, final int pPrixHypotheque,
               final Joueur pProprietaire)
    {
        // initialisation des variables d'instance
        super(pNum, pDescription, pPrixDeVente, pLoyer, pPrixHypotheque, pProprietaire);
        this.aCouleur = pCouleur;
        this.aPrixConstruction = pPrixConstruction;
        this.aNbMaisons = 0;
        this.aNbHotels = 0;
    }
    
    /**
     * Getteurs
     */
    public int getNbMaisons()
    {
        return(this.aNbMaisons);
    }
    
    public int getNbHotel()
    {
        return(this.aNbHotels);
    }

    public int getPrixConstruction() {return this.aPrixConstruction;}
    
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
