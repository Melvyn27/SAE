package SAE.graphics2.screenComponent.questionComponent;

import SAE.action.ListerLesTrucs;
import SAE.graphics2.Screen;
import SAE.map.Route;
import SAE.map.Site;

import javax.swing.*;
import java.util.ArrayList;

public class ListerLesSitePanel extends JPanel {

    Screen screen;

    public ListerLesSitePanel(Screen screen){
        this.screen = screen;
        init();
    }

    void init(){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JButton v = new JButton("lister les ville");
        v.addActionListener(a->{
            V(true);
        });
        JButton r = new JButton("lister les restaurants");
        r.addActionListener(a->{
            R(true);
        });
        JButton l = new JButton("lister les loisirs");
        l.addActionListener(a->{
            L(true);
        });
        JButton t = new JButton("tout afficher");
        t.addActionListener(a->{
            V(true);R(false);L(false);
        });
        JButton e = new JButton("lister les autoroutes");
        e.addActionListener(a->{
            A();
        });
        JButton n = new JButton("lister les nationals");
        n.addActionListener(a->{
            N();
        });
        JButton d = new JButton("lister les departementals");
        d.addActionListener(a->{
            D();
        });

        add(v);
        add(r);
        add(l);
        add(t);
        add(e);
        add(n);
        add(d);


    }

    private void V(Boolean g){
        ArrayList<Site> v = new ListerLesTrucs(screen).listerLesVilles();
        if(g)screen.getCarte().resetGraph();
        screen.getLog().addLine("Villes:");
        for(Site s:v){
            screen.getLog().addLine("       "+s.getNom());
            s.setSelectionné(true);
        }
        screen.getLog().addLine(" ");
        screen.getGraphPanel().repaint();
    }

    private void R(Boolean g){
        ArrayList<Site> r = new ListerLesTrucs(screen).listerLesRestaurants();
        if(g)screen.getCarte().resetGraph();
        screen.getLog().addLine("Restaurants:");
        for(Site s:r){
            screen.getLog().addLine("       "+s.getNom());
            s.setSelectionné(true);
        }
        screen.getLog().addLine(" ");
        screen.getGraphPanel().repaint();
    }
    private void L(Boolean g){
        ArrayList<Site> l = new ListerLesTrucs(screen).listerLesLoisires();
        if(g)screen.getCarte().resetGraph();
        screen.getLog().addLine("Loisires:");
        for(Site s:l){
            screen.getLog().addLine("       "+s.getNom());
            s.setSelectionné(true);
        }
        screen.getLog().addLine(" ");
        screen.getGraphPanel().repaint();
    }

    private void A(){
        ArrayList<Route> a = new ListerLesTrucs(screen).listerLesAutoroute();
        screen.getLog().addLine("Autoroutes:");
        for(Route r:a){
            screen.getLog().addLine("       "+r.getSource()+" <-"+r.getLongueur() +"-> "+r.getDestination());
        }
        screen.getLog().addLine(" ");
    }
    private void N(){
        ArrayList<Route> a = new ListerLesTrucs(screen).listerLesNational();
        screen.getLog().addLine("Nationals:");
        for(Route r:a){
            screen.getLog().addLine("       "+r.getSource()+" <-"+r.getLongueur() +"-> "+r.getDestination());
        }
        screen.getLog().addLine(" ");
    }
    private void D(){
        ArrayList<Route> a = new ListerLesTrucs(screen).listerLesDepartementale();
        screen.getLog().addLine("Depatementals:");
        for(Route r:a){
            screen.getLog().addLine("       "+r.getSource()+" <-"+r.getLongueur() +"-> "+r.getDestination());
        }
        screen.getLog().addLine(" ");
    }

}
