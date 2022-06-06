package SAE.graphics2.screenComponent.questionComponent;

import SAE.action.VoisinDe;
import SAE.graphics2.Screen;
import SAE.graphics2.comboBoxModel.SiteComboBoxModel;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

public class VoisinProchePanel extends JPanel {
    Screen screen;
    SiteComboBoxModel siteComboBoxModel1 = new SiteComboBoxModel();
    JComboBox<String> choixSite1 = new JComboBox<>(siteComboBoxModel1);
    SiteComboBoxModel siteComboBoxModel2 = new SiteComboBoxModel();
    JComboBox<String> choixSite2 = new JComboBox<>(siteComboBoxModel2);


    public VoisinProchePanel(Screen screen){
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
            boolean test = new VoisinDe(false, screen.getCarte()).start((String) siteComboBoxModel1.getSelectedItem(), 2).getSites().contains(screen.getCarte().sites.get((String) siteComboBoxModel2.getSelectedItem()));
            String res = ""+siteComboBoxModel2.getSelectedItem();
            if(test)res+=" est a deux de distance de "+ siteComboBoxModel1.getSelectedItem();
            else res+=" n'est pas a deux de distance de "+ siteComboBoxModel1.getSelectedItem();
            screen.getLog().addLine(res);

            screen.getCarte().resetGraph();
            screen.getCarte().sites.get((String) siteComboBoxModel2.getSelectedItem()).setRechercher(true);
            screen.getCarte().sites.get((String) siteComboBoxModel1.getSelectedItem()).setRechercher(true);

            for(String s1:screen.getCarte().sites.get((String) siteComboBoxModel2.getSelectedItem()).getVoisin()){
                    if(screen.getCarte().sites.get((String) siteComboBoxModel1.getSelectedItem()).getVoisin().contains(s1)){
                        screen.getCarte().sites.get(s1).setSelectionné(true);

                }

            }
            screen.getGraphPanel().repaint();
        }





    }
}
