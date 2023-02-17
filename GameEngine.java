import java.awt.*;
import java.util.*;

public class GameEngine {

    private Parser aParser;
    private UserInterface aGui;
    private ArrayList<Case> aListCase = new ArrayList<Case>();
    private int aNBlancer;
    private Joueur aCurrentPlayer;
    private ArrayList<Joueur> aListJoueur;
    private int aNbJoueur;
    private int aPosJoueurActuel = 0;
    private int aNbActuelJoueur = 0;
    private int aFiniInit = 0;
    private int aPremiersLancer = 0;
    private ArrayList<Integer> aListLancer;
    private LinkedList<Carte> aListChance;
    private LinkedList<Carte> aListCom;

    private int aTestUnique = 0;
    private ArrayList<Integer> aListGrand;


    /**
     * Constructeur pour les objets de la classe GameEngine
     */
    public GameEngine()
    {
        this.createCase();
        this.createCarte();
        this.aParser = new Parser();
        this.aListJoueur = new ArrayList<Joueur>();
        this.aListLancer = new ArrayList<Integer>();
        this.aListGrand = new ArrayList<Integer>();

    }//GameEngine()

    /***
     * Setteur.
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.aGui.showImage("plateau.jpg");
        this.printWelcome();
    }//setGUI(.)

    /**
     * Accesseur pour le Parser.
     */
    public Parser getParser() { return this.aParser; } //getParser()

    public int getLancer() {return this.aNBlancer;}

    /**
     * Affichage du message d'acceuil au joueur.
     */
    private void printWelcome()
    {
        this.aGui.println("Bienvenue dans le jeu : Monopoly");
        this.aGui.println("");
        this.aGui.println("Pour jouer, chaque joueur devra chacun son tour quand il sera");
        this.aGui.println("appelé, taper les commandes des actions qu'il souhaite faire");
        this.aGui.println("dans l'invite de commande.");
        this.aGui.println("Pour commencer à jouer, taper la commande ''joueur + nom du");
        this.aGui.println("joueur'' pour chaque joueur.");
        this.aGui.println("");
        this.aGui.println("Une fois tous les joueurs enregistré, lancer la partie avec");
        this.aGui.println("la fonction start !");
        this.aGui.println("");
        this.aGui.println("Si vous avez besoin d'aide, appuyer sur le bouton ''help''.");
        this.aGui.println("");
    }


    /**
     * Créer toutes les propriétés du jeu.
     */
    private void createCase()
    {
        Case vDepart = new Case(0, "Départ");
        this.aListCase.add(vDepart);
        Rue vBoulevardDeBelleville = new Rue(1, "Boulevard de Belleville", "Marron", 60, new int[]{2, 10, 30, 90, 160, 250}, 50, 30, null);
        this.aListCase.add(vBoulevardDeBelleville);
        Case vCaisseDeCommunaute1 = new Case(2, "Caisse de Communauté");
        this.aListCase.add(vCaisseDeCommunaute1);
        Rue vRueLecourbe = new Rue(3, "Rue Lecourbe", "Marron", 60, new int[]{4,20,60,180,320,450}, 50, 30, null);
        this.aListCase.add(vRueLecourbe);
        Case vImpot = new Case(4, "Impôt sur le revenu");
        this.aListCase.add(vImpot);
        Gare vGareMontparnasse = new Gare(5, "Gare Montparnasse", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareMontparnasse);
        Rue vRueDeVaugirard = new Rue(6, "Rue de Vaugirard", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        this.aListCase.add(vRueDeVaugirard);
        Case vChance1 = new Case(7, "Chance");
        this.aListCase.add(vChance1);
        Rue vRueDeCourcelles = new Rue(8, "Rue de Courcelles", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        this.aListCase.add(vRueDeCourcelles);
        Rue vAvenueDeLaRepublique = new Rue(9, "Avenue de la République","Bleu ciel", 120, new int[]{8,40,100,300,450,600}, 50, 60, null);
        this.aListCase.add(vAvenueDeLaRepublique);
        Case vPrison = new Case(10, "Prison");
        this.aListCase.add(vPrison);
        Rue vBoulevardDeLaVillette = new Rue(11, "Boulevard de la Villette", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        this.aListCase.add(vBoulevardDeLaVillette);
        Compagnie vElectricite = new Compagnie(12, "Compagnie de distribution d'électricité'", 150, new int[]{4,10}, 75, null);
        this.aListCase.add(vElectricite);
        Rue vAvenueDeNeuilly = new Rue(13, "Avenue de Neuilly", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        this.aListCase.add(vAvenueDeNeuilly);
        Rue vRueDeParadis = new Rue(14, "Rue de Paradis", "Rose", 160, new int[]{12,60,180,500,700,900}, 100, 80, null);
        this.aListCase.add(vRueDeParadis);
        Gare vGareDeLyon = new Gare(15, "Gare de Lyon", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareDeLyon);
        Rue vAvenueMozart = new Rue(16, "Avenue Mozart", "Orange", 180, new int[]{14,70,200,550,700,900}, 100, 90, null);
        this.aListCase.add(vAvenueMozart);
        Case vCaisseDeCommunaute2 = new Case(17, "Caisse de Communauté");
        this.aListCase.add(vCaisseDeCommunaute2);
        Rue vBoulevardSaintMichel = new Rue(18, "Boulevard Saint-Michel", "Orange", 180, new int[]{14,70,200,550,700,950}, 100, 90, null);
        this.aListCase.add(vBoulevardSaintMichel);
        Rue vPlacePigalle = new Rue(19, "Place Pigalle", "Orange", 200, new int[]{16,80,220,600,800,1000}, 100, 100, null);
        this.aListCase.add(vPlacePigalle);
        Case vParcGratuit = new Case(20, "Parc Gratuit");
        this.aListCase.add(vParcGratuit);
        Rue vAvenueMatignon = new Rue(21, "Avenue  Matignon", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150,110, null);
        this.aListCase.add(vAvenueMatignon);
        Case vChance2 = new Case(22, "Chance");
        this.aListCase.add(vChance2);
        Rue vBoulevardMalesherbes = new Rue(23, "Boulevard Malesherbes", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150, 110, null);
        this.aListCase.add(vBoulevardMalesherbes);
        Rue vAvenueHenriMartin = new Rue(24, "Avenue Henri-Martin", "Rouge", 240, new int[]{20,100,300,750,925,1100}, 150, 120, null);
        this.aListCase.add(vAvenueHenriMartin);
        Gare vGareDuNord = new Gare(25, "Gare du Nord", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareDuNord);
        Rue vFaubourgSaintHonore = new Rue(26, "Faubourg Saint-Honoré", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        this.aListCase.add(vFaubourgSaintHonore);
        Rue vPlaceDeLaBourse = new Rue(27, "Place de la Bourse", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        this.aListCase.add(vPlaceDeLaBourse);
        Compagnie vEau = new Compagnie(28, "Compagnie de distribution des eaux", 150, new int[]{4,10}, 75, null);
        this.aListCase.add(vEau);
        Rue vRueLaFayette= new Rue(29, "Rue La Fayette", "Jaune", 280, new int[]{24,120,360,850,1025,1200}, 150, 140, null);
        this.aListCase.add(vRueLaFayette);
        Case vAllezEnPrison = new Case(30, "Allez en Prison");
        this.aListCase.add(vAllezEnPrison);
        Rue vAvenueDeBreteuil = new Rue(31, "Avenue de Breteuil", "Vert", 300,  new int[]{26,130,390,900,1100,1275}, 200, 150, null);
        this.aListCase.add(vAvenueDeBreteuil);
        Rue vAvenueFoch = new Rue(32, "Avenue Foch", "Vert", 300, new int[]{26,130,390,900,1100,1275}, 200, 150,null);
        this.aListCase.add(vAvenueFoch);
        Case vCaisseDeCommunaute3 = new Case(33, "Caisse de Communauté");
        this.aListCase.add(vCaisseDeCommunaute3);
        Rue vBoulevardDesCapucines = new Rue(34, "Boulevard des Capucines", "Vert", 320, new int[]{28,150,450,1000,1200,1400}, 200, 160, null);
        this.aListCase.add(vBoulevardDesCapucines);
        Gare vGareSaintLazare = new Gare(35, "Gare Saint-Lazare", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareSaintLazare);
        Case vChance3 = new Case(36, "Chance");
        this.aListCase.add(vChance3);
        Rue vAvenueChampsElisees = new Rue(37, "Avenue Champs-Élysées", "BleuFonce", 350, new int[]{35,175,500,1100,1300,1500}, 200, 175, null);
        this.aListCase.add(vAvenueChampsElisees);
        Case vTaxeDeLuxe = new Case(38, "Taxe de Luxe");
        this.aListCase.add(vTaxeDeLuxe);
        Rue vRueDeLaPaix = new Rue(39, "Rue de la  Paix", "BleuFonce", 400, new int[]{50,200,600,1400,1700,2000}, 200, 200, null);
        this.aListCase.add(vRueDeLaPaix);
    }


    public void createCarte()
    {
        //Liste des cartes chances

        this.aListChance = new LinkedList<Carte>();
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
        this.aListChance.add(vCarteChance1);this.aListChance.add(vCarteChance2);this.aListChance.add(vCarteChance3);
        this.aListChance.add(vCarteChance4);this.aListChance.add(vCarteChance5);this.aListChance.add(vCarteChance6);
        this.aListChance.add(vCarteChance7);this.aListChance.add(vCarteChance8);this.aListChance.add(vCarteChance9);
        this.aListChance.add(vCarteChance10);this.aListChance.add(vCarteChance11);this.aListChance.add(vCarteChance12);
        this.aListChance.add(vCarteChance13);this.aListChance.add(vCarteChance14);this.aListChance.add(vCarteChance15);
        this.aListChance.add(vCarteChance16);
        Collections.shuffle(this.aListChance);



        //Liste des cartes Caisse de Communauté

        this.aListCom = new LinkedList<Carte>();
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
        this.aListCom.add(vCarteCom1);this.aListCom.add(vCarteCom2);this.aListCom.add(vCarteCom3);
        this.aListCom.add(vCarteCom4);this.aListCom.add(vCarteCom5);this.aListCom.add(vCarteCom6);
        this.aListCom.add(vCarteCom7);this.aListCom.add(vCarteCom8);this.aListCom.add(vCarteCom9);
        this.aListCom.add(vCarteCom10);this.aListCom.add(vCarteCom11);this.aListCom.add(vCarteCom12);
        this.aListCom.add(vCarteCom13);this.aListCom.add(vCarteCom14);this.aListCom.add(vCarteCom15);
        this.aListCom.add(vCarteCom16);
        Collections.shuffle(this.aListCom);

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
                break;

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
                    this.aGui.println( "Quelle propriété ?" );
                }
                break;

            case JOUEUR :
                if(pCommandLine.hasSecondWord())
                {
                    this.ajouterJoueur(vWord2);
                }
                else
                {
                    this.aGui.println("Il faut ajouter un nom au joueur");
                }
                break;

            case START :
                if(!pCommandLine.hasSecondWord())
                {
                    this.start();
                }
                else
                {
                    this.aGui.println("start ne prend pas de second mot");
                }
                break;

            case PASSER :
                if(!pCommandLine.hasSecondWord())
                {
                    this.passer();
                }
                else
                {
                    this.aGui.println("passer ne prend pas de second mot");
                }
                break;
        }


    }//interpretCommand(.)

    private void start()
    {
        this.aGui.println("Que la partie commence !");
        aFiniInit += 1;
        this.aGui.println("");
        this.aGui.println("Chaque joueur doit lancer les dés,");
        this.aGui.println("celui qui aura le plus gros score commencera.");
        this.aGui.println("");

        this.aCurrentPlayer = this.aListJoueur.get(0);
        this.aGui.println(this.aCurrentPlayer.getNom() + " c'est à toi de lancer");


    }//start()

    private void ajouteCouleur()
    {
        if (this.aPosJoueurActuel==0) {this.aGui.aJoueur.setBackground(Color.PINK);}
        if (this.aPosJoueurActuel==1) {this.aGui.aJoueur.setBackground(Color.BLUE);}
        if (this.aPosJoueurActuel==2) {this.aGui.aJoueur.setBackground(Color.RED);}
        if (this.aPosJoueurActuel==3) {this.aGui.aJoueur.setBackground(Color.GREEN);}
        if (this.aPosJoueurActuel==4) {this.aGui.aJoueur.setBackground(Color.CYAN);}
        if (this.aPosJoueurActuel==5) {this.aGui.aJoueur.setBackground(Color.ORANGE);}
        if (this.aPosJoueurActuel==6) {this.aGui.aJoueur.setBackground(Color.MAGENTA);}
        if (this.aPosJoueurActuel==7) {this.aGui.aJoueur.setBackground(Color.LIGHT_GRAY);}
    }

    private void ajouterJoueur(String vNom)
    {
        if(aFiniInit == 0)
        {
            if(aNbActuelJoueur < 8) {

                aListJoueur.add(new Joueur(vNom));
                aNbActuelJoueur += 1;

                this.aGui.println("Le joueur " + vNom + " à bien été ajouter.");
                this.aGui.println("Il y a actuellement " + aNbActuelJoueur + " joueur(s) dans la partie.");
                this.aGui.println("");
            }
            else
            {
                this.aGui.println("Vous ne pouvez pas avoir plus de 8 Joueur dans la même partie");
            }
        }
        else
        {
            this.aGui.println("Vous ne pouvez pas rajouter de joueur après le début de la partie");
        }

        if(aNbActuelJoueur == 1) {this.aGui.aNom1.setText(aListJoueur.get(0).getNom());
            this.aGui.aSom1.setText(""+aListJoueur.get(0).getArgent());}
        if(aNbActuelJoueur == 2) {this.aGui.aNom2.setText(aListJoueur.get(1).getNom());
            this.aGui.aSom2.setText(""+aListJoueur.get(1).getArgent());}
        if(aNbActuelJoueur == 3) {this.aGui.aNom3.setText(aListJoueur.get(2).getNom());
            this.aGui.aSom3.setText(""+aListJoueur.get(2).getArgent());}
        if(aNbActuelJoueur == 4) {this.aGui.aNom4.setText(aListJoueur.get(3).getNom());
            this.aGui.aSom4.setText(""+aListJoueur.get(3).getArgent());}
        if(aNbActuelJoueur == 5) {this.aGui.aNom5.setText(aListJoueur.get(4).getNom());
            this.aGui.aSom5.setText(""+aListJoueur.get(4).getArgent());}
        if(aNbActuelJoueur == 6) {this.aGui.aNom6.setText(aListJoueur.get(5).getNom());
            this.aGui.aSom6.setText(""+aListJoueur.get(5).getArgent());}
        if(aNbActuelJoueur == 7) {this.aGui.aNom7.setText(aListJoueur.get(6).getNom());
            this.aGui.aSom7.setText(""+aListJoueur.get(6).getArgent());}
        if(aNbActuelJoueur == 8) {this.aGui.aNom8.setText(aListJoueur.get(7).getNom());
            this.aGui.aSom8.setText(""+aListJoueur.get(7).getArgent());}
    }

    /**
     * Fonction retournant les commandes possibles que le joueur peut effefctuer
     */
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
                ArrayList<Propriete> pro = this.aListJoueur.get(i).getProprietes();
                for (Propriete p : pro){
                    this.aGui.println(p.getDescription());
                }
            }
        }
    }

    private void quitter()
    {
        this.aGui.println("Merci. À Bientôt");
        this.aGui.enable( false );
    }

    private void carte()
    {
        if (this.aCurrentPlayer.getPos()==(2|17|33)) {Carte vCarteTiree = this.aListCom.poll(); this.aListCom.push(vCarteTiree);}
        else {Carte vCarteTiree = this.aListChance.poll(); this.aListChance.push(vCarteTiree);}
        this.aGui.println("ceci est une carte");


    }

    private void lancer()
    {
        De vDe1 = new De();
        De vDe2 = new De();
        vDe1.lanceDe();
        vDe2.lanceDe();
        this.aNBlancer = vDe1.getNbDe()+vDe2.getNbDe();
        this.aGui.println("Vous avez fait un score de "+this.aNBlancer);
        this.aGui.showImageDe(vDe1.getNbDe()+".jpg", vDe2.getNbDe()+".jpg");

        if(this.aPremiersLancer == 0)
        {
            this.premierslancer(this.aNBlancer);
            return;
        }

        if (vDe1.getNbDe() == vDe2.getNbDe())
        {
            this.aCurrentPlayer.setDouble();
            this.aGui.println("Vous avez fait un double, vous pourrez rejouer !");
            if (this.aCurrentPlayer.IsPrison()==1){
                this.aCurrentPlayer.outPrison();
            }
        }
        if (this.aCurrentPlayer.getDouble() == 3){
            this.aGui.println("Dommage, vous avez fait des doubles 3 fois de suite,");
            this.aGui.println("Vous allez en prison.");
            this.aCurrentPlayer.goPrison();
        }
        this.avancer();
        this.descriptionPos();
    }//lancer()

    public void avancer()
    {
        if (this.aCurrentPlayer.IsPrison()==0) {
            this.aCurrentPlayer.ajoutePos(this.aNBlancer);
            int pos = this.aCurrentPlayer.getPos();
            if ( pos >= 40) {
                this.aCurrentPlayer.addArgent(200);
                this.actualiseArgent();
                this.aCurrentPlayer.setPos(pos-40);
            }
            //this.aGui.println("vous avez avancé de "+this.aNBlancer+" case(s).");
        }
    }

    public void actualiseArgent()
    {
        if(aNbActuelJoueur == 1) {this.aGui.aSom1.setText(""+aListJoueur.get(0).getArgent());}
        if(aNbActuelJoueur == 2) {this.aGui.aSom2.setText(""+aListJoueur.get(1).getArgent());}
        if(aNbActuelJoueur == 3) {this.aGui.aSom3.setText(""+aListJoueur.get(2).getArgent());}
        if(aNbActuelJoueur == 4) {this.aGui.aSom4.setText(""+aListJoueur.get(3).getArgent());}
        if(aNbActuelJoueur == 5) {this.aGui.aSom5.setText(""+aListJoueur.get(4).getArgent());}
        if(aNbActuelJoueur == 6) {this.aGui.aSom6.setText(""+aListJoueur.get(5).getArgent());}
        if(aNbActuelJoueur == 7) {this.aGui.aSom7.setText(""+aListJoueur.get(6).getArgent());}
        if(aNbActuelJoueur == 8) {this.aGui.aSom8.setText(""+aListJoueur.get(7).getArgent());}
    }

    private void premierslancer(int NbrLancer)
    {
        if(this.aListLancer.size() <= this.aNbActuelJoueur)
        {
            this.aGui.println("Au joueur suivant de lancer les dés.");

            this.aListLancer.add(NbrLancer);

            prochain();
        }
        if(this.aListLancer.size() == this.aNbActuelJoueur)
        {

            if(this.aTestUnique==0)
            {
                int vPG;
                vPG = this.plusgrands();
                
                for(int i=0; i<this.aListGrand.size()-1; i++)
                {
                    this.aGui.println(this.aListJoueur.get(this.aListGrand.get(i)).getNom() + " a obtenu le plus grand nombre");
                }

                this.aGui.println(vPG + " est le plus grand nombre");

                if (this.aListGrand.size() == 1) {
                    this.lancerPartie();
                }
                else
                {
                    this.aTestUnique = 1;
                }
            }

            if(this.aTestUnique==1)
            {
                this.aCurrentPlayer = this.aListJoueur.get(this.aListGrand.get(0));

                this.aListGrand.remove(0);

                if(this.aListGrand.size() == 0)
                {
                    this.aTestUnique = 0;
                }
            }

        }
    }

    private void lancerPartie()
    {
        this.aPremiersLancer = 1;
        this.aPosJoueurActuel = this.aListGrand.get(0);
        this.aCurrentPlayer = this.aListJoueur.get(this.aPosJoueurActuel);
        this.aGui.println(this.aCurrentPlayer.getNom() + " vous commencer a jouer");
        this.aGui.aJoueur.setText("Joueur "+ this.aCurrentPlayer.getNom());
        this.ajouteCouleur();
        this.debutDeTour();
    }

    private int plusgrands()
    {
        ArrayList<Integer> vListPlusGrand = new ArrayList<Integer>();

        int max = this.aListLancer.get(0);

        for(int i = 1; i<this.aListLancer.size(); i++)
        {
            if(max<this.aListLancer.get(i))
            {
                max = this.aListLancer.get(i);
            }
        }

        for(int i = 0; i<this.aListLancer.size(); i++)
        {
            if(max==this.aListLancer.get(i))
            {
                vListPlusGrand.add(i);
            }
        }
        this.aListGrand = vListPlusGrand;

        return max;
    }

    private void passer()
    {
        this.aCurrentPlayer.initDouble();

        prochain();

        this.aGui.aJoueur.setText("Joueur "+ this.aCurrentPlayer.getNom());
        this.ajouteCouleur();
        this.debutDeTour();
    }

    private void prochain()
    {
        if(this.aPosJoueurActuel+1<this.aNbJoueur)
        {
            this.aPosJoueurActuel+= 1;
        }
        else
        {
            this.aPosJoueurActuel = 0;
        }

        this.aCurrentPlayer = this.aListJoueur.get(this.aPosJoueurActuel);
    }

    private void debutDeTour()
    {
        this.aGui.println(this.aCurrentPlayer.getNom() + " doit lancer les dés !");
    }//debutDeTour()

    /**
     * Décris la case sur laquelle le CurrentPlayer se trouve, soit donne le nom de la case
     */
    private void descriptionPos()
    {
        this.aGui.println(this.aCurrentPlayer.getNom() + " arrive sur :");
        this.aGui.println(this.aListCase.get(this.aCurrentPlayer.getPos()).getDescription());

        //Le joueur tombe sur une rue
        if (this.aListCase.get(this.aCurrentPlayer.getPos()).getClass().equals(Rue.class))
        {

        }

        //Le joueur tombe sur une gare
        if (this.aListCase.get(this.aCurrentPlayer.getPos()).getClass().equals(Gare.class))
        {

        }

        //Le joueur tombe sur une compagnie
        if (this.aListCase.get(this.aCurrentPlayer.getPos()).getClass().equals(Compagnie.class))
        {

        }
        int[] vChanceNum = {7,22,36};
        //if (this.aListCase.get(this.aCurrentPlayer.getPos())
    }//descriptionPos()
}

