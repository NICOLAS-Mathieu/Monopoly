/**
 * La classe CommandWord déffinit toutes les commandes possibles du
 * jeu.
 *
 * @author NICOLAS Mathieu
 * @version 02/01/2022
 */
public enum CommandWord
{
    // Une valeur pour chaque mot de commande avec sa chaîne
    // d'interface utilisateur correspondante.
    HELP("help"), QUITTER("quitter"), LANCER("lancer"),
    CARTE("carte"), PROPRIETE("propriete"), UNKNOWN("?"),
    ACHETER("acheter"), VENDRE("vendre"), JOUEUR("joueur"), 
    START("start"), PASSER("passer"), DETAIL("detail"),
    ENCHERE("enchere"), MISER("miser"), MAISON("maison"),
    HOTEL("hotel");

    //Le mot de commande.
    private String aCommandWord;

    /**
     * Initialise avec le mot de commande correspondant.
     * @param pCommandWord Le mot de commande.
     */
    CommandWord(final String pCommandWord)
    {
        this.aCommandWord = pCommandWord;
    }

    /**
     * @return Le mot de commande en chaîne.
     */
    public String toString()
    { return this.aCommandWord ;}
}
