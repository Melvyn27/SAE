package SAE.map;

import java.util.ArrayList;

public class Carte {
    static public ArrayList<Site> sites = new ArrayList<>();
    static public ArrayList<Route> routes = new ArrayList<>();

    public Carte(){
    }

    public void ajouterSite(char type, String nom){
        Site s = new Site(nom,type);
        sites.add(s);
    }

    static boolean ajouterRoute(Route r){
        boolean test=true;
        for(Route e : routes){
            if((e.destination.equals(r.source) || e.destination.equals(r.destination))
                    && e.type==r.type
                    && e.longueur==r.longueur
                    && (e.source.equals(r.source) || e.source.equals(r.destination)))test=false;
        }
        if(test)routes.add(r);
        return test;
    }

    public int getIndexOf(String search){
        int test = -1;
        int i = 0;
        while(test == -1) {
            if (search.equals(sites.get(i).getNom()))
                test = i;
            else
                i++;
        }
        return test;
    }

    public static ArrayList<Site> getSites() {
        return sites;
    }

    public static ArrayList<Route> getRoutes() {
        return routes;
    }
}
