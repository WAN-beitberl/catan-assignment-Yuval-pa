package infrastructure;

import java.util.HashMap;

/**
 * a factory and manager class for tiles
 */
public class TileManager {
	private static final HashMap<Location, Tile> allTiles= new HashMap<>();

	public static void initTiles(){
		Location loc;

		loc = new Location(4,2);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(4,3);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(4,4);
		allTiles.put(loc,new Tile(loc));

		loc = new Location(6,2);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(6,3);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(6,4);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(6,5);
		allTiles.put(loc,new Tile(loc));

		loc = new Location(8,1);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(8,2);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(8,3);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(8,4);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(8,5);
		allTiles.put(loc,new Tile(loc));

		loc = new Location(10,1);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(10,2);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(10,3);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(10,4);
		allTiles.put(loc,new Tile(loc));

		loc = new Location(12,1);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(12,2);
		allTiles.put(loc,new Tile(loc));
		loc = new Location(12,3);
		allTiles.put(loc,new Tile(loc));
	}

	/**
	 * get the instance of a specific tile
	 * @param location the base location of the tile
	 * @return the instance of the tile, if it does not exist null.
	 */
	public static Tile getInstance(Location location){
		return allTiles.get(location);
	}

	public static boolean checkIfTileExist(Location location){
		return allTiles.containsKey(location);
	}
}
