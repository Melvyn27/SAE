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


    /**
     * @param search
     * @return retourne l'index du site de nom 'search'(si non trouvé retourne _1_)
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



}
