package SAE;

import SAE.graphics2.Screen;
import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    //FileChooser fileChooser=new FileChooser();

    public static void main(String[] args) {
        //Main prgm = new Main();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());

        } catch (Exception e) {
            System.out.println("lol");
        };

        new Screen();
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
