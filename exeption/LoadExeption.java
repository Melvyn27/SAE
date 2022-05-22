package SAE.exeption;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;
import java.awt.*;

public class LoadExeption extends Exception {
    //fixme adapter les exeption a la nouvelle interface
    JFrame frame;
    public LoadExeption(FileLoaderPanel target) {
        JOptionPane.showMessageDialog(frame,"erreur de chargement","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public LoadExeption(FileLoaderPanel target,String line) {
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("erreur de chargement a la ligne "+line);
    }
    public LoadExeption(FileLoaderPanel target,String line, String site) {
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("le site "+site+" est dupliqué a la ligne "+line);
    }
}
