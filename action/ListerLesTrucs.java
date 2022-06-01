package SAE.action;

import SAE.graphics2.Screen;
import SAE.map.Route;
import SAE.map.Site;

import java.util.ArrayList;

public class ListerLesTrucs {
Screen screen;

    public ListerLesTrucs(Screen screen){
        this.screen=screen;
    }


    public ArrayList<Site> listerLesVilles(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='V'){sites.add(s);}
        }
        return sites;
    }
    public ArrayList<Site> listerLesLoisires(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='L'){sites.add(s);}
        }
        return sites;
    }
    public ArrayList<Site> listerLesRestaurants(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            if(s.getType()=='R'){sites.add(s);}
        }
        return sites;
    }
    private ArrayList<Route> delDupi(ArrayList<Route> routes){
        ArrayList<Route> res=new ArrayList<>();
        for(Route r1:routes){
           if(r1.getSource().charAt(0)<r1.getDestination().charAt(0))res.add(r1);
        }
        return res;
    }
    public ArrayList<Route> listerLesDepartementale(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            for(Route r:s.getRoutes())
            if(r.getType()=='D'){routes.add(r);}
        }
        return delDupi(routes);
    }
    public ArrayList<Route> listerLesNational(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            for(Route r:s.getRoutes())
                if(r.getType()=='N'){routes.add(r);}
        }
        return delDupi(routes);
    }
    public ArrayList<Route> listerLesAutoroute(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:screen.getCarte().getSites()){
            for(Route r:s.getRoutes())
                if(r.getType()=='A'){routes.add(r);}
        }
        return delDupi(routes);
    }












}
