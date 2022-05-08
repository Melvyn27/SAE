package SAE.graphics.screen_component;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    JScrollPane view;


    public Log() {
        init();
    }




    void init(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        view = new JScrollPane(this);


    }
    public void addLine(String str){
        //fixme affichage a refaire
        //this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(new JLabel(str));
        //setSize(this.getWidth(),getComponentCount()*25);
        System.out.println("new log added : " + str);
        JScrollBar bar= view.getVerticalScrollBar();
        bar.setValue(bar.getMaximum());

    }
    public void clear(){
        removeAll();
        //setSize(this.getWidth(),getComponentCount()*25);
        System.out.println("component free");
    }




    public JScrollPane getView() {
        return view;
    }
}
