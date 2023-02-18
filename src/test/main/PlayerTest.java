package main;

import infrastructure.Corner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void afterAddSettlementTheSettlementShouldBeAddedToTheArray(){
        var p = new Player("test","test");
        var s = new Corner(1,2,"test");
        var loc = s.getLocation();
        p.addSettlement(loc[0],loc[1]);
        assertTrue(p.getSettlements().contains(s));
    }

    @Test
    void addPathReturnFalseIfThePathDoseNotStartOnOneOfThePlayersSettlements(){
        var pl = new Player("test","test");
        var s1 = new Corner(8,2,"test");
        pl.addSettlement(1,8);
        assertFalse(pl.addPath(s1));
    }
    @Test
    void addPathDoseNotHaveDuplicities(){
        var pl = new Player("test","test");
        var s1 = new Corner(8,2,"test");
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,8);
        assertFalse(pl.addPath(s1,1,8));
    }
    @Test
    void addPathShouldReturnTrue(){
        var pl = new Player("test","test");
        var s1 = new Corner(8,2,"test");
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,5);
        assertTrue(pl.addPath(s1,1,6));
    }
}