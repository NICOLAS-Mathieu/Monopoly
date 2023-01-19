public class Command
{
    private String aCommandWord;
    private String aSecondWord;

    /***
     *
     * Constructeur de command avec initialisation de deux mots dans la barre de commande
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }//Command()

    /***
     * Cette methode permet d'obtenir le premier mot.
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    }//getCommandWord()

    /***
     * Cette methode permet d'obtenir le deuxieme mot.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord()

    /***
     * Cette methode permet de verifier s'il y a bien un deuxieme mot.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }//hasSecondWord()

    /***
     * Cette methode permet de voir si le premier mot est inconnue.
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    }//isUnknown()


}
