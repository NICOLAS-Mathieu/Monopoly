/**
 * Type de propriete particulière. Le loyer dépend du nombre de gares que le joueur possède.
 */
public class Gare extends Propriete
{
    /**
     * Constructeur d'objets de classe Gare
     */
    public Gare(final int pNum, final String pDescription, final int pPrixDeVente, final int pLoyer, final Joueur pProprietaire)
    {
        super(pNum, pDescription, pPrixDeVente, pLoyer, pProprietaire);
    }


}
