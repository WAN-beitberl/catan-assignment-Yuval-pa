package main;

import infrastructure.Settlement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void afterAddSettlementTheSettlementShouldBeAddedToTheArray(){
        var p = new Player("test","test");
        var s = new Settlement(1,2,"test");
        var loc = s.getLocation();
        p.addSettlement(loc[0],loc[1]);
        assertTrue(p.getSettlements().contains(s));
    }
}