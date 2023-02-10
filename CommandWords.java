import java.util.HashMap;

public class CommandWords {
    private HashMap<String, CommandWord> aValidCommands;

    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        this.aValidCommands.put("help", CommandWord.HELP);
        this.aValidCommands.put("lancer", CommandWord.LANCER);
        this.aValidCommands.put("carte", CommandWord.CARTE);
        this.aValidCommands.put("propriete", CommandWord.PROPRIETE);
        this.aValidCommands.put("quitter", CommandWord.QUITTER);
        this.aValidCommands.put("acheter", CommandWord.ACHETER);
        this.aValidCommands.put("vendre", CommandWord.VENDRE);
    }//CommandWords()


    public CommandWord getCommandWord(final String pCommandWord)
    {
        CommandWord vCommand = this.aValidCommands.get(pCommandWord);
        if( vCommand != null)
        { return vCommand; }
        else
        { return CommandWord.UNKNOWN ;}
    }//getCommandList(.)

    public boolean isCommand( final String pString )
    {
        return this.aValidCommands.containsKey(pString);
    } // isCommand(.)

    /**
     * Affiche toutes les commandes valides sur System.out.
     */
    public String getAllCommands()
    {
        String vCommands = "";
        for(String vCommand : this.aValidCommands.keySet())
        { vCommands += vCommand + " " ;}
        return vCommands ;
    }//getAllCommands()
}
