package SAE.exeption;

import SAE.graphics2.threadedMotors.ChargementParallele;

import javax.swing.*;

public class VerificationExeption extends Exception{
    //fixme adapter les exeption a la nouvelle interface
    JFrame frame;
    public VerificationExeption(ChargementParallele target){
        JOptionPane.showMessageDialog(frame,"fichier incomplet","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public VerificationExeption(ChargementParallele target, String site){
        target.setTargetMessage("le site "+site+" est introuvable");
    }
    public VerificationExeption(ChargementParallele target,String site1,String site2){
        JOptionPane.showMessageDialog(frame,"la route reliant le site "+site1+" au site "+site2+" est incomplete","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
}
