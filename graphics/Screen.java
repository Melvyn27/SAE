package SAE.graphics;

import SAE.graphics.screen_component.ChoixSite;
import SAE.graphics.screen_component.Log;
import SAE.map.Site;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Screen extends JFrame implements ActionListener{
    ArrayList<Site> sites = new ArrayList<>();
    int SelectedSite1;
    Log log = new Log(0,0,100,100);
    ChoixSite site1=new ChoixSite(0,100,100,100);



    public Screen(){

        //TODO creation de la fenetre
        super("graph-Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,400);
        setLayout(null);
        //todo ajout des composant
        add(site1.getView());
        //add(log.getView());
        //for(int i=0;i<200;i++)log.addLine("test");


        //TODO afficher la fenetre
        setVisible(true);
    }

    public void mainScreen(){


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}


/**
 * doc:
 * fait
 * - creation de deux panneaux d'affichage pour le choix des sites
 * - creation de un panneau de Log pour afficher les resultats
 *
 * a faire:
 * - finaliser les panneaux d'affichage
 * - class de questionement du graph
 * - class de dessin pour afficher le graph dynamiquement
 * - creer un affichage dynamique avce un WindowsListener
 */
