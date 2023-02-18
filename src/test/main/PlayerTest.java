package main;

import infrastructure.Corner;
import infrastructure.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void afterAddSettlementTheSettlementShouldBeAddedToTheArray(){
        var p = new Player("test","test");
        var s = new Corner(new Location(1,2));
        var loc = s.getLocation();
        p.addSettlement(loc.get_xCor(), loc.get_yCor()); // todo make more efficient
        assertTrue(p.getSettlements().contains(s));
    }

    @Test
    void addPathReturnFalseIfThePathDoseNotStartOnOneOfThePlayersSettlements(){
        var pl = new Player("test","test");
        var s1 = new Corner(new Location(2,8));
        pl.addSettlement(1,8);
        assertFalse(pl.addPath(s1));
    }
    @Test
    void addPathDoseNotHaveDuplicities(){
        var pl = new Player("test","test");
        var s1 = new Corner(new Location(8,2));
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,8);
        assertFalse(pl.addPath(s1,1,8));
    }
    @Test
    void addPathShouldReturnTrue(){
        var pl = new Player("test","test");
        var s1 = new Corner(new Location(8,2));
        pl.addSettlement(8,2);
        pl.addPath(s1, 1,5);
        assertTrue(pl.addPath(s1,1,6));
    }
}