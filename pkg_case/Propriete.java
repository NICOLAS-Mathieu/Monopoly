package pkg_case;

import pkg_game.Joueur;

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
        //this.aProprietaire = pProprietaire;
    }
    
    /**
     * Getteurs
     */
    public int getPrixDeVente()
    {
        return this.aPrixDeVente;
    }
    
    public int getLoyer(int pIndex)
    {
        return this.aLoyer[pIndex];
    }

    public int getPrixHypotheque() {return this.aPrixHypotheque;}

    
    /**
     * Setteurs
     */
    public void setPrixDeVente(final int pPrixDeVente)
    {
        this.aPrixDeVente = pPrixDeVente;
    }


}
