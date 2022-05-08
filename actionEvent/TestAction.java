package SAE.actionEvent;

import SAE.graphics.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestAction extends AbstractAction {

    Screen target;

    public TestAction(Screen target){
        this.target=target;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        target.getLog().addLine(target.getChoixSite1().getChoix()+" -> "+target.getChoixSite2().getChoix());


    }
}
