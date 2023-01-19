
/**
 * Un pion est la représentation d'un joueur sur le plateau. Il indique sa position.
 */
public class Pion
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aCouleur;
    private String aPosition;

    /**
     * Constructeur d'objets de classe Pion
     */
    public Pion(String pCouleur)
    {
        // initialisation des variables d'instance
        this.aCouleur = pCouleur;
        this.aPosition = "Depart";
    }
    
    /**
     * Modifie la position du pion
     *
     */
    public void setPosition(String pPosition)
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
    public String getPosition()
    {
        return this.aPosition;
    }
}
