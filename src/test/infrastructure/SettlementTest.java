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
}