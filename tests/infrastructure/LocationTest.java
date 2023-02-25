package infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testEquals() {
        Location location1 =new Location(1,2);
        Location location2 = new Location(1,2);
        Location location3 = new Location(5,4);

        assertEquals(location1, location2);
        assertNotEquals(location1, location3);
        assertEquals(location1, location1);
    }
}