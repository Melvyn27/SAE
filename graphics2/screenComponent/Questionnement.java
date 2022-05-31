package SAE.graphics2.screenComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.screenComponent.questionComponent.ListerLesSite;
import SAE.graphics2.screenComponent.questionComponent.VoisinDePanel;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

/**
 *  /!\ le premier composant n'a pas 0 comme action
 */
public class Questionnement extends JTabbedPane {
//todo: reformer la jpanel en JTabPane

Screen screen;

VoisinDePanel voisin;


    public Questionnement(Screen screen){
        this.screen=screen;
        voisin = new VoisinDePanel(screen);


        addTab("voisin",voisin);
        addTab("lister",new ListerLesSite(screen));
        addTab("encore un test",new JPanel());
        addTab("fun",new JPanel());




    }

    public void updateChoix(ArrayList<Site> s){
        voisin.updateChoix(s);
        /*
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
        siteComboBoxModel2.resetChoix();
        siteComboBoxModel2.addChoix(s);
         */

    }
}
