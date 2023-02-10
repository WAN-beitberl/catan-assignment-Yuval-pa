package infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettlementTest {

    @Test
    void upgradeToCity() {
        Settlement s = new Settlement(0,0,"test");
        s.upgrade();
        assertEquals(1, s.getLevel());
    }
    @Test
    void upgradeFromCity(){
        Settlement s = new Settlement(0,0,"test");
        s.upgrade();
        s.upgrade();
        assertEquals(1, s.getLevel());
    }

    @Test
    void equalsShouldReturnFalseIfItGetsNonSettlementObject(){
        Settlement s = new Settlement(1,1,"test");
        int[] location = new int[]{1,2,3, 4};
        Path p = new Path(location, "test");
        assertFalse(s.equals(p));
    }
    @Test
    void equalsShouldReturnFalseIfPosIsDifferent(){
        var s = new Settlement(7,2,"test");
        var p = new Settlement(7,3, "test");
        assertFalse(s.equals(p));
    }
    @Test
    void equalsShouldReturnFalseIfColorIsDifferent(){
        var s = new Settlement(7,3,"test");
        var p = new Settlement(7,3, "notTest");
        assertFalse(s.equals(p));
    }
    @Test
    void equalsShouldReturnTrueIfSettlementsAreTheSame(){
        var s = new Settlement(7,3,"test");
        var p = new Settlement(7,3, "test");
        assertTrue(s.equals(p));
    }
    @Test
    void equalsShouldBeTrueWithItself(){
        var s = new Settlement(1,1,"test");
        assertTrue(s.equals(s));
    }
}