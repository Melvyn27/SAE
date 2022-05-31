package SAE.graphics2.screenComponent.questionComponent;

import SAE.action.PathFindding;
import SAE.graphics2.Screen;

import javax.swing.*;

public class PathPanel extends JPanel {
    Screen screen;

    public PathPanel(Screen screen){
        this.screen=screen;
        JButton b = new JButton("lol");
        b.addActionListener(l->{
            PathFindding p =new PathFindding(screen);
            System.out.println(p.PathFindding("Lyon","Paris"));
        });
        add(b);
    }



}
