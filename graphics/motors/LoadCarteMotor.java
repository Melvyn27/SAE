package SAE.graphics.motors;

import SAE.exeption.LoadExeption;
import SAE.exeption.VerificationExeption;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

import java.io.*;

public class LoadCarteMotor {
    String path;
    Carte carte = new Carte();
    //LoadCarte loadCarte;


    public LoadCarteMotor(String path) {
        this.path = path;
        //loadCarte = new LoadCarte();

        start();
    }

    public void start() {
        System.out.println("load start from file: " + path);

        try {
            load();
            System.out.println("load done");
            //loadCarte.dispose();
            //new Screen();
        } catch (LoadExeption e) {
            e.printStackTrace();
        } catch (VerificationExeption e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //todo remplir la fonction de chargement du jeu de donnée et ajouter les exeptions
    void load() throws LoadExeption, VerificationExeption, IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        Character typeS;
        String source = null;
        String destination = null;
        Character typeA = null;
        String distance = null;
        int i;
        while ((line = br.readLine()) != null) {
            typeS = line.charAt(0);
            i = 2; //type site
            while (line.charAt(i) != ':') {
                source = source + line.charAt(i);
                i = i + 1;
            }//nom site
            i = i + 1;
            Site site = new Site(source, typeS);
            while (line.charAt(i) != ';' && line.charAt(i + 1) != ';') {
                while (line.charAt(i) != ';') {
                    typeA = line.charAt(i);
                    i = i + 2;//type route
                    while (line.charAt(i) != ':' && line.charAt(i + 1) != ':') {
                        distance = distance + line.charAt(i);
                        i = i + 1;
                    }//distance route
                    i = i + 2;
                    typeS = line.charAt(i);
                    i = i + 2;//type destination
                    while (line.charAt(i) != ';') {
                        destination = destination + line.charAt(i);
                        i = i + 1;
                    }//destination route
                }//fin de route
                site.ajouterRoute(typeA, Integer.parseInt(distance), destination);

            }//fin de ligne
            carte.ajouterSite(site);

        }//fin chargement


        verification();
    }

    void verification() throws VerificationExeption {
        for (Site s : carte.getSites()) {
            for (Route r : s.getRoutes()) {
                if (!carte.containSite(r.getDestination())) throw new VerificationExeption(null,r.getDestination());
            }
        }
    }
}
