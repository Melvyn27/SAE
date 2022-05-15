package SAE.graphics.motors;

import SAE.exeption.LoadExeption;
import SAE.exeption.VerificationExeption;
import SAE.graphics.LoadCarte;
import SAE.graphics.Screen;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

public class LoadCarteMotor {
    String path;
    Carte carte = new Carte();
    LoadCarte loadCarte;


    public LoadCarteMotor(String path){
        this.path=path;
        loadCarte=new LoadCarte();

        start();
    }

    public void start(){
        System.out.println("load start from file: "+path);

        try {
            load();
                System.out.println("load done");
                loadCarte.dispose();
                new Screen();
        } catch (LoadExeption e) {
            e.printStackTrace();
        } catch (VerificationExeption e) {
            e.printStackTrace();
        }
    }


    //todo remplir la fonction de chargement du jeu de donnée et ajouter les exeptions
    void load() throws LoadExeption, VerificationExeption {



        verification();
    }
    void verification() throws VerificationExeption{
        for(Site s:carte.getSites()){
            for (Route r:s.getRoutes()){
                if(!carte.containSite(r.getDestination()))throw new VerificationExeption(r.getDestination());
            }
        }
    }

}
