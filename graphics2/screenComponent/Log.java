package SAE.graphics2.screenComponent;

import SAE.actionEvent.ClasserLesVilles;
import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Log extends JPanel {
    LogFormat format = LogFormat.all;

    JPanel downPanel = new JPanel();
    JPanel upPanel = new JPanel();

    JScrollPane view = new JScrollPane(downPanel);

    Screen screen;



    public Log(Screen target) {
        this.screen =target;
        init();
    }




    void init(){
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
        test.addActionListener(t->addLine("test"));
        upPanel.add(test);

        JButton testsite = new JButton("test site");
        testsite.addActionListener(new ClasserLesVilles(screen));
        upPanel.add(testsite);


    }
    public void addLine(String str){
        downPanel.add(new JLabel(str));
        JScrollBar bar= view.getVerticalScrollBar();
        //fixme bug de scrollBar
        bar.setValue(bar.getMaximum());
        revalidate();
    }
    public void addLine(Site site){
        switch (format){
            case all -> addLine(site.toString());
            case reduce -> addLine(site.getNom());
            case simple -> addLine(site.getNom());
        }
    }
    public void addLines(ArrayList<Site> sites){
        for (Site s:sites)addLine(s);
    }


    //todo ajouter methode: ecrire un ensemble sites en fonction d'un format d'affichage


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
