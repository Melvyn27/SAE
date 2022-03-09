package SAE.map;

import java.util.ArrayList;

public class Carte {
    static public ArrayList<Site> sites = new ArrayList<>();

    public Carte(){
    }

    public void ajouterSite(char type, String nom){
        Site s = new Site(nom,type);
        sites.add(s);
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


}
