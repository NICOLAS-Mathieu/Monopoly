import java.util.ArrayList;
import java.util.Arrays;

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
        //Vert
        //Bleu foncé
    }//createProprietes()

    public void processCommand( final String pCommandLine )
    {

    }
}

