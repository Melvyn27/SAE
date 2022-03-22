package SAE.graphics;

import SAE.graphics.screen_component.ChoixSite;
import SAE.graphics.screen_component.Log;
import SAE.graphics.screen_component.Questionnement;
import SAE.map.Site;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Screen extends JFrame implements ActionListener, ComponentListener, WindowListener {
    ArrayList<Site> sites = new ArrayList<>();

    Log log = new Log();
    ChoixSite site1=new ChoixSite();
    ChoixSite site2=new ChoixSite();
    Questionnement quest = new Questionnement();


    public Screen(){

        //TODO set la fenetre
        super("graph-Map");
        setSize(800,400);
        setLayout(null);
        setVisible(true);
        addWindowListener(this);
        addComponentListener(this);

        //todo ajout des composant
        add(site1.getView());
        add(site2.getView());
        add(log.getView());
        add(quest.getView());


        //todo set les parametre composant
        quest.link(this);
        placeComponent();



    }
    void init(){


    }

    /**
     * move component when window resize
     */
    void placeComponent(){
        int a=(int) ((getHeight()-20) * 0.70);
        int b=(int) ((getHeight()-20) * 0.30);
        int c=(int) (getWidth() * 0.33);

        site1.updateLocation(0,0,100,a);
        site2.updateLocation(100,0,100,a);
        quest.updateLocation(0,a,c,b);
        log.updateLocation(c,a,getWidth()-c+5,b);


    }



    public void mainScreen(){


    }


    public void action(String act){
        log.addLine(act+": "+site1.getChoix()+"->"+site2.getChoix());



    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }


    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {
        placeComponent();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}


/**
 * doc:
 * fait
 * - creation de deux panneaux d'affichage pour le choix des sites
 * - creation de un panneau de Log pour afficher les resultats
 * - class de questionement du graph
 * a faire:
 * - finaliser les panneaux d'affichage
 * - finaliser de questionement du graph pour la mise a jour d'action
 * - class de dessin pour afficher le graph dynamiquement
 * - creer un affichage dynamique
 */
