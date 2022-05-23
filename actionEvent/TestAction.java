package SAE.actionEvent;

import SAE.graphics2.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestAction extends AbstractAction {

    Screen target;

    public TestAction(Screen target){
        this.target=target;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        target.getLog().addLine("");
    }
}
