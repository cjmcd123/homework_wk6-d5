import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom1;

    @Before
    public void  setUp(){
        conferenceRoom1 = new ConferenceRoom(12, 25, new ArrayList<Guest>());
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(12, conferenceRoom1.capacity());
    }

    @Test
    public void roomHasDailyRate(){
        assertEquals(25, conferenceRoom1.getDailyRate());
    }

    @Test
    public void setDailyRate(){
        conferenceRoom1.setDailyRate(50);
        assertEquals(50, conferenceRoom1.getDailyRate());
    }

    @Test
    public void roomStartsEmpty(){
        assertEquals(0, conferenceRoom1.guestCount());
    }

}
