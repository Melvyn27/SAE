package SAE.actionEvent;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.map.Carte;

import java.io.File;

public class ChargementParallele extends Thread{
    private volatile boolean running = true;
    private Carte carte = new Carte();
    FileLoaderPanel target;
    File file;


    public ChargementParallele(FileLoaderPanel target, File file){
        this.target =target;
        this.file = file;
        System.out.println("created");
    }


    @Override
    public void run() {
        running=true;
        target.information.setText("chargement de "+file.getName());//indication de chargement sur le panel
        System.out.println("started");
        load();
        target.confirmeCarte(carte);
        System.out.println("ended");
        target.information.setText("chargement fini");//indication de chargement sur le panel
    }

    private void load(){

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run");
        }



    }


    public boolean isRunning() {
        return running;
    }

    public void arreter() {
        this.stop();//je sais que pas ouf mais pas d'autre solution pour l'instant ☻
        this.running = false;
        System.out.println("try to stop");
        target.information.setText("chargement annulé");//indication de chargement sur le panel
    }
}
