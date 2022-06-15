package SAE.exeption;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;
import java.awt.*;

/**
 * la classe LoadExeption affiche un message d'erreur lors de la verification du jeu de donnée
 */
public class VerificationExeption extends Exception{
    JFrame frame;

    public VerificationExeption(FileLoaderPanel target, String site){
        target.information.setForeground(new Color(255,0,0));
        target.information.setText("le site "+site+" est introuvable");
    }
}
