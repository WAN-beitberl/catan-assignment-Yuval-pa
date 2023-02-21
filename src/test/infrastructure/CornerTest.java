package infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornerTest {
    private Corner s;

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
}