package SAE.graphics2;

import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.screenComponent.Log;
import SAE.map.Carte;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {
    Carte carte = new Carte();

    //----
    Log log = new Log();
    FileLoaderPanel fileChooserPanel = new FileLoaderPanel(this);
    //GraphPanel graph = new GraphPanel();
    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    SiteComboBoxModel siteComboBoxModel2 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);
    JComboBox<String> choixSite2 = new JComboBox<>(siteComboBoxModel2);


    JPanel leftPanel = new JPanel();
    JTabbedPane rightPanel = new JTabbedPane();


    public Screen(){
        init();
        setUp();
    }
    private void setUp(){
        setDefaultCloseOperation(3);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void init(){
        rightPanel.addTab("log",null,log,"afficher les resultats");
        rightPanel.addTab("file",null,fileChooserPanel,"choose a file to load");

        JPanel p1 = new JPanel(new FlowLayout());//top panel of leftPanel
        p1.add(choixSite1);
        p1.add(choixSite2);
        leftPanel.setLayout(new GridLayout(2,1));
        leftPanel.add(p1);





        add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel));
    }

    public void setChoix(ArrayList<Site> s){
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
        siteComboBoxModel2.resetChoix();
        siteComboBoxModel2.addChoix(s);
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
    public Log getLog(){
        return log;
    }

    public static void main(String[] args) {
        new Screen();
    }
}
