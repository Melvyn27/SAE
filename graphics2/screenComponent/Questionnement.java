package SAE.graphics2.screenComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.screenComponent.questionComponent.ListerLesSitePanel;
import SAE.graphics2.screenComponent.questionComponent.PathPanel;
import SAE.graphics2.screenComponent.questionComponent.VoisinDePanel;
import SAE.graphics2.screenComponent.questionComponent.VoisinProchePanel;
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

    public Questionnement(Screen screen){
        this.screen=screen;
        voisin = new VoisinDePanel(screen);
        voisinProche = new VoisinProchePanel(screen);

        addTab("voisin",voisin);
        addTab("lister",new ListerLesSitePanel(screen));
        addTab("chemin",new PathPanel(screen));
        addTab("voisin a deux",voisinProche);




    }

    public void updateChoix(ArrayList<Site> s){
        voisin.updateChoix(s);
        voisinProche.updateChoix(s);


    }
}
