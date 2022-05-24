package SAE.graphics.screen_component;

import SAE.graphics2.format.DisplayStyle;
import SAE.map.Carte;

import javax.swing.*;

import static SAE.graphics2.format.DisplayStyle.*;

public class GraphPanel extends JPanel {
    Carte carte;
    JScrollPane view=new JScrollPane();
    DisplayStyle style = All;
    //todo créer les fonctions de dessin
    //todo créer plusieur style d'affichage





    public void draw(){

    }
    private void drawAll(){

    }
    private void drawReduce(){


    }






    public JScrollPane getView() {
        return view;
    }
}
