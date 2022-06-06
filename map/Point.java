package SAE.map;


/**
 * class de coordonnée
 */
public class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * fais en sorte que le point soit remis au centre si il sort de la zone
     * @param xmin
     * @param ymin
     * @param xmax
     * @param ymax
     */
    public void constrain(int xmin,int ymin,int xmax,int ymax){
        if(x<xmin)x=50;
        if(x>xmax)x=50;
        if(y<ymin)y=50;
        if(y>ymax)y=50;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
