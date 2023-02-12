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

    @Test
    void addPathReturnFalseIfThePathDoseNotStartOnOneOfThePlayersSettlements(){
        var pl = new Player("test","test");
        var s1 = new Settlement(8,2,"test");
        pl.addSettlement(1,8);
        assertFalse(pl.addPath(s1));
    }
    @Test
    void addPathDoseNotHaveDuplicets(){
        var pl = new Player("test","test");
        var s1 = new Settlement(8,2,"test");
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,8);
        assertFalse(pl.addPath(s1,1,8));
    }
    @Test
    void addPathShouldReturnTrue(){
        var pl = new Player("test","test");
        var s1 = new Settlement(8,2,"test");
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,5);
        assertTrue(pl.addPath(s1,1,6));
    }
}