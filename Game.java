import pkg_game.GameEngine;
import pkg_game.UserInterface;

/**
 * La classe Game permet la création du jeu.
 *
 * @author NICOLAS Mathieu, ALEXANDRE Orlane, FOURNIER Goulven, MUZEAU Amael
 * @version 02/01/2022
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;


    /**
     * Crée le jeu et initialise sa carte.
     */
    public Game()
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI(this.aGui);
    }//Game()

    public static void main(String[] args){
        Game game = new Game();
    }
} // Game



