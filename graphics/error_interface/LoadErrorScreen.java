package SAE.graphics.error_interface;

import javax.swing.*;
import java.awt.*;

public class LoadErrorScreen extends JFrame {
    public LoadErrorScreen(){
        super("erreur de chargement");
        add(new JLabel("erreur de chargement"));
        init();
    }
    public LoadErrorScreen(String line){
        super("erreur de chargement");
        add(new JLabel("erreur de chargement a la ligne "+line));
        init();
    }
    public LoadErrorScreen(String line,String car){
        super("erreur de chargement");
        add(new JLabel("erreur de chargement a la ligne "+line+ " caractère "+car));
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
