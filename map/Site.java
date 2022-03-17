package SAE.map;

import java.util.ArrayList;

public class Site {
    String nom;
    char type;
    ArrayList<Route> routes = new ArrayList<>();

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
