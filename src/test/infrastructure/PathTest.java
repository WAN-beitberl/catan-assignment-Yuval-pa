package infrastructure;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PathTest {
    @Test
    void constructorCantHaveLessThen4ParametersInLocationArray() {
        int[] location = new int[]{1, 2, 3};
        assertThrows(Exception.class, () -> new Path(location, "test"));

    }

    @Test
    void constructorDoseNotThrowExceptionWithFourParameters() {
        int[] location = new int[]{1, 3, 2, 4};
        assertDoesNotThrow(() -> {
            new Path(location, "test");
        });

    }

    @Test
    void equalsShouldReturnFalseIfItGetsNonPathObject(){
        Corner s = new Corner(new Location(1,1));
        int[] location = new int[]{1,2,3, 4};
        Path p = new Path(location, "test");
        assertFalse(p.equals(s));
    }
    @Test
    void equalsShouldReturnFalseIfPosToIsDifferent(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,2,8, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "test");
        assertNotEquals(p, s);
    }
    @Test
    void equalsShouldReturnFalseIfPosIsDifferent(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,5,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "test");
        assertNotEquals(p, s);
    }
    @Test
    void equalsShouldReturnFalseIfPlayerIdIsDifferent(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,2,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "notTest");
        p.playerId = 4;
        assertNotEquals(p, s);
    }
    @Test
    void equalsShouldReturnTrueIfPathsAreTheSame(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,2,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "test");
        assertEquals(p, s);
    }
}