package SAE.graphics.screen_component;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Parameter;
import java.net.NetworkInterface;

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

        //this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(new JLabel(str));
        //setSize(this.getWidth(),getComponentCount()*25);
        //System.out.println("new log added : " + str);
        revalidate();
        JScrollBar bar= view.getVerticalScrollBar();
        //fixme bug de scrollBar
        bar.setValue(bar.getMaximum());
        view.revalidate();
    }


    public void clear(){
        removeAll();
        //setSize(this.getWidth(),getComponentCount()*25);
        System.out.println("component free");
        revalidate();
    }
    public JScrollPane getView() {
        return view;
    }
}
