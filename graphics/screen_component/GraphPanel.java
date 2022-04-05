package SAE.graphics.screen_component;

import SAE.map.Carte;

import javax.swing.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    Carte carte;
    JScrollPane view=new JScrollPane();







    public JScrollPane getView() {
        return view;
    }
}
