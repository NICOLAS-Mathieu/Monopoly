
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

    /**
     * Constructeur d'objets de classe Case
     */
    public Case(final int pNum, final String pDescription)
    {
        // initialisation des variables d'instance
        this.aNumero = pNum;
        this.aDescription = pDescription;
    }//Case(.)

    public String getDescription() {return this.aDescription;}
    public int getNumero()
    {
        // Insérez votre code ici
        return this.aNumero;
    }//getNumero()
}
