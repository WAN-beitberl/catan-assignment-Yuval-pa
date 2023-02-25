package infrastructure;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {


	@BeforeAll
	static void setup() {
		TileManager.initTiles();
	}

	@Test
	void setType() {
		Location loc1 = new Location(0, 0);
		Tile t1 =new Tile(loc1);
		assertFalse(t1.setType(6));
		assertFalse(t1.setType(-1));
		assertTrue(t1.setType(4));
	}

	@Test
	void setNumber() {
		Location loc1 = new Location(0, 0);
		Tile t1= new Tile(loc1);
		assertFalse(t1.setNumber(1));
		assertFalse(t1.setNumber(13));
		assertTrue(t1.setNumber(6));
	}

	@Test
	void cadAddSettlementsSuccessfully() {
		Corner corner = new Corner(new Location(0, 0));
		Location loc1 = new Location(0, 0);
		Tile t1 = new Tile(loc1);
		assertTrue(t1.addSettlement(corner), "one");
		assertTrue(t1.addSettlement(corner), "two");
		assertTrue(t1.addSettlement(corner), "three");
		assertTrue(t1.addSettlement(corner), "four");
		assertTrue(t1.addSettlement(corner), "five");
		assertTrue(t1.addSettlement(corner), "six");
		assertFalse(t1.addSettlement(corner), "seven");
	}

}