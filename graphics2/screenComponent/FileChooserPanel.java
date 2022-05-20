package SAE.graphics2.screenComponent;

import javax.swing.*;
import java.awt.*;

public class FileChooserPanel extends JPanel {
    //todo faire l'affichage et la gestion parallèle
    JFileChooser fileChooser = new JFileChooser();
    JProgressBar loadSiteBar = new JProgressBar();
    JProgressBar loatDestBar = new JProgressBar();
    public FileChooserPanel(){




    }
    private void init(){

        fileChooser.setControlButtonsAreShown(false);
        add(fileChooser, BorderLayout.CENTER);





    }




}
