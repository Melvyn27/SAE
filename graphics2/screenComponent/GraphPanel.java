package SAE.graphics2.screenComponent;

import SAE.graphics2.format.DisplayStyle;
import SAE.graphics2.Screen;
import SAE.map.Carte;
import SAE.map.Point;
import SAE.map.Route;
import SAE.map.Site;

import javax.swing.*;

import java.awt.*;

import static SAE.graphics2.format.DisplayStyle.All;

public class GraphPanel extends JPanel {
    Carte carte;
    JScrollPane view=new JScrollPane();
    DisplayStyle style = All;

    Graphics2D displayGraphics;
    Screen screen;


    int pointSize=11;

    //todo créer les fonctions de dessin
    //todo créer plusieur style d'affichage
    public GraphPanel(Screen screen){
        this.screen=screen;
        carte = screen.getCarte();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        displayGraphics=(Graphics2D) g;
        carte = screen.getCarte();
        if(carte!=null)draw();
    }

    public void draw(){

        drawRoutes();
        drawSites();

    }
    void drawRoutes(){
        for(Route r:carte.getRoute()){
            drawRoute(r);
        }

    }
    void drawSites(){

        for(Site s:carte.getSites()){
            drawSite(s);
        }

    }


    void drawSite(Site s){
        if(s.isSelectionné()) {


            Point p = s.getCoordonnée();
            int x = (int) ((p.getX() / 100.0) * this.getWidth()) - pointSize / 2;
            int y = (int) ((p.getY() / 100.0) * this.getHeight()) - pointSize / 2;

            if (s.getType() == 'V') displayGraphics.setColor(Color.red);
            if (s.getType() == 'L') displayGraphics.setColor(Color.GREEN);
            if (s.getType() == 'R') displayGraphics.setColor(Color.blue);
            if (s.isRechercher()) displayGraphics.setColor(Color.gray);

            displayGraphics.setStroke(new BasicStroke(1));
            displayGraphics.fillOval(x, y, pointSize, pointSize);
        }
    }
    void drawRoute(Route r){
        if(carte.sites.get(r.getSource()).isSelectionné() && carte.sites.get(r.getDestination()).isSelectionné()) {

            Point p1 = carte.sites.get(r.getSource()).getCoordonnée();
            Point p2 = carte.sites.get(r.getDestination()).getCoordonnée();

            int x1 = (int) ((p1.getX() / 100.0) * this.getWidth());
            int y1 = (int) ((p1.getY() / 100.0) * this.getHeight());
            int x2 = (int) ((p2.getX() / 100.0) * this.getWidth());
            int y2 = (int) ((p2.getY() / 100.0) * this.getHeight());

            if (r.getType() == 'A') displayGraphics.setColor(Color.red);
            if (r.getType() == 'N') displayGraphics.setColor(Color.GREEN);
            if (r.getType() == 'D') displayGraphics.setColor(Color.blue);

            displayGraphics.setStroke(new BasicStroke(3));
            displayGraphics.drawLine(x1, y1, x2, y2);
        }
    }



    public void setStyle(DisplayStyle style) {
        this.style = style;
    }

    public void setPointSize(int pointSize) {
        this.pointSize = pointSize;
    }

    public JScrollPane getView() {
        return view;
    }
}
