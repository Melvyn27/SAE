package SAE.map;

import SAE.graphics.graphComponent.Point;

import java.util.ArrayList;

public class Site {
    String nom;
    char type;
    ArrayList<Route> routes = new ArrayList<>();
    boolean selectionné=false;
    public Point coordonnée=new Point(0,0);

    public Site(String nom, char type) {
        this.nom = nom;
        this.type = type;
    }

    void ajouterRoute(char type, int longueur, String destination){
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
}
