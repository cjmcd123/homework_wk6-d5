import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom1;

    @Before
    public void setUp(){
        bedroom1 = new Bedroom(BedroomType.SINGLE, 1, 5);
    }

    @Test
    public void roomHasNumber(){
        assertEquals(1, bedroom1.getRoomNum());
    }

    @Test
    public void roomHasRate(){
        assertEquals(5, bedroom1.getNightlyRate());
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(1, bedroom1.capacity());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(0, bedroom1.guestCount());
    }

    @Test
    public void setNightlyRate(){
        bedroom1.setNightlyRate(6);
        assertEquals(6, bedroom1.getNightlyRate());
    }

}
