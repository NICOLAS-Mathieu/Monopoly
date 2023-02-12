import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {

    private Parser aParser;
    private UserInterface aGui;
    private int aNBlancer;

    /**
     * Constructeur pour les objets de la classe GameEngine
     */
    public GameEngine()
    {
        this.createProprietes();
        this.createGare();
        this.createCompagnie();
        this.createCase();
        this.createCarte();
        this.aParser = new Parser();

    }//GameEngine()

    /***
     * Cette procedure affiche le message de bienvenue.
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.aGui.showImage("plateau.jpg");
    }

    /**
     * Accesseur pour le Parser.
     */
    public Parser getParser() { return this.aParser; } //getParser()


    /**
     * Créer toutes les propriétés du jeu.
     */
    private void createProprietes()
    {
        // Marron
        Rue vBoulevardDeBelleville = new Rue(1, "Boulevard de Belleville", "Marron", 60, new int[]{2, 10, 30, 90, 160, 250}, 50, 30, null);
        Rue vRueLecourbe = new Rue(3, "Rue Lecourbe", "Marron", 60, new int[]{4,20,60,180,320,450}, 50, 30, null);
        // Bleu ciel
        Rue vRueDeVaugirard = new Rue(6, "Rue de Vaugirard", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        Rue vRueDeCourcelles = new Rue(8, "Rue de Courcelles", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        Rue vAvenueDeLaRepublique = new Rue(9, "Avenue de la République","Bleu ciel", 120, new int[]{8,40,100,300,450,600}, 50, 60, null);
        // Rose
        Rue vBoulevardDeLaVillette = new Rue(11, "Boulevard de la Villette", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        Rue vAvenueDeNeuilly = new Rue(13, "Avenue de Neuilly", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        Rue vRueDeParadis = new Rue(14, "Rue de Paradis", "Rose", 160, new int[]{12,60,180,500,700,900}, 100, 80, null);
        // Orange
        Rue vAvenueMozart = new Rue(16, "Avenue Mozart", "Orange", 180, new int[]{14,70,200,550,700,900}, 100, 90, null);
        Rue vBoulevardSaintMichel = new Rue(18, "Boulevard Saint-Michel", "Orange", 180, new int[]{14,70,200,550,700,950}, 100, 90, null);
        Rue vPlacePigalle = new Rue(19, "Place Pigalle", "Orange", 200, new int[]{16,80,220,600,800,1000}, 100, 100, null);
        //Rouge
        Rue vAvenueMatignon = new Rue(21, "Avenue  Matignon", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150,110, null);
        Rue vBoulevardMalesherbes = new Rue(23, "Boulevard Malesherbes", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150, 110, null);
        Rue vAvenueHenriMartin = new Rue(24, "Avenue Henri-Martin", "Rouge", 240, new int[]{20,100,300,750,925,1100}, 150, 120, null);
        //Jaune
        Rue vFaubourgSaintHonore = new Rue(26, "Faubourg Saint-Honoré", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        Rue vPlaceDeLaBourse = new Rue(27, "Place de la Bourse", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        Rue vRueLaFayette= new Rue(29, "Rue La Fayette", "Jaune", 280, new int[]{24,120,360,850,1025,1200}, 150, 140, null);
        //Vert
        Rue vAvenueDeBreteuil = new Rue(31, "Avenue de Breteuil", "Vert", 300,  new int[]{26,130,390,900,1100,1275}, 200, 150, null);
        Rue vAvenueFoch = new Rue(32, "Avenue Foch", "Vert", 300, new int[]{26,130,390,900,1100,1275}, 200, 150,null);
        Rue vBoulevardDesCapucines = new Rue(34, "Boulevard des Capucines", "Vert", 320, new int[]{28,150,450,1000,1200,1400}, 200, 160, null);
        //Bleu foncé
        Rue vAvenueChampsElisees = new Rue(37, "Avenue Champs-Élysées", "BleuFonce", 350, new int[]{35,175,500,1100,1300,1500}, 200, 175, null);
        Rue vRueDeLaPaix = new Rue(39, "Rue de la  Paix", "BleuFonce", 400, new int[]{50,200,600,1400,1700,2000}, 200, 200, null);
    }//createProprietes()

    public void createGare()
    {
        Gare vGareMontparnasse = new Gare(5, "Gare Montparnasse", 200, new int[]{25,50,100,200}, 100, null);
        Gare vGareDeLyon = new Gare(15, "Gare de Lyon", 200, new int[]{25,50,100,200}, 100, null);
        Gare vGareDuNord = new Gare(25, "Gare du Nord", 200, new int[]{25,50,100,200}, 100, null);
        Gare vGareSaintLazare = new Gare(35, "Gare Saint-Lazare", 200, new int[]{25,50,100,200}, 100, null);
    }//createGare()

    public void createCompagnie()
    {
        Compagnie vElectricite = new Compagnie(12, "Compagnie de distribution d'électricité'", 150, new int[]{4,10}, 75, null);
        Compagnie vEau = new Compagnie(28, "Compagnie de distribution des eaux", 150, new int[]{4,10}, 75, null);
    }//createCompagnie()

    public void createCase()
    {
        Case vCaisseDeCommunaute1 = new Case(2, "Caisse de Communauté");
        Case vCaisseDeCommunaute2 = new Case(17, "Caisse de Communauté");
        Case vCaisseDeCommunaute3 = new Case(33, "Caisse de Communauté");

        Case vChance1 = new Case(7, "Chance");
        Case vChance2 = new Case(22, "Chance");
        Case vChance3 = new Case(36, "Chance");

        Case vDepart = new Case(0, "Départ");
        Case vPrison = new Case(10, "Prison");
        Case vParcGratuit = new Case(20, "Parc Gratuit");
        Case vAllezEnPrison = new Case(30, "Allez en Prison");

        Case vImpot = new Case(4, "Impôt sur le revenu");
        Case vTaxeDeLuxe = new Case(38, "Taxe de Luxe");
    }//createCase


    public void createCarte()
    {
        //Liste des cartes chances
        Carte vCarteChance1 = new Carte(0, 39, "Rendez-vous à la Rue de la Paix", 0);
        Carte vCarteChance2 = new Carte(0, 0, "Avancer jusqu'à la case départ", 0);
        Carte vCarteChance3 = new Carte(0, 24, "Rendez-vous à l'Avenue Henri-Martin. Si vous passez par la case départ, recevez 200€", 0);
        Carte vCarteChance4 = new Carte(0, 11, "Avancez au Boulevard de La Villette. Si vous passez par la case départ, recevez 200€", 0);
        Carte vCarteChance5 = new Carte(0, -1, "Vous êtes imposé pour les réparations de voirie à raison de 40€ par maison et 115€ par hotêl", 1);
        Carte vCarteChance6 = new Carte(0, 15, "Avancez jusqu'à la Gare de Lyon. Si vous passez par la case départ, recevez 200€", 0);
        Carte vCarteChance7 = new Carte(100,-1, "Vous gagnez le prix de mots croisés. Recevez 100€", 0);
        Carte vCarteChance8 = new Carte(50, -1, "La banque vous verse un dividende de 50€", 0);
        Carte vCarteChance9 = new Carte(0, -1, "Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.", 2);
        Carte vCarteChance10 = new Carte(0,-1, "Reculez de trois cases", 3);
        Carte vCarteChance11 = new Carte(0, 10, "Allez en prison. Rendez-vous directement en prison. Ne franchissez pas la case départ, ne touchez pas 200€", 4);
        Carte vCarteChance12 = new Carte(0, -1, "Faites des réparations dans toutes vos maisons. Versez pour chaque maison 25€. Versez pour chaque hôtel 100€", 5);
        Carte vCarteChance13 = new Carte(-15, -1, "Amende pour excès de vitesse 15€", 0);
        Carte vCarteChance14 = new Carte(-150, -1, "Payez pour frais de scolarité 150€", 0);
        Carte vCarteChance15 = new Carte(-20, -1, "Amende pour ivresse 20€", 0);
        Carte vCarteChance16 = new Carte(150, -1, "Votre immeuble et votre prêt rapportent. Vous devez toucher 150€", 0);

        //Liste des cartes Caisse de Communauté
        Carte vCarteCom1 = new Carte(0, 0, "Placez-vous sur la case départ", 0);
        Carte vCarteCom2 = new Carte(200, -1, "Erreur de la banque en votre faveur. Recevez 200€", 0);
        Carte vCarteCom3 = new Carte(-50, -1, "Payez la  note du médecin 50€", 0);
        Carte vCarteCom4 = new Carte(50, -1, "La vente de votre stock vous rapporte 50€", 0);
        Carte vCarteCom5 = new Carte(0, -1, "Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.", 6);
        Carte vCarteCom6 = new Carte(0, 10, "Allez en prison. Rendez-vous directement en prison. Ne franchissez pas la case départ, ne touchez pas 200€", 7);
        Carte vCarteCom7 = new Carte(0,1, "Retournez à Belleville", 8);
        Carte vCarteCom8 = new Carte(100, -1, "Recevez votre revenu annuel 100€", 0);
        Carte vCarteCom9 = new Carte(0, -1, "C'est votre anniversaire. Chaque joueur doit vous donner 10€", 9);
        Carte vCarteCom10 = new Carte(20, -1, "Les contributions vous remboursent la somme de 20€", 0);
        Carte vCarteCom11 = new Carte(25, -1, "Recevez votre intérêt sur l'emprunt à 7% 25€", 0);
        Carte vCarteCom12 = new Carte(-50, -1, "Payez votre Police d'Assurance 50€", 0);
        Carte vCarteCom13 = new Carte(0, -1, "Payez une amende de 10€ ou bien tirez une carte <<CHANCE>>", 10);
        Carte vCarteCom14 = new Carte(0, -1, "Rendez-vous à la gare la plus proche. Si vous pasez par la départ, recevez 200€", 11);
        Carte vCarteCom15 = new Carte(10, -1, "Vous avez gagné le deuxième Prix de Beauté. Recevez 10€", 0);
        Carte vCarteCom16 = new Carte(10, -1, "Vous héritez de 10€", 0);

    }//createCarte
    /**
     * Exécute la commande donné
     * @return true Si la commande termine le jeu, false dans le cas contraire.
     */
    public void interpretCommand(final Command pCommandLine)
    {
        CommandWord vCommandWord = pCommandLine.getCommandWord();

        String vWord1 = pCommandLine.getCommandWord().toString();
        String vWord2 = pCommandLine.getSecondWord();

        if(vWord2 != null)
        {
            this.aGui.println( "> " + vWord1 + " " + vWord2);
        }
        else
        {
            this.aGui.println( "> " + vWord1);
        }


        switch (vCommandWord)
        {
            case UNKNOWN :
                this.aGui.println("Je ne comprends pas ce que vous voulez faire...");
                return ;

            case HELP :
                this.printHelp();
                break;

            case QUITTER :
                if ( pCommandLine.hasSecondWord() )
                    this.aGui.println( "Quitter quoi ?" );
                else
                {
                    this.quitter();
                }
                break;

            case LANCER :
                this.lancer();
                break;

            case CARTE :
                this.carte();
                break;

            case PROPRIETE :
                if ( pCommandLine.hasSecondWord() )
                    this.propieteSelect(vWord2);
                else
                {
                    this.aGui.println( "Quelle propriete ?" );
                }
                break;




        }
    }//interpretCommand(.)

    private void printHelp()
    {
        this.aGui.println("Les commandes que tu peux utiliser sont :");
        this.aGui.println(this.aParser.getCommandsList());
    }//printHelp()

    private void propieteSelect(final String pCommand)
    {
        for(int i=1; i<9; i++)
        {
            if(pCommand.equals(i+""));
            {
                this.aGui.println("Propriétées " + i);
            }
        }
    }

    private void quitter()
    {
        this.aGui.println("merci. A Bientot");
        this.aGui.enable( false );
    }

    private void carte()
    {
        this.aGui.println("ceci est une carte");
    }

    private void lancer()
    {
        De vDe1 = new De();
        De vDe2 = new De();
        vDe1.lanceDe();
        vDe2.lanceDe();
        this.aNBlancer = vDe1.getNbDe()+vDe2.getNbDe();
        this.aGui.showImageDe(vDe1.getNbDe()+".jpg", vDe2.getNbDe()+".jpg");
        //int vPos = this.aJoueur.getPion().getposition();

        
    }//lancer()

    int getLancer(){
        return this.aNBlancer;
    }
}

