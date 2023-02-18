package infrastructure;


import java.io.IOException;
import java.util.HashMap;

public class Tile {
    private static final HashMap<Location, Tile> locationTileHashMap = new HashMap<>();

    /**
     * get the tile with the given base location
     * @param baseLocation the base location to search
     * @return the instance of the tile with the given base location, if there is no such tile returns null
     */
    public static Tile getInstanceOfLocation(Location baseLocation){
      return locationTileHashMap.get(baseLocation);
    }

    /**
     * <b>This method is for testing only!!!</b>
     * @return a copy of {@link Tile#locationTileHashMap}
     */
    static HashMap<Location, Tile> getLocationTileHashMapForTest(){
        return new HashMap<>(locationTileHashMap);
    }

    /**
     * <b>This method is for testing only!!!</b>
     */
    static void setLocationTileHashMapForTest(HashMap<Location,Tile> map){
        locationTileHashMap.clear();
        locationTileHashMap.putAll(map);
    }

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
    private final Settlement[] settlements;
    private final Location baseLocation;
    private int numberOfSettlements;
    private final int MAX_NUM_OF_SETTLEMENTS =6;

    /**
     * <p>
     * Sets the base location of the tile.<br>
     * if used {@link Tile#setType(int)} and {@link Tile#setNumber(int)} must be called later.
     * </p>
     * @param baseLocation the location of the lowest corner of the tile.
     * @throws java.io.IOException if another tile already has the given base location
     */
    public  Tile(Location baseLocation) throws IOException {
        addToHashMap(baseLocation);
        this.baseLocation = baseLocation;
        this.type = -1;
        this.number = 0;
        this.numberOfSettlements =0;
        this.settlements = new Settlement[6];
    }

    private void addToHashMap(Location baseLocation) throws IOException{
        if (locationTileHashMap.get(baseLocation) != null){
            throw new IOException("This base location already exists");
        }
        locationTileHashMap.put(baseLocation, this);
    }

    /**
     * The same as {@link Tile#Tile(Location)} but without the need to set the number ond type of the tile afterwards
     * @param baseLocation the location of the lowest corner of the tile.
     * @param type The type of resource associated with this tile.
     * @param number The dice value associated with this tile.
     * @throws IOException if there is a tile instance with the given base location
     */
    public Tile(Location baseLocation, int type, int number) throws IOException {
        this(baseLocation);
        setType(type);
        setNumber(number);
    }

    public Settlement[] getSettlements(){
        return this.settlements;
    }

    public int getNumber(){
        return  this.number;
    }

    public int getType(){
        return this.type;
    }

    /**
     * add a new settlement to the array of this tile, is called by todo: add link to method in Settlement
     * @param settlement a reference to the settlement to add
     * @return true if the settlement was added successfully else false.
     */
    public boolean addSettlement(Settlement settlement){
        if (this.numberOfSettlements >= this.MAX_NUM_OF_SETTLEMENTS)
            return false;
        this.settlements[this.numberOfSettlements] = settlement;
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

    /*public void produce(){
        for (Settlement settlement: this.settlements){
            settlement.produce(this.type);
        }
    }*/
}
