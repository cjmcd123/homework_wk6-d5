import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public  void  setUp(){
        guest = new Guest("Basil", 100);
    }

    @Test
    public void guestHasName(){
        assertEquals("Basil", guest.getName());
    }

    @Test
    public void guestHasMoney(){
        assertEquals(100, guest.getMoney());
    }

    @Test
    public void canChangeName(){
        guest.setName("Sybil");
        assertEquals("Sybil", guest.getName());
    }

    @Test
    public void canChangeMoney(){
        guest.setMoney(90);
        assertEquals(90, guest.getMoney());
    }

}
