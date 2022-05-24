package SAE.graphics2;

import SAE.actionEvent.ClasserLesVilles;
import SAE.actionEvent.VoisinDe1;
import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.graphics2.screenComponent.Log;
import SAE.graphics2.screenComponent.Questionnement;
import SAE.graphics2.screenComponent.SettingsPanel;
import SAE.map.Carte;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {
    //todo ajout d'un panneau 'Settings': but potentiel changer l'affichage des logs ou du graph




    Carte carte = new Carte();

    //----
    Log log = new Log(this);
    FileLoaderPanel fileChooserPanel = new FileLoaderPanel(this);
    Questionnement questionnement = new Questionnement(this);
    SettingsPanel settings = new SettingsPanel(this);
    //todo: ajouter le panneau de questionnement
    //GraphPanel graph = new GraphPanel();

    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    SiteComboBoxModel siteComboBoxModel2 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);
    JComboBox<String> choixSite2 = new JComboBox<>(siteComboBoxModel1);


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
        rightPanel.addTab("settings",settings);

        JPanel p1 = new JPanel();//top panel of leftPanel
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        //p1.add(choixSite1);
        //p1.add(choixSite2);
        leftPanel.setPreferredSize(new Dimension(200,0));
        leftPanel.setMinimumSize(new Dimension(200,0));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(p1,BorderLayout.NORTH);
        leftPanel.add(questionnement,BorderLayout.CENTER);

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

    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
    public Log getLog(){
        return log;
    }

    public FileLoaderPanel getFileChooserPanel() {
        return fileChooserPanel;
    }

    public SiteComboBoxModel getSiteComboBoxModel1() {
        return siteComboBoxModel1;
    }

    public SiteComboBoxModel getSiteComboBoxModel2() {
        return siteComboBoxModel2;
    }

    public JComboBox<String> getChoixSite1() {
        return choixSite1;
    }
    public String getSelectedSite1(){
        return (String)siteComboBoxModel1.getSelectedItem();
    }
    public String getSelectedSite2(){
        return (String)siteComboBoxModel2.getSelectedItem();
    }

    public JComboBox<String> getChoixSite2() {
        return choixSite2;
    }

    public static void main(String[] args) {

        new Screen();
    }
}
