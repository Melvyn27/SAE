package SAE.exeption;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;
import java.awt.*;

public class VerificationExeption extends Exception{
    //fixme adapter les exeption a la nouvelle interface
    JFrame frame;
    public VerificationExeption(FileLoaderPanel target){
        JOptionPane.showMessageDialog(frame,"fichier incomplet","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public VerificationExeption(FileLoaderPanel target, String site){
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("le site "+site+" est introuvable");
    }
    public VerificationExeption(FileLoaderPanel target,String site1,String site2){
        JOptionPane.showMessageDialog(frame,"la route reliant le site "+site1+" au site "+site2+" est incomplete","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
}
