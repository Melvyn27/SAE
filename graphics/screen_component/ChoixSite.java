package SAE.graphics.screen_component;

import SAE.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixSite extends JPanel implements ActionListener {
    int x=0;
    int y=0;
    int width =10;
    int height =10;


    int choix;
    ButtonGroup buttons=new ButtonGroup();
    JScrollPane view=new JScrollPane(this);

    public ChoixSite(){
        init();
    }

    public ChoixSite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        init();
    }

    void init(){
        view.setBounds(x,y,width,height);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBounds(0,0,width,1000);
        addChoix("first");
        addChoix("second");

    }

    public void addChoix(String name){
        JRadioButton b=new JRadioButton(name);
        buttons.add(b);
        add(b);
        b.addActionListener(this);
        b.setActionCommand(""+getComponentCount());
        setBounds(0,0,width,getComponentCount()*25);

    }
    public void updateLocation(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        view.setBounds(x,y,width,height);
    }
    public int getChoix(){
        return choix;
    }



    public void setWidth(int width){
        this.width=width;
        view.setBounds(x,y,width,height);
    }
    public void setHeight(int height){
        this.height=height;
        view.setBounds(x,y,width,height);
    }

    public JScrollPane getView() {
        return view;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        choix=Integer.parseInt(cmd)-1;


        System.out.println(choix);
    }



}
