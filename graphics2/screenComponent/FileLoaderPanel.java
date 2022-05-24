package SAE.graphics2.screenComponent;

import SAE.graphics2.threadedMotors.ChargementParallele;
import SAE.graphics2.Screen;
import SAE.map.Carte;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class FileLoaderPanel extends JPanel {
    Screen screen;

    ChargementParallele chargement;
    public JLabel information = new JLabel();

    JFileChooser fileChooser = new JFileChooser();
    public JProgressBar loadSiteBar = new JProgressBar();
    public JProgressBar loadDestBar = new JProgressBar();
    public FileLoaderPanel(Screen target){
        this.screen = target;
        init();
    }
    private void init(){
        this.setLayout(new BorderLayout());
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("fichier de sauvergarde(.csv,.txt)","csv","txt"));
        fileChooser.setControlButtonsAreShown(false);
        fileChooser.setMultiSelectionEnabled(false);
        add(fileChooser, BorderLayout.CENTER);

        loadSiteBar.setForeground(Color.BLUE);
        loadDestBar.setForeground(Color.green);
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p0.setBorder(new LineBorder(new Color(100,100,100)));
        p0.setLayout(new BorderLayout());


        JButton loadButton = new JButton("charger");
        loadButton.addActionListener(s->{
            if(fileChooser.getSelectedFile()!=null || chargement==null) {//filtre de lancement
                chargement = new ChargementParallele(getScreen(), fileChooser.getSelectedFile());//creation de l'objet
            }
        });

        JButton cancelButton = new JButton("annuler");
        cancelButton.addActionListener(c->{
            if(chargement!=null && chargement.isRunning()){//filtre d'arret
                chargement.arreter();
                chargement=null;//destruction de l'objet
            }
        });


        p1.setLayout(new GridLayout(2,1,0,5));

        p1.add(loadButton);
        p1.add(cancelButton);


        p2.setLayout(new GridLayout(3,1,0,5));

        p2.add(loadSiteBar);
        p2.add(loadDestBar);
        p2.add(information);
        p0.add(p2,BorderLayout.CENTER);
        p0.add(p1,BorderLayout.EAST);

        this.add(p0,BorderLayout.SOUTH);




    }

    public void confirmeCarte(Carte newCarte){
        screen.setCarte(newCarte);
        screen.update();
    }
    public Screen getScreen(){
        return screen;
    }








}
