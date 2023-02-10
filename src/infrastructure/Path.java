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
    public Path(int[] location, String color) throws Exception {
        super(location[0], location[1], color);
        this.posTo = new Location(location[2], location[3]);
    }
}
