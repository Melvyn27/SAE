package SAE.graphics;

import SAE.graphics.screen_component.ChoixSite;
import SAE.graphics.screen_component.GraphPanel;
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
    JPanel choixPanel = new JPanel();
    JPanel globalPane;
    //
    Questionnement quest = new Questionnement();
    Log log = new Log();
    ChoixSite choixSite1 = new ChoixSite();
    ChoixSite choixSite2 = new ChoixSite();
    GraphPanel graph = new GraphPanel();
    //
    JSplitPane globalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPanel,lowPanel);
    JSplitPane topSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,choixPanel,graph.getView());
    JSplitPane lowSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,quest.getView(),log.getView());
    //------------



    public Screen(){



        init();
    }

    /** —   └   ┐   ┬   ├   │
     * globalPane——globalSpit—┬—topPanel——topSplit—┬—choixSite—┬—choixSite1
     *                        │                    │           └—choixSite2
     *                        │                    └—graph
     *                        └—lowPanel——lowSplit—┬—quest
     *                                             └—log
     */
    void init(){
        //-----set-des-panneaux-principaux-----------------
        globalPane = (JPanel) this.getContentPane();
        setVisible(true);
        setSize(800,400);
        setDefaultCloseOperation(3);
        setMinimumSize(new Dimension(600,500));
        lowPanel.setPreferredSize(new Dimension(0,150));
        globalSplit.setDividerLocation(300);
        globalSplit.setDividerSize(5);
        topSplit.setDividerSize(5);
        lowSplit.setDividerSize(5);

        //-----set-des-panneaux-secondaire-----------------
        {
            //
            lowPanel.setLayout(new BorderLayout());
            quest.link(this);
            quest.getView().setPreferredSize(new Dimension(300, 0));
            quest.addChoix("ajout question");
            quest.addChoix("clear");
            quest.addChoix("ajout choix site 1");
            //
            topPanel.setLayout(new BorderLayout());

            //
            choixPanel.setLayout(new GridLayout(0,2,1,1));




        }
        //------ajout-des-panneau----------
        {
            globalPane.add(globalSplit);
            topPanel.add(topSplit);
            choixPanel.add(choixSite1);
            choixPanel.add(choixSite2);
            lowPanel.add(lowSplit);
        }





    }

    public void action(int act){
        System.out.println("action performed : " + act);

        if(act == 0) log.addLine("lol");
        else if(act == 1) log.clear();
        else if(act == 2) choixSite1.addChoix("new site");
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
