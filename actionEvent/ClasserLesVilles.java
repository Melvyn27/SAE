package SAE.actionEvent;

import SAE.graphics2.Screen;
import SAE.graphics2.format.LogFormat;
import SAE.map.Carte;
import SAE.map.Site;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClasserLesVilles extends AbstractAction {

    Screen screen;

    public ClasserLesVilles(Screen target) {
        this.screen = target;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Carte carte = screen.getCarte();

        screen.getLog().addLine("liste des villes:");
        for (Site s : carte.getSites()) {
            if (s.getType() == 'V') screen.getLog().addLine(s);
        }
        screen.getLog().addLine(" ");
        screen.getLog().addLine("liste des centres de loisir:");
        for (Site s : carte.getSites()) {
            if (s.getType() == 'L') screen.getLog().addLine(s);
        }
        screen.getLog().addLine(" ");
        screen.getLog().addLine("liste des restaurant:");
        for (Site s : carte.getSites()) {
            if (s.getType() == 'R') screen.getLog().addLine(s);
        }
        screen.getLog().addLine(" ");
    }
}
