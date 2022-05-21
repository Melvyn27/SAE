package SAE.graphics2.screenComponent;

import SAE.actionEvent.ChargementParallele;
import SAE.graphics2.Screen;
import SAE.map.Carte;

import javax.security.auth.Destroyable;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FileLoaderPanel extends JPanel {
    //todo faire l'affichage et la gestion parallèle
    Screen target;

    ChargementParallele chargement;
    public JLabel information = new JLabel();

    JFileChooser fileChooser = new JFileChooser();
    public JProgressBar loadSiteBar = new JProgressBar();
    public JProgressBar loatDestBar = new JProgressBar();
    public FileLoaderPanel(Screen target){
        this.target = target;
        init();
    }
    private void init(){
        this.setLayout(new BorderLayout());

        fileChooser.setControlButtonsAreShown(false);
        fileChooser.setMultiSelectionEnabled(false);
        add(fileChooser, BorderLayout.CENTER);
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p0.setBorder(new LineBorder(new Color(100,100,100)));
        p0.setLayout(new BorderLayout());


        JButton loadButton = new JButton("charger");
        loadButton.addActionListener(s->{
            if(fileChooser.getSelectedFile()==null)return;
            chargement=new ChargementParallele(this,fileChooser.getSelectedFile());//creation de l'objet
            chargement.start();//demarage de l'objet
        });

        JButton cancelButton = new JButton("annuler");
        cancelButton.addActionListener(c->{
            if(chargement!=null && chargement.isRunning()){
                chargement.arreter();
                chargement=null;//destruction de l'objet
            }
        });


        p1.setLayout(new GridLayout(2,1,0,5));

        p1.add(loadButton);
        p1.add(cancelButton);


        p2.setLayout(new GridLayout(3,1,0,5));

        p2.add(loadSiteBar);
        p2.add(loatDestBar);
        p2.add(information);
        p0.add(p2,BorderLayout.CENTER);
        p0.add(p1,BorderLayout.EAST);

        this.add(p0,BorderLayout.SOUTH);

    }

    public void confirmeCarte(Carte newCarte){
        target.setCarte(newCarte);
    }









}
