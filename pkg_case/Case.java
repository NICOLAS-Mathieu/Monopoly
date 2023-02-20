package pkg_case;

import pkg_game.Joueur;

/**
 * Décrivez votre classe Case ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Case
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aNumero;
    private String aDescription;
    private Joueur aProprietaire;

    /**
     * Constructeur d'objets de classe Case
     */
    public Case(final int pNum, final String pDescription, Joueur pProprietaire)
    {
        // initialisation des variables d'instance
        this.aNumero = pNum;
        this.aDescription = pDescription;
        this.aProprietaire= pProprietaire;
    }//Case(.)

    /**
     * Retourne la description d'une case
     * @return
     */
    public String getDescription() {return this.aDescription;} //getDes

    /**
     * Retourne le numéro d'une case
     * @return
     */
    public int getNumero() {return this.aNumero;} //getNumero()

    public Joueur getProprietaire(){return this.aProprietaire;}

    public void setProprietaire(final Joueur pProprietaire)
    {
        this.aProprietaire = pProprietaire;
    }
}
