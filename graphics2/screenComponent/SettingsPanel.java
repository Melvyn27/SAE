package SAE.graphics2.screenComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;

import javax.swing.*;

public class SettingsPanel extends JPanel {
    Screen screen;

    public SettingsPanel(Screen screen){
        this.screen=screen;
        init();
    }

    void init(){
        JComboBox<LogFormat> choosFormat= new JComboBox<>();
        choosFormat.addItem(LogFormat.simple);
        choosFormat.addItem(LogFormat.none);
        choosFormat.addItem(LogFormat.all);
        choosFormat.addActionListener(l->screen.getLog().setFormat((LogFormat)choosFormat.getSelectedItem()));
        choosFormat.setToolTipText("/!\\ 'all' peut poser des problème d'affichage");
        add(choosFormat);



    }






}
