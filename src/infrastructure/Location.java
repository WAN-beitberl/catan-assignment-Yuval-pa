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
    public int get_xCor() {
        return xCor;
    }

    public int get_yCor() {
        return yCor;
    }

    /**
     * checks if two locations are the same
     * @param location the location to be tested
     * @return true if they are the same, else false.
     */
    public boolean equals(Location location){
        return this.xCor == location.get_xCor() && this.yCor == location.get_yCor();
    }
}
