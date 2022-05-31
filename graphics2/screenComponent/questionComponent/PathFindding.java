package SAE.graphics2.screenComponent.questionComponent;

import SAE.graphics2.Screen;
import SAE.map.Site;

import java.util.ArrayList;

public class PathFindding {
    Screen screen;
    int i = 0;
    private ArrayList<DijkstraSite> liste;
    private ArrayList<DijkstraSite> visite;

    public PathFindding(Screen screen) {
        this.screen = screen;
    }

    private class DijkstraSite {
        public Site site;
        public int distance;
        public DijkstraSite source;
        public boolean visite;

        public DijkstraSite(Site site) {
            this.site = site;
            this.distance = -1;
        }
    }


    private ArrayList<Site> PathFindding(String src, String dest) {
        DijkstraSite a;
        for (i = 0; i < screen.getCarte().getSites().size(); i++) {
            DijkstraSite newSite = new DijkstraSite(screen.getCarte().getSites().get(i));
            liste.add(newSite);
        }
        for (i = 0; i < liste.size(); i++) {//Initialisation
            if (src == liste.get(i).site.getNom()) {
                liste.get(i).distance = 0;
            }
        }

        while (liste.size() > 0) {//trouver le plus court
            a = liste.get(0);
            for (i = 1; i < liste.size() - 1; i++) {//trouver a
                if (a.distance <= liste.get(i).distance) {
                    a = liste.get(i);
                }
            }
            visite.add(a);
            liste.remove(a);
            for (i = 0; i < liste.size(); i++) {//set les distance
                if (liste.get(i).distance > a.distance + screen.getCarte().sites.get(a.site.getNom()).getRoute(liste.get(i).site.getNom()).getLongueur() || liste.get(i).distance == -1) {
                    liste.get(i).distance = a.distance + screen.getCarte().sites.get(a.site.getNom()).getRoute(liste.get(i).site.getNom()).getLongueur();
                    liste.get(i).source = a;
                }
            }
        }

        return dijkstra(screen.getCarte().sites.get(src), screen.getCarte().sites.get(src));
    }

    private ArrayList<Site> dijkstra(Site src, Site dest) {
        DijkstraSite a = visite.get(0);
        for (i = 0; i < visite.size(); i++) {//trouver a
            if (visite.get(i).site == dest) {
                a = visite.get(i);
            }
        }

        ArrayList<Site> chemin = null;
        while (a.site != src) {
            chemin.add(a.site);
            a = a.source;
        }
        chemin.add(a.site);
        return chemin;


    }
}
