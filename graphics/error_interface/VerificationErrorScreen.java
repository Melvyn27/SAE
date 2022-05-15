package SAE.graphics.error_interface;

import SAE.exeption.VerificationExeption;

import javax.swing.*;
import java.awt.*;

public class VerificationErrorScreen extends JFrame {

    public VerificationErrorScreen(){
        super("erreur de chargement");
        add(new JLabel("fichier incomplet"));
        init();
    }

    /**
     * @param site
     */
    public VerificationErrorScreen(String site){
        super("erreur de chargement");
        add(new JLabel("le site "+site+" est introuvable"));
        init();
    }
    public VerificationErrorScreen(String site1,String site2){
        super("erreur de chargement");
        add(new JLabel("la route reliant le site "+site1+" au site "+site2+" est incomplete"));
        init();
    }



    void init(){
        setLayout(new FlowLayout());

        JButton b = new JButton("ok");
        b.addActionListener(l->{System.exit(0);});
        add(b);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();//setSize(300,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
