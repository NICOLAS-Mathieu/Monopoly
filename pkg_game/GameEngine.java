package pkg_game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import pkg_case.Gare;
import pkg_case.Rue;
import pkg_case.Compagnie;
import pkg_case.Propriete;
import pkg_case.Case;
import pkg_commands.CommandWord;
import pkg_commands.Command;


public class GameEngine {

    private Parser aParser;
    private UserInterface aGui;
    private ArrayList<Case> aListCase = new ArrayList<Case>();
    private int aNbActuelJoueur = 0;
    private int aFiniInit = 0;
    private Joueur aCurrentPlayer;
    private boolean aCurrentPlayerPlay = true;
    private int aNBlancer;
    private int aPosJoueurActuel = 0;
    private ArrayList<Joueur> aListJoueur;
    private int aPremiersLancer = 0;
    private ArrayList<Integer> aListLancer;
    private LinkedList<Carte> aListChance;
    private LinkedList<Carte> aListCom;
    private int aArgentCentral = 0;
    private int aTestUnique = 0;
    private ArrayList<Integer> aListGrand;
    private int aPasAcheter = 0;
    private boolean aPendantEnchere = false;
    private int aMaxEnchere = -1;
    private Joueur aJoueurEnchere;
    private boolean aPasAssez = false;
    private int aNbTotalMaison;
    private int aNbTotalHotel;
    private ArrayList<Integer> aListDette;
    private ArrayList<Joueur> aListPreteur;
    private boolean aTestMode;
    private int aChoix;
    private boolean aAutorise;

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
        this.aNbTotalMaison = 32;
        this.aNbTotalHotel = 12;
        this.aTestMode = false;
        this.aChoix = 0;
        this.aAutorise = false;
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
     * @return si le aCurrentPlayer poss??de le monopole sur lequel il se trouve
     */
    public boolean getMonopole()
    {
        boolean vMonopole = false;
        int vPos = this.aCurrentPlayer.getPos();
        Rue vCurrentRue = (Rue) this.aListCase.get(vPos);
        String vRueCouleur = vCurrentRue.getCouleur();

        for(int i = 0; i < 39 ; i++)
        {
            if(this.aListCase.get(i).getClass().equals(Rue.class)) //Regarde seulement les Rues
            {
                Rue vRue = (Rue) this.aListCase.get(i);
                //Regarde si le CurrentPlayer poss??de le monopole avant de construire
                if( vRue.getCouleur().equalsIgnoreCase(vRueCouleur))
                {
                    if (vRue.getProprietaire() == this.aCurrentPlayer){
                    vMonopole = true;}
                    else { vMonopole = false;}
                }
            }
        }
        return vMonopole;
    }//getMonopole()

    /**
     * Affichage du message d'acceuil au joueur.
     */
    private void printWelcome()
    {
        this.aGui.println("Bienvenue dans le jeu : Monopoly");
        this.aGui.println("");
        this.aGui.println("Pour jouer, chaque joueur devra chacun son tour quand il sera");
        this.aGui.println("appel??, taper les commandes des actions qu'il souhaite faire");
        this.aGui.println("dans l'invite de commande.");
        this.aGui.println("Pour commencer ?? jouer, taper la commande ''joueur + nom du");
        this.aGui.println("joueur'' pour chaque joueur.");
        this.aGui.println("");
        this.aGui.println("Une fois tous les joueurs enregistr??, lancer la partie avec");
        this.aGui.println("la fonction start !");
        this.aGui.println("");
        this.aGui.println("Si vous avez besoin d'aide, appuyer sur le bouton ''help''.");
        this.aGui.println("");
    }//printWelcome()


    /**
     * Cr??er toutes les propri??t??s du jeu.
     */
    private void createCase()
    {
        Case vDepart = new Case(0, "D??part", null);
        this.aListCase.add(vDepart);
        Rue vBoulevardDeBelleville = new Rue(1, "Boulevard de Belleville", "Marron", 60, new int[]{2, 10, 30, 90, 160, 250}, 50, 30, null);
        this.aListCase.add(vBoulevardDeBelleville);
        Case vCaisseDeCommunaute1 = new Case(2, "Caisse de Communaut??", null);
        this.aListCase.add(vCaisseDeCommunaute1);
        Rue vRueLecourbe = new Rue(3, "Rue Lecourbe", "Marron", 60, new int[]{4,20,60,180,320,450}, 50, 30, null);
        this.aListCase.add(vRueLecourbe);
        Case vImpot = new Case(4, "Imp??t sur le revenu", null);
        this.aListCase.add(vImpot);
        Gare vGareMontparnasse = new Gare(5, "Gare Montparnasse", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareMontparnasse);
        Rue vRueDeVaugirard = new Rue(6, "Rue de Vaugirard", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        this.aListCase.add(vRueDeVaugirard);
        Case vChance1 = new Case(7, "Chance", null);
        this.aListCase.add(vChance1);
        Rue vRueDeCourcelles = new Rue(8, "Rue de Courcelles", "Bleu ciel", 100, new int[]{5,30,90,270,400,550}, 50, 50, null);
        this.aListCase.add(vRueDeCourcelles);
        Rue vAvenueDeLaRepublique = new Rue(9, "Avenue de la R??publique","Bleu ciel", 120, new int[]{8,40,100,300,450,600}, 50, 60, null);
        this.aListCase.add(vAvenueDeLaRepublique);
        Case vPrison = new Case(10, "Prison", null);
        this.aListCase.add(vPrison);
        Rue vBoulevardDeLaVillette = new Rue(11, "Boulevard de la Villette", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        this.aListCase.add(vBoulevardDeLaVillette);
        Compagnie vElectricite = new Compagnie(12, "Compagnie de distribution d'??lectricit??", 150, new int[]{4,10}, 75, null);
        this.aListCase.add(vElectricite);
        Rue vAvenueDeNeuilly = new Rue(13, "Avenue de Neuilly", "Rose", 140, new int[]{10,50,150,450,625,750}, 100, 70, null);
        this.aListCase.add(vAvenueDeNeuilly);
        Rue vRueDeParadis = new Rue(14, "Rue de Paradis", "Rose", 160, new int[]{12,60,180,500,700,900}, 100, 80, null);
        this.aListCase.add(vRueDeParadis);
        Gare vGareDeLyon = new Gare(15, "Gare de Lyon", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareDeLyon);
        Rue vAvenueMozart = new Rue(16, "Avenue Mozart", "Orange", 180, new int[]{14,70,200,550,700,900}, 100, 90, null);
        this.aListCase.add(vAvenueMozart);
        Case vCaisseDeCommunaute2 = new Case(17, "Caisse de Communaut??", null);
        this.aListCase.add(vCaisseDeCommunaute2);
        Rue vBoulevardSaintMichel = new Rue(18, "Boulevard Saint-Michel", "Orange", 180, new int[]{14,70,200,550,700,950}, 100, 90, null);
        this.aListCase.add(vBoulevardSaintMichel);
        Rue vPlacePigalle = new Rue(19, "Place Pigalle", "Orange", 200, new int[]{16,80,220,600,800,1000}, 100, 100, null);
        this.aListCase.add(vPlacePigalle);
        Case vParcGratuit = new Case(20, "Parc Gratuit", null);
        this.aListCase.add(vParcGratuit);
        Rue vAvenueMatignon = new Rue(21, "Avenue  Matignon", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150,110, null);
        this.aListCase.add(vAvenueMatignon);
        Case vChance2 = new Case(22, "Chance", null);
        this.aListCase.add(vChance2);
        Rue vBoulevardMalesherbes = new Rue(23, "Boulevard Malesherbes", "Rouge", 220, new int[]{18,90,250,700,875,1050}, 150, 110, null);
        this.aListCase.add(vBoulevardMalesherbes);
        Rue vAvenueHenriMartin = new Rue(24, "Avenue Henri-Martin", "Rouge", 240, new int[]{20,100,300,750,925,1100}, 150, 120, null);
        this.aListCase.add(vAvenueHenriMartin);
        Gare vGareDuNord = new Gare(25, "Gare du Nord", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareDuNord);
        Rue vFaubourgSaintHonore = new Rue(26, "Faubourg Saint-Honor??", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        this.aListCase.add(vFaubourgSaintHonore);
        Rue vPlaceDeLaBourse = new Rue(27, "Place de la Bourse", "Jaune", 260, new int[]{22,110,330,800,975,1150}, 150, 130, null);
        this.aListCase.add(vPlaceDeLaBourse);
        Compagnie vEau = new Compagnie(28, "Compagnie de distribution des eaux", 150, new int[]{4,10}, 75, null);
        this.aListCase.add(vEau);
        Rue vRueLaFayette= new Rue(29, "Rue La Fayette", "Jaune", 280, new int[]{24,120,360,850,1025,1200}, 150, 140, null);
        this.aListCase.add(vRueLaFayette);
        Case vAllezEnPrison = new Case(30, "Allez en Prison", null);
        this.aListCase.add(vAllezEnPrison);
        Rue vAvenueDeBreteuil = new Rue(31, "Avenue de Breteuil", "Vert", 300,  new int[]{26,130,390,900,1100,1275}, 200, 150, null);
        this.aListCase.add(vAvenueDeBreteuil);
        Rue vAvenueFoch = new Rue(32, "Avenue Foch", "Vert", 300, new int[]{26,130,390,900,1100,1275}, 200, 150,null);
        this.aListCase.add(vAvenueFoch);
        Case vCaisseDeCommunaute3 = new Case(33, "Caisse de Communaut??", null);
        this.aListCase.add(vCaisseDeCommunaute3);
        Rue vBoulevardDesCapucines = new Rue(34, "Boulevard des Capucines", "Vert", 320, new int[]{28,150,450,1000,1200,1400}, 200, 160, null);
        this.aListCase.add(vBoulevardDesCapucines);
        Gare vGareSaintLazare = new Gare(35, "Gare Saint-Lazare", 200, new int[]{25,50,100,200}, 100, null);
        this.aListCase.add(vGareSaintLazare);
        Case vChance3 = new Case(36, "Chance", null);
        this.aListCase.add(vChance3);
        Rue vAvenueChampsElisees = new Rue(37, "Avenue Champs-??lys??es", "BleuFonce", 350, new int[]{35,175,500,1100,1300,1500}, 200, 175, null);
        this.aListCase.add(vAvenueChampsElisees);
        Case vTaxeDeLuxe = new Case(38, "Taxe de Luxe", null);
        this.aListCase.add(vTaxeDeLuxe);
        Rue vRueDeLaPaix = new Rue(39, "Rue de la  Paix", "BleuFonce", 400, new int[]{50,200,600,1400,1700,2000}, 200, 200, null);
        this.aListCase.add(vRueDeLaPaix);
    }//createCase()

    /**
     * Initialise l'ensemble des cartes chance et communaut?? du jeu
     */
    public void createCarte()
    {
        //Liste des cartes chances

        this.aListChance = new LinkedList<Carte>();
        Carte vCarteChance1 = new Carte(0, 39, "Rendez-vous ?? la Rue de la Paix", 0);
        Carte vCarteChance2 = new Carte(0, 0, "Avancer jusqu'?? la case d??part", 0);
        Carte vCarteChance3 = new Carte(0, 24, "Rendez-vous ?? l'Avenue Henri-Martin. Si vous passez par la case d??part, recevez 200???", 0);
        Carte vCarteChance4 = new Carte(0, 11, "Avancez au Boulevard de La Villette. Si vous passez par la case d??part, recevez 200???", 0);
        Carte vCarteChance5 = new Carte(0, -1, "Vous ??tes impos?? pour les r??parations de voirie ?? raison de 40??? par maison et 115??? par hot??l", 1);
        Carte vCarteChance6 = new Carte(0, 15, "Avancez jusqu'?? la Gare de Lyon. Si vous passez par la case d??part, recevez 200???", 0);
        Carte vCarteChance7 = new Carte(100,-1, "Vous gagnez le prix de mots crois??s. Recevez 100???", 0);
        Carte vCarteChance8 = new Carte(50, -1, "La banque vous verse un dividende de 50???", 0);
        Carte vCarteChance9 = new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 2);
        Carte vCarteChance10 = new Carte(0,-1, "Reculez de trois cases", 3);
        Carte vCarteChance11 = new Carte(0, 10, "Allez en prison. Rendez-vous directement en prison. Ne franchissez pas la case d??part, ne touchez pas 200???", 4);
        Carte vCarteChance12 = new Carte(0, -1, "Faites des r??parations dans toutes vos maisons. Versez pour chaque maison 25???. Versez pour chaque h??tel 100???", 5);
        Carte vCarteChance13 = new Carte(-15, -1, "Amende pour exc??s de vitesse 15???", 0);
        Carte vCarteChance14 = new Carte(-150, -1, "Payez pour frais de scolarit?? 150???", 0);
        Carte vCarteChance15 = new Carte(-20, -1, "Amende pour ivresse 20???", 0);
        Carte vCarteChance16 = new Carte(150, -1, "Votre immeuble et votre pr??t rapportent. Vous devez toucher 150???", 0);
        this.aListChance.add(vCarteChance1);this.aListChance.add(vCarteChance2);this.aListChance.add(vCarteChance3);
        this.aListChance.add(vCarteChance4);this.aListChance.add(vCarteChance5);this.aListChance.add(vCarteChance6);
        this.aListChance.add(vCarteChance7);this.aListChance.add(vCarteChance8);this.aListChance.add(vCarteChance9);
        this.aListChance.add(vCarteChance10);this.aListChance.add(vCarteChance11);this.aListChance.add(vCarteChance12);
        this.aListChance.add(vCarteChance13);this.aListChance.add(vCarteChance14);this.aListChance.add(vCarteChance15);
        this.aListChance.add(vCarteChance16);
        Collections.shuffle(this.aListChance);



        //Liste des cartes Caisse de Communaut??

        this.aListCom = new LinkedList<Carte>();
        Carte vCarteCom1 = new Carte(0, 0, "Placez-vous sur la case d??part", 0);
        Carte vCarteCom2 = new Carte(200, -1, "Erreur de la banque en votre faveur. Recevez 200???", 0);
        Carte vCarteCom3 = new Carte(-50, -1, "Payez la  note du m??decin 50???", 0);
        Carte vCarteCom4 = new Carte(50, -1, "La vente de votre stock vous rapporte 50???", 0);
        Carte vCarteCom5 = new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 6);
        Carte vCarteCom6 = new Carte(0, 10, "Allez en prison. Rendez-vous directement en prison. Ne franchissez pas la case d??part, ne touchez pas 200???", 7);
        Carte vCarteCom7 = new Carte(0,1, "Retournez ?? Belleville", 8);
        Carte vCarteCom8 = new Carte(100, -1, "Recevez votre revenu annuel 100???", 0);
        Carte vCarteCom9 = new Carte(0, -1, "C'est votre anniversaire. Chaque joueur doit vous donner 10???", 9);
        Carte vCarteCom10 = new Carte(20, -1, "Les contributions vous remboursent la somme de 20???", 0);
        Carte vCarteCom11 = new Carte(25, -1, "Recevez votre int??r??t sur l'emprunt ?? 7% 25???", 0);
        Carte vCarteCom12 = new Carte(-50, -1, "Payez votre Police d'Assurance 50???", 0);
        Carte vCarteCom13 = new Carte(0, -1, "Payez une amende de 10??? ou bien tirez une carte <<CHANCE>>", 10);
        Carte vCarteCom14 = new Carte(0, -1, "Rendez-vous ?? la gare la plus proche. Si vous passez par la d??part, recevez 200???", 11);
        Carte vCarteCom15 = new Carte(10, -1, "Vous avez gagn?? le deuxi??me Prix de Beaut??. Recevez 10???", 0);
        Carte vCarteCom16 = new Carte(10, -1, "Vous h??ritez de 10???", 0);
        this.aListCom.add(vCarteCom1);this.aListCom.add(vCarteCom2);this.aListCom.add(vCarteCom3);
        this.aListCom.add(vCarteCom4);this.aListCom.add(vCarteCom5);this.aListCom.add(vCarteCom6);
        this.aListCom.add(vCarteCom7);this.aListCom.add(vCarteCom8);this.aListCom.add(vCarteCom9);
        this.aListCom.add(vCarteCom10);this.aListCom.add(vCarteCom11);this.aListCom.add(vCarteCom12);
        this.aListCom.add(vCarteCom13);this.aListCom.add(vCarteCom14);this.aListCom.add(vCarteCom15);
        this.aListCom.add(vCarteCom16);
        Collections.shuffle(this.aListCom);

    }//createCarte


    /**
     * Ex??cute la commande donn??
     * @return true Si la commande termine le jeu, false dans le cas contraire.
     */
    public void interpretCommand(final Command pCommandLine)
    {
        CommandWord vCommandWord = pCommandLine.getCommandWord();

        String vWord1 = pCommandLine.getCommandWord().toString();
        String vWord2 = pCommandLine.getSecondWord();
        String vWord3 = pCommandLine.getThirdWord();

        if(vWord3 != null)
        {
            this.aGui.println( "> " + vWord1 + " " + vWord2 + " " + vWord3);
        }
        else if(vWord2 != null)
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
                this.aGui.println("");
                break;

            case HELP :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.printHelp(); }
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
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.lancer();}
                break;

            case CARTE :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.carte();}
                break;

            case PROPRIETE :
                if ( pCommandLine.hasSecondWord() ){
                    this.proprieteSelect(vWord2);
                }
                else
                {
                    this.aGui.println( "Quelle propri??t?? ?" );
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
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.start();}
                break;

            case PASSER :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.passer();}
                break;

            case ACHETER :
                if  (pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.acheter(this.aCurrentPlayer);}
                break;

            case DETAIL :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.detail();}
                break;

            case ENCHERE :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.enchere();}
                break;

            case MISER :
                if(!pCommandLine.hasSecondWord() || !pCommandLine.hasThirdWord())
                {
                    this.aGui.println("miser prend un trois mot.");
                }
                else this.miser(vWord2, vWord3);
                break;

            case MAISON :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                if(pCommandLine.hasSecondWord())
                {
                    this.maison(vWord2);
                }
                else
                {
                    this.aGui.println("Vous devez entrer le nombre de maison souhait??e,");
                    this.aGui.println("Exemple : ''maison 2''.");
                    this.aGui.println("");
                }
                break;

            case HOTEL :
                if ( pCommandLine.hasThirdWord() ) {this.thirdWord();}
                else if ( pCommandLine.hasSecondWord() ) {this.secondWord();}
                else {
                    this.hotel();}
                break;


            case REMBOURSER :
                if(!pCommandLine.hasSecondWord()){this.aGui.println("rembourser prend 2 mots");}
                for(Joueur vJoueur : this.aListJoueur)
                {
                    if(vJoueur.getNom().equals(vWord2)) {this.rembourser(vJoueur);}
                }
                break;

            case CHOIX :
                if ( !pCommandLine.hasSecondWord() ) {this.aGui.println("Choix prends un deuxieme mot.");}
                else {
                    this.aChoix = Integer.parseInt(vWord2);
                }
                this.choix();
                break;

            case VENDRE :
                if ( !pCommandLine.hasSecondWord() || ! pCommandLine.hasThirdWord())
                {
                    this.aGui.println("vendre prend un trois mot.");
                    this.aGui.println("Exemple : 'vendre joueur1 3' (le joueur1 vend Rue Lecourbe)");

                }
                else
                {
                    for(Joueur vJoueur : this.aListJoueur)
                    {
                        if(vJoueur.getNom().equals(vWord2)) {this.vendre(vWord3, vJoueur);}
                    }
                }
                break;

            case TEST :
                this.aTestMode = true;
                this.test(pCommandLine);
                this.aTestMode = false;
                break;

            case LANCERTEST :
                if(this.aTestMode) {this.lancerTest(vWord2, vWord3);}
                break;
        }
    }//interpretCommand(.)

    /***
     * renvoie un message d'erreur si il y a un second mot alors que ce n'est pas necessaire
     */
    private void secondWord()
    {
        this.aGui.println("Cette commande ne prend pas de second mot");
        this.aGui.println("");
    }//secondWord()

    /***
     * renvoie un message d'erreur si il y a un troisieme mot alors que ce n'est pas necessaire
     */
    private void thirdWord()
    {
        this.aGui.println("Cette commande ne prend pas de troisi??me mot");
        this.aGui.println("");
    }//thirdWord()

    /***
     * La fonction qui permet de commencer le jeu
     */
    public void start()
    {
        if (this.aNbActuelJoueur < 2 ) {
            this.aGui.println("Il faut au moins 2 joueurs pour commencer la partie !");
            this.aGui.println("");
            return;
        }
        else {
            this.aGui.println("Que la partie commence !");
            aFiniInit += 1;
            this.aGui.println("");
            this.aGui.println("Chaque joueur doit lancer les d??s, celui qui aura le plus gros");
            this.aGui.println("score commencera.");
            this.aGui.println("");

            this.aCurrentPlayer = this.aListJoueur.get(0);
            this.aGui.println(this.aCurrentPlayer.getNom() + " c'est ?? toi de lancer");
            this.aGui.println("");

            this.aListDette = new ArrayList<Integer>();
            for(int i = 0; i<this.aNbActuelJoueur; i++)
            {
                this.aListDette.add(0);
            }
            this.aListPreteur = new ArrayList<Joueur>();
            for(int i = 0; i<this.aNbActuelJoueur; i++)
            {
                this.aListPreteur.add(null);
            }
        }
    }//start()

    /***
     * permet d'afficher la couleur du joueur actuel correspondant
     */
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
    }//ajouteCouleur()

    /***
     * permet de cr??er le nombre de joueur souhaite et d'initialiser les nom de joueur
     * @param vNom
     */
    private void ajouterJoueur(String vNom)
    {
        if(aFiniInit == 0)
        {
            if(aNbActuelJoueur < 8) {

                aListJoueur.add(new Joueur(vNom));
                aNbActuelJoueur += 1;

                this.aGui.println("Le joueur " + vNom + " ?? bien ??t?? ajouter.");
                this.aGui.println("Il y a actuellement " + aNbActuelJoueur + " joueur(s) dans la partie.");
                this.aGui.println("");
            }
            else
            {
                this.aGui.println("Vous ne pouvez pas avoir plus de 8 Joueur dans la m??me partie");
            }
        }
        else
        {
            this.aGui.println("Vous ne pouvez pas rajouter de joueur apr??s le d??but de la partie");
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
    }//ajouterJoueur()

    /**
     * Fonction retournant les commandes possibles que le joueur peut effectuer
     */
    private void printHelp()
    {
        this.aGui.println("Les commandes que tu peux utiliser sont :");
        this.aGui.println(this.aParser.getCommandsList());
    }//printHelp()

    /***
     * Fonction permettant d'afficher les propriete d'un joueur precis
     * @param pCommand
     */
    private void proprieteSelect(final String pCommand)
    {
        for(int i=1; i<this.aNbActuelJoueur+1; i++)
        {
            if(pCommand.equals(i+""))
            {
                Joueur j = this.aListJoueur.get(i-1);
                this.aGui.println("Propri??t??es de " + j.getNom());
                ArrayList<Propriete> pro = j.getProprietes();
                for (Propriete p : pro){
                    this.aGui.println("- " + p.getDescription());
                }
                this.aGui.println("");
            }
        }
    }//proprieteSelect()

    /***
     * Permet au joueur en parametre d'acheter la propriete sur laquelle on se trouve
     * @param joueurAcheteur
     */
    private void acheter(Joueur joueurAcheteur)
    {
        int pos = this.aCurrentPlayer.getPos();
        Case currentCase = this.aListCase.get(pos);
        if (currentCase.getProprietaire()==null)
        {
            if (currentCase.getClass().equals(Rue.class) || currentCase.getClass().equals(Gare.class) || currentCase.getClass().equals(Compagnie.class))
            {
                Propriete vCurrentPropriete = (Propriete) this.aListCase.get(pos);
                if (joueurAcheteur.getArgent() > vCurrentPropriete.getPrixDeVente())
                {
                    if(aPendantEnchere)
                    {

                        joueurAcheteur.addArgent( - this.aMaxEnchere);
                    }
                    else {
                        joueurAcheteur.addArgent( - vCurrentPropriete.getPrixDeVente());
                    }
                    joueurAcheteur.addPropriete(vCurrentPropriete);
                    vCurrentPropriete.setProprietaire(joueurAcheteur);
                    this.aGui.println("Achat effectu?? avec succ??s !");
                    this.aGui.println("Taper la commande ''passer'' si vous avez fini votre tour.");
                    this.aGui.println("");

                    this.aPasAcheter = 0;
                }
                else{
                    this.aGui.println("Vous n'avez pas assez d'argent,");
                    this.aGui.println("la propriet?? va ??tre mise aux ench??res.");
                    this.aGui.println("");
                    this.aPasAcheter = 1;
                    this.enchere();
                }
            }
        }
        else{
            this.aGui.println("Cette propriet?? appartient d??j?? ?? quelqu'un,");
            this.aGui.println("vous ne pouvez pas l'acheter.");
            this.aGui.println("");
        }

        this.actualiseArgent();
    }//acheter()

    /***
     * Permet d'afficher les details de la propriete sur laquelle on se trouve
     */
    public void detail()
    {
        int pos = this.aCurrentPlayer.getPos();
        Case vCurrentCase = this.aListCase.get(pos);
        if (vCurrentCase.getClass().equals(Rue.class) || vCurrentCase.getClass().equals(Gare.class) || vCurrentCase.getClass().equals(Compagnie.class))
        {
            Propriete vCurrentPropriete = (Propriete) this.aListCase.get(pos);
            this.aGui.println("Loyer : " + vCurrentPropriete.getLoyer(0));

            if (vCurrentCase.getClass().equals(Rue.class)) {
                Rue vCurrentRue = (Rue) this.aListCase.get(pos);
                this.aGui.println("Avec 1 Maisons : " + vCurrentRue.getLoyer(1));
                this.aGui.println("Avec 2 Maisons : " + vCurrentRue.getLoyer(2));
                this.aGui.println("Avec 3 Maisons : " + vCurrentRue.getLoyer(3));
                this.aGui.println("Avec 4 Maisons : " + vCurrentRue.getLoyer(4));
                this.aGui.println("Avec 1 H??tel : " + vCurrentRue.getLoyer(5));
                this.aGui.println("");
                this.aGui.println("Prix des Maisons " + vCurrentRue.getPrixConstruction() + " chacune");
                this.aGui.println("Prix d'un H??tel " + vCurrentRue.getPrixConstruction() + " plus 4 Maisons");
                this.aGui.println("");
                this.aGui.println("Nombre de Maison(s) : " + vCurrentRue.getNbMaisons());
                this.aGui.println("Nombre d'H??tel : " + vCurrentRue.getNbHotel());
            }

            if (vCurrentCase.getClass().equals(Gare.class))
            {
                Gare vCurrentGare = (Gare) this.aListCase.get(pos);
                this.aGui.println("Si vous avez 2 Gares : " + vCurrentGare.getLoyer(1));
                this.aGui.println("Si vous avez 3 Gares : " + vCurrentGare.getLoyer(2));
                this.aGui.println("Si vous avez 4 Gares : " + vCurrentGare.getLoyer(3));
            }

            if (vCurrentCase.getClass().equals(Compagnie.class))
            {
                Compagnie vCurrentGare = (Compagnie) this.aListCase.get(pos);
                this.aGui.println("Si vous poss??dez UNE carte de compagnie de Service Public,");
                this.aGui.println("le loyer est 4 fois le montant indiqu?? par les d??s.");
                this.aGui.println("");
                this.aGui.println("Si vous poss??dez les DEUX cartes de compagnie de Service Public,");
                this.aGui.println("le loyer est 10 fois le montant indiqu?? par les d??s.");
            }
            this.aGui.println("");
            this.aGui.println("Valeur hypoth??caire : " + vCurrentPropriete.getPrixHypotheque());
            this.aGui.println("");
        }
        else {
            this.aGui.println("Il n'y a pas plus de d??tail ?? donner pour cette case.");
            this.aGui.println("");
        }
    }//detail()

    /***
     * permet de lancer et d'arreter une enchere
     */
    public void enchere()
    {
        if(this.aPasAcheter==0)
        {
            this.aGui.println("Vous ne pouvez pas lancer d'enchere maintenant");
        }

        if(this.aPendantEnchere)
        {
            if(this.aMaxEnchere == -1)
            {
                this.aGui.println("Il faut que quelqu'un mise avant de finir les ench??res");
                return;
            }

            this.aGui.println("Les Ench??res sont closes");
            this.aGui.println(this.aJoueurEnchere.getNom() + " obtient la propri??t?? pour " + this.aMaxEnchere);
            this.acheter(this.aJoueurEnchere);

            aMaxEnchere = -1;
            this.aPasAcheter = 0;
            this.aPendantEnchere = false;

            return;

        }
        this.aGui.println("Que les ench??res commencent!");
        this.aGui.println("");
        this.aGui.println("Pour miser, entrez ''miser'' + le nom du joueur + le montant");
        this.aGui.println("Si vous voulez finir les ench??res entrer ''enchere''");

        this.aPendantEnchere = true;
    }//enchere()

    /**
     * permet de tester si une enchere est en cours
     * @return
     */
    private boolean testEnchere()
    {
        boolean vTest = false;
        if(this.aPasAcheter == 1)
        {
            if(this.aPendantEnchere)
            {
                this.aGui.println("Des Ench??res sont en cours");
                return true;
            }
            this.aGui.println("Vous n'avez pas achet?? la prorpi??t?? : ");
            this.aGui.println(this.aListCase.get(this.aCurrentPlayer.getPos()).getDescription());
            this.aGui.println("Elle va donc ??tre mise aux ench??res");

            this.enchere();

            vTest = true;
        }
        return vTest;
    }//testEnchere()

    /***
     * Cette fonction permet de miser lors d'une enchere
     * @param pJoueurMise
     * @param pMise
     */
    public void miser(String pJoueurMise, String pMise)
    {
        if(this.aPendantEnchere)
        {
            int vmise = Integer.parseInt(pMise);

            if(vmise <= aMaxEnchere)
            {
                this.aGui.println(pJoueurMise + " ne mise pas assez haut");
            }
            else
            {
                Joueur vJoueurMise = null;
                boolean vPasAccepter = true;
                for(int i=0; i<this.aNbActuelJoueur; i++)
                {
                    if(this.aListJoueur.get(i).getNom().equals(pJoueurMise))
                    {
                        vJoueurMise = this.aListJoueur.get(i);
                        if(vJoueurMise.getFaillite())
                        {
                            this.aGui.println("le joueur a fait faillite !");
                        }
                        vPasAccepter = false;
                    }
                }

                if(vPasAccepter)
                {
                    this.aGui.println("Joueur non reconnue");
                    return;
                }

                if(vJoueurMise.getArgent() < vmise)
                {
                    this.aGui.println("Vous n'avez pas assez d'argent pour miser");
                    return;
                }
                this.aGui.println(vJoueurMise.getNom() + " vient de miser " + vmise);
                this.aMaxEnchere = vmise;
                this.aJoueurEnchere = vJoueurMise;
            }
        }
        else
        {
            this.aGui.println("il n'y a pas d'ench??res en cours");
        }
    }//miser()

    /***
     * Cette fonction permet de quitter le jeux
     */
    private void quitter()
    {
        this.aGui.println("Merci d'avoir jouer au Monopoly. ?? Bient??t !");
        this.aGui.enable( false );
    }//quitter()

    /***
     * Cette fonction permet de piocher une carte
     */
    private void carte()
    {
        int vPos = this.aCurrentPlayer.getPos();
        if (vPos == 2 || vPos == 17|| vPos==7 || vPos==22 || vPos ==36 || this.aAutorise)
        {
            Carte vCarteTiree;

            if (vPos == 2 || vPos == 17 || vPos == 33) {
                vCarteTiree = this.aListCom.pollFirst();
                if (vCarteTiree.getAction() != 6) this.aListCom.addLast(vCarteTiree);
                this.aGui.println("Vous avez pioch?? une carte communaut??.");
            } else {
                vCarteTiree = this.aListChance.pollFirst();
                if (vCarteTiree.getAction() != 2) this.aListChance.addLast(vCarteTiree);
                this.aGui.println("Vous avez pioch?? une carte chance.");
            }
            this.aGui.println("Vous avez tir?? la carte :");
            this.aGui.println(vCarteTiree.getDescription());
            this.aGui.println("");

            if (vCarteTiree.getAction() == 0) {
                if (vCarteTiree.getDeplacement() != -1) {
                    this.aCurrentPlayer.setPos(vCarteTiree.getDeplacement());
                    this.aGui.println("Vous avez ??t?? d??plac?? sur la case " + this.aListCase.get(vCarteTiree.getDeplacement()).getDescription());
                    if (this.aCurrentPlayer.getPos()> vCarteTiree.getDeplacement()) {
                        this.aCurrentPlayer.addArgent(200);
                        this.aGui.println("Vous passez par la case d??part, recevez 200???.");
                        this.actualiseArgent();
                    }

                    this.descriptionPos();
                } else {
                    if (this.aCurrentPlayer.getArgent() > -vCarteTiree.getPrix()) {
                        this.aCurrentPlayer.addArgent(vCarteTiree.getPrix());
                        this.aGui.println("Transaction effectu??e avec succ??s!");
                        this.aGui.println("");
                        this.actualiseArgent();
                        if (vCarteTiree.getPrix() < 0) {
                            this.aArgentCentral += -vCarteTiree.getPrix();
                            this.aGui.aCagnotte.setText("Cagnotte = " + this.aArgentCentral);
                        }
                        if (!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                        {
                            this.passer();
                        }
                    } else {
                        if(compteFaillite(aCurrentPlayer) < -vCarteTiree.getPrix())
                        {
                            faillite(aCurrentPlayer);
                            return;
                        }
                        this.aListDette.set(this.aPosJoueurActuel, -vCarteTiree.getPrix());
                        this.aListPreteur.set(this.aPosJoueurActuel, null);
                        this.pasAssezArgent(this.aCurrentPlayer);
                    }
                }
            }
            //impos?? pour les r??parations de voirie ?? raison de 40??? par maison et 115??? par hot??l
            if (vCarteTiree.getAction() == 1) {
                int vNbMaison = this.getNbMaisonPlayer(this.aCurrentPlayer);
                int vPrixMaison = 40 * vNbMaison;
                int vNbHotel = this.getNbHotelPlayer(this.aCurrentPlayer);
                int vPrixHotel = 115 * vNbHotel;
                int vPrix = vPrixHotel + vPrixMaison;
                if (this.aCurrentPlayer.getArgent() > vPrix) {
                    this.aCurrentPlayer.addArgent(-vPrix);
                    this.aGui.println("Transaction effectu??e avec succ??s!");
                    this.aGui.println("");
                    this.actualiseArgent();
                    this.aArgentCentral += vPrix;
                    this.aGui.aCagnotte.setText("Cagnotte = " + this.aArgentCentral);
                    if (!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                    {
                        this.passer();
                    }
                } else {
                    if(compteFaillite(aCurrentPlayer) < vPrix)
                    {
                        faillite(aCurrentPlayer);
                        return;
                    }
                    this.aListDette.set(this.aPosJoueurActuel, vPrix);
                    this.aListPreteur.set(this.aPosJoueurActuel, null);
                    this.pasAssezArgent(this.aCurrentPlayer);
                }
            }
            //Vous ??tes lib??r?? de prison
            if (vCarteTiree.getAction() == 2 || vCarteTiree.getAction() == 6) {
                this.aCurrentPlayer.addCarteFreePrison(vCarteTiree.getAction());
                this.aGui.println("Votre carte est mise de cot?? et pourra etre utilis??e");
                this.aGui.println("automatiquement si vous allez en prison.");
            }
            //Reculez de trois cases
            if (vCarteTiree.getAction() == 3) {
                int vNewPos = this.aCurrentPlayer.getPos() - 3;
                if (vNewPos < 0) {
                    vNewPos += 40;
                }
                this.aCurrentPlayer.setPos(vNewPos);
                this.descriptionPos();
            }
            //Allez en prison
            if (vCarteTiree.getAction() == 4 || vCarteTiree.getAction() == 7) {
                this.aCurrentPlayer.goPrison();
                this.aGui.println("Vous etes en prison");
                this.aGui.println("");
                if (!this.aCurrentPlayer.getCarteFreePrison().isEmpty()) {
                    this.aGui.println("Vous avez une carte 'sortie de prison',");
                    this.aGui.println("la carte a ??t?? utilis??, vous etes donc libre.");
                    this.aGui.println("");
                    this.aCurrentPlayer.outPrison();
                    int vNumCarte = this.aCurrentPlayer.supCarteFreePrison();
                    if(vNumCarte == 2) {this.aListChance.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 2));}
                    else {this.aListCom.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 6));}
                    this.aGui.println("");
                } else {
                    this.aGui.println("Vous ne pouvez plus jouer, vous passez votre tour.");
                    this.aGui.println("");
                }
                this.passer();
            }
            //Versez pour chaque maison 25???. Versez pour chaque h??tel 100???
            if (vCarteTiree.getAction() == 5)
            {
                int vNbMaison = this.getNbMaisonPlayer(this.aCurrentPlayer);
                int vNbHotel = this.getNbHotelPlayer(this.aCurrentPlayer);
                int vPrix = 25 * vNbMaison + 100 * vNbHotel;
                if (this.aCurrentPlayer.getArgent() > vPrix) {
                    this.aCurrentPlayer.addArgent(-vPrix);
                    this.aGui.println("Transaction effectu??e avec succ??s!");
                    this.aGui.println("");
                    this.actualiseArgent();
                    this.aArgentCentral += vPrix;
                    this.aGui.aCagnotte.setText("Cagnotte = " + this.aArgentCentral);
                    if (!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                    {
                        this.passer();
                    }
                } else {
                    if(compteFaillite(aCurrentPlayer) < vPrix)
                    {
                        faillite(aCurrentPlayer);
                        return;
                    }
                    this.aListDette.set(this.aPosJoueurActuel, vPrix);
                    this.aListPreteur.set(this.aPosJoueurActuel, null);
                    this.pasAssezArgent(this.aCurrentPlayer);
                }
            }
            //Retournez ?? Belleville sans passer par le depart
            if (vCarteTiree.getAction()==8)
            {
                this.aCurrentPlayer.setPos(vCarteTiree.getDeplacement());
                this.aGui.println("Vous avez ??t?? d??plac?? sur la case " + this.aListCase.get(vCarteTiree.getDeplacement()).getDescription());
                this.descriptionPos();
            }
            // anniversaire Chaque joueur doit vous donner 10???
            if (vCarteTiree.getAction()==9)
            {
                for (int i = 0; i < this.aListJoueur.size(); i++)
                {
                    if (i != this.aPosJoueurActuel)
                    {
                        Joueur vCurrentJoueur = this.aListJoueur.get(i);
                        if (vCurrentJoueur.getArgent() > 10)
                        {
                            this.aCurrentPlayer.addArgent(10);
                            vCurrentJoueur.addArgent(-10);
                            this.actualiseArgent();
                            this.aGui.println("Le joueur "+vCurrentJoueur.getNom()+" a donn?? 10 euros a "+this.aCurrentPlayer.getNom());
                        }
                        else {
                            this.aGui.println("Le joueur "+vCurrentJoueur.getNom()+" n'a pas assez d'argent");
                            if(compteFaillite(vCurrentJoueur) < 10)
                            {
                                faillite(vCurrentJoueur);
                                return;
                            }
                            this.pasAssezArgent(this.aListJoueur.get(i));
                            this.aListDette.set(i,10);
                            this.aListPreteur.set(i,this.aCurrentPlayer);
                        }
                    }
                }
            }
            //Payez une amende de 10??? ou bien tirez une carte <<CHANCE>>
            if (vCarteTiree.getAction()==10)
            {
                if (this.aChoix == 0)
                {
                    this.aGui.println("Vous devez choisir. Pour cela, tapez 'choix' suivi");
                    this.aGui.println("de 1 pour le premier choix ou 2 pour le deuxieme.");
                }
                else {
                    this.aAutorise = true;
                    this.choix();
                }

            }
            //Rendez-vous ?? la gare la plus proche. Si vous passez par la d??part, recevez 200???
            if (vCarteTiree.getAction()==11)
            {
                ArrayList<Integer> vListeGare = new ArrayList<Integer>();
                vListeGare.add(5); vListeGare.add(15); vListeGare.add(25); vListeGare.add(35);
                int vDistanceMin = 40;
                int vNumGareChoisi = 5;
                for(int vNumGare : vListeGare)
                {
                    int vDistance = vNumGare - this.aCurrentPlayer.getPos();
                    if(vDistance<vDistanceMin && vDistance>0)
                    {
                        vDistanceMin = vDistance;
                        vNumGareChoisi = vNumGare;
                    }
                }
                if(this.aCurrentPlayer.getPos() > vNumGareChoisi)
                {
                    this.aCurrentPlayer.addArgent(200);
                    this.aGui.println("Vous passez par la case d??part, recevez 200???.");
                    this.actualiseArgent();
                }
                this.aCurrentPlayer.setPos(vNumGareChoisi);
                this.descriptionPos();

            }
        }
        else{
            this.aGui.println("Vous ne pouvez pas piocher de carte.");
            this.aGui.println("");
        }

    }//carte()

    /***
     * Cette fonction permet de choisir deux possibilit?? avec la carte communaut?? numero 13
     */
    public void choix()
    {
        if (this.aChoix == 1)
        {
            if (this.aCurrentPlayer.getArgent() > 10)
            {
                this.aCurrentPlayer.addArgent(-10);
                this.aArgentCentral += 10;
                this.aGui.aCagnotte.setText("Cagnotte = "+this.aArgentCentral);
            }
            else {
                this.aListDette.set(this.aPosJoueurActuel,10);
                this.aListPreteur.set(this.aPosJoueurActuel,null);
            }
        }
        if (this.aChoix == 2)
        {
            this.aGui.println("Vous devez piocher une carte.");
        }
        this.aChoix=0;
        this.aAutorise = false;
    }//choix()

    /***
     * Cette fonction permet de connaitre le nombre de maison d'un joueur precis
     */
    public int getNbMaisonPlayer(Joueur pJoueur)
    {
        int vNbMaison = 0;
        ArrayList<Propriete> pro = pJoueur.getProprietes();
        for (Propriete vCurrentPropriete : pro){
            if(vCurrentPropriete.getClass().equals(Rue.class))
            {
                Rue vCurrentPro = (Rue)vCurrentPropriete;
                vNbMaison += vCurrentPro.getNbMaisons();
            }
        }
        return vNbMaison;
    }//getNbMaisonPlayer()

    /***
     * Cette fonction permet de connaitre le nombre d'hotel d'un joueur precis
     */
    public int getNbHotelPlayer(Joueur pJoueur)
    {
        int vNbHotel = 0;
        ArrayList<Propriete> pro = pJoueur.getProprietes();
        for (Propriete vCurrentPropriete : pro){
            if(vCurrentPropriete.getClass().equals(Rue.class))
            {
                Rue vCurrentPro = (Rue)vCurrentPropriete;
                vNbHotel += vCurrentPro.getNbHotel();
            }
        }
        return vNbHotel;
    }//getNbHotelPlayer()

    /**
     * Cette fonction permet de lancer les d??s.
     */
    public void lancer()
    {
        if(this.aPasAssez)
        {
            this.aGui.println("Il reste des dettes ?? rembourser");
            this.aGui.println("Vous ne pouvez pas passer.");
            return;
        }

        if (this.testEnchere())
        {
            return;
        }

        if (!this.aCurrentPlayerPlay && this.aPremiersLancer == 1) //v??rifie si le joueur n'a pas d??j?? lancer ses d??s dans son tour
        {
            this.aGui.println("Vous avez d??j?? lancer les d??s pour ce tour l?? !");
            this.aGui.println("");
            return;
        }


        De vDe1 = new De();
        De vDe2 = new De();
        vDe1.lanceDe();
        vDe2.lanceDe();
        this.aNBlancer = vDe1.getNbDe()+vDe2.getNbDe();
        this.aGui.println("Vous avez fait un score de "+this.aNBlancer);
        this.aGui.showImageDe(vDe1.getNbDe()+".jpg", vDe2.getNbDe()+".jpg");
        this.aCurrentPlayerPlay = false;

        if(this.aPremiersLancer == 0)
        {
            this.premierslancer(this.aNBlancer);
            return;
        }

        if (vDe1.getNbDe() == vDe2.getNbDe())
        {
            this.aCurrentPlayer.setDouble();
            if (this.aCurrentPlayer.IsPrison())
            {
                this.aCurrentPlayer.outPrison();
                this.aGui.println("Vous avez fait un double, vous sortez de prison.");
            }
            this.aGui.println("Vous avez fait un double, vous pourrez rejouer !");
            this.aCurrentPlayerPlay = true;

        }
        if (this.aCurrentPlayer.getDouble() == 3){
            this.aGui.println("Dommage, vous avez fait des doubles 3 fois de suite,");
            this.aGui.println("Vous allez en prison.");
            this.aGui.println("");
            this.aCurrentPlayer.goPrison();
            if(!this.aCurrentPlayer.getCarteFreePrison().isEmpty())
            {
                this.aGui.println("Vous avez une carte 'sortie de prison',");
                this.aGui.println("la carte a ??t?? utilis??, vous serez libre au prochain tour.");
                this.aGui.println("");
                this.aCurrentPlayer.outPrison();
                int vNumCarte = this.aCurrentPlayer.supCarteFreePrison();
                if(vNumCarte == 2) {this.aListChance.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 2));}
                else {this.aListCom.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 6));}
            }
            else
            {
                return;
            }
        }
        this.avancer();
        if (!this.aCurrentPlayer.IsPrison()) { this.descriptionPos();}
    }//lancer()

    /***
     * permet de faire avancer le joueur du nombre obtenu apres avoir lanc?? les d??s
     */
    private void avancer()
    {
        if (!this.aCurrentPlayer.IsPrison())
        {
            this.aCurrentPlayer.ajoutePos(this.aNBlancer);
            int pos = this.aCurrentPlayer.getPos();
            if ( pos >= 40)
            {
                this.aCurrentPlayer.addArgent(200);
                this.aGui.println("Vous passez par la case d??part, recevez 200???.");
                this.actualiseArgent();
                this.aCurrentPlayer.setPos(pos-40);
            }
        }
        else
        {
            if(this.aCurrentPlayer.getNbTourPrison()!=2)
            {
                this.aCurrentPlayer.setNbTourPrison(this.aCurrentPlayer.getNbTourPrison() + 1);
                this.aGui.println("Vous etes en prison vous ne pouvez pas avancer.");
                this.aGui.println("");
                this.passer();
            }
            else
            {
                this.aCurrentPlayer.outPrison();
                this.aCurrentPlayer.setNbTourPrison(0);
                this.aGui.println("Vous avez pass??s 3 tours en prison, vous ??tes libre au prochain tour.");
                this.aGui.println("");
            }
        }
    }//avancer()

    /***
     * permet d'actualiser l'affichage des somme d'argent des joueurs
     */
    private void actualiseArgent()
    {
        int nbJoueur = this.aListJoueur.size();
        if (nbJoueur >=1 ) {this.aGui.aSom1.setText(""+this.aListJoueur.get(0).getArgent());}
        if (nbJoueur >=2 ) {this.aGui.aSom2.setText(""+this.aListJoueur.get(1).getArgent());}
        if (nbJoueur >=3 ) {this.aGui.aSom3.setText(""+this.aListJoueur.get(2).getArgent());}
        if (nbJoueur >=4 ) {this.aGui.aSom4.setText(""+this.aListJoueur.get(3).getArgent());}
        if (nbJoueur >=5 ) {this.aGui.aSom5.setText(""+this.aListJoueur.get(4).getArgent());}
        if (nbJoueur >=6 ) {this.aGui.aSom6.setText(""+this.aListJoueur.get(5).getArgent());}
        if (nbJoueur >=7 ) {this.aGui.aSom7.setText(""+this.aListJoueur.get(6).getArgent());}
        if (nbJoueur >=8 ) {this.aGui.aSom8.setText(""+this.aListJoueur.get(7).getArgent());}
    }//actualiseArgent()

    /**
     * permet de savoir qui va commencer la partie
     * @param NbrLancer
     */
    private void premierslancer(int NbrLancer)
    {
        if(this.aListLancer.size() <= this.aNbActuelJoueur && this.aTestUnique == 0)
        {
            this.aListLancer.add(NbrLancer);

            prochain();

            if(this.aListLancer.size()<this.aNbActuelJoueur)
            {
                this.aGui.println("?? " +aCurrentPlayer.getNom()+ " de lancer les d??s.");
                this.aGui.println("");
            }
        }

        if(this.aTestUnique == 1 || this.aTestUnique == 2)
        {
            this.aListLancer.set( this.aPosJoueurActuel, NbrLancer);
        }

        if(this.aListLancer.size() == this.aNbActuelJoueur)
        {

            if(this.aTestUnique==0 || this.aTestUnique==2)
            {
                int vPG;
                vPG = this.plusgrands();

                this.aGui.println("");

                for(int i=0; i<this.aListGrand.size(); i++)
                {
                    this.aGui.println(this.aListJoueur.get(this.aListGrand.get(i)).getNom() + " a obtenu "+vPG+" et c'est le plus grand nombre.");
                }

                this.aGui.println("");

                if (this.aListGrand.size() == 1) {
                    this.aCurrentPlayerPlay = true;
                    this.lancerPartie();
                }
                else
                {
                    this.aGui.println("Il y a " + this.aListGrand.size() + " joueurs avec le plus grand nombre");
                    this.aTestUnique = 1;
                }
            }

            if(this.aTestUnique!=0)
            {
                this.aPosJoueurActuel = this.aListGrand.get(0);
                this.aCurrentPlayer = this.aListJoueur.get(this.aPosJoueurActuel);

                this.aGui.println("?? " +aCurrentPlayer.getNom()+ " de lancer les d??s.");
                this.aGui.println("");

                this.aListGrand.remove(0);

                this.aGui.println(aListGrand.toString());


                if(this.aListGrand.isEmpty())
                {
                    this.aTestUnique = 2;
                }
            }

        }
    }//premierslancer()

    /**
     * Le jeu commencera officiellement
     */
    private void lancerPartie()
    {
        this.aPremiersLancer = 1;
        this.aPosJoueurActuel = this.aListGrand.get(0);
        this.aCurrentPlayer = this.aListJoueur.get(this.aPosJoueurActuel);
        this.aGui.println("");
        this.aGui.println(this.aCurrentPlayer.getNom() + ", vous commencez ?? jouer");
        this.aGui.aJoueur.setText("Joueur "+ this.aCurrentPlayer.getNom());
        this.ajouteCouleur();
        this.debutDeTour();
    }//lancerPartie()

    /***
     * permet de savoir qui a r??aliser le plus gros score pour determiner qui commencera la partie
     * @return
     */
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
    }//plusgrands();

    /***
     * permet de passer au tour suivant
     */
    public void passer()
    {
        if(aPasAssez)
        {
            this.aGui.println("Il reste des dettes a rembourser");
            return;
        }

        if (this.testEnchere())
        {
            return;
        }

        if(this.aCurrentPlayerPlay) //si le joueur a fait de double le pr??venir qu'il peut rejouer
        {
            this.aGui.println("Vous aviez fait un double, vous pouvez relancer les d??s.");
            this.aGui.println("");
            return;}



        this.aCurrentPlayer.initDouble();
        this.actualiseArgent();
        this.aCurrentPlayerPlay = true;

        prochain();

        this.aGui.aJoueur.setText("Joueur "+ this.aCurrentPlayer.getNom());
        this.ajouteCouleur();
        this.debutDeTour();
    }//passer()

    /***
     * Cette fonction permet de changer de joueur actuel
     */
    private void prochain()
    {
        if(this.aPosJoueurActuel+1<this.aNbActuelJoueur)
        {
            this.aPosJoueurActuel+= 1;
        }
        else
        {
            this.aPosJoueurActuel = 0;
        }

        this.aCurrentPlayer = this.aListJoueur.get(this.aPosJoueurActuel);
        if(this.aCurrentPlayer.getFaillite())
        {
            prochain();
        }
    }//prochain()

    /***
     * cette fonction permet de lancer un tour
     */
    private void debutDeTour()
    {
        this.aGui.println("");
        this.aGui.println(this.aCurrentPlayer.getNom() + " doit lancer les d??s !");
        this.aGui.println("");
    }//debutDeTour()

    /**
     * D??cris la case sur laquelle le CurrentPlayer se trouve, soit donne le nom de la case
     */
    private void descriptionPos()
    {
        this.aGui.println(this.aCurrentPlayer.getNom() + " arrive sur la case :");
        int pos = this.aCurrentPlayer.getPos();
        Case vCurrentCase = this.aListCase.get(pos);
        this.aGui.println(vCurrentCase.getDescription());

        //Le joueur tombe sur une rue
        if (vCurrentCase.getClass().equals(Rue.class))
        {
            Rue vCurrentRue = (Rue) this.aListCase.get(pos);

            //Il n'y a pas de propri??taire
            if (vCurrentRue.getProprietaire() == null)
            {
                this.aGui.println("Cette propriet??e n'appartient ?? personne, vous pouvez l'acheter");
                this.aGui.println("ou lancer les ench??res.");
                this.aGui.println("Prix de vente : " + vCurrentRue.getPrixDeVente());
                this.aGui.println("");

                this.aPasAcheter = 1;
            }
            //S'il y a un propri??taire
            else {
                int vNbMaison = vCurrentRue.getNbMaisons();
                int vNbHotel = vCurrentRue.getNbHotel();
                int vPrixLoyer = 0;
                if (vNbHotel==0) {vPrixLoyer = vCurrentRue.getLoyer(vNbMaison);}
                else { vPrixLoyer = vCurrentRue.getLoyer(4); }
                Joueur j = vCurrentRue.getProprietaire();
                //La propri??t?? appartient au CurrentPlayer
                if (j.getNom().equals(this.aCurrentPlayer.getNom())){
                    this.aGui.println("Cette propriet??e vous appartient.");
                    this.aGui.println("Vous pouvez y ajouter une maison ou un h??tel,");
                    this.aGui.println("avec les commandes ''maison'' + nombre de maison souhait??e");
                    this.aGui.println("et ''hotel'', ou vous pouvez passer votre tour.");
                    this.aGui.println("");
                }
                //La propri??t?? appartient ?? un autre joueur
                else {
                    this.aGui.println("Vous devez payer un loyer de "+vPrixLoyer+" ?? "+j.getNom());
                    this.payer(vPrixLoyer,j);
                }
            }
        }

        //Le joueur tombe sur une gare
        else if (vCurrentCase.getClass().equals(Gare.class))
        {
            Gare vCurrentGare = (Gare) this.aListCase.get(pos);

            //Il n'y a pas de propri??taire
            if (vCurrentGare.getProprietaire() == null)
            {
                this.aGui.println("Cette gare n'appartient ?? personne, vous pouvez l'acheter");
                this.aGui.println("ou lancer les ench??res.");
                this.aGui.println("Prix de vente : " + vCurrentGare.getPrixDeVente());
                this.aGui.println("");

                this.aPasAcheter = 1;
            }
            //S'il y a un propri??taire
            else
            {
                Joueur vProprio = vCurrentGare.getProprietaire();
                if (vProprio.getNom().equals(this.aCurrentPlayer.getNom()))
                {
                    this.aGui.println("Cette gare vous appartient.");
                    this.aGui.println("");
                    if(!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                    { this.passer();}
                }
                else
                    {
                        int i = vProprio.nbGares();
                        int vPrixLoyer = vCurrentGare.getLoyer(i);
                        this.aGui.println("Vous devez payer un loyer de " + vPrixLoyer + " ?? " + vProprio.getNom());
                        this.payer(vPrixLoyer, vProprio);
                    }
            }
        }

        //Le joueur tombe sur une compagnie
        else if (vCurrentCase.getClass().equals(Compagnie.class))
        {
            Compagnie vCurrentCompagnie = (Compagnie) this.aListCase.get(pos);

            //Il n'y a pas de propri??taire
            if (vCurrentCompagnie.getProprietaire() == null)
            {
                this.aGui.println("Cette compagnie de distribution n'appartient ?? personne, vous");
                this.aGui.println("pouvez l'acheter ou lancer les ench??res.");
                this.aGui.println("Prix de vente : " + vCurrentCompagnie.getPrixDeVente());
                this.aGui.println("");

                this.aPasAcheter = 1;
            }
            //S'il y a un propri??taire
            else
            {
                Joueur vProprio = vCurrentCompagnie.getProprietaire();
                if (vProprio.getNom().equals(this.aCurrentPlayer.getNom())){
                    this.aGui.println("Cette compagnie de distribution vous appartient.");
                    this.aGui.println("");
                    if(!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                    { this.passer();}
                }
                else {
                    int i = vProprio.nbCompagnies();
                    int vPrixLoyer = vCurrentCompagnie.getLoyer(i) * this.aNBlancer;
                    this.aGui.println("Vous devez payer un loyer de " + vPrixLoyer + " ?? " + vProprio.getNom());
                    this.payer(vPrixLoyer, vProprio);
                }
            }
        }

        //Le joueur tombe sur les cases Imp??t sur le Revenu ou Taxe de Luxe
        else if (this.aCurrentPlayer.getPos() == 4 || this.aCurrentPlayer.getPos() == 38)
        {
            int vPrix;
            if (this.aCurrentPlayer.getPos() == 4) {vPrix = 200;}
            else {vPrix = 100;}
            this.aGui.println("Vous etes sur la case" + vCurrentCase.getDescription() + ".");
            this.aGui.println("Vous payer" + vPrix);
            if (this.aCurrentPlayer.getArgent() > vPrix)
            {
                this.aCurrentPlayer.addArgent(-vPrix);
                this.aArgentCentral += vPrix;
                this.aGui.aCagnotte.setText("Cagnotte = "+this.aArgentCentral);
                this.aGui.println("Payement effectu?? avec succ??s!");
                this.actualiseArgent();
                if(!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
                { this.passer();}
            }
            else
            {
                if(compteFaillite(aCurrentPlayer) < vPrix)
                {
                    faillite(aCurrentPlayer);
                    return;
                }
                this.pasAssezArgent(this.aCurrentPlayer);
            }
        }

        //Le joueur tombe sur une case chance ou communaut??
        else if (pos == 2 || pos == 7 || pos == 17 || pos == 22 ||pos == 33 ||pos==36)
        {
            this.aGui.println("Vous devez piocher une carte.");
        }

        //Le joueur tombe sur la case Prison
        else if (this.aCurrentPlayer.getPos() == 10)
        {
            this.aGui.println("Vous visitez la prison.");
            if(!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
            { this.passer();}
        }

        //Le joueur tombe sur la case Allez en Prison
        else if (this.aCurrentPlayer.getPos() == 30)
        {
            this.aGui.println("Vous pouvez sortir de prison en faisant un double,");
            this.aGui.println("ou avec une carte 'sortie de prison'.");
            this.aGui.println("");
            this.aCurrentPlayer.goPrison();
            if(!this.aCurrentPlayer.getCarteFreePrison().isEmpty())
            {
                this.aGui.println("Vous avez une carte 'sortie de prison',");
                this.aGui.println("la carte a ??t?? utilis??, vous etes donc libre.");
                this.aGui.println("");
                this.aCurrentPlayer.outPrison();
                int vNumCarte = this.aCurrentPlayer.supCarteFreePrison();
                if(vNumCarte == 2) {this.aListChance.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 2));}
                else {this.aListCom.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 6));}
            }
            this.passer();
        }

        //Le joueur tombe sur la case Parc Gratuit
        else if (this.aCurrentPlayer.getPos() == 20)
        {
            this.aGui.println("Vous visitez le Parc Gratuit.");
            this.aCurrentPlayer.addArgent(this.aArgentCentral);
            this.aGui.println("Vous avez re??u l'argent au milieu du plateau.");
            this.aArgentCentral = 0;
            this.aGui.aCagnotte.setText("Cagnotte = "+this.aArgentCentral);
            this.actualiseArgent();
        }

    }//descriptionPos()

    /***
     * Cette fonction permet de payer un loyer
     * @param loyer
     * @param joueur
     */
    public void payer(final int loyer, final Joueur joueur)
    {
        if (this.aCurrentPlayer.getArgent() > loyer)
        {
            this.aCurrentPlayer.addArgent(-loyer);
            joueur.addArgent(loyer);
            this.aGui.println("Payement effectu?? avec succ??s!");
            this.aGui.println("");
            this.actualiseArgent();
            if(!this.aCurrentPlayerPlay) //le joueur n'a pas fait de double et ne peut pas rejouer
            { this.passer();}
        }
        else{
            if(compteFaillite(aCurrentPlayer) < loyer)
            {
                this.aGui.println("Un joueur n'a pas pu payer");
                faillite(aCurrentPlayer);
                return;
            }
            this.aListDette.set(this.aPosJoueurActuel, loyer);
            this.aListPreteur.set(this.aPosJoueurActuel, joueur);
            this.pasAssezArgent(this.aCurrentPlayer);
        }
    }//payer()

    /***
     * Cette fonction permet de construire des maisons
     */
    public void maison(final String pNbAddMaison)
    {
        int vNbAddMaison = Integer.parseInt(pNbAddMaison);
        int vPos = this.aCurrentPlayer.getPos();
        Case vCurrentCase = this.aListCase.get(vPos);

        if (vCurrentCase.getClass().equals(Rue.class))
        {
            Rue vCurrentRue = (Rue) this.aListCase.get(vPos);
            //Regarde si le joueur poss??de le monopole
            if (this.getMonopole())
            {
                int vNbMaison = vCurrentRue.getNbMaisons();
                if (vNbMaison + vNbAddMaison > 4)
                {
                    this.aGui.println("Le nombre de Maison sur une propri??t?? est limit?? ?? 4.");
                    this.aGui.println("");
                    return;
                }
                //Regarde si le CurrentPlayer poss??de l'argent pour constuire la/les maison(s)
                if (this.aCurrentPlayer.getArgent() >= vNbAddMaison * vCurrentRue.getPrixConstruction())
                {

                    //Regarde si on ne se trouve pas dans une crise du b??timent
                    if (this.aNbTotalMaison - vNbAddMaison >= 0) {
                        vCurrentRue.addMaison(vNbAddMaison);
                        this.aNbTotalMaison -= vNbAddMaison;
                        this.aCurrentPlayer.addArgent(-vNbAddMaison * vCurrentRue.getPrixConstruction());

                        if (vNbMaison == 1) {
                            this.aGui.println(vNbAddMaison + " maison vient d'??tre construite sur :");
                        } else {
                            this.aGui.println(vNbAddMaison + " maisons viennent d'??tre construites sur :");
                        }
                        this.aGui.println(vCurrentRue.getDescription());
                        this.aGui.println("");
                        this.actualiseArgent();
                        this.passer();
                    }
                    else {
                        this.aGui.println("Nous sommes dans une crise du b??timent !");
                        this.aGui.println("Il ne reste plus que " + this.aNbTotalMaison + " Maison(s).");
                    }
                }
                else {
                    this.aGui.println("Vous ne poss??dez pas assez d'argent pour construire cette/ces Maison(s).");
                }
            }
            else {
                this.aGui.println("Vous ne poss??dez pas ce monopole.");
            }
        }
        else {
            this.aGui.println("Vous ne pouvez construire des Maisons que sur des rues.");
        }
        this.aGui.println("");
    }//maison()

    /**
     * Cette fonction permet de creer un hotel
     */
    public void hotel()
    {
        int vPos = this.aCurrentPlayer.getPos();
        Case vCurrentCase = this.aListCase.get(vPos);

        if (vCurrentCase.getClass().equals(Rue.class))
        {
            Rue vCurrentRue = (Rue) this.aListCase.get(vPos);
            //Regarde si le joueur poss??de le monopole
            if (this.getMonopole()) {

                //Regarde s'il y a d??j?? un h??tel sur cette rue
                if(vCurrentRue.getNbHotel() == 0){

                    //Regarde s'il y a 4 maisons sur la rue
                    if(vCurrentRue.getNbMaisons() == 4) {

                        //Regarde si le CurrentPlayer poss??de l'argent pour construire l'h??tel
                        if (this.aCurrentPlayer.getArgent() >= vCurrentRue.getPrixConstruction()) {

                            //Regarde si on ne se trouve pas dans une crise du b??timent
                            if (this.aNbTotalMaison >= 1) {
                                vCurrentRue.addMaison(-4);
                                this.aNbTotalMaison -= 4;
                                vCurrentRue.addHotel();
                                this.aNbTotalHotel -= 1;
                                this.aCurrentPlayer.addArgent(-vCurrentRue.getPrixConstruction());
                                this.aGui.println("Un H??tel vient d'??tre construit sur : ");
                                this.aGui.println(vCurrentRue.getDescription());
                                this.aGui.println("");
                                this.actualiseArgent();
                                this.passer();
                            }
                            else {
                                this.aGui.println("Nous sommes dans une crise du b??timent !");
                                this.aGui.println("Il ne reste plus d'H??tel.");
                            }
                        }
                        else {
                            this.aGui.println("Vous ne poss??dez pas assez d'argent pour construire un H??tel.");
                        }
                    }
                    else {
                        this.aGui.println("Pour construire un H??tel sur une rue, elle doit d??j?? poss??der 4 maisons.");
                    }
                }
                else{
                    this.aGui.println("Il y a d??j?? un H??tel sur cette rue.");
                }
            }
            else {
                this.aGui.println("Vous ne poss??dez pas ce monopole.");
            }
        }
        else {
            this.aGui.println("Vous ne pouvez construire un H??tel que sur des rues.");
        }
        this.aGui.println("");
    }//hotel()


    private void pasAssezArgent(Joueur pJoueurPauvre)
    {
        Joueur vJoueurPauvre = pJoueurPauvre;

        this.aGui.println("vous pouvez hypoth??quer une propri??t?? ou d??clarer faillite.");
        this.aGui.println("Exemple : 'vendre joueur1 3' (le joueur1 vend Rue Lecourbe)");
        this.aGui.println("");

        this.aPasAssez = true;
    }//pasAssezArgent()

    public void rembourser(Joueur pJoueurRemboursant)
    {
        for(int i=0; i<aNbActuelJoueur; i++)
        {
            if(this.aListJoueur.get(i)==pJoueurRemboursant)
            {
                if(pJoueurRemboursant.getArgent() < aListDette.get(i))
                {
                    this.aGui.println(pJoueurRemboursant.getNom() + " n'a pas assez d'argent pour rembourser");
                    this.aGui.println("");

                    return;
                }
                else
                {
                    if(this.aListPreteur.get(i) == null)
                    {
                        this.aArgentCentral+=this.aListDette.get(i);
                        this.aGui.aCagnotte.setText("Cagnotte = " + this.aArgentCentral);
                    }
                    else
                    {
                        this.aListPreteur.get(i).addArgent(this.aListDette.get(i));
                    }

                    pJoueurRemboursant.addArgent(-this.aListDette.get(i));
                    this.actualiseArgent();
                    this.aGui.println(pJoueurRemboursant.getNom() + " a bien rembours?? ses dettes de " + this.aListDette.get(i));
                    this.aGui.println("");

                    this.aListDette.set( i, 0);
                    this.aListPreteur.set(i,null);


                }
            }
        }
        int vCompte = 0;
        for(int o=0; o<this.aNbActuelJoueur; o++)
        {
            if(aListDette.get(o)==0)
            {
                vCompte+=1;
            }
            else
            {
                this.aGui.println(this.aListJoueur.get(o).getNom() + " N'a pas encore rembourser");
            }


        }

        if(vCompte==this.aNbActuelJoueur)
        {
            this.aGui.println("Tout le monde a payer ce qu'il devait");
            this.aGui.println("");

            this.aPasAssez = false;
        }
    }//rembourser()

    public void vendre(final String pNumProp, final Joueur pJoueur)
    {
        int vArgent = 0;
        int vNumProp = Integer.parseInt(pNumProp);
        Case vCase = this.aListCase.get(vNumProp);
        if(vCase.getProprietaire().equals(pJoueur))
        {
            if(vCase.getClass().equals(Rue.class))
            {
                Rue vRue = (Rue) vCase;
                vArgent += vRue.getPrixHypotheque() +(vRue.getNbMaisons() + vRue.getNbHotel()) * vRue.getPrixConstruction();
            }
            if(vCase.getClass().equals(Gare.class))
            {
                vArgent += ((Gare) vCase).getPrixHypotheque();
            }
            if(vCase.getClass().equals(Compagnie.class))
            {
                vArgent += ((Compagnie) vCase).getPrixHypotheque();
            }
        }
        vCase.setProprietaire(null);
        this.aGui.println("Vous avez vendu " + vCase.getDescription() + ".");
        pJoueur.addArgent(vArgent);
        this.actualiseArgent();
        this.aGui.println("Vous avez re??u " + vArgent + " correspondant au prix d'hypoth??que.");
        this.aGui.println("Vous pouvez peut ??tre rembourser vos dettes maintenant.");
        this.aGui.println("Exemple : 'rembourser joueur2' (Si le joueur2 a des dettes)");
        this.aGui.println("");
    }

    /**
     * Compte l'argent total d'un joueur qui doit hypoth??quer.
     * @param pJoueurFaillite
     * @return l'argent total du compte du joueur + l'argent correspondant au prix de ses propri??t??s
     */
    private int compteFaillite(Joueur pJoueurFaillite)
    {
        int vCapitalJoueur = 0;

        vCapitalJoueur+= pJoueurFaillite.getArgent();

        int vNbMaison = 0;
        int vNbHotel  = 0;

        ArrayList<Propriete> pro = pJoueurFaillite.getProprietes();

        for (Propriete vCurrentPropriete : pro){
            if(vCurrentPropriete.getClass().equals(Rue.class))
            {
                Rue vCurrentPro = (Rue)vCurrentPropriete;

                vNbMaison = vCurrentPro.getNbMaisons();
                vNbHotel = vCurrentPro.getNbHotel();

                vCapitalJoueur+= vNbMaison*vCurrentPro.getPrixConstruction() + vNbHotel*vCurrentPro.getPrixConstruction();
                vCapitalJoueur+= vCurrentPro.getPrixHypotheque();
            }
        }
        return vCapitalJoueur;
    }//compteFaillite()

    /**
     * Lib??re les biens du joueur ayant fait faillite et v??rifie si la partie se termine ou non
     * @param pJoueurFaillite
     */
    private void faillite(Joueur pJoueurFaillite)
    {
        ArrayList<Propriete> vListPropieteFaillite;

        vListPropieteFaillite = pJoueurFaillite.setFailliteJoueur();

        for(int i = 0; i < vListPropieteFaillite.size(); i++)
        {
            this.aNbTotalMaison+= getNbMaisonPlayer(pJoueurFaillite);
            this.aNbTotalHotel+= getNbHotelPlayer(pJoueurFaillite);
            vListPropieteFaillite.get(0).setProprietaire(null);
        }

        this.aGui.println(pJoueurFaillite.getNom() + " A fait faillite");

        //On teste si la partie se finit ou non
        if(this.finPartie())
        {
            this.aGui.println("Il ne reste qu'un joueur la partie est finie");
            this.quitter();
        }
    }//faillite()

    /**
     * Test si 1 seul joueur n'est pas en faillite
     * @return un bool??en qui indique si la partie se finit ou non
     */
    public boolean finPartie()
    {
        int vNbNonFaillite = 0;
        for(Joueur vJoueur : this.aListJoueur)
        {
            if(!vJoueur.getFaillite()) vNbNonFaillite += 1;
        }
        return(vNbNonFaillite==1);
    }//finPartie()



    /**
     * Phase de Test
     */

    private void test(final Command pCommand)
    {
        try
        {
            Scanner sr = new Scanner( new File( "Tests/" + pCommand.getSecondWord() + ".txt" ) );
            while( sr.hasNext() )
            {
                String vLigne = sr.nextLine();
                this.interpretCommand( getParser().getCommand(vLigne));
            }
            sr.close();
        }
        catch (final FileNotFoundException pProbl??me)
        { this.aGui.println("Le fichier n'existe pas."); }
    }//test(.)


    private void lancerTest(final String pDe1, final String pDe2)
    {
        int vDe1 = Integer.parseInt(pDe1);
        int vDe2 = Integer.parseInt(pDe2);

        if(this.aPasAssez)
        {
            this.aGui.println("Vous n'avez pas assez d'argent il faut hypothequer, vendre ou faire faillite");
            this.aGui.println("Vous ne pouvez pas passer.");
            return;
        }

        if (this.testEnchere())
        {
            return;
        }

        if (!this.aCurrentPlayerPlay && this.aPremiersLancer == 1) //v??rifie si le joueur n'a pas d??j?? lancer ses d??s dans son tour
        {
            this.aGui.println("Vous avez d??j?? lancer les d??s pour ce tour l?? !");
            this.aGui.println("");
            return;
        }


        this.aNBlancer = vDe1 +vDe2 ;
        this.aGui.println("Vous avez fait un score de "+this.aNBlancer);
        this.aGui.showImageDe(vDe1 +".jpg", vDe2 +".jpg");
        this.aCurrentPlayerPlay = false;

        if(this.aPremiersLancer == 0)
        {
            this.premierslancer(this.aNBlancer);
            return;
        }

        if (vDe1 == vDe2)
        {
            this.aCurrentPlayer.setDouble();
            this.aGui.println("Vous avez fait un double, vous pourrez rejouer !");
            if (this.aCurrentPlayer.IsPrison()==true){
                this.aCurrentPlayer.outPrison();
            }
            this.aCurrentPlayerPlay = true;
        }
        if (this.aCurrentPlayer.getDouble() == 3){
            this.aGui.println("Dommage, vous avez fait des doubles 3 fois de suite,");
            this.aGui.println("Vous allez en prison.");
            this.aGui.println("");
            this.aCurrentPlayer.goPrison();
            if(!this.aCurrentPlayer.getCarteFreePrison().isEmpty())
            {
                this.aGui.println("Vous avez une carte 'sortie de prison',");
                this.aGui.println("la carte a ??t?? utilis??, vous etes donc libre.");
                this.aGui.println("");
                this.aCurrentPlayer.outPrison();
                int vNumCarte = this.aCurrentPlayer.supCarteFreePrison();
                if(vNumCarte == 2) {this.aListChance.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 2));}
                else {this.aListCom.addLast(new Carte(0, -1, "Vous ??tes lib??r?? de prison. Cette carte peut ??tre conserv??e jusqu'?? ce qu'elle soit utilis??e ou vendue.", 6));}
            }
            else
            {
                return;
            }
        }
        this.avancer();
        this.descriptionPos();
    }//lancerTest()
}

