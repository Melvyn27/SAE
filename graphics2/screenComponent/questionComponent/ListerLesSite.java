package SAE.graphics2.screenComponent.questionComponent;

import SAE.graphics2.Screen;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

public class ListerLesSite extends JPanel {

    Screen screen;

    JLabel info = new JLabel();

    public ListerLesSite(Screen screen){
        this.screen = screen;
        init();
    }

    void init(){
        JButton v = new JButton("lister les ville");
        v.addActionListener(a->listerLesVilles());
        JButton r = new JButton("lister les restaurants");
        r.addActionListener(a->listerLesRestaurant());
        JButton l = new JButton("lister les loisirs");
        l.addActionListener(a->listerLesLoisir());
        JButton t = new JButton("tout afficher");
        t.addActionListener(a->info.setText(listerLesVilles()+listerLesRestaurant()+listerLesLoisir()+" sites au total"));

        add(v);
        add(r);
        add(l);
        add(t);
        add(info);

    }






    int listerLesVilles(){
        int t = 0;
        ArrayList<Site> sites = new ArrayList<>();

        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='V'){sites.add(s);t++;}
        }
        screen.getLog().addLine("liste des villes: ");
        for (Site s : sites) screen.getLog().addLine("    " + s.getNom());
        screen.getLog().addLine(" ");

        info.setText(t+" villes au total");

        return t;
    }
    int listerLesLoisir(){
        int t = 0;
        ArrayList<Site> sites = new ArrayList<>();

        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='L'){sites.add(s);t++;}
        }
        screen.getLog().addLine("liste des loisirs: ");
        for (Site s : sites) screen.getLog().addLine("    " + s.getNom());
        screen.getLog().addLine(" ");

        info.setText(t+" loisirs au total");

        return t;
    }
    int listerLesRestaurant(){
        int t = 0;
        ArrayList<Site> sites = new ArrayList<>();

        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='R'){sites.add(s);t++;}
        }
        screen.getLog().addLine("liste des restaurants: ");
        for (Site s : sites) screen.getLog().addLine("    " + s.getNom());
        screen.getLog().addLine(" ");

        info.setText(t+" restaurants au total");

        return t;
    }










}
