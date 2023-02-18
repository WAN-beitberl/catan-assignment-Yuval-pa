package infrastructure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    private static HashMap<Location, Tile> prevMap;

    @BeforeAll
    static void setup() {
        prevMap = Tile.getLocationTileHashMapForTest();
        Tile.setLocationTileHashMapForTest(new HashMap<>());
    }

    @Test
    void baseConstructorWorksFine() {
       var loc = new Location(0,0);
        assertDoesNotThrow(()-> new Tile(loc), "add new location OK");
        assertThrows(IOException.class, ()->new Tile(loc),"This base location already exist");
    }

    @Test
    void getInstanceOfLocation() {
        var loc1 = new Location(0, 0);
        assertNull(Tile.getInstanceOfLocation(loc1), "fake location should return no instance");
        Tile t1;
        try {
             t1 = new Tile(loc1);
            var inst = Tile.getInstanceOfLocation(loc1);
            assertNotNull(inst,"should return an instance");
            assertEquals(t1, inst);
        }
        catch (Exception e){
            System.err.println("error creating tile");
        }

    }

    @Test
    void setType() {
        Tile t1;
        Location loc1 = new Location(0,0);
        try {
            t1 = new Tile(loc1);
            assertFalse(t1.setType(6));
            assertFalse(t1.setType(-1));
            assertTrue(t1.setType(4));
        }
        catch (Exception e){
            System.err.println("error creating tile");
        }
    }

    @Test
    void setNumber() {
        Tile t1;
        Location loc1 = new Location(0,0);
        try {
            t1 = new Tile(loc1);
            assertFalse(t1.setNumber(1));
            assertFalse(t1.setNumber(13));
            assertTrue(t1.setNumber(6));
        }
        catch (Exception e){
            System.err.println("error creating tile");
        }
    }

    @Test
    void cadAddSettlementsSuccessfully(){
        Tile t1;
        Settlement settlement = new Settlement(0,0,"test");
        Location loc1 = new Location(0,0);
        try {
            t1 = new Tile(loc1);
            assertTrue(t1.addSettlement(settlement), "one");
            assertTrue(t1.addSettlement(settlement), "two");
            assertTrue(t1.addSettlement(settlement), "three");
            assertTrue(t1.addSettlement(settlement), "four");
            assertTrue(t1.addSettlement(settlement),"five");
            assertTrue(t1.addSettlement(settlement),"six");
            assertFalse(t1.addSettlement(settlement),"seven");
        }
        catch (Exception e){
            System.err.println("error creating tile");
        }
    }
    @AfterAll
    static void cleanup(){
        Tile.setLocationTileHashMapForTest(prevMap);
        prevMap.clear();
    }
}