package SAE.exeption;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;
import java.awt.*;


/**
 * la classe LoadExeption affiche un message d'erreur lors du chargement
 */
public class LoadExeption extends Exception {
    JFrame frame;
    public LoadExeption(FileLoaderPanel target,String message) {
        target.information.setForeground(new Color(255,0,0));
        target.information.setText(message);
    }
    public LoadExeption(FileLoaderPanel target,int line) {
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("erreur de chargement a la ligne "+line);
    }
    public LoadExeption(FileLoaderPanel target,String line, String site) {
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("le site "+site+" est dupliqué a la ligne "+line);
    }
}
