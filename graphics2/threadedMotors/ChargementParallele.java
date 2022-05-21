package SAE.graphics2.threadedMotors;

import SAE.exeption.LoadExeption;
import SAE.exeption.VerificationExeption;
import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class ChargementParallele extends Thread{
    private volatile boolean running = true;
    private Carte carte = new Carte();
    FileLoaderPanel target;
    File file;

    int caractereCount=0;
    int lineCount=0;




    public ChargementParallele(FileLoaderPanel target, File file){
        this.target =target;
        this.file = file;
        System.out.println("created");
    }
    @Override
    public void run() {
        setTargetMessage("chargement de "+file.getName());//indication de chargement sur le panel
        System.out.println("started");

        try {
            long milliTimeCount = System.currentTimeMillis();
            load();
            target.confirmeCarte(carte);
            setTargetMessage("chargement fini.");//indication de chargement sur le panel
            target.loadSiteBar.setStringPainted(false);
            target.loadDestBar.setStringPainted(false);
            System.out.println("ended");
            target.getTarget().getLog().addLine("file "+file.getName()+" loaded in: "+(System.currentTimeMillis()-milliTimeCount)+" ms");
        } catch (LoadExeption e) {
            //e.printStackTrace();



        } catch (VerificationExeption e) {
            //e.printStackTrace();



        } catch (IOException e) {
            e.printStackTrace();



        }

        this.running = false;
    }
    public boolean isRunning() {
        return running;
    }
    public void arreter() {
        this.stop();//je sais que pas ouf mais pas d'autre solution pour l'instant ☻
        this.running = false;
        System.out.println("try to stop");
        setTargetMessage("chargement annulé");//indication de chargement sur le panel
    }
    public void setTargetMessage(String message){
        target.information.setText(message);
    }

    void load() throws LoadExeption, VerificationExeption, IOException {
        target.loadSiteBar.setStringPainted(true);
        target.loadDestBar.setStringPainted(true);
        target.loadSiteBar.setMaximum(totalLineCount());//affichage
        lineCount=0;//affichage

        Scanner inputFile = new Scanner(file);
        String line = "";
        while (inputFile.hasNextLine()){
            line=lineClear(inputFile.nextLine());
            target.loadDestBar.setMaximum(line.length());//affichage
            caractereCount=0;//affichage et programme

            String src="";
            char type;
            if(!line.matches("^[VRL],[a-zA-Z]*:([DAN],[0-9]*::[VRL],[a-zA-Z]*;)+;$")){
                System.out.println(line);
                throw new LoadExeption(this,lineCount+"");
            }
            ArrayList<String> goodLine = lineSeq(line);

            Site site=new Site(goodLine.get(0).substring(goodLine.get(0).indexOf(',')+1), goodLine.get(0).toCharArray()[0]);//creation site
            if(carte.containSite(site.getNom()))throw new LoadExeption(this,lineCount+"", site.getNom());
            target.loadSiteBar.setString(site.getNom());//affichage
            target.loadDestBar.setMaximum(goodLine.size());//affichage
            for(int i=1;i<goodLine.size();i++){
                String r = goodLine.get(i);
                char t = r.charAt(0);
                String dist = r.substring(2,r.indexOf(':'));
                String dest = r.substring(r.lastIndexOf(',')+1);
                target.loadDestBar.setValue(i+1);//affichage
                target.loadDestBar.setString(dest);
                site.ajouterRoute(t,Integer.parseInt(dist),dest);

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            carte.ajouterSite(site);
            target.loadSiteBar.setValue(lineCount+1);//affichage
            lineCount++;//affichage
        }//chargement ligne
        verification();
    }


    void verification() throws VerificationExeption {
        int i = 0;
        target.loadSiteBar.setMaximum(carte.getSites().size());
        for (Site s : carte.getSites()) {
            int j=0;
            target.loadDestBar.setMaximum(s.getRoutes().size());
            for (Route r : s.getRoutes()) {
                if (!carte.containSite(r.getDestination())) throw new VerificationExeption(this,r.getDestination());
                j++;
                target.loadDestBar.setString(r.getDestination());
                target.loadDestBar.setValue(j);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            target.loadSiteBar.setString(s.getNom());
            target.loadSiteBar.setValue(i);
        }
    }
    private ArrayList<String> lineSeq(String line){
        ArrayList<String> seqline = new ArrayList<>();
        seqline.add(line.substring(0,line.indexOf(":")));
        line=line.substring(line.indexOf(":")+1);
        while (line.charAt(0)!=';'){
            seqline.add(line.substring(0,line.indexOf(";")));
            line=line.substring(line.indexOf(";")+1);
        }
        return seqline;
    }


    private String lineClear(String line) {
        return line.replaceAll("\\s+","");
    }


    private int totalLineCount() throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int count = 0;
        while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }
        return count;
    }
}
