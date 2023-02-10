package infrastructure;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PathTest {
    @Test
    void constructorCantHaveLessThen4ParametersInLocationArray() {
        int[] location = new int[]{1, 2, 3};
        assertThrows(Exception.class, () -> {
            Path p = new Path(location, "test");
        });

    }

    @Test
    void constructorDoseNotThrowExceptionWithFourParameters() {
        int[] location = new int[]{1, 3, 2, 4};
        assertDoesNotThrow(() -> {
            Path p = new Path(location, "test");
        });

    }

    @Test
    void equalsShouldReturnFalseIfItGetsNonPathObject(){
        Settlement s = new Settlement(1,1,"test");
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
        assertFalse(p.equals(s));
    }
    @Test
    void equalsShouldReturnFalseIfPosIsDifferent(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,5,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "test");
        assertFalse(p.equals(s));
    }
    @Test
    void equalsShouldReturnFalseIfColorIsDifferent(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,2,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "notTest");
        assertFalse(p.equals(s));
    }
    @Test
    void equalsShouldReturnTrueIfPathsAreTheSame(){
        int[] locationPath = new int[]{1,2,3, 4};
        int[] locationToCompere = new int[]{1,2,3, 4};

        var s = new Path(locationToCompere,"test");
        var p = new Path(locationPath, "test");
        assertTrue(p.equals(s));
    }
}