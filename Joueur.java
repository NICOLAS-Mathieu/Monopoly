import java.util.ArrayList;

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
    private int aIsPrison;
    
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
        this.aIsPrison=0;
    }

    public String getNom(){return this.aNom;}

    public int getPos() {return this.aPos;}

    public void ajoutePos(int p){
        this.aPos += p;
    }

    public void setPos(int p){
        this.aPos = p;
    }

    /**
     * @return l'argent qu'un joueur possède.
     */
    public int getArgent() {return this.aArgent;}
    //getArgent()


    /**
     * @return le pion qui représente le joueur.
     */
    //public Pion getPion(){return this.aPion;}
    //getPion()

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

    public void goPrison(){
        this.aIsPrison=1;
    }

    public void outPrison(){
        this.aIsPrison=0;
    }

    public int IsPrison(){
        return this.aIsPrison;
    }
}
