package SAE.graphics2.screenComponent;

import SAE.graphics2.format.DisplayStyle;
import SAE.graphics2.Screen;
import SAE.map.Carte;
import SAE.map.Point;
import SAE.map.Route;
import SAE.map.Site;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.security.cert.PolicyNode;

import static SAE.graphics2.format.DisplayStyle.*;

public class GraphPanel extends JPanel implements MouseListener,MouseMotionListener {
    Carte carte;
    JScrollPane view=new JScrollPane();
    DisplayStyle style = Reduce;
    public boolean modeDaltonien=false;

    /**
     * affich les information relative a un site ou une route
     */
    JWindow info;

    Graphics2D displayGraphics;
    Screen screen;


    int pointSize=10;

    public GraphPanel(Screen screen){
        this.screen=screen;
        carte = screen.getCarte();
        addMouseListener(this);
        addMouseMotionListener(this);
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
        if(style!= Only_Sites)
        for(Route r:carte.getRoute()){
            drawRoute(r);
        }

    }
    void drawSites(){
        if(style!= Only_Roads)
        for(Site s:carte.getSites()){
            drawSite(s);
        }

    }


    void drawSite(Site s){
        if(s.isSelectionné()) {

            Point p = s.getCoordonnée();
            int x = (int) ((p.getX() / 100.0) * this.getWidth());
            int y = (int) ((p.getY() / 100.0) * this.getHeight());


            if(!modeDaltonien) {
                int size = pointSize;
                if (s.getType() == 'V') displayGraphics.setColor(Color.red.darker());
                if (s.getType() == 'L') displayGraphics.setColor(Color.pink.darker());
                if (s.getType() == 'R') displayGraphics.setColor(Color.yellow.darker());
                if (s.isRechercher()){
                    size*=2;
                    displayGraphics.setColor(Color.lightGray);
                }


                displayGraphics.setStroke(new BasicStroke(1));
                displayGraphics.fillOval(x-size/2, y-size/2, size, size);
                displayGraphics.setColor(Color.black);
                displayGraphics.drawOval(x-size/2, y-size/2, size, size);

            }else{
                displayGraphics.setStroke(new BasicStroke(1));
                displayGraphics.setColor(Color.lightGray);
                int size = pointSize;
                if (s.isRechercher())size*=2;
                    if (s.getType() == 'V') displayGraphics.fillOval(x-size/2, y-size/2, size, size);
                    if (s.getType() == 'L') displayGraphics.fill(drawTriangle(x, y, size));
                    if (s.getType() == 'R') displayGraphics.fill(new Rectangle(x-size/2, y-size/2, size, size));



            }
        }else if(style== All){
            Point p = s.getCoordonnée();
            int x = (int) ((p.getX() / 100.0) * this.getWidth()) - pointSize / 4;
            int y = (int) ((p.getY() / 100.0) * this.getHeight()) - pointSize / 4;
            displayGraphics.setColor(Color.black);

            displayGraphics.setStroke(new BasicStroke(1));
            displayGraphics.fillOval(x, y, pointSize/2, pointSize/2);

        }

    }
    void drawRoute(Route r){
        if (carte.sites.get(r.getSource()).isSelectionné() && carte.sites.get(r.getDestination()).isSelectionné()) {

            Point p1 = carte.sites.get(r.getSource()).getCoordonnée();
            Point p2 = carte.sites.get(r.getDestination()).getCoordonnée();

            int x1 = (int) ((p1.getX() / 100.0) * this.getWidth());
            int y1 = (int) ((p1.getY() / 100.0) * this.getHeight());
            int x2 = (int) ((p2.getX() / 100.0) * this.getWidth());
            int y2 = (int) ((p2.getY() / 100.0) * this.getHeight());

            if (r.getType() == 'A') displayGraphics.setColor(Color.blue.darker());
            if (r.getType() == 'N') displayGraphics.setColor(Color.yellow.darker());
            if (r.getType() == 'D') displayGraphics.setColor(Color.pink.darker());

            displayGraphics.setStroke(new BasicStroke(2));
            displayGraphics.drawLine(x1, y1, x2, y2);
        }else if(style==All){
            Point p1 = carte.sites.get(r.getSource()).getCoordonnée();
            Point p2 = carte.sites.get(r.getDestination()).getCoordonnée();

            int x1 = (int) ((p1.getX() / 100.0) * this.getWidth());
            int y1 = (int) ((p1.getY() / 100.0) * this.getHeight());
            int x2 = (int) ((p2.getX() / 100.0) * this.getWidth());
            int y2 = (int) ((p2.getY() / 100.0) * this.getHeight());
            displayGraphics.setColor(Color.black);
            displayGraphics.setStroke(new BasicStroke(1));
            displayGraphics.drawLine(x1, y1, x2, y2);
        }

    }


    private Polygon drawTriangle(int xOrigin,int yOrigin, int size){
        Polygon triangle;

        int x1=(int)(Math.cos(0)*size/2)+xOrigin;
        int y1=(int)(Math.sin(0)*size/2)+yOrigin;
        int x2=(int)(Math.cos(2*Math.PI/3f)*size/2)+xOrigin;
        int y2=(int)(Math.sin(2*Math.PI/3f)*size/2)+yOrigin;
        int x3=(int)(Math.cos(4*Math.PI/3f)*size/2)+xOrigin;
        int y3=(int)(Math.sin(4*Math.PI/3f)*size/2)+yOrigin;

        triangle=new Polygon(new int[]{x1, x2, x3},new int[]{y1, y2, y3},3);
        return triangle;
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


    @Override
    public void mouseClicked(MouseEvent e) {
        if(info != null)info.dispose();
        boolean isDisplayable = false;
        info = new JWindow();
        JPanel p = new JPanel();
        p.setBorder(new LineBorder(Color.gray));
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        info.add(p);

        for(Site s:carte.getSites()){
            if(s.isSelectionné()) {
                if (Point2D.distance(e.getX() * 100f / this.getWidth(), e.getY() * 100f / this.getHeight(), s.coordonnée.getX(), s.coordonnée.getY()) < pointSize/4f){
                    JLabel l = new JLabel(s.getNom());
                    p.add(l);
                    for(Route r:s.getRoutes()){
                        l = new JLabel("    vers "+r.getDestination()+" à "+r.getLongueur()+"km, type: "+r.getType());
                        p.add(l);
                    }
                    isDisplayable=true;
                    break;
                }
            }
        }
        if(!isDisplayable)
            for(Route r:carte.getRoute()){
                if(carte.sites.get(r.getSource()).isSelectionné() && carte.sites.get(r.getDestination()).isSelectionné()) {
                    if (Line2D.ptSegDist(carte.sites.get(r.getSource()).coordonnée.getX(), carte.sites.get(r.getSource()).coordonnée.getY(), carte.sites.get(r.getDestination()).coordonnée.getX(), carte.sites.get(r.getDestination()).coordonnée.getY(), e.getX() * 100f / this.getWidth(), e.getY() * 100f / this.getHeight()) <= 1) {
                        JLabel l;
                        l = new JLabel("de "+r.getSource()+" vers "+r.getDestination()+" à "+r.getLongueur()+"km, type: "+r.getType());
                        p.add(l);
                        isDisplayable=true;
                    }
                }
            }

        if(isDisplayable){//affiche le panneau d'information
            info.pack();
            info.setLocation((int)MouseInfo.getPointerInfo().getLocation().getX(),(int)MouseInfo.getPointerInfo().getLocation().getY());
            info.setVisible(true);
        }
    }


    boolean mouseIsPressed=false;
    Site selectedSiteToMove = null;

    @Override
    public void mousePressed(MouseEvent e) {
        //init
        if(info != null)info.dispose();
        selectedSiteToMove=null;
        mouseIsPressed =true;


        for(Site s:carte.getSites()){
            if(s.isSelectionné()) {
                if (Point2D.distance(e.getX() * 100f / getWidth(), e.getY() * 100f / getHeight(), s.coordonnée.getX(), s.coordonnée.getY()) < pointSize/4f){
                    selectedSiteToMove=s;
                    break;
                }
            }
        }


/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(!mouseIsPressed)return;
                System.out.println("press");
                Site site=null;
                for(Site s:carte.getSites()){
                    if(s.isSelectionné()) {
                        if (Point2D.distance(e.getX() * 100f / getWidth(), e.getY() * 100f / getHeight(), s.coordonnée.getX(), s.coordonnée.getY()) < pointSize/4f){
                            site=s;
                            System.out.println("find");
                            break;
                        }
                    }
                }

                if(site!=null) {
                    while (mouseIsPressed) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("move");
                        site.coordonnée.setX(MouseInfo.getPointerInfo().getLocation().x*100/getWidth());
                        site.coordonnée.setY(MouseInfo.getPointerInfo().getLocation().y*100/getHeight());
                        repaint();
                    }
                }
            }
        }).start();

*/
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseIsPressed =false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(mouseIsPressed && selectedSiteToMove!=null){
            selectedSiteToMove.coordonnée.setX(e.getX()*100/getWidth());
            selectedSiteToMove.coordonnée.setY(e.getY()*100/getHeight());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
