package SAE.graphics2.screenComponent.questionComponent;

import SAE.graphics2.Screen;
import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.map.Site;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VoisinDe extends JPanel {
    Screen screen;

    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);

    JCheckBox aff = new JCheckBox();


    JTextField dist = new JTextField(3);
    public VoisinDe(Screen screen){
        this.screen=screen;
        //setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        init();
    }
    public void updateChoix(ArrayList<Site> s){
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
    }
    void init(){//fixme: bug d'affichage
        JPanel global = new JPanel(new GridLayout(0,1,1,1));


        global.add(choixSite1);

        JPanel p2 = new JPanel();
        p2.add(new JLabel("distance: "));
        p2.add(dist);
        dist.setToolTipText("conseil: ne depasse pas 10 stp");
        global.add(p2);

        JPanel p3 = new JPanel();
        p3.add(aff);
        aff.setText("afficher tout");
        //p3.add(new JLabel());
        global.add(p3);

        JButton b =new JButton("trouver les voisin");
        b.addActionListener(v->voisinDe());
        global.add(b);

        add(global);
    }

    public void voisinDe(){
        int dist = Integer.parseInt( this.dist.getText());
        String site = (String)siteComboBoxModel1.getSelectedItem();
        if(site!=null) {
            screen.getCarte().resetGraph();
            screen.getCarte().sites.get(site).setRechercher(true);
            ArrayList<Site> res = screen.getCarte().delDupli(voisinDe(site, dist));
            //screen.getLog().addLines(res);

            screen.getLog().addLine("voisins de " + site+" a "+dist+" saut: ");
            for (Site s : res) screen.getLog().addLine("    " + s.getNom());
            screen.getLog().addLine(" ");
        }

    }

    private ArrayList<Site> voisinDe(String name,int jump){

        return voisinDe(screen.getCarte().sites.get(name),jump);
    }
    private ArrayList<Site> voisinDe(Site site,int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump!=0){
                for(String s:site.getVoisin()){
                    site.getRoute(s).setSelectionné(true);
                    if(aff.isSelected()){v.add(site);site.setSelectionné(true);}
                    v.addAll(voisinDe(s,jump-1));
                }
            }else{
                v.add(site);
                screen.getCarte().selectSite(site);
            }
        }
        return v;
    }






}
