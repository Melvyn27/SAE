package SAE;

import map.Carte;
import map.Route;
import map.Site;

public class Main {
    static Carte carte=new Carte();


    public static void main(String[] args) {
        carte.ajouterSite('V',"test");
        carte.ajouterSite('R',"test2");
        carte.ajouterSite('L',"test3");
        listerLesSite();


    }

    static void menu(){









    }
    int init(){
        int test = 0;

        if(chargement()==0){
            for(Site s : Carte.getSites()){
                for(Route r:s.getRoutes()){
                    if(carte.getIndexOf (r.getDestination())==-1)test = 1;
                }
            }


        }

        return test;
    }
    int chargement(){







        return 1;
    }
    static void listerLesRoute(){
        System.out.println("liste des autoroutes:");
        for (Route s: Carte.routes) {
            if(s.getType()=='A') System.out.println("\t" + s.getSource() + "<-->" + s.getDestination());
        }
        System.out.println("liste des routes national:");
        for (Route s: Carte.routes) {
            if(s.getType()=='N') System.out.println("\t" + s.getSource() + "<-->" + s.getDestination());
        }
        System.out.println("liste des routes departemental");
        for (Route s: Carte.routes) {
            if(s.getType()=='D') System.out.println("\t" + s.getSource() + "<-->" + s.getDestination());
        }
    }

    static void listerLesSite(){
        System.out.println("liste des villes:");
        for (Site s: Carte.sites) {
            if(s.getType()=='V') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des centres de loisir:");
        for (Site s: Carte.sites) {
            if(s.getType()=='L') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des restaurant:");
        for (Site s: Carte.sites) {
            if(s.getType()=='R') System.out.println("\t" + s.getNom());
        }
    }

}
