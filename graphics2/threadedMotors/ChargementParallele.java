package SAE.graphics2.threadedMotors;

import SAE.exeption.LoadExeption;
import SAE.exeption.VerificationExeption;
import SAE.graphics2.Screen;
import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChargementParallele extends Thread{
    private volatile boolean running = true;

    Screen screen;
    File file;

    private Carte carte=new Carte();

    int caractereCount=0;
    int lineCount=0;




    public ChargementParallele(Screen target, File file){

        this.screen =target;
        this.file = file;

        System.out.println("created");
        start();
    }
    @Override
    public void run() {
        setTargetMessage("chargement de "+file.getName());//indication de chargement sur le panel
        System.out.println("started");
        screen.getFileChooserPanel().information.setForeground(null);
        try {
            long milliTimeCount = System.currentTimeMillis();
            load();
            verification();
            screen.getFileChooserPanel().confirmeCarte(carte);
            repositionnement();
            setTargetMessage("chargement fini.");//indication de chargement sur le panel
            System.out.println("chargement fini.");
            screen.getLog().addLine("file "+file.getName()+" loaded in: "+(System.currentTimeMillis()-milliTimeCount)+" ms");
        } catch (LoadExeption e) {
            //e.printStackTrace();



        } catch (VerificationExeption e) {
            //e.printStackTrace();



        } catch (IOException e) {
            e.printStackTrace();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.getFileChooserPanel().loadSiteBar.setStringPainted(false);
        screen.getFileChooserPanel().loadDestBar.setStringPainted(false);
        screen.getFileChooserPanel().loadSiteBar.setValue(0);
        screen.getFileChooserPanel().loadDestBar.setValue(0);
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
        screen.getFileChooserPanel().information.setText(message);
    }



    private void load() throws LoadExeption, IOException, InterruptedException {
        screen.getFileChooserPanel().loadSiteBar.setStringPainted(true);
        screen.getFileChooserPanel().loadDestBar.setStringPainted(true);
        screen.getFileChooserPanel().loadSiteBar.setMaximum(totalLineCount());//affichage
        lineCount=0;//affichage
        Scanner inputFile = new Scanner(file);
        String line = "";
        if(!inputFile.hasNextLine()){throw new LoadExeption(screen.getFileChooserPanel(),"le fichier"+file.getName()+" est vide");}//pre-condition
        do{
            line=lineClear(inputFile.nextLine());
            screen.getFileChooserPanel().loadDestBar.setMaximum(line.length());//affichage
            caractereCount=0;//affichage et programme
            String src="";
            char type;
            if(!line.matches("^[VRL],[a-zA-Z]*:([DAN],[0-9]*::[VRL],[a-zA-Z]*;)+;$")){
                System.out.println(line);
                throw new LoadExeption(screen.getFileChooserPanel(),lineCount);
            }//verification du format de la ligne
            ArrayList<String> goodLine = lineSeq(line);
            Site site=new Site(goodLine.get(0).substring(goodLine.get(0).indexOf(',')+1), goodLine.get(0).toCharArray()[0]);//creation site
            if(carte.containSite(site.getNom()))throw new LoadExeption(screen.getFileChooserPanel(),lineCount+"", site.getNom());
            screen.getFileChooserPanel().loadSiteBar.setString("site: "+site.getNom());//affichage
            screen.getFileChooserPanel().loadDestBar.setMaximum(goodLine.size());//affichage
            for(int i=1;i<goodLine.size();i++){
                String r = goodLine.get(i);
                char t = r.charAt(0);
                String dist = r.substring(2,r.indexOf(':'));
                String dest = r.substring(r.lastIndexOf(',')+1);
                screen.getFileChooserPanel().loadDestBar.setValue(i+1);//affichage
                screen.getFileChooserPanel().loadDestBar.setString("route: "+dest);
                site.ajouterRoute(t,Integer.parseInt(dist),dest);

                sleep(10);//juste pour le style

            }//chargement route
            carte.ajouterSite(site);
            screen.getFileChooserPanel().loadSiteBar.setValue(lineCount+1);//affichage
            lineCount++;//affichage
        }while (inputFile.hasNextLine());//chargement ligne
    }

    private void verification() throws VerificationExeption, InterruptedException {
        screen.getFileChooserPanel().loadSiteBar.setValue(0);
        screen.getFileChooserPanel().loadDestBar.setValue(0);//reset des bars

        int i = 0;
        screen.getFileChooserPanel().loadSiteBar.setMaximum(carte.getSites().size());
        for (Site s : carte.getSites()) {
            screen.getFileChooserPanel().loadSiteBar.setValue(i);
            screen.getFileChooserPanel().loadSiteBar.setString("carte/"+ s.getNom());
            int j=0;
            screen.getFileChooserPanel().loadDestBar.setMaximum(s.getRoutes().size());
            for (Route r : s.getRoutes()) {
                screen.getFileChooserPanel().loadDestBar.setValue(j);
                screen.getFileChooserPanel().loadDestBar.setString("site/"+r.getDestination());
                if (!carte.containSite(r.getDestination()))throw new VerificationExeption(screen.getFileChooserPanel(),r.getDestination());
                    j++;

                    sleep(10);//juste pour le style

            }

            i++;
        }
        screen.getFileChooserPanel().loadSiteBar.setValue(0);
        screen.getFileChooserPanel().loadDestBar.setValue(0);//reset des bars
    }

    private void repositionnement() throws InterruptedException {
        screen.getFileChooserPanel().loadSiteBar.setIndeterminate(true);
        screen.getFileChooserPanel().loadDestBar.setIndeterminate(true);
        setTargetMessage("replacement des points");


        ArrayList<Site> sites = carte.getSites();
        boolean movingPoint=false;
        do{
            movingPoint=false;
            for(Site site:sites){

                for(Site s:sites){
                    if(site!=s){
                        if(site.coordonnée.getX()==s.coordonnée.getX() && site.coordonnée.getY()==s.coordonnée.getY())site.coordonnée.setX(site.coordonnée.getX()+2);

                        if(Point2D.distance(site.coordonnée.getX(),site.coordonnée.getY(),s.coordonnée.getX(),s.coordonnée.getY())<10){
                            double angle=Math.atan2(s.coordonnée.getY()-site.coordonnée.getY(),s.coordonnée.getX()-site.coordonnée.getX());
                            double dist=Point2D.distance(site.coordonnée.getX(),site.coordonnée.getY(),s.coordonnée.getX(),s.coordonnée.getY());
                            site.coordonnée.setX((int)(11*Math.cos(angle))+s.coordonnée.getX());
                            site.coordonnée.setY((int)(11*Math.sin(angle))+s.coordonnée.getY());
                            movingPoint=true;
                        }
                    }

                }
                sleep(1);//aussi pour le style
                screen.getGraphPanel().repaint();
                site.coordonnée.constrain(10,10,90,90);
            }



        }while(movingPoint);

        screen.getFileChooserPanel().loadSiteBar.setIndeterminate(false);
        screen.getFileChooserPanel().loadDestBar.setIndeterminate(false);


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
