package pkg_commands;

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
        this.aValidCommands.put("joueur", CommandWord.JOUEUR);
        this.aValidCommands.put("start", CommandWord.START);
        this.aValidCommands.put("passer", CommandWord.PASSER);
        this.aValidCommands.put("detail", CommandWord.DETAIL);
        this.aValidCommands.put("enchere", CommandWord.ENCHERE);
        this.aValidCommands.put("miser", CommandWord.MISER);
        this.aValidCommands.put("maison", CommandWord.MAISON);
        this.aValidCommands.put("hotel", CommandWord.HOTEL);
        this.aValidCommands.put("rembourser", CommandWord.REMBOURSER);
        this.aValidCommands.put("choix", CommandWord.CHOIX);
        this.aValidCommands.put("test", CommandWord.TEST);
        this.aValidCommands.put("lancerTest", CommandWord.LANCERTEST);
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
