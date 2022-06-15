package SAE.action;

import SAE.map.Carte;
import SAE.map.Site;

import java.util.ArrayList;

public class VoisinDe {

    boolean intermediaire = false;
    Carte carte;
    char filtre = ' ';
    ArrayList<Site> sites;

    /**
     *
     * initialisation de la classe
     * @param intermediaire
     * @param carte
     */
    public VoisinDe(boolean intermediaire,Carte carte){
        this.intermediaire =intermediaire;
        this.carte=carte;
        sites=carte.getSites();
    }

    /**
     * lance la recherche
     * @param src
     * @param dist
     * @return  se retourne soit meme pour pouvoir enchainer les methodes
     */
    public VoisinDe start(String src,int dist){

        if(src!=null) {
            sites = voisinDe(src, dist);

        }
        return this;
    }

    /**
     * effectue un filtre pour ne garder que se que l'on veut
     * filtre parmi villes, restaurants, loisires
     * @param filtre
     * @return se retourne soit meme pour pouvoir enchainer les methodes
     */
    public VoisinDe filtres(String filtre){
        ArrayList<Site> newSites = new ArrayList<>();
        char f=' ';
        if(filtre!="tout") {
            if (filtre == "villes"){
                f = 'V';
            }
            if (filtre == "restaurants"){
                f = 'R';
            }
            if (filtre == "loisires"){
                f = 'L';
            }
            for (Site s : sites) {
                if (s.getType() == f){
                    newSites.add(s);
                }
            }
            sites = newSites;
        }
        return this;
    }

    /**
     * fait juste le lien entre le nom d'un site et son objet dans la carte
     * @param name
     * @param jump
     * @return la liste des sites
     * */
    private ArrayList<Site> voisinDe(String name,int jump){
        return voisinDe(carte.sites.get(name),jump);
    }

    /**
     * fait la liste des voisin directe d'un site puis effectue une recherche recursive si _jump_ est superrieur a _0_
     * @param site
     * @param jump
     * @return  la liste des sites
     */
    private ArrayList<Site> voisinDe(Site site,int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump>0){
                for(String s:site.getVoisin()){
                    if(intermediaire){v.add(site);}
                    v.addAll(voisinDe(s,jump-1));
                }
            }else{
                v.add(site);
            }
        }
        return v;
    }

    /**
     * suprime la duplication des site
     * @return se retourne soit meme pour pouvoir enchainer les methodes
     */
    public VoisinDe delDupli(){
        ArrayList<Site> newSite = new ArrayList<>();
        for(Site s : sites)if(!newSite.contains(s))newSite.add(s);
        return this;
    }

    /**
     * @return les resultats de la recherche
     */
    public ArrayList<Site> getSites() {
        return sites;
    }
}
