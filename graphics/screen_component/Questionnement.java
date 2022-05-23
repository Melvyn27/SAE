package SAE.graphics.screen_component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *  /!\ le premier composant n'a pas 0 comme action
 */
public class Questionnement extends JPanel {


    JLabel legend;
    int choix;
    JScrollPane view;
    JPanel global = new JPanel();


    public Questionnement(){
        init();
    }
    public Questionnement(String legend){
        this.legend.setText(legend);
        init();
    }

    void init(){
        add(legend, BorderLayout.NORTH);
        add(global,BorderLayout.CENTER);
        view=new JScrollPane(global);
        global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));

    }

    public void addChoix(String name){
        addChoix(name,null);
    }
    public void addChoix(String name,ActionListener action){
        JButton b=new JButton(name);
        b.addActionListener(action);
        global.add(b);
        revalidate();
        repaint();
    }

    public void setLegend(String legend) {
        this.legend.setText(legend);
    }
}
