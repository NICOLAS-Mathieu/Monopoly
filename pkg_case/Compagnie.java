package pkg_case;

import pkg_game.Joueur;

/**
 * Type de propriété particulière qui dépend du déplacement effectué avant d'arrivé sur la case
 * et du nombre de propriétés que le propriétaire possède.
 */
public class Compagnie extends Propriete
{
    /**
     * Constructeur d'objets de classe Compagnie.
     */
    public Compagnie(final int pNum, final String pDescription, final int pPrixDeVente, final int[] pLoyer, final int pPrixHypotheque, final Joueur pProprietaire)
    {
        super(pNum, pDescription, pPrixDeVente, pLoyer, pPrixHypotheque, pProprietaire);
    }
}
