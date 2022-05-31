package SAE.graphics2.screenComponent.questionComponent;

import SAE.action.VoisinDe;
import SAE.graphics2.Screen;
import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.map.Route;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VoisinDePanel extends JPanel {
    Screen screen;

    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);
    JComboBox<String> filtre = new JComboBox<>();

    JCheckBox aff = new JCheckBox();


    JTextField dist = new JTextField(3);
    public VoisinDePanel(Screen screen){
        this.screen=screen;
        //setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        init();
    }
    public void updateChoix(ArrayList<Site> s){
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
    }
    void init(){//fixme: bug d'affichage
        JPanel global = new JPanel();
        global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));

        filtre.addItem("tout");
        filtre.addItem("villes");
        filtre.addItem("restaurants");
        filtre.addItem("loisires");


        JPanel p2 = new JPanel();
        p2.add(new JLabel("distance: "));
        p2.add(dist);
        dist.setToolTipText("conseil: ne depasse pas 10 stp");

        JPanel p3 = new JPanel();
        p3.add(aff);
        aff.setText("afficher les noeuds intermediaires");

        JPanel p4 = new JPanel();
        JLabel l4 = new JLabel("filtre");
        filtre.setToolTipText("filtre l'affichage des sites pour les Logs");
        p4.add(l4);
        p4.add(filtre);

        JButton b =new JButton("trouver les voisin");
        b.addActionListener(v->start());

        global.add(choixSite1);
        global.add(p2);
        global.add(p3);
        global.add(p4);
        global.add(b);

        add(global);
    }

    private void start(){


        String site = (String)choixSite1.getSelectedItem();


        ArrayList<Site> res = new VoisinDe(aff.isSelected(),screen.getCarte()).start(site,Integer.parseInt(dist.getText())).delDupli().filtres((String)filtre.getSelectedItem()).getSites();
        screen.getCarte().resetGraph();
        screen.getCarte().sites.get(site).setRechercher(true);
        for(Site s:res){
            s.setSelectionné(true);
        }
        screen.getLog().addLine("voisins de " + site+" a "+dist.getText()+" saut:(pour un totals de "+res.size()+" sites )");
        for (Site s : res){
            screen.getLog().addLine("    " + s.getNom());
        }
        screen.getLog().addLine(" ");
        screen.getGraphPanel().repaint();
    }








}
