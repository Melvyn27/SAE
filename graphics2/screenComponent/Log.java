package SAE.graphics2.screenComponent;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    JPanel downPanel = new JPanel();
    JPanel upPanel = new JPanel();

    JScrollPane view = new JScrollPane(downPanel);



    public Log() {
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



    }
    public void addLine(String str){
        downPanel.add(new JLabel(str));
        JScrollBar bar= view.getVerticalScrollBar();
        //fixme bug de scrollBar
        bar.setValue(bar.getMaximum());
        revalidate();
    }
    //todo ajouter methode: ecrire un ensemble sites en fonction d'un format d'affichage


    public void clear(){
        downPanel.removeAll();
        System.out.println("component free");
        view.revalidate();
        repaint();
    }
    /*public JScrollPane getView() {
        return view;
    }
     */
}
