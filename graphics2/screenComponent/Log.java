package SAE.graphics2.screenComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;
import SAE.map.Site;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class Log extends JPanel {
    public LogFormat format = LogFormat.all;

    JPanel downPanel = new JPanel();
    JPanel upPanel = new JPanel();

    JScrollPane view = new JScrollPane(downPanel);

    Screen screen;



    public Log(Screen target) {
        this.screen =target;
        init();
    }




    void init(){
        downPanel.setBorder(new LineBorder(new Color(100,100,100)));

        setLayout(new BorderLayout());
        downPanel.setLayout(new BoxLayout(downPanel,BoxLayout.Y_AXIS));
        add(view,BorderLayout.CENTER);
        add(upPanel,BorderLayout.NORTH);
        view.setBorder(null);


        upPanel.setLayout(new BoxLayout(upPanel,BoxLayout.X_AXIS));
        JButton clear = new JButton("Clear");
        clear.addActionListener(c->clear());
        upPanel.add(clear);

        JButton test = new JButton("test");
        test.addActionListener(null);
        //upPanel.add(test);




    }

    /**
     * ajoute une ligne
     * @param str
     */
    public void addLine(String str){
        downPanel.add(new JLabel(str));
        JScrollBar bar= view.getVerticalScrollBar();
        //fixme bug de scrollBar
        bar.setValue(bar.getMaximum());
        revalidate();

    }
    /**
     * ajoute un site selon le format defini
     * @param site
     */
    public void addLine(Site site){
        switch (format){
            case all -> addLine(site.toString());
            case simple -> addLine(site.getNom());

        }
    }

    /**
     * ajoute un ensemble de site selon le format defini
     * @param sites
     */
    public void addLines(ArrayList<Site> sites){
        for (Site s:sites)addLine(s);
    }


/**
 * vide les log de toute ligne
 */
    public void clear(){
        downPanel.removeAll();
        System.out.println("component free");
        view.revalidate();
        repaint();
    }

    public void setFormat(LogFormat format) {
        this.format = format;
    }

    /*public JScrollPane getView() {
        return view;
    }
     */
}
