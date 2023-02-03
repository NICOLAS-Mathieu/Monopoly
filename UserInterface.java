import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
import javax.swing.JFrame;

public class UserInterface {

    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JButton    aB_De;
    private JButton    aB_help;
    private JButton    aB_carte;
    private JButton    aB_propriete1;
    private JButton    aB_propriete2;
    private JButton    aB_propriete3;
    private JButton    aB_propriete4;
    private JButton    aB_propriete5;
    private JButton    aB_propriete6;
    private JButton    aB_propriete7;
    private JButton    aB_propriete8;
    private JTextArea  aNom1;
    private JTextArea  aNom2;
    private JTextArea  aNom3;
    private JTextArea  aNom4;
    private JTextArea  aNom5;
    private JTextArea  aNom6;
    private JTextArea  aNom7;
    private JTextArea  aNom8;
    private JTextArea  aSom1;
    private JTextArea  aSom2;
    private JTextArea  aSom3;
    private JTextArea  aSom4;
    private JTextArea  aSom5;
    private JTextArea  aSom6;
    private JTextArea  aSom7;
    private JTextArea  aSom8;


    /**
     * constructeur de user Interface
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();

    } // UserInterface(.)

    /**
     * la fonction print
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * la fonction println
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * la fonction premetant de montrer une image
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "Image/" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * fonction premetant de savoir si on peux ou pas faire une action
     * @param pOnOff parametre de type boolean
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener((ActionListener)this); // won't react to entry
        }
    } // enable(.)

    public void actualisation(int numero, String somme)
    {
        if(numero==1)
        {

        }
    }

    /**
     * fonction premettant d'afficher a l'ecran
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "Monopoly" ); // change the title
        this.aEntryField = new JTextField( 34 );
        this.aB_De = new JButton ("lancer les dés");
        this.aB_help = new JButton ("help");
        this.aB_carte = new JButton ("carte");
        this.aB_propriete1 = new JButton ("propriete1");
        this.aB_propriete2 = new JButton ("propriete2");
        this.aB_propriete3 = new JButton ("propriete3");
        this.aB_propriete4 = new JButton ("propriete4");
        this.aB_propriete5 = new JButton ("propriete5");
        this.aB_propriete6 = new JButton ("propriete6");
        this.aB_propriete7 = new JButton ("propriete7");
        this.aB_propriete8 = new JButton ("propriete8");

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel_Gauche = new JPanel();
        this.aImage = new JLabel();

        JPanel vPanel_Droite = new JPanel();
        JPanel vPanel_Haut = new JPanel();
        JPanel vPanel_Centre= new JPanel();
        JPanel vPanel_Bas = new JPanel();
        JPanel vPanel_Droite2 = new JPanel();
        JPanel vPanel_Gauche2 = new JPanel();

        JPanel vPanel_Bas1= new JPanel();
        JPanel vPanel_Bas2= new JPanel();
        JPanel vPanel_Bas3= new JPanel();
        JPanel vPanel_Bas4= new JPanel();
        JPanel vPanel_Bas5= new JPanel();
        JPanel vPanel_Bas6= new JPanel();
        JPanel vPanel_Bas7= new JPanel();
        JPanel vPanel_Bas8= new JPanel();

        vPanel_Gauche.setLayout( new BorderLayout() ); // ==> only five places
        vPanel_Droite.setLayout(new BorderLayout());
        vPanel_Haut.setLayout(new BorderLayout());
        vPanel_Centre.setLayout(new BorderLayout());
        vPanel_Bas.setLayout( vGrid_Bas );
        vPanel_Droite2.setLayout(new BorderLayout());
        vPanel_Gauche2.setLayout( new BorderLayout() );

        vPanel_Bas1.setLayout(new BorderLayout());
        vPanel_Bas2.setLayout(new BorderLayout());
        vPanel_Bas3.setLayout(new BorderLayout());
        vPanel_Bas4.setLayout(new BorderLayout());
        vPanel_Bas5.setLayout(new BorderLayout());
        vPanel_Bas6.setLayout(new BorderLayout());
        vPanel_Bas7.setLayout(new BorderLayout());
        vPanel_Bas8.setLayout(new BorderLayout());

        vPanel_Gauche.add( this.aImage, BorderLayout.WEST );
        vPanel_Gauche.add( vPanel_Droite, BorderLayout.EAST );

        vPanel_Droite.add( vPanel_Haut, BorderLayout.NORTH);
        vPanel_Droite.add( vPanel_Centre, BorderLayout.CENTER);
        vPanel_Droite.add( vPanel_Bas, BorderLayout.SOUTH);

        vPanel_Centre.add(this.aEntryField, BorderLayout.WEST);
        vPanel_Centre.add( vListScroller, BorderLayout.EAST );

        vPanel_Haut.add( vPanel_Gauche2, BorderLayout.WEST);
        vPanel_Haut.add( vPanel_Droite2, BorderLayout.EAST);

        vPanel_Droite2.add( this.aB_De, BorderLayout.NORTH );

        vPanel_Gauche2.add( this.aB_help, BorderLayout.WEST);
        vPanel_Gauche2.add( this.aB_carte, BorderLayout.EAST);

        vPanel_Bas1.add( this.aNom1, BorderLayout.NORTH);
        vPanel_Bas2.add( this.aNom2, BorderLayout.NORTH);
        vPanel_Bas3.add( this.aNom3, BorderLayout.NORTH);
        vPanel_Bas4.add( this.aNom4, BorderLayout.NORTH);
        vPanel_Bas5.add( this.aNom5, BorderLayout.NORTH);
        vPanel_Bas6.add( this.aNom6, BorderLayout.NORTH);
        vPanel_Bas7.add( this.aNom7, BorderLayout.NORTH);
        vPanel_Bas8.add( this.aNom8, BorderLayout.NORTH);
        vPanel_Bas1.add( this.aSom1, BorderLayout.CENTER);
        vPanel_Bas2.add( this.aSom2, BorderLayout.CENTER);
        vPanel_Bas3.add( this.aSom3, BorderLayout.CENTER);
        vPanel_Bas4.add( this.aSom4, BorderLayout.CENTER);
        vPanel_Bas5.add( this.aSom5, BorderLayout.CENTER);
        vPanel_Bas6.add( this.aSom6, BorderLayout.CENTER);
        vPanel_Bas7.add( this.aSom7, BorderLayout.CENTER);
        vPanel_Bas8.add( this.aSom8, BorderLayout.CENTER);
        vPanel_Bas1.add( this.aB_propriete1, BorderLayout.SOUTH);
        vPanel_Bas2.add( this.aB_propriete2, BorderLayout.SOUTH);
        vPanel_Bas3.add( this.aB_propriete3, BorderLayout.SOUTH);
        vPanel_Bas4.add( this.aB_propriete4, BorderLayout.SOUTH);
        vPanel_Bas5.add( this.aB_propriete5, BorderLayout.SOUTH);
        vPanel_Bas6.add( this.aB_propriete6, BorderLayout.SOUTH);
        vPanel_Bas7.add( this.aB_propriete7, BorderLayout.SOUTH);
        vPanel_Bas8.add( this.aB_propriete8, BorderLayout.SOUTH);





        this.aMyFrame.getContentPane().add( vPanel_Gauche, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener(this );
        this.aB_De.addActionListener( this );

        // to end program when window is closed
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * fonction faisant fonctionner le bouton
     */
    public void actionPerformed( final ActionEvent pE )
    {
        Object vObjet = pE.getSource();

        if (vObjet == aB_De)
        {
            this.aEngine.processCommand("Lancer dés");
        }
        if (vObjet == aB_carte)
        {
            this.aEngine.processCommand("carte");
        }
        if (vObjet == aB_help)
        {
            this.aEngine.processCommand("help");
        }
        if (vObjet == aB_propriete1)
        {
            this.aEngine.processCommand("Propriete 1");
        }
        if (vObjet == aB_propriete2)
        {
            this.aEngine.processCommand("Propriete 2");
        }
        if (vObjet == aB_propriete3)
        {
            this.aEngine.processCommand("Propriete 3");
        }
        if (vObjet == aB_propriete4)
        {
            this.aEngine.processCommand("Propriete 4");
        }
        if (vObjet == aB_propriete5)
        {
            this.aEngine.processCommand("Propriete 5");
        }
        if (vObjet == aB_propriete6)
        {
            this.aEngine.processCommand("Propriete 6");
        }
        if (vObjet == aB_propriete7)
        {
            this.aEngine.processCommand("Propriete 7");
        }
        if (vObjet == aB_propriete8)
        {
            this.aEngine.processCommand("Propriete 8");
        }

        this.processCommand(); // never suppress this line

    } // actionPerformed(.)


    /**
     * la fonction processCommand
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.processCommand( vInput );
    } // processCommand()


}