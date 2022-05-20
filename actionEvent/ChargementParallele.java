package SAE.actionEvent;

import SAE.graphics2.screenComponent.FileLoaderPanel;
import SAE.map.Carte;

public class ChargementParallele extends Thread{
    private volatile boolean running = true;
    private Carte carte = new Carte();
    FileLoaderPanel target;


    public ChargementParallele(FileLoaderPanel target){
        this.target =target;

    }


    @Override
    public void run() {
        running=true;
        System.out.println("started");
        load();
        target.confirmeCarte(carte);
        System.out.println("ended");
    }

    private void load(){




    }






    public void arreter() {
        this.running = false;
        System.out.println("try to stop");
    }
}
