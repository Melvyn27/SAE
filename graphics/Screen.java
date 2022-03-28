package SAE.graphics;

import SAE.graphics.screen_component.ChoixSite;
import SAE.graphics.screen_component.Log;
import SAE.graphics.screen_component.Questionnement;
import SAE.map.Carte;
import SAE.map.Site;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Screen extends JFrame implements ActionListener, ComponentListener, WindowListener {
    Carte carte = new Carte();
    //----creation-des-composants-----
    JPanel topPanel = new JPanel();
    JPanel lowPanel = new JPanel();
    JPanel globalPane;

    Questionnement quest = new Questionnement();
    Log log = new Log();
    ChoixSite choixSite1 = new ChoixSite();
    ChoixSite choixSite2 = new ChoixSite();
    //------------



    public Screen(){



        init();
    }
    void init(){
        globalPane = (JPanel) this.getContentPane();
        setVisible(true);
        setSize(800,400);
        setDefaultCloseOperation(3);
        setMinimumSize(new Dimension(600,500));
        topPanel.setBackground(Color.green);
        lowPanel.setBackground(Color.red);
        lowPanel.setPreferredSize(new Dimension(0,150));
        //-----ajout-des-panneaux-principaux-----------------
        globalPane.add(topPanel);
        globalPane.add(lowPanel,BorderLayout.SOUTH);
        //-----ajout-des-panneaux-secondaire-----------------
        {
            //
            lowPanel.setLayout(new BorderLayout());
            quest.link(this);
            quest.getView().setPreferredSize(new Dimension(300, 0));
            quest.addChoix("ajout");
            quest.addChoix("clear");
            lowPanel.add(quest.getView(), BorderLayout.WEST);
            //
            lowPanel.add(log.getView());
            //
            topPanel.setLayout(new GridLayout(1,4));
            choixSite1.getView().setPreferredSize(new Dimension(150,0));
            topPanel.add(choixSite1.getView());
            choixSite2.getView().setPreferredSize(new Dimension(150,0));
            topPanel.add(choixSite2.getView());

        }





    }

    public void action(int act){
        System.out.println("action performed : " + act);

        if(act == 0) log.addLine("lol");
        else if(act == 1) log.clear();


        System.out.println("nb component : " + log.getComponentCount());
    }






    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }


    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
