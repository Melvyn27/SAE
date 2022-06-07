package SAE.graphics2;

import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.graphics2.screenComponent.*;
import SAE.map.Carte;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {

    Carte carte = new Carte();

    //----
    Log log = new Log(this);
    FileLoaderPanel fileChooserPanel = new FileLoaderPanel(this);
    Questionnement questionnement = new Questionnement(this);
    SettingsPanel settings = new SettingsPanel(this);
    InformationPanel info = new InformationPanel(this);

    GraphPanel graphPanel = new GraphPanel(this);



    JPanel leftPanel = new JPanel();
    public JTabbedPane rightPanel = new JTabbedPane();


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
        rightPanel.addTab("graphe", graphPanel);
        rightPanel.addTab("settings",settings);
        rightPanel.addTab("information",info);


        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(questionnement);

        setContentPane(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel,rightPanel));
    }

    public void setChoix(ArrayList<Site> s){
        questionnement.updateChoix(s);

        revalidate();
        repaint();
    }




    /**
     * serre a rafraichir le graph
     */
    public void update(){
        setChoix(carte.getSites());
        info.update();
        graphPanel.revalidate();
        graphPanel.repaint();
        repaint();
    }

    public Carte getCarte() {
        return carte;
    }
    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }
    public Log getLog(){
        return log;
    }
    public FileLoaderPanel getFileChooserPanel() {
        return fileChooserPanel;
    }

    public static void main(String[] args) {

        new Screen();
    }
}
