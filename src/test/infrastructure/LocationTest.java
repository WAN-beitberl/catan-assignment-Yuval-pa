package infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testEquals() {
        Location location1 =new Location(1,2);
        Location location2 = new Location(1,2);
        Location location3 = new Location(5,4);

        assertTrue(location1.equals(location2));
        assertFalse(location1.equals(location3));
        assertTrue(location1.equals(location1));
    }
}