import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class UserInterface implements ActionListener
{
    public final UserInterface USER_INTERFACE = this;
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private JLabel     aImageDe1;
    private JLabel     aImageDe2;
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
    private JTextArea  aNbDe;
    private JTextArea  aJoueur;


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
        String vImagePath = "Images/" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    public void showImageDe( final String pImageName1, final String pImageName2 )
    {
        String vImagePath1 = "Images/" + pImageName1; // to change the directory
        String vImagePath2 = "Images/" + pImageName2;
        URL vImageURL1 = this.getClass().getClassLoader().getResource( vImagePath1 );
        if ( vImageURL1 == null )
            System.out.println( "Image not found : " + vImagePath1 );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL1 );
            this.aImageDe1.setIcon( vIcon );
            this.aMyFrame.pack();
        }
        URL vImageURL2 = this.getClass().getClassLoader().getResource( vImagePath2 );
        if ( vImageURL2 == null )
            System.out.println( "Image not found : " + vImagePath2 );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL2 );
            this.aImageDe2.setIcon( vIcon );
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
        this.aNom1 = new JTextArea("Joueur1");
        this.aNom2 = new JTextArea("Joueur2");
        this.aNom3 = new JTextArea("Joueur3");
        this.aNom4 = new JTextArea("Joueur4");
        this.aNom5 = new JTextArea("Joueur5");
        this.aNom6 = new JTextArea("Joueur6");
        this.aNom7 = new JTextArea("Joueur7");
        this.aNom8 = new JTextArea("Joueur8");
        this.aSom1 = new JTextArea("150000");
        this.aSom2 = new JTextArea("150000");
        this.aSom3 = new JTextArea("150000");
        this.aSom4 = new JTextArea("150000");
        this.aSom5 = new JTextArea("150000");
        this.aSom6 = new JTextArea("150000");
        this.aSom7 = new JTextArea("150000");
        this.aSom8 = new JTextArea("150000");
        this.aNbDe = new JTextArea("0");
        this.aJoueur = new JTextArea("Joueur1");

        this.aNom1.setBackground(Color.PINK);
        this.aNom2.setBackground(Color.BLUE);
        this.aNom3.setBackground(Color.RED);
        this.aNom4.setBackground(Color.GREEN);
        this.aNom5.setBackground(Color.CYAN);
        this.aNom6.setBackground(Color.ORANGE);
        this.aNom7.setBackground(Color.MAGENTA);
        this.aNom8.setBackground(Color.LIGHT_GRAY);

        this.aNom1.setText("Joueur1");
        this.aNom2.setText("Joueur2");
        this.aNom3.setText("Joueur3");
        this.aNom4.setText("Joueur4");
        this.aNom5.setText("Joueur5");
        this.aNom6.setText("Joueur6");
        this.aNom7.setText("Joueur7");
        this.aNom8.setText("Joueur8");
        this.aSom1.setText("getArgent(1)");
        this.aSom2.setText("getArgent(2)");
        this.aSom3.setText("getArgent(3)");
        this.aSom4.setText("getArgent(4)");
        this.aSom5.setText("getArgent(5)"); //creer les fonctions pour recuperer l'argent des joueurs
        this.aSom6.setText("getArgent(6)");
        this.aSom7.setText("getArgent(7)");
        this.aSom8.setText("getArgent(8)");
        this.aNbDe.setText(this.aEngine.getLancer()+""); //creer les fonctions pour recuperer le nb realiser par les dé
        this.aJoueur.setText("getJoueur()"); //creer fonction qui dit quel joueur joue

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 350) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel_Gauche = new JPanel();
        this.aImage = new JLabel();
        this.aImageDe1 = new JLabel();
        this.aImageDe2 = new JLabel();

        JPanel vPanel_Droite = new JPanel();
        JPanel vPanel_Haut = new JPanel();
        JPanel vPanel_Centre= new JPanel();
        GridLayout vGrid_Bas = new GridLayout(2,4);
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

        JPanel vPanel_BasHaut= new JPanel();

        vPanel_Gauche.setLayout( new BorderLayout() );
        vPanel_Droite.setLayout(new BorderLayout());
        vPanel_Haut.setLayout(new BorderLayout());
        vPanel_Centre.setLayout(new BorderLayout());
        vPanel_Bas.setLayout( vGrid_Bas );
        vPanel_Droite2.setLayout(new BorderLayout());
        vPanel_Gauche2.setLayout( new BorderLayout() );

        vPanel_Bas.add(vPanel_Bas1);
        vPanel_Bas.add(vPanel_Bas2);
        vPanel_Bas.add(vPanel_Bas3);
        vPanel_Bas.add(vPanel_Bas4);
        vPanel_Bas.add(vPanel_Bas5);
        vPanel_Bas.add(vPanel_Bas6);
        vPanel_Bas.add(vPanel_Bas7);
        vPanel_Bas.add(vPanel_Bas8);

        vPanel_Bas1.setLayout(new BorderLayout());
        vPanel_Bas2.setLayout(new BorderLayout());
        vPanel_Bas3.setLayout(new BorderLayout());
        vPanel_Bas4.setLayout(new BorderLayout());
        vPanel_Bas5.setLayout(new BorderLayout());
        vPanel_Bas6.setLayout(new BorderLayout());
        vPanel_Bas7.setLayout(new BorderLayout());
        vPanel_Bas8.setLayout(new BorderLayout());

        vPanel_BasHaut.setLayout(new BorderLayout());

        vPanel_Gauche.add( this.aImage, BorderLayout.WEST );
        vPanel_Gauche.add( vPanel_Droite, BorderLayout.EAST );

        vPanel_Droite.add( vPanel_Haut, BorderLayout.NORTH);
        vPanel_Droite.add( vPanel_Centre, BorderLayout.CENTER);
        vPanel_Droite.add( vPanel_Bas, BorderLayout.SOUTH);

        vPanel_Centre.add(this.aEntryField, BorderLayout.SOUTH);
        vPanel_Centre.add( vListScroller, BorderLayout.NORTH );

        vPanel_Haut.add( vPanel_Gauche2, BorderLayout.WEST);
        vPanel_Haut.add( vPanel_Droite2, BorderLayout.EAST);

        vPanel_Droite2.add( this.aB_De, BorderLayout.NORTH );
        vPanel_Droite2.add( this.aNbDe, BorderLayout.CENTER);
        vPanel_Droite2.add( vPanel_BasHaut, BorderLayout.SOUTH);
        vPanel_BasHaut.add( this.aImageDe1, BorderLayout.WEST);
        vPanel_BasHaut.add( this.aImageDe2, BorderLayout.EAST);

        vPanel_Gauche2.add( this.aB_help, BorderLayout.WEST);
        vPanel_Gauche2.add( this.aB_carte, BorderLayout.EAST);
        vPanel_Gauche2.add( this.aJoueur, BorderLayout.NORTH);

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
        this.aEntryField.addActionListener((ActionListener) this);
        this.aB_De.addActionListener((ActionListener) this);
        this.aB_help.addActionListener((ActionListener) this);
        this.aB_carte.addActionListener((ActionListener) this);
        this.aB_propriete1.addActionListener((ActionListener) this);
        this.aB_propriete2.addActionListener((ActionListener) this);
        this.aB_propriete3.addActionListener((ActionListener) this);
        this.aB_propriete4.addActionListener((ActionListener) this);
        this.aB_propriete5.addActionListener((ActionListener) this);
        this.aB_propriete6.addActionListener((ActionListener) this);
        this.aB_propriete7.addActionListener((ActionListener) this);
        this.aB_propriete8.addActionListener((ActionListener) this);

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
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("lancer"));
            this.aNbDe.setText(this.aEngine.getLancer()+"");
        }
        else if (vObjet == aB_carte)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("carte"));
        }
        else if (vObjet == aB_help)
        {
            this.aEngine.interpretCommand(USER_INTERFACE.aEngine.getParser().getCommand("help"));
        }
        else if (vObjet == aB_propriete1)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete1"));
        }
        else if (vObjet == aB_propriete2)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete2"));
        }
        else if (vObjet == aB_propriete3)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete3"));
        }
        else if (vObjet == aB_propriete4)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete4"));
        }
        else if (vObjet == aB_propriete5)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete5"));
        }
        if (vObjet == aB_propriete6)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete6"));
        }
        if (vObjet == aB_propriete7)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete7"));
        }
        if (vObjet == aB_propriete8)
        {
            this.aEngine.interpretCommand(this.aEngine.getParser().getCommand("propriete8"));
        }

        this.processCommand(); // never suppress this line

    } // actionPerformed(.)


    /**
     * Une commande a été entrée. Lis la commande et fait ce qui est
     * nécessaire pour la traiter
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand(this.aEngine.getParser().getCommand( vInput ));
    } // processCommand()

    public String getInput()
    {
        return this.aEntryField.getText();
    }//getInput()

}