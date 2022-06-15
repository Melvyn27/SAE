package SAE.action;

import SAE.graphics2.Screen;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

import java.util.ArrayList;


/**
 * liste les différente route ou site selon les methodes utilisé
 */
public class ListerLesTrucs {
Carte carte;

    public ListerLesTrucs(Screen screen){
        carte=screen.getCarte();
    }
    public ListerLesTrucs(Carte carte){
        this.carte=carte;
        
    }

    /**
     * liste les villes selon la carte donnée
     * @return les villes de la carte
     */
    public ArrayList<Site> listerLesVilles(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:carte.getSites()){
            if(s.getType()=='V'){sites.add(s);}
        }
        return sites;
    }
    /**
     * liste les loisires selon la carte donnée
     * @return les loisire de la carte
     */
    public ArrayList<Site> listerLesLoisires(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:carte.getSites()){
            if(s.getType()=='L'){sites.add(s);}
        }
        return sites;
    }
    /**
     * liste les retaurants selon la carte donnée
     * @return les restaurants de la carte
     */
    public ArrayList<Site> listerLesRestaurants(){

        ArrayList<Site> sites = new ArrayList<>();
        for(Site s:carte.getSites()){
            if(s.getType()=='R'){sites.add(s);}
        }
        return sites;
    }

    /**
     * suprime les routes dupiqué en ne gardant que les route dont le site de depart est superieur au site d'arrivée
     * @param routes
     * @return renvoie une liste de route
     */
    private ArrayList<Route> delDupi(ArrayList<Route> routes){
        ArrayList<Route> res=new ArrayList<>();
        for(Route r1:routes){
           if(r1.getSource().charAt(0)<r1.getDestination().charAt(0))res.add(r1);
        }
        return res;
    }
    /**
     * liste les route departementals selon la carte donnée
     * @return les departementals de la carte
     */
    public ArrayList<Route> listerLesDepartementale(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:carte.getSites()){
            for(Route r:s.getRoutes())
            if(r.getType()=='D'){routes.add(r);}
        }
        return delDupi(routes);
    }
    /**
     * liste les nationals selon la carte donnée
     * @return les nationals de la carte
     */
    public ArrayList<Route> listerLesNational(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:carte.getSites()){
            for(Route r:s.getRoutes())
                if(r.getType()=='N'){routes.add(r);}
        }
        return delDupi(routes);
    }
    /**
     * liste les autoroutes selon la carte donnée
     * @return les autoroutes de la carte
     */
    public ArrayList<Route> listerLesAutoroute(){
        ArrayList<Route> routes = new ArrayList<>();
        for(Site s:carte.getSites()){
            for(Route r:s.getRoutes())
                if(r.getType()=='A'){routes.add(r);}
        }
        return delDupi(routes);
    }












}
