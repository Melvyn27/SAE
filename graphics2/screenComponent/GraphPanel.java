package SAE.graphics2.screenComponent;

import SAE.graphics.screen_component.DisplayStyle;
import SAE.map.Carte;

import javax.swing.*;

import java.awt.*;

import static SAE.graphics.screen_component.DisplayStyle.All;

public class GraphPanel extends JPanel {
    Carte carte;
    JScrollPane view=new JScrollPane();
    DisplayStyle style = All;
    //todo créer les fonctions de dessin
    //todo créer plusieur style d'affichage
    public GraphPanel(){
        setBackground(Color.red);

    }




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
