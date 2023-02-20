package pkg_game;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pkg_case.Propriete;
import pkg_case.Gare;
import pkg_case.Compagnie;

/**
 * On décrit un joueur par l'argent qu'il possède, le pion qui le représente
 * et la liste de propriétés qu'il possède.
 */
public class Joueur
{
    private int aArgent;
    private String aNom;
    private int aPos;
    private ArrayList<Propriete> aProprietes;
    private int aDouble;
    private boolean aIsPrison;
    private int aNbTourPrison;
    private ArrayList<Integer> aCartefreePrison;
    private boolean aFaillite;
    
    /**
     * Constructeur d'objets de classe Joueur
     */
    public Joueur(final String pNom)//, final String pCouleur)
    {
        // initialisation des variables d'instance
        this.aArgent = 1500;
        this.aPos = 0;
        this.aNom = pNom;
        this.aProprietes = new ArrayList<Propriete>();
        this.aDouble=0;
        this.aIsPrison=false;
        this.aCartefreePrison= new ArrayList<Integer>();
        this.aFaillite=false;
        this.aNbTourPrison = 0;
    }

    public String getNom(){return this.aNom;}

    public int getPos() {return this.aPos;}

    public void ajoutePos(int p){
        this.aPos += p;
    }

    public void setPos(int p){
        this.aPos = p;
    }

    public int getNbTourPrison() {return this.aNbTourPrison;}

    public void setNbTourPrison(int p) {this.aNbTourPrison = p;}

    /**
     * @return l'argent qu'un joueur possède.
     */
    public int getArgent() {return this.aArgent;}
    //getArgent()


    /**
     * @return la liste des proprietes du joueur.
     */
    public ArrayList<Propriete> getProprietes()
    {
        return this.aProprietes;
    }
    //getProprietes()

    /**
     * @param pDifference Argent à prélever ou ajouter au joueur.
     */
    public void addArgent(int pDifference)
    {
        this.aArgent += pDifference;
    }
    //addArgent(.)

    /**
     * @param pPropriete Propriete à ajouter au joueur.
     */
    public void addPropriete(Propriete pPropriete)
    {
        this.aProprietes.add(pPropriete);
    }
    //addPropriete(.)

    /**
     * @param pPropriete Propriete à enlever au joueur.
     */
    public Propriete popPropriete(Propriete pPropriete)
    {
        Propriete vPropiete = pPropriete;
        this.aProprietes.remove(pPropriete);
        return vPropiete;
    }
    //addPropriete(.)


    /**
     * @return Le nombre de gare qu'un joueur possède.
     */
    public int nbGares()
    {
        int n = 0;
        for (Propriete vPropriete : this.getProprietes())
        {
            if (vPropriete instanceof Gare) {n+=1;}
        }
        return n;
    }//nbGares()

    /**
     * @return Le nombre de compagnie qu'un joueur possède.
     */
    public int nbCompagnies()
    {
        int n = 0;
        for (Propriete vPropriete : this.getProprietes())
        {
            if (vPropriete instanceof Compagnie) {n+=1;}
        }
        return n;
    }//nbGares()

    public void setDouble(){
        this.aDouble+=1;
    }

    public int getDouble(){
        return this.aDouble;
    }

    public void initDouble(){
        this.aDouble=0;
    }

    /**
     * Envoi le joueur en prison
     */
    public void goPrison(){
        this.setPos(10);
        this.aIsPrison=true;
    }

    public void outPrison(){
        this.aIsPrison=false;
    }

    public boolean IsPrison(){
        return this.aIsPrison;
    }

    public void addCarteFreePrison(final int pNum) { this.aCartefreePrison.add(pNum);}

    public int supCarteFreePrison()
    {
        int numeroCarte = this.aCartefreePrison.remove(0);
        return numeroCarte;
    }

    public ArrayList<Integer> getCarteFreePrison() { return this.aCartefreePrison;}

    public boolean getFaillite() { return this.aFaillite;}

    public void removePropriete() { this.aProprietes.remove(0);}

    public ArrayList<Propriete> setFailliteJoueur()
    {
        ArrayList<Propriete> vListPropriete = aProprietes;

        this.aArgent = -1;
        this.aFaillite = true;
        while(!aProprietes.isEmpty())
        {
            this.removePropriete();
        }

        return vListPropriete;
    }
}
