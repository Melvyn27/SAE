package SAE.graphics.screen_component;

import SAE.map.Carte;

import javax.swing.*;
import java.util.ArrayList;
import static SAE.graphics.screen_component.DisplayStyle.*;

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
