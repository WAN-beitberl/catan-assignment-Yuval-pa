package infrastructure;


public class Location {
    private final int xCor;
    private final int yCor;

/**
 * A class that is used by every item to and stores its location on the map
 * @param xCor the row number in the board.
 * @param yCor the column number in the board.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (xCor != location.xCor) return false;
        return yCor == location.yCor;
    }

    @Override
    public int hashCode() {
        int result = xCor;
        result = 31 * result + yCor;
        return result;
    }

}
