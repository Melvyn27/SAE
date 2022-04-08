package SAE.graphics;

import SAE.assets.Notification;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser implements ActionListener {
JFileChooser fileGetter = new JFileChooser();
JFrame chooseFrame = new JFrame();
    Notification notifiable;

public FileChooser(){
    chooseFrame.setVisible(true);
    chooseFrame.setSize(200,200);
    chooseFrame.add(fileGetter);
    fileGetter.addActionListener(this);
    chooseFrame.setDefaultCloseOperation(3);
    fileGetter.setCurrentDirectory(new File("/"));

}
    public void setNotifiable(Notification notifiable){
        this.notifiable=notifiable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);

        if(notifiable!=null)notifiable.newNotification(0,fileGetter.getSelectedFile().getAbsolutePath().toString());

        chooseFrame.dispose();
    }
}
