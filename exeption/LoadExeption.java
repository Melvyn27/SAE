package SAE.exeption;

import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;

public class LoadExeption extends Exception {
    //fixme adapter les exeption a la nouvelle interface
    JFrame frame;
    public LoadExeption(ChargementParallele target) {
        JOptionPane.showMessageDialog(frame,"erreur de chargement","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public LoadExeption(ChargementParallele target,String line) {
        target.setTargetMessage("erreur de chargement a la ligne "+line);
    }
    public LoadExeption(ChargementParallele target,String line, String site) {

        target.setTargetMessage("le site "+site+" est dupliqué a la ligne "+line);
    }
}
