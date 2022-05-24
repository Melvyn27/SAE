package SAE.map;

public class Route {

    char type;
    int longueur;
    String destination;
    String source;
    boolean selectionné=true;


    public Route(char type, int longueur, String destination,String source) {
        this.type = type;
        this.longueur = longueur;
        this.destination = destination;
        this.source = source;
    }

    public boolean isSelectionné() {
        return selectionné;
    }

    public void setSelectionné(boolean selectionné) {
        this.selectionné = selectionné;
    }

    public char getType() {
        return type;
    }

    public int getLongueur() {
        return longueur;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }
}
