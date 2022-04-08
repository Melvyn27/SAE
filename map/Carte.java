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





    public void selectSite(String name){
        selectSite(sites.get(getIndexOf(name)));
    }
    public void selectSite(Site s){
        s.setSelectionné(true);
    }

    public void resetGraph(){
        for(Site s:sites){
         s.setSelectionné(false);
         for(Route r:s.getRoutes()){
             r.setSelectionné(false);
         }
        }
    }
    /**
     * @param search
     * @return retourne l'index du site de nom 'search'(si non trouvé retourne 1)
     */
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

    /**
     * @param index
     * @param d
     * @return retourne une chaine de caractere ce composant du nom des voisins à d-distances en noeud separé par un '.'
     */
    public String voisinDe(int  index,int d){
        String rtn = "";
        if(index!=-1){
            if(d!=0){
                for(String site:sites.get(index).getVoisin()){
                    voisinDe(getIndexOf(site),d-1);
                }

            }else{
                rtn+= sites.get(index).getNom()+".";
            }
        }
        return rtn;
    }
    static void listerLesSite(){
        System.out.println("liste des villes:");
        for (Site s: sites) {
            if(s.getType()=='V') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des centres de loisir:");
        for (Site s: sites) {
            if(s.getType()=='L') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des restaurant:");
        for (Site s: sites) {
            if(s.getType()=='R') System.out.println("\t" + s.getNom());
        }
    }



}
