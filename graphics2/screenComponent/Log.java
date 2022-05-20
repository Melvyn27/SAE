package SAE.graphics2.screenComponent;

import javax.swing.*;
import java.awt.*;

public class Log extends JPanel {
    JPanel upPanel = new JPanel();
    JPanel downPanel = new JPanel(new FlowLayout());

    JScrollPane view = new JScrollPane(upPanel);



    public Log() {
        init();
    }




    void init(){
        upPanel.setLayout(new BoxLayout(upPanel,BoxLayout.Y_AXIS));
        add(upPanel,BorderLayout.CENTER);
        add(downPanel,BorderLayout.SOUTH);

        JButton clear = new JButton("Clear");
        clear.addActionListener(c->clear());
        downPanel.add(clear);
    }
    public void addLine(String str){
        upPanel.add(new JLabel(str));
        revalidate();
        JScrollBar bar= view.getVerticalScrollBar();
        //fixme bug de scrollBar
        bar.setValue(bar.getMaximum());
        revalidate();
    }


    public void clear(){
        upPanel.removeAll();
        System.out.println("component free");
        revalidate();
    }
    /*public JScrollPane getView() {
        return view;
    }
     */
}
