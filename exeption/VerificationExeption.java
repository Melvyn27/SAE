package SAE.exeption;

import javax.swing.*;

public class VerificationExeption extends Exception{
    JFrame frame;
    public VerificationExeption(){
        JOptionPane.showMessageDialog(frame,"fichier incomplet","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public VerificationExeption(String site){
        JOptionPane.showMessageDialog(frame,"le site "+site+" est introuvable","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public VerificationExeption(String site1,String site2){
        JOptionPane.showMessageDialog(frame,"la route reliant le site "+site1+" au site "+site2+" est incomplete","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
}
