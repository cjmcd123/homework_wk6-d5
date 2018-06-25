import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom1;

    @Before
    public void setUp(){
        diningRoom1 = new DiningRoom(100, new ArrayList<Guest>());
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(100, diningRoom1.capacity());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(0, diningRoom1.guestCount());
    }

}
