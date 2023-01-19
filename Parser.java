import java.util.StringTokenizer;

public class Parser {
    private CommandWords aValidCommands;

    public Parser()
    {
        this.aValidCommands = new CommandWords();
    }//Parser()

    public String getCommandString()
    {
        return this.aValidCommands.getCommandList();
    }//getCommandString()

    public Command getCommand( final String pInputLine )
    {
        String vWord1;
        String vWord2;

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();
        else
            vWord1 = null;

        if( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();
        else
            vWord2 = null;

        if ( this.aValidCommands.isCommand( vWord1 ) )
            return new Command( vWord1, vWord2 );
        else
            return new Command( null, vWord2 );
    }//getCommand
}
