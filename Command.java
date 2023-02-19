public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;
    private String aThirdWord;

    /***
     *
     * Constructeur de command avec initialisation de deux mots dans la barre de commande
     */
    public Command(final CommandWord pCommandWord, final String pSecondWord, final String pThirdWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
        this.aThirdWord = pThirdWord;
    }//Command()

    /***
     * Cette methode permet d'obtenir le premier mot.
     */
    public CommandWord getCommandWord()
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
     * Cette methode permet d'obtenir le troisième mot.
     */
    public String getThirdWord()
    {
        return this.aThirdWord;
    }//getSecondWord()

    /***
     * Cette methode permet de verifier s'il y a bien un deuxieme mot.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }//hasSecondWord()

    /***
     * Cette methode permet de verifier s'il y a bien un troisieme mot.
     */
    public boolean hasThirdWord()
    {
        return this.aThirdWord != null;
    }//hasSecondWord()

    /***
     * Cette methode permet de voir si le premier mot est inconnue.
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    }//isUnknown()


}
