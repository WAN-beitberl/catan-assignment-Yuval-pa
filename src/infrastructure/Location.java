package infrastructure;

public class Location {
    private final int xCor;
    private final int yCor;

/**
 * A class that is used by every item to and stores its location on the map
 * @param xCor the x-axis.
 * @param yCor the y-axis.
 */
    public Location(int xCor, int yCor){
        this.xCor= xCor;
        this.yCor=yCor;
    }
    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }
}
