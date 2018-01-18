package Vues;

import Controller.Message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;


public class VueAventurier extends Vue {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger  ;
    private final JButton btnAssecher;
    private final JButton btnCapacite;
    private final JButton btnTerminerTour;
    private final JButton btnDeffausserCartes;
    private final JButton btninvoque;
    private final JButton btnDonnerCartes;
    private final JButton btnUtiliserCarte;
    private JTextField position;
   
   
   
    
    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur, int index){

        this.window = new JFrame();
        window.setSize(2000, 1200);
        //le titre = nom du joueur 
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        window.setResizable(false);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);


        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);

        /* =================================================================================
        // OUEST : Niveau d'autre et autre
        this.panelBoutons = new JPanel(new GridLayout(8,1));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.WEST);
*/

        // =================================================================================
        // EST : les boutons
        this.panelBoutons = new JPanel(new GridLayout(8,1));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);

        this.btnBouger = new JButton("Bouger") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnCapacite = new JButton("Utiliser sa capacité") ;
        this.btnDeffausserCartes = new JButton("Défausser une carte");
        this.btninvoque = new JButton("Invoquer un trésor");
        this.btnDonnerCartes = new JButton("Donner une carte");
        this.btnUtiliserCarte = new JButton("Utiliser une carte");
        this.btnTerminerTour = new JButton("Terminer Tour") ;

        btnBouger.setEnabled(false);
        btnAssecher.setEnabled(false);
        btnCapacite.setEnabled(false);
        btnDeffausserCartes.setEnabled(false);
        btninvoque.setEnabled(false);
        btnDonnerCartes.setEnabled(false);
        btnUtiliserCarte.setEnabled(false);
        btnTerminerTour.setEnabled(false);
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnCapacite);
        this.panelBoutons.add(btnDeffausserCartes);
        this.panelBoutons.add(btninvoque);
        this.panelBoutons.add(btnDonnerCartes);
        this.panelBoutons.add(btnUtiliserCarte);
        this.panelBoutons.add(btnTerminerTour);


        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.DEPLACER);
                clearChanged();
            }
        });

        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ASSECHER);
                clearChanged();
            }
        });
        btnCapacite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.UTILISATION_CAPACITE);
                clearChanged();
            }
        });

        btnDeffausserCartes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.DEFFAUSSER);
                clearChanged();
            }
        });

        btninvoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.INVOQUER);
                clearChanged();
            }
        });

        btnDonnerCartes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.DONNER);
                clearChanged();
            }
        });

        btnUtiliserCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.UTILISER_CARTE);
                clearChanged();
            }
        });

        btnTerminerTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.FINTOUR);
                clearChanged();
            }
        });



    }


    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnCapacite;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }

    public JButton getbtnDeffausserCartes() {
        return btnDeffausserCartes ;
    }

    public JButton getbtninvoque() {
        return btninvoque ;
    }

    public JButton getbtnDonnerCartes() {
        return btnDonnerCartes ;
    }

    public JButton getbtnUtiliserCarte() {
        return btnUtiliserCarte ;
    }


    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }
}

 

