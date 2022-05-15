package SAE.graphics.screen_component;

import SAE.map.Carte;

import javax.swing.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    Carte carte;
    JScrollPane view=new JScrollPane();
    //todo créer les fonctions de dessin
    //todo créer plusieur style d'affichage




    public JScrollPane getView() {
        return view;
    }
}
