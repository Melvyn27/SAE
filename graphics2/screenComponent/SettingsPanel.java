package SAE.graphics2.screenComponent;

import SAE.graphics2.format.DisplayStyle;
import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.TreeMap;

public class SettingsPanel extends JPanel {
    Screen screen;
    int fun_count=0;

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

        JCheckBox md=new JCheckBox();
        md.addActionListener(m->screen.getGraphPanel().modeDaltonien=md.isSelected());
        addSettings("mode daltonien",md,"squid game mod");


        JButton fun = new JButton("fun mode");
        fun.addActionListener(l->{
            fun_count++;
            if(fun_count==10)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    screen.rightPanel.setEnabledAt(1,false);
                    fun.setEnabled(false);
                    while (true){
                        for(Site s:screen.getCarte().getSites()){
                            s.coordonnée.setX(new Random().nextInt(10,90));
                            s.coordonnée.setY(new Random().nextInt(10,90));
                            screen.getGraphPanel().repaint();
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        });
        addSettings("lol",fun,"eh, chui pas un moustique");







        add(global);
    }

    void addSettings(String legends,JComponent component){
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p1.setBackground(new Color(100,100,100));

        p1.add(new JLabel(legends));
        p1.add(component);

        global.add(p1);

    }
    void addSettings(String legends,JComponent component,String toolTip){
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p1.setBackground(new Color(100,100,100));

        p1.add(new JLabel(legends));
        p1.add(component);
        p1.setToolTipText(toolTip);
        global.add(p1);

    }





}
