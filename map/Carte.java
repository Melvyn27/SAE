package SAE.map;

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
    public ArrayList<Site> voisinDe(String name,int jump){
        resetGraph();
        return delDupli(voisinDe(sites.get(name),jump));
    }
    private ArrayList<Site> voisinDe(Site site,int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump!=0){
                for(String s:site.getVoisin()){
                    site.getRoute(s).setSelectionné(true);
                    v.addAll(voisinDe(s,jump-1));
                }
            }else{
                v.add(site);
                selectSite(site);
            }
        }
        return v;
    }
    private ArrayList<Site> delDupli(ArrayList<Site> sites){
        ArrayList<Site> newSite = new ArrayList<>();
        for(Site s : sites)if(!newSite.contains(s))newSite.add(s);
        return newSite;
    }


    void listerLesSite(){
        System.out.println("liste des villes:");
        for (Site s: getSites()) {
            if(s.getType()=='V') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des centres de loisir:");
        for (Site s: getSites()) {
            if(s.getType()=='L') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des restaurant:");
        for (Site s: getSites()) {
            if(s.getType()=='R') System.out.println("\t" + s.getNom());
        }
    }
}
