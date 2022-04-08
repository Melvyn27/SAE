package SAE;

import SAE.assets.Notification;
import SAE.graphics.FileChooser;
import SAE.graphics.LoadCarte;
import SAE.map.Carte;
import SAE.map.Route;
import SAE.map.Site;

public class Main implements Notification {
    FileChooser fileChooser=new FileChooser();
    LoadCarte loadCarte = new LoadCarte();

    public static void main(String[] args) {
        Main prgm = new Main();








    }




    @Override
    public void newNotification(int id,String notif) {
        switch (id){
            case 0:

                break;
            case 1:

                break;
            default:

        }



    }





    /*
    int init(){
        int test = 0;

        if(chargement()==0){
            for(Site s : Carte.getSites()){
                for(Route r:s.getRoutes()){
                    if(carte.getIndexOf (r.getDestination())==-1)test = 1;
                }
            }


        }

        return test;
    }
    int chargement(){







        return 1;
    }



*/
}
