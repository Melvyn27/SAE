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
    JTextField dist = new JTextField(3);
    public VoisinDe(Screen screen){
        this.screen=screen;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        init();
    }
    public void updateChoix(ArrayList<Site> s){
        siteComboBoxModel1.resetChoix();
        siteComboBoxModel1.addChoix(s);
    }
    void init(){//fixme: bug d'affichage
        JPanel p1 = new JPanel();
        p1.add(choixSite1);
        add(p1);
        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("distance: "));
        p2.add(dist);
        add(p2);
        add(new JButton("start"));
    }




}
