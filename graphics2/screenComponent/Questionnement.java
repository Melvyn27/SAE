package SAE.graphics2.screenComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.screenComponent.questionComponent.*;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

/**
 *  /!\ le premier composant n'a pas 0 comme action
 */
public class Questionnement extends JTabbedPane {

Screen screen;

VoisinDePanel voisin;
VoisinProchePanel voisinProche;
ComparePanel comparePanel ;

    public Questionnement(Screen screen){
        this.screen=screen;
        voisin = new VoisinDePanel(screen);
        voisinProche = new VoisinProchePanel(screen);
        comparePanel = new ComparePanel(screen);

        addTab("voisin",voisin);
        addTab("lister",new ListerLesSitePanel(screen));
        //addTab("chemin",new PathPanel(screen));
        addTab("voisin a deux",voisinProche);
        addTab("comparer",comparePanel);




    }

    public void updateChoix(ArrayList<Site> s){
        voisin.updateChoix(s);
        voisinProche.updateChoix(s);
        comparePanel.updateChoix(s);

    }
}
