package SAE.graphics2.screenComponent.questionComponent;

import SAE.action.VoisinDe;
import SAE.graphics2.Screen;
import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

public class ComparePanel extends JPanel {
    Screen screen;
    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);
    SiteComboBoxModel siteComboBoxModel2 = new SiteComboBoxModel();
    JComboBox<String> choixSite2 = new JComboBox<>(siteComboBoxModel2);


    public ComparePanel(Screen screen){
        this.screen=screen;
        init();
    }
    private void init(){
        JPanel global = new JPanel();

        global.setLayout(new BoxLayout(global,BoxLayout.Y_AXIS));
        JPanel p1 =new JPanel();
        //p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        p1.add(choixSite1);
        p1.add(choixSite2);

        JButton st = new JButton("start");
        st.addActionListener(l->start());

        global.add(p1);
        global.add(st);
        add(global);

    }
    public void updateChoix(ArrayList<Site> s){
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
        siteComboBoxModel2.resetChoix();
        siteComboBoxModel2.addChoix(s);
    }


    void start(){

        if(siteComboBoxModel1.getSelectedItem()!=null || siteComboBoxModel2.getSelectedItem()!=null) {
            Site s1 = screen.getCarte().sites.get((String) siteComboBoxModel1.getSelectedItem());
            Site s2 = screen.getCarte().sites.get((String) siteComboBoxModel2.getSelectedItem());

            screen.getLog().addLine("comparaison entre "+s2.getNom()+" et "+s1.getNom());

            int s1v = new VoisinDe(false, screen.getCarte()).start(s1.getNom(), 2).delDupli().filtres("villes").getSites().size();
            int s2v = new VoisinDe(false, screen.getCarte()).start(s2.getNom(), 2).delDupli().filtres("villes").getSites().size();

            int nb = s1v-s2v;
            if(nb<0)screen.getLog().addLine("    "+s2.getNom()+" est plus ouverte que "+s1.getNom());
            else if(nb>0)screen.getLog().addLine("    "+s1.getNom()+" est plus ouverte que "+s2.getNom());
            else screen.getLog().addLine("    "+s1.getNom()+" et "+s2.getNom()+ " sont equivalent");
            nb = new VoisinDe(false, screen.getCarte()).start(s1.getNom(), 2).delDupli().filtres("restaurants").getSites().size()-new VoisinDe(false, screen.getCarte()).start(s2.getNom(), 2).delDupli().filtres("restaurants").getSites().size();
            if(nb<0)screen.getLog().addLine("    "+s2.getNom()+" est plus gastronomique que "+s1.getNom());
            else if(nb>0)screen.getLog().addLine("    "+s1.getNom()+" est plus gastronomique que "+s2.getNom());
            else screen.getLog().addLine("    "+s1.getNom()+" et "+s2.getNom()+ " sont equivalent");
            nb = new VoisinDe(false, screen.getCarte()).start(s1.getNom(), 2).delDupli().filtres("loisires").getSites().size()-new VoisinDe(false, screen.getCarte()).start(s2.getNom(), 2).delDupli().filtres("loisires").getSites().size();
            if(nb<0)screen.getLog().addLine("    "+s2.getNom()+" est plus culturelle que "+s1.getNom());
            else if(nb>0)screen.getLog().addLine("    "+s1.getNom()+" est plus culturelle que "+s2.getNom());
            else screen.getLog().addLine("    "+s1.getNom()+" et "+s2.getNom()+ " sont equivalent");




            screen.getCarte().resetGraph();
            s1.setRechercher(true);
            s2.setRechercher(true);

            for(Site s:new VoisinDe(false, screen.getCarte()).start(s1.getNom(), 2).getSites()){
                s.setSelectionné(true);
            }
            for(Site s:new VoisinDe(false, screen.getCarte()).start(s2.getNom(), 2).getSites()){
                s.setSelectionné(true);
            }
            screen.getGraphPanel().repaint();
        }





    }
}
