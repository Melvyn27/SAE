package SAE.graphics.screen_component;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    int x=0;
    int y=0;
    int width =10;
    int height =10;
    int length=0;
    JScrollPane view;


    public Log() {
        init();
    }

    public Log(int x, int y) {
        this.x = x;
        this.y = y;
        init();
    }

    public Log(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        init();
    }
    void init(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        view = new JScrollPane(this);
        setBounds(0,0,this.getWidth(),0);
        view.setBounds(x,y,width,height);

    }
    public void addLine(String str){
        add(new JLabel(str));
        setSize(width,getComponentCount()*25);
    }
    public void updateLocation(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        view.setBounds(x,y,width,height);
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
}
