import java.util.ArrayList;

/**
 * Décrivez votre classe Joueur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Joueur
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aArgent;
    private Pion aPion;
    private ArrayList aProprietes;
    
    /**
     * Constructeur d'objets de classe Joueur
     */
    public Joueur()
    {
        // initialisation des variables d'instance
        int aArgent = 150000;
        Pion aPion = new Pion();
        ArrayList aProprietes = new ArrayList();
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @return     la somme de x et de y
     */
    public int getArgent()
    {
        // Insérez votre code ici
        return this.aArgent;
    }
    
    public Pion getPion()
    {
        return this.aPion;
    }
    
    public ArrayList getProprietes()
    {
        return this.aProprietes;
    }
    
    public void addArgent(int pDifference)
    {
        this.aArgent += pDifference;
    }
    
    public void addPropriete(Carte pPropriete)
    {
        this.aProprietes.add(pPropriete);
    }
}
