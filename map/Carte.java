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

    public void ajouterRoute(char type, int distance, String source, String destination){
        Route r = new Route(type, distance ,source, destination);
        routes.add(r);
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

    public String voisinDe(int  index,int distance){
        String rtn = "";
        if(distance!=0){
            for(String site:sites.get(index).getVoisin()){
                voisinDe(getIndexOf(site),distance-1);
            }

        }else{
            rtn+= " "+sites.get(index).getNom();
        }
        return rtn;
    }



}
