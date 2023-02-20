package pkg_game;

import java.util.StringTokenizer;

import pkg_commands.CommandWords;
import pkg_commands.Command;

public class Parser {
    private CommandWords aValidCommands;

    public Parser() {
        this.aValidCommands = new CommandWords();
    }//Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) {
        String vWord1 = null;
        String vWord2 = null;
        String vWord3 = null;

        StringTokenizer vTokenizer = new StringTokenizer(pInputLine);

        if (vTokenizer.hasMoreTokens()) {
            vWord1 = vTokenizer.nextToken();      // recupere le premier mot
            if (vTokenizer.hasMoreTokens()) {
                vWord2 = vTokenizer.nextToken();  // recupere le deuxieme mot
                if(vTokenizer.hasMoreTokens()){
                    vWord3 = vTokenizer.nextToken(); //recupere le deuxieme mot
                    }
                    // note : on ignore tout le reste de la ligne tapee !
                }
            } // if

        return new Command(this.aValidCommands.getCommandWord(vWord1), vWord2, vWord3);
    } // getCommand(.)

    /**
     * Affiche une liste des commandes valides.
     */
    public String getCommandsList() {
        CommandWords vCommandWords = new CommandWords();
        return aValidCommands.getAllCommands();
    }//getCommandsList()
}
