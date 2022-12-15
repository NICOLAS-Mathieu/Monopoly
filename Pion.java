
/**
 * Décrivez votre classe Pion ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pion
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aCouleur;
    private int aPosition;

    /**
     * Constructeur d'objets de classe Pion
     */
    public Pion()
    {
        // initialisation des variables d'instance
        aPosition = 0;
    }

    /**
     * Modifie la couleur du pion
     *
     */
    public void setCouleur(String pCouleur)
    {
        this.aCouleur = pCouleur;
    }
    
    /**
     * Modifie la position du pion
     *
     */
    public void setPosition(int pPosition)
    {
        this.aPosition = pPosition;
    }
    
    /**
     * Accède à la couleur du pion
     *
     * @return     la couleur du pion
     */
    public String getCouleur()
    {
        return this.aCouleur;
    }
    
    /**
     * Accède à la position du pion
     *
     * @return     la position du pion
     */
    public int getPosition()
    {
        return this.aPosition;
    }
}
