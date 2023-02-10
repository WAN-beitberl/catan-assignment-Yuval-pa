package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void incrementCantByLowerThenOne() {
        var p = new Player("test","red");
        assertFalse(p.incrementNumberOfWinPoints(0));
    }
    @Test
    void incrementCantByBiggerThenTwo() {
        var p = new Player("test","red");
        assertFalse(p.incrementNumberOfWinPoints(3));
    }
    @Test
    void incrementIsOneOrTwo() {
        var p = new Player("test","red");
        assertTrue(p.incrementNumberOfWinPoints(1));
        assertTrue(p.incrementNumberOfWinPoints(2));
    }
}