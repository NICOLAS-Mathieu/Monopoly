public class GameEngine {


    /**
     * Constructeur pour les objets de la classe GameEngine
     */
    public GameEngine()
    {
        this.createProprietes();
    }//GameEngine()

    /**
     * Créer toutes les propriétés du jeu.
     */
    private void createProprietes()
    {
        Rue vRueLecourbe = new Rue(1, "Rue Lecourbe", "Marron", 60, [2,10,30,90,160,250], 50, 30, null);
        Rue vBoulevardDeBelleville = new Rue(3, "Boulevard de Belleville", "Marron", 60, [4,20,60,180,320,450], 50, 30, null);
        Rue vAvenueDeLaRepublique = new Rue(6, "Avenue de la République", "Bleu ciel", 100, [5,30,90,270,400,550], 50, 50, null);
        Rue vRueDeCourcelles = new Rue(8, "Rue de Courcelles");
    }//createProprietes()

    public void processCommand( final String pCommandLine )
    {

    }
}

