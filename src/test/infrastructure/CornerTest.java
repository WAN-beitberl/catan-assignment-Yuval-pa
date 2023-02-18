package infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CornerTest {

    @Test
    void upgradeToCity() {
        Corner s = new Corner(0,0,"test");
        s.upgrade();
        assertEquals(1, s.getStatus());
    }
    @Test
    void upgradeFromCity(){
        Corner s = new Corner(0,0,"test");
        s.upgrade();
        s.upgrade();
        assertEquals(1, s.getStatus());
    }

    @Test
    void equalsShouldReturnFalseIfItGetsNonSettlementObject(){
        Corner s = new Corner(1,1,"test");
        int[] location = new int[]{1,2,3, 4};
        Path p = new Path(location, "test");
        assertFalse(s.equals(p));
    }
    @Test
    void equalsShouldReturnFalseIfPosIsDifferent(){
        var s = new Corner(7,2,"test");
        var p = new Corner(7,3, "test");
        assertNotEquals(s, p);
    }
    @Test
    void equalsShouldReturnFalseIfColorIsDifferent(){
        var s = new Corner(7,3,"test");
        var p = new Corner(7,3, "notTest");
        assertNotEquals(s, p);
    }
    @Test
    void equalsShouldReturnTrueIfSettlementsAreTheSame(){
        var s = new Corner(7,3,"test");
        var p = new Corner(7,3, "test");
        assertEquals(s, p);
    }
    @Test
    void equalsShouldBeTrueWithItself(){
        var s = new Corner(1,1,"test");
        assertEquals(s, s);
    }
}