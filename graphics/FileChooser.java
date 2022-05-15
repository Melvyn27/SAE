package SAE.graphics;

import SAE.graphics.motors.LoadCarteMotor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooser extends JFrame implements ActionListener{
JFileChooser fileGetter = new JFileChooser();

public FileChooser(){


    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(fileGetter);

    fileGetter.resetChoosableFileFilters();
    //fileGetter.setAcceptAllFileFilterUsed(false);//fixme: a mettre a la fin des test
    fileGetter.addChoosableFileFilter(new FileNameExtensionFilter("fichier de sauvergarde(*.csv)","csv"));


    fileGetter.addActionListener(this);

    setLocationRelativeTo(null);
    setSize(400,400);
    setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand()=="CancelSelection")System.exit(0);


        dispose();
        new LoadCarteMotor(fileGetter.getSelectedFile().getAbsolutePath());

    }
}
