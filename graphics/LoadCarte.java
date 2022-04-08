package SAE.graphics;

import SAE.assets.Notification;
import SAE.map.Carte;

public class LoadCarte {
    String Path;
    Carte carte = new Carte();
    Notification notifiable;



    public LoadCarte(){




    }


    public void setNotifiable(Notification notifiable){
        this.notifiable=notifiable;
    }
    public Carte getCarte() {
        return carte;
    }
}
