package infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornerTest {

    @Test
    void CantUpgradeFromEmpty() {
        Corner s = new Corner(new Location(0,0));
        s.upgrade();
        assertNotEquals(Corner.CITY, s.isCity());
    }
    @Test
    void upgradeToCity() {
        Corner s = new Corner(new Location(0,0));
        s.build(1);
        s.upgrade();
        assertEquals(Corner.CITY, s.isCity());
    }
    @Test
    void upgradeFromCity(){
        Corner s = new Corner(new Location(0,0));
        s.build(1);
        s.upgrade();
        s.upgrade();
        assertEquals(Corner.CITY, s.isCity());
    }

    @Test
    void equalsShouldReturnFalseIfItGetsNonSettlementObject(){
        var loc1 = new Location(1,1);
        Corner s = new Corner(loc1);
        int[] location = new int[]{1,2,3, 4};
        Path p = new Path(location, "test");
        assertFalse(s.equals(p));
    }
    @Test
    void equalsShouldReturnFalseIfPosIsDifferent(){
        var s = new Corner(new Location(7,2));
        var p = new Corner(new Location(7,3));
        assertNotEquals(s, p);
    }
    @Test
    void equalsShouldReturnFalseIfPlayerIdIsDifferent(){
        var s = new Corner(new Location(7,3));
        var p = new Corner(new Location(7,3));
        p.playerId = 4;
        assertNotEquals(s, p);
    }
    @Test
    void equalsShouldReturnTrueIfSettlementsAreTheSame(){
        var s = new Corner(new Location(7,3));
        var p = new Corner(new Location(7,3));
        assertEquals(s, p);
    }
    @Test
    void equalsShouldBeTrueWithItself(){
        var s = new Corner(new Location(7,3));
        assertEquals(s, s);
    }

    @Test
    void setToBlockFromEmptyShouldRerunTrue() {
        var s = new Corner(new Location(1,1));
        assertTrue(s.setToBlock());
    }
    @Test
    void setToBlockNotFromEmptyShouldRerunFalse() {
        var s = new Corner(new Location(1,1));
        s.setToBlock();
        assertFalse(s.setToBlock());
    }

    @Test
    void buildFromEmptyShouldReturnTrue(){
        var c = new Corner(new Location(1,1));
        assertTrue(c.build(1));
    }

    @Test
    void buildNotFromEmptyShouldReturnFalse(){
        var loc = new Location(1,1);
        var block = new Corner(loc);
        var settle = new Corner(loc);

        block.setToBlock();
        settle.build(1);

        assertFalse(block.build(1));
        assertFalse(settle.build(1));
    }
}