package SAE.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Carte {
    public HashMap<String,Site> sitees = new HashMap<>();



    public Carte(){


    }

    public void ajouterSite(char type, String nom){
        Site s = new Site(nom,type);
        sitees.put(nom,s);
    }





    public void selectSite(String name){
        selectSite(sitees.get(name));
    }
    public void selectSite(Site s){
        s.setSelectionné(true);
    }

    public void resetGraph(){
        Set<String> key = sitees.keySet();
        for(String k:key){
            sitees.get(k).setSelectionné(false);
        }
    }
    /*public int getIndexOf(String search){
        int test = -1;
        int i = 0;
        while(test == -1) {
            if (search.equals(sites.get(i).getNom()))
                test = i;
            else
                i++;
        }
        return test;
    }*/

    public ArrayList<Site> getSites() {
        ArrayList<Site> rtn = new ArrayList<>();
        Set<String> key = sitees.keySet();
        for(String k:key){
            rtn.add(sitees.get(k));
        }
        return rtn;
    }
    public ArrayList<Site> voisinDe(String name,int jump){
        return delDupli(voisinDe(sitees.get(name),jump));

    }
    public ArrayList<Site> voisinDe(Site site,int jump) {
        ArrayList<Site> v = new ArrayList<>();
        if(site!=null){
            if(jump!=0){
                for(String s:site.getVoisin()){
                    v.addAll(voisinDe(s,jump-1));
                }

            }else{
                v.add(site);
            }
        }
        return v;
    }
    private ArrayList<Site> delDupli(ArrayList<Site> sites){
        ArrayList<Site> newSite = new ArrayList<>();
        for(Site s : sites)if(!newSite.contains(s))newSite.add(s);
        return newSite;
    }

    /*
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
    }*/
    void listerLesSite(){
        System.out.println("liste des villes:");
        for (Site s: getSites()) {
            if(s.getType()=='V') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des centres de loisir:");
        for (Site s: getSites()) {
            if(s.getType()=='L') System.out.println("\t" + s.getNom());
        }
        System.out.println("liste des restaurant:");
        for (Site s: getSites()) {
            if(s.getType()=='R') System.out.println("\t" + s.getNom());
        }
    }
}
