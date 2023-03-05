package infrastructure;


public class Tile {

    /**
     * The number of the tile
     */
    private int number;

    /**
     * list of possible values:
     * <ul>
     *     <li>0 - Desert</li>
     *     <li>1 - Wood</li>
     *     <li>2 - Wool</li>
     *     <li>3 - Stone</li>
     *     <li>4 - Clay</li>
     *     <li>5 - Wheat</li></ul>
     */
    private int type;
    private final Corner[] corners;
    private final Location baseLocation;
    private int numberOfSettlements;
    private final int MAX_NUM_OF_SETTLEMENTS =6;

    /**
     * <p>
     * Sets the base location of the tile.<br>
     * if used {@link Tile#setType(int)} and {@link Tile#setNumber(int)} must be called later.
     * </p>
     * @param baseLocation the location of the lowest corner of the tile.
     */
    public  Tile(Location baseLocation)  {
        this.baseLocation = baseLocation;
        this.type = -1;
        this.number = 0;
        this.numberOfSettlements =0;
        this.corners = new Corner[6];
    }


    /**
     * The same as {@link Tile#Tile(Location)} but without the need to set the number ond type of the tile afterwards
     * @param baseLocation the location of the lowest corner of the tile.
     * @param type The type of resource associated with this tile.
     * @param number The dice value associated with this tile.
     */
    public Tile(Location baseLocation, int type, int number) {
        this(baseLocation);
        setType(type);
        setNumber(number);
    }

    public Corner[] getSettlements(){
        return this.corners;
    }

    public int getNumber(){
        return  this.number;
    }

    public int getType(){
        return this.type;
    }
    public Location getLocation(){return baseLocation;}

    /**
     * add a new corner to the array of this tile, is called by todo: add link to method in Corner
     * @param corner a reference to the corner to add
     * @return true if the corner was added successfully else false.
     */
    public boolean addSettlement(Corner corner){
        if (this.numberOfSettlements >= this.MAX_NUM_OF_SETTLEMENTS)
            return false;
        this.corners[this.numberOfSettlements] = corner;
        this.numberOfSettlements++;
        return true;
    }

    public boolean setType(int type){
        if (type <0 || type >5){
            System.err.println("value of type out of bounds");
            return false;
        }

        this.type = type;
        return true;
    }

    public boolean setNumber(int number){
        if (number <=1 || number >12){
            System.err.println("value of number out of bounds");
            return false;
        }
        this.number =number;
        return true;
    }

    /**
     * Check if this tile should produce resources or not, if so that's what it does
     * @param number The number of the tiles that needs to produce resources
     * @return true if the tile produced, else false
     */
    public boolean produce(int number){
        if (number!=this.number)
            return false;
        produce();
        return true;
    }

    /**
     * produces resources in all the corners of this tile
     */
    private void produce(){
        for (Corner corner : this.corners){
           corner.produce(this.type);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return baseLocation.equals(tile.baseLocation);
    }

    @Override
    public int hashCode() {
        return baseLocation.hashCode();
    }
}
