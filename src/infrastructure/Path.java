package infrastructure;

public class Path extends Building {
    private final Location posTo;

    /**
     * Create a new path
     *
     * @param location int[] holding the following values:
     *                 <p>[0]: the X position of origin <br>
     *                 [1]: the Y position of origin<br>
     *                 [2]: the X position of destination<br>
     *                 [3]: the Y position of destination
     *                 </p>
     * @param color    the color of the player
     */
    public Path(int[] location, String color) {
        super(location[0], location[1], color);
        this.posTo = new Location(location[2], location[3]);
    }

    /**
     * checks if two paths are the same
     * @param o a Path type to be compared.
     * @return return true if the two paths are the same, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Path path = (Path) o;

        return posTo.equals(path.posTo);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (posTo != null ? posTo.hashCode() : 0);
        return result;
    }
}
