package SAE.map;

import java.util.ArrayList;
import java.util.Random;

public class Site {
    String nom;
    char type;
    ArrayList<Route> routes = new ArrayList<>();
    boolean selectionné=true;

    boolean rechercher=false;

    public Point coordonnée=new Point(Math.abs(new Random().nextInt()%100),Math.abs(new Random().nextInt()%100));

    public Site(String nom, char type) {
        this.nom = nom;
        this.type = type;
    }
    public Site(String nom, char type,Point coordonnée) {
        this.nom = nom;
        this.type = type;
        this.coordonnée=coordonnée;
    }

    public void ajouterRoute(char type, int longueur, String destination){
        if(!nom.equals(destination)){
            Route r = new Route(type,longueur,destination,nom);
            routes.add(r);
        }
    }




    public ArrayList<String> getVoisin(){
        ArrayList<String> v=new ArrayList<>();
        for (Route route: routes) {
            v.add(route.getDestination());
        }
        return v;
    }


    public boolean isSelectionné() {
        return selectionné;
    }
    public void setSelectionné(boolean selectionné) {
        this.selectionné = selectionné;
    }

    public boolean isRechercher() {
        return rechercher;
    }

    public void setRechercher(boolean rechercher) {
        this.rechercher = rechercher;
        selectionné=rechercher;
    }

    public void setCoordonnée(Point coordonnée) {
        this.coordonnée = coordonnée;
    }
    public Point getCoordonnée() {
        return coordonnée;
    }
    public String getNom() {
        return nom;
    }

    public char getType() {
        return type;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }
    public Route getRoute(String dest){
        for(Route r:routes)if(r.getDestination()==dest)return r;

        return null;
    }

    @Override
    public String toString() {
        String str=nom+":";
        for(Route r:routes)str+=r.destination+",";
        return str;
    }
}

