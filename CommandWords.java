public class CommandWords {
    private final String[] aValidCommands;

    public CommandWords()
    {
        this.aValidCommands = new String[3];
        this.aValidCommands[0] = "help";
        this.aValidCommands[1] = "lancer";
        this.aValidCommands[2] = "Carte";
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
