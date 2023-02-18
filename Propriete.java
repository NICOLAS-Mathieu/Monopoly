
/**
 * Décrivez votre classe Propriete ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Propriete extends Case
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aPrixDeVente;
    private int[] aLoyer;
    private int aPrixHypotheque;
    private int aIndex;
    //private Joueur aProprietaire;

    /**
     * Constructeur d'objets de classe Propriete
     */
    public Propriete(final int pNum, final String pDescription, final int pPrixDeVente,
                     final int[] pLoyer, final int pPrixHypotheque, final Joueur pProprietaire)
    {
        // initialisation des variables d'instance
        super(pNum, pDescription, pProprietaire);
        this.aPrixDeVente = pPrixDeVente;
        this.aLoyer = pLoyer;
        this.aPrixHypotheque = pPrixHypotheque;
        this.aIndex  =0;
        //this.aProprietaire = pProprietaire;
    }
    
    /**
     * Getteurs
     */
    public int getPrixDeVente()
    {
        return this.aPrixDeVente;
    }
    
    public int getLoyer()
    {
        return this.aLoyer[this.aIndex];
    }
    
    //public Joueur getProprietaire() { return this.aProprietaire; }
    
    /**
     * Setteurs
     */
    public void setPrixDeVente(final int pPrixDeVente)
    {
        this.aPrixDeVente = pPrixDeVente;
    }
    
    public void setLoyer(final int pIndex)
    {
        this.aIndex = pIndex;
    }

    //public void setProprietaire(final Joueur pProprietaire) { this.aProprietaire = pProprietaire; }
}
