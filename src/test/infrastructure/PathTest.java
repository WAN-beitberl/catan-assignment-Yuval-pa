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
}