package SAE.exeption;

import javax.swing.*;

public class LoadExeption extends Exception {
    JFrame frame;
    public LoadExeption() {
        JOptionPane.showMessageDialog(frame,"erreur de chargement","erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public LoadExeption(String line) {
        JOptionPane.showMessageDialog(frame,"erreur de chargement a la ligne "+line,"erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }
    public LoadExeption(String line, String car) {
        JOptionPane.showMessageDialog(frame,"erreur de chargement a la ligne "+line+ " caractère "+car,"erreur de chargement",JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new LoadExeption();
    }
}
