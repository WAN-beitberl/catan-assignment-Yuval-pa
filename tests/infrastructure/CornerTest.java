package infrastructure;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornerTest {
    private Corner s;

    @BeforeAll
    static void superSetup(){
        TileManager.initTiles();
        CornerManager.createCorners();
    }
    @BeforeEach
    void setup() {
        s = new Corner(new Location(0, 0));
    }

    @Test
    void CantUpgradeFromEmpty() {
        s.upgrade(1);
        assertNotEquals(BuildingType.CITY, s.getStatus());
    }

    @Test
    void upgradeToCity() {
        s.build(1);
        s.upgrade(1);
        assertEquals(BuildingType.CITY, s.getStatus());
    }

    @Test
    void cantUpgradeASettlementOfADifferentPlayer() {
        s.build(1);
        assertFalse(s.upgrade(2));
    }

    @Test
    void upgradeFromCity() {
        Corner s = new Corner(new Location(0, 0));
        s.build(1);
        s.upgrade(1);
        assertFalse(s.upgrade(1));
    }

    @Test
    void equalsShouldReturnFalseIfPosIsDifferent() {
        var s1 = new Corner(new Location(7, 2));
        var p = new Corner(new Location(7, 3));
        assertNotEquals(s1, p);
    }

    @Test
    void equalsShouldReturnTrueIfSettlementsAreTheSame() {
        var s1 = new Corner(new Location(7, 3));
        var p = new Corner(new Location(7, 3));
        assertEquals(s1, p);
    }

    @Test
    void AddEdge() {
        var path = new Path(s);
        assertTrue(s.addEdge(path));
        assertTrue(s.addEdge(path));
        assertFalse(s.addEdge(path));
    }

    @Test
    void buildFromEmptyShouldReturnTrue() {
        var c = new Corner(new Location(1, 1));
        assertTrue(c.build(1));
    }

    private boolean isTileInArray(Tile @NotNull [] tiles, Tile target){
        for (Tile tile : tiles) {
            if (tile != null)
                if (tile.equals(target))
                    return true;
        }
        return false;
    }
    @Test
    void addTilesOddLower(){
        var validCorner = new Corner(new Location(7,2));
        var tiles = validCorner.getTiles();
       assertTrue(isTileInArray(tiles,new Tile(new Location(8,1))));
       assertTrue(isTileInArray(tiles, new Tile(new Location(8,2))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(10,1))));

        var inValidCorner = new Corner(new Location(9,6));
        assertEquals(0, inValidCorner.getNumOfTiles(), "a fake location cant have tiles");

        var validButMissingOneTile = new Corner(new Location(11,3));
        tiles = validButMissingOneTile.getTiles();

        assertTrue(isTileInArray(tiles, new Tile(new Location(12,2))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(12,3))));
        assertFalse(isTileInArray(tiles, new Tile(new Location(14,1))));
    }

    @Test
    void addTilesEvenLower(){
        var validCorner = new Corner(new Location(8,3));
        var tiles = validCorner.getTiles();
        assertTrue(isTileInArray(tiles,new Tile(new Location(8,3))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(10,2))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(10,3))));

        var inValidCorner = new Corner(new Location(12,4));
        assertEquals(0, inValidCorner.getNumOfTiles(), "a fake location cant have tiles");

        var validButMissingOneTile = new Corner(new Location(10,4));
        tiles = validButMissingOneTile.getTiles();

        assertTrue(isTileInArray(tiles, new Tile(new Location(12,3))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(10,4))));
        assertFalse(isTileInArray(tiles, new Tile(new Location(12,4))));
    }

    @Test
    void addTilesOddUpper(){
        var validCorner = new Corner(new Location(5,3));
        var tiles = validCorner.getTiles();
        assertTrue(isTileInArray(tiles,new Tile(new Location(6,3))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(6,4))));
        assertTrue(isTileInArray(tiles, new Tile(new Location(8,3))));

        assertEquals(0, s.getNumOfTiles(), "a fake location cant have tiles");

        var validButMissingTiles = new Corner(new Location(1,1));
        tiles = validButMissingTiles.getTiles();

        assertTrue(isTileInArray(tiles, new Tile(new Location(4,2))));
        assertFalse(isTileInArray(tiles, new Tile(new Location(2,1))));
        assertFalse(isTileInArray(tiles, new Tile(new Location(2,2))));
    }
}