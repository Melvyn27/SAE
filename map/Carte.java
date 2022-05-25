package SAE.map;

import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Carte {
    public HashMap<String,Site> sites = new HashMap<>();



    public Carte(){

    }
    public void ajouterSite(char type, String nom){
        Site s = new Site(nom,type);
        sites.put(nom,s);
    }
    public void ajouterSite(Site site){
        sites.put(site.getNom(),site);
    }
    /**
     * permet de savoir quels sites afficher ou non
     * faire attention a bien utiliser resetGraph() avant utilisation
     * @param name
     */
    public void selectSite(String name){
        selectSite(sites.get(name));
    }
    /**
     * permet de savoir quel site afficher ou non
     * faire attention a bien utiliser resetGraph() avant utilisation
     * @param s
     */
    public void selectSite(Site s){
        s.setSelectionné(true);
    }
    /**
     * permet de savoir quel site afficher ou non
     * faire attention a bien utiliser resetGraph() avant utilisation
     * @param sites
     */
    public void selectAllSite(ArrayList<Site> sites){
        for(Site s : sites){
            s.setSelectionné(true);
        }
    }
    /**
     * permet d'afficher tout le graph
     */
    public void selectAllSite(){
        for(Site s : getSites()){
            s.setSelectionné(true);
            for(Route r:s.getRoutes())r.setSelectionné(true);
        }
    }


    /**
     * a utiliser avant l'appel de fonction pouvant agir sur l'affichage du graph
     */
    public void resetGraph(){
        for(Site s : getSites()){
            s.setSelectionné(false);
            s.setRechercher(false);
            for(Route r:s.getRoutes())r.setSelectionné(false);
        }
    }

    public boolean containSite(String name){
        return sites.containsKey(name);
    }

    public ArrayList<Site> getSites() {
        ArrayList<Site> rtn = new ArrayList<>();
        Set<String> key = sites.keySet();
        for(String k:key){
            rtn.add(sites.get(k));
        }
        return rtn;
    }
    public ArrayList<Route> getRoute(){
        ArrayList<Route> rs =new ArrayList<>();
        for(Site s:getSites())rs.addAll(s.getRoutes());
        return rs;
    }
    public ArrayList<Site> delDupli(ArrayList<Site> sites){
        ArrayList<Site> newSite = new ArrayList<>();
        for(Site s : sites)if(!newSite.contains(s))newSite.add(s);
        return newSite;
    }
}
