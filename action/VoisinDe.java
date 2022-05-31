package SAE.action;

import SAE.map.Carte;
import SAE.map.Site;

import java.util.ArrayList;

public class VoisinDe {

    boolean aff = false;
    Carte carte;
    char filtre = ' ';
    ArrayList<Site> sites;

    public VoisinDe(boolean aff,Carte carte){
        this.aff=aff;
        this.carte=carte;
        sites=carte.getSites();
    }

    public VoisinDe start(String src,int dist){

        if(src!=null) {
            sites = voisinDe(src, dist);

        }
        return this;
    }


    public VoisinDe filtres(String filtre){
        ArrayList<Site> newSites = new ArrayList<>();
        char f=' ';
        if(filtre!="tout") {
            if (filtre == "villes"){
                System.out.println("V");
                f = 'V';
            }
            if (filtre == "restaurants"){
                System.out.println("R");
                f = 'R';
            }
            if (filtre == "loisires"){
                System.out.println("L");
                f = 'L';
            }
            for (Site s : sites) {
                if (s.getType() == f){
                    newSites.add(s);
                }
            }
            sites = newSites;
        }else System.out.println("T");
        return this;
    }

    private ArrayList<Site> voisinDe(String name,int jump){

        return voisinDe(carte.sites.get(name),jump);
    }
    private ArrayList<Site> voisinDe(Site site,int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump>0){
                for(String s:site.getVoisin()){
                    if(aff){v.add(site);}
                    v.addAll(voisinDe(s,jump-1));
                }
            }else{
                v.add(site);
            }
        }
        return v;
    }
    public VoisinDe delDupli(){
        ArrayList<Site> newSite = new ArrayList<>();
        for(Site s : sites)if(!newSite.contains(s))newSite.add(s);
        return this;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }
}
