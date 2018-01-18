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
    private final JButton btnRecupTre;
    private final JButton btnTerminerTour;
    private final JButton btnUtiliserCarte;
    private final JButton btnEchangeCarte;
    private JTextField position;
   
   
   
    
    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur, int index){

        this.window = new JFrame();
        window.setSize(350, 200);
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


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,3));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnRecupTre = new JButton("Reuperer Trésor") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        this.btnUtiliserCarte = new JButton("Utliser Carte");
        this.btnEchangeCarte = new JButton("Echange Carte");

        btnBouger.setEnabled(false);
        btnAssecher.setEnabled(false);
        btnRecupTre.setEnabled(false);
        btnTerminerTour.setEnabled(false);
        btnUtiliserCarte.setEnabled(false);
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnRecupTre);
        this.panelBoutons.add(btnUtiliserCarte);
        this.panelBoutons.add(btnEchangeCarte);
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
        
        btnRecupTre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.RECUPTRE);
                clearChanged();
            }
        });
        
        btnUtiliserCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.UTILISECARTE);
                clearChanged();
            }
        });
        
        btnEchangeCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ECHANGECARTE);
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

    public JButton getBtnRecupTre() {
        return btnRecupTre;
    }

    public JButton getBtnUtiliserCarte() {
        return btnUtiliserCarte;
    }

    public JButton getBtnEchangeCarte() {
        return btnEchangeCarte;
    }
    
    


    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }
}

 

