package SAE.graphics2.screenComponent;

import SAE.action.ListerLesTrucs;
import SAE.graphics2.Screen;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {

    JLabel nbVilles = new JLabel();
    JLabel nbRestau = new JLabel();
    JLabel nbLoisires = new JLabel();
    JLabel nbtotS = new JLabel();

    JLabel nbDep = new JLabel();
    JLabel nbNat = new JLabel();
    JLabel nbAut = new JLabel();
    JLabel nbtotR = new JLabel();

    Screen screen;

    JPanel global = new JPanel(new GridLayout(0,2,10,10));

    public InformationPanel(Screen screen){
        this.screen = screen;
        //setLayout(new GridLayout(0,2,10,10));
        setLayout(new FlowLayout());
        setComponent();
    }
    private void setComponent(){
        addInfo("nombre de villes:",nbVilles);
        addInfo("nombre de restaurants:",nbRestau);
        addInfo("nombre de loisires:",nbLoisires);
        addInfo("nombre total de sites:",nbtotS);
        addInfo("nombre de autoroutes:",nbAut);
        addInfo("nombre de departemental:",nbDep);
        addInfo("nombre de national:",nbNat);
        addInfo("nombre total de routes:",nbtotR);

        add(global);
    }
    public void update(){
        nbVilles.setText(new ListerLesTrucs(screen).listerLesVilles().size()+"");
        nbRestau.setText(new ListerLesTrucs(screen).listerLesRestaurants().size()+"");
        nbLoisires.setText(new ListerLesTrucs(screen).listerLesLoisires().size()+"");
        nbtotS.setText(new ListerLesTrucs(screen).listerLesLoisires().size()+new ListerLesTrucs(screen).listerLesRestaurants().size()+new ListerLesTrucs(screen).listerLesVilles().size()+"");

        nbAut.setText(new ListerLesTrucs(screen).listerLesAutoroute().size()+"");
        nbNat.setText(new ListerLesTrucs(screen).listerLesNational().size()+"");
        nbDep.setText(new ListerLesTrucs(screen).listerLesDepartementale().size()+"");
        nbtotR.setText(new ListerLesTrucs(screen).listerLesDepartementale().size()+new ListerLesTrucs(screen).listerLesNational().size()+new ListerLesTrucs(screen).listerLesAutoroute().size()+"");


    }


    void addInfo(String legends,JComponent component){
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p1.setBackground(new Color(50,50,50));

        p1.add(new JLabel(legends));
        p1.add(component);

        global.add(p1);

    }


}
