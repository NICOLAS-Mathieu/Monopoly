
/**
 * Décrivez votre classe Rue ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Rue extends Propriete
{
    private int aNbMaisons;
    private int aNbHotels;
    
    /**
     * Constructeur d'objets de classe Rue
     */
    public Rue(final int pPrixDeVente, final int pLoyer, final Joueur pProprietaire)
    {
        // initialisation des variables d'instance
        super(pPrixDeVente, pLoyer, pProprietaire);
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
