package SAE.graphics.motors;

import SAE.exeption.LoadExeption;
import SAE.exeption.VerificationExeption;
import SAE.graphics.LoadCarte;
import SAE.graphics.Screen;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

import java.io.*;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //todo remplir la fonction de chargement du jeu de donnée et ajouter les exeptions
    void load() throws LoadExeption, VerificationExeption {

        Character typeS;
        String source = null;
        String destination = null;
        Character typeA = null;
        String distance = null;
        int i;
        while ((line = br.readLine()) != null) {
            typeS = line.charAt(0);
            i = 2;
            while (line.charAt(i) != ':') {
                source = source + line.charAt(i);
                i = i + 1;
            }
            i = i + 1;
            Site site = new Site(source, typeS);
            while (line.charAt(i) != ';' && line.charAt(i + 1) != ';') {
                while (line.charAt(i) != ';') {
                    typeA = line.charAt(i);
                    i = i + 2;
                    while (line.charAt(i) != ':' && line.charAt(i + 1) != ':') {
                        distance = distance + line.charAt(i);
                        i = i + 1;
                    }
                    i = i + 2;
                    typeS = line.charAt(i);
                    i = i + 2;
                    while (line.charAt(i) != ';') {
                        destination = destination + line.charAt(i);
                        i = i + 1;
                    }
                }
                Route r = new Route(typeA,Integer.parseInt(distance),destination, source);
            }

        }


        verification();
    }
    void verification() throws VerificationExeption{
        for(Site s:carte.getSites()){
            for (Route r:s.getRoutes()){
                if(!carte.containSite(r.getDestination()))throw new VerificationExeption(r.getDestination());
                if (!carte.containSite(r.getDestination())) throw new VerificationExeption(r.getDestination());
            }
        }
    }
}
