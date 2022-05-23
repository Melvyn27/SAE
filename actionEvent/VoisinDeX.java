package SAE.actionEvent;

import SAE.graphics2.Screen;
import SAE.map.Site;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VoisinDeX extends AbstractAction{

    Screen target;

    public VoisinDeX(Screen target){
        this.target=target;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int jump = 0;




        target.getCarte().resetGraph();
        target.getLog().addLine(target.getSelectedSite1()+":");
        target.getLog().addLines(target.getCarte().delDupli(voisinDe(target.getCarte().sites.get(target.getSelectedSite1()),jump)));
    }
    public ArrayList<Site> voisinDe(String name, int jump){
        return voisinDe(target.getCarte().sites.get(name),jump);
    }

    private ArrayList<Site> voisinDe(Site site, int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump!=0){
                for(String s:site.getVoisin()){
                    site.getRoute(s).setSelectionné(true);
                    v.addAll(voisinDe(s,jump-1));
                }
            }else{
                v.add(site);
                target.getCarte().selectSite(site);
            }
        }
        return v;
    }
}
