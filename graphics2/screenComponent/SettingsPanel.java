package SAE.graphics2.screenComponent;

import SAE.graphics2.format.DisplayStyle;
import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    Screen screen;

    JPanel global = new JPanel(new GridLayout(0,2,10,10));

    public SettingsPanel(Screen screen){
        this.screen=screen;
        this.setLayout(new FlowLayout());
        init();
    }

    void init(){


        JComboBox<LogFormat> choosFormat= new JComboBox<>();
        {
            for(int i=0;i<LogFormat.values().length;i++)choosFormat.addItem(LogFormat.values()[i]);
            choosFormat.addActionListener(l -> screen.getLog().setFormat((LogFormat) choosFormat.getSelectedItem()));
            choosFormat.setToolTipText("/!\\ 'all' peut poser des problème d'affichage");
        }
        addSettings("format d'affichage des resultat",choosFormat);

        JComboBox<DisplayStyle> graphStyle = new JComboBox<>();
        {
            for(int i=0;i<DisplayStyle.values().length;i++)graphStyle.addItem(DisplayStyle.values()[i]);
            graphStyle.addActionListener(l->screen.getGraphPanel().setStyle((DisplayStyle) graphStyle.getSelectedItem()));
        }
        addSettings("format d'affichage du Graphe",graphStyle);


        addSettings("test",new JButton("test"));



        add(global);
    }

    void addSettings(String legends,JComponent component){
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p1.setBackground(new Color(50,50,50));

        p1.add(new JLabel(legends));
        p1.add(component);

        global.add(p1);

    }





}
