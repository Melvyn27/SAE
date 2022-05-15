package SAE.graphics.screen_component;

import SAE.graphics.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  /!\ le premier composant n'a pas 0 comme action
 */
public class Questionnement extends JPanel {



    int choix;
    ButtonGroup buttons=new ButtonGroup();
    JScrollPane view;


    public Questionnement(){
        init();
    }

    void init(){
        view=new JScrollPane(this);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

    }

    public void addChoix(String name){
        addChoix(name,null);
    }
    public void addChoix(String name,ActionListener action){
        //fixme affichage a refaire
        /** /!\ le premier composant n'a pas 0 comme action */
        JButton b=new JButton(name);
        buttons.add(b);
        add(b);
        b.addActionListener(action);
        b.setActionCommand(""+getComponentCount());
        setBounds(0,0,getWidth(),getComponentCount()*25);
    }




    public int getChoix(){
        /** /!\ le premier composant n'a pas 0 comme action */
        return choix;
    }



    public JScrollPane getView() {
        return view;
    }






}
