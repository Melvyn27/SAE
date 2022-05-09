package SAE.graphics;

import SAE.assets.Notification;
import SAE.map.Carte;

import javax.swing.*;

public class LoadCarte  extends JWindow {
    String Path;
    Carte carte = new Carte();
    Notification notifiable;


//fixme créer la fonction de chargement du jeu de donnée
    public LoadCarte(){




        setSize(400,300);
        setVisible(true);
    }


    public void setNotifiable(Notification notifiable){
        this.notifiable=notifiable;
    }
    public Carte getCarte() {
        return carte;
    }


    public static void main(String[] args) {
        new LoadCarte();
    }
}
