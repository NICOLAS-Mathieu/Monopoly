public class CommandWords {
    private final String[] aValidCommands;

    public CommandWords()
    {
        this.aValidCommands = new String[11];
        this.aValidCommands[0] = "help";
        this.aValidCommands[1] = "lancer dés";
        this.aValidCommands[2] = "Carte";
        this.aValidCommands[3] = "Propriete 1";
        this.aValidCommands[4] = "Propriete 2";
        this.aValidCommands[5] = "Propriete 3";
        this.aValidCommands[6] = "Propriete 4";
        this.aValidCommands[7] = "Propriete 5";
        this.aValidCommands[8] = "Propriete 6";
        this.aValidCommands[9] = "Propriete 7";
        this.aValidCommands[10] = "Propriete 8";

    }//CommandWords()


    public String getCommandList()
    {
        StringBuilder vCommands = new StringBuilder();
        for(String CommandWords : aValidCommands)
        {
            vCommands.append(CommandWords).append(" ");
        }
        return vCommands.toString();
    }//getCommandList

    public boolean isCommand( final String pString )
    {
        for (String aValidCommand : this.aValidCommands) {
            if (aValidCommand.equals(pString)) {
                return true;
            }
        }

        return false;
    } // isCommand()
}
