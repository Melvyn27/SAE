package SAE.graphics;

import SAE.assets.Notification;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JFrame implements ActionListener{
JFileChooser fileGetter = new JFileChooser();

public FileChooser(){


    setDefaultCloseOperation(3);
    add(fileGetter);

    fileGetter.resetChoosableFileFilters();
    fileGetter.addChoosableFileFilter(new FileNameExtensionFilter("fichier de sauvergarde(*.csv,*.grm)","csv","grm"));

    fileGetter.addActionListener(this);

    setVisible(true);
    setSize(400,400);


}

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand()=="CancelSelection")System.exit(0);



    }
}
