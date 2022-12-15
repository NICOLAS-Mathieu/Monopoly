import java.util.ArrayList;

/**
 * Décrivez votre classe Plateau ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Plateau
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList aListeCases;
    private int aArgentCentral;
    
    /**
     * Constructeur d'objets de classe Plateau
     */
    public Plateau()
    {
        // initialisation des variables d'instance
        this.aListeCases = new ArrayList();
        this.aArgentCentral = 0;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     argent central
     */
    public int getArgentCentral()
    {
        // Insérez votre code ici
        return this.aArgentCentral;
    }
    
    public ArrayList getListeCases()
    {
        return this.aListeCases;
    }
    
    public void addArgentCentral(int pArgent)
    {
        this.aArgentCentral += pArgent;
    }
    
    public void enleveArgentCentral()
    {
        this.aArgentCentral = 0;
    }
}
