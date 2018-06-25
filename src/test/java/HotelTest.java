import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    DiningRoom diningRoom;
    ConferenceRoom conferenceRoom1;
    ConferenceRoom conferenceRoom2;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Bedroom bedroom4;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setUp(){
        diningRoom = new DiningRoom(50);
        conferenceRoom1 = new ConferenceRoom(12, 50);
        conferenceRoom2 = new ConferenceRoom(20, 100);
        bedroom1 = new Bedroom(BedroomType.SINGLE, 1, 20);
        bedroom2 = new Bedroom(BedroomType.DOUBLE, 2, 40);
        bedroom3 = new Bedroom(BedroomType.LARGE, 3, 60);
        bedroom4 = new Bedroom(BedroomType.SUITE, 4, 80);
        ArrayList<Room> listOfRooms = new ArrayList<Room>();
        listOfRooms.add(diningRoom);
        listOfRooms.add(conferenceRoom1);
        listOfRooms.add(conferenceRoom2);
        listOfRooms.add(bedroom1);
        listOfRooms.add(bedroom2);
        listOfRooms.add(bedroom3);
        listOfRooms.add(bedroom4);
        hotel = new Hotel("Codeclan Towers", listOfRooms);
        guest1 = new Guest("Basil Fawlty", 1000);
        guest2 = new Guest("Sybil Fawlty", 100);
        guest3 = new Guest("Manuel", 500);
    }

    @Test
    public void hotelHasName(){
        assertEquals("Codeclan Towers", hotel.getName());
    }

    @Test
    public void hotelCanChangeName(){
        hotel.setName("Fawlty Towers");
        assertEquals("Fawlty Towers", hotel.getName());
    }

    @Test
    public void hotelHasRooms(){
        assertEquals(7, hotel.getRooms().size());
    }

    @Test
    public void guestCanCheckIntoBedroom(){
        hotel.checkIn(bedroom1, guest1);
        assertEquals(1, bedroom1.guestCount());
        assertEquals(980, guest1.getMoney());
    }

    @Test
    public void guestCanCheckIntoConferenceRoom(){
        hotel.checkIn(conferenceRoom1, guest2);
        assertEquals(1, conferenceRoom1.guestCount());
        assertEquals(50, guest2.getMoney());
    }

    @Test
    public void guestCanCheckIntoDiningRoom(){
        hotel.checkIn(diningRoom, guest3);
        assertEquals(1, diningRoom.guestCount());
        assertEquals(500, guest3.getMoney());
    }

    @Test
    public void multipleGuestsCanCheckIntoRoom(){
        hotel.checkIn(bedroom4, guest1);
        hotel.checkIn(bedroom4, guest2);
        assertEquals(2, bedroom4.guestCount());
    }

    @Test
    public void guestCanCheckIntoFullRoom(){
        hotel.checkIn(bedroom1, guest1);
        hotel.checkIn(bedroom1, guest2);
        assertEquals(1, bedroom1.guestCount());
    }

    @Test
    public void guestCanCheckout(){
        hotel.checkIn(bedroom3, guest3);
        hotel.checkOut(bedroom3, guest3);
        assertEquals(0, bedroom3.guestCount());
    }

    @Test
    public void listOfGuestsInRoom(){
        hotel.checkIn(conferenceRoom2, guest1);
        ArrayList guestCount = hotel.guestList(conferenceRoom2);
        assertEquals(1, guestCount.size());
    }

    @Test
    public void checksOutCorrectGuest(){
        hotel.checkIn(conferenceRoom1, guest1);
        hotel.checkIn(conferenceRoom1, guest2);
        hotel.checkOut(conferenceRoom1, guest2);
        Guest remaining = conferenceRoom1.getGuests().get(0);
        assertEquals(guest1, remaining);
    }

    @Test
    public void canClearRoom(){
        hotel.checkIn(bedroom4, guest2);
        hotel.checkIn(bedroom4, guest1);
        hotel.clearRoom(bedroom4);
        assertEquals(0, bedroom4.guestCount());
    }

    @Test
    public void canGetListOfEmptyRooms(){
        hotel.checkIn(bedroom1, guest2);
        hotel.checkIn(conferenceRoom1, guest1);
        hotel.checkIn(diningRoom, guest3);
        ArrayList<Room> listOfEmptyRooms = hotel.emptyRooms();
        assertEquals(4, listOfEmptyRooms.size());
    }

    @Test
    public void canGetListOfOccupiedRooms(){
        hotel.checkIn(bedroom1, guest2);
        hotel.checkIn(conferenceRoom1, guest1);
        hotel.checkIn(diningRoom, guest3);
        ArrayList<Room> listOfEmptyRooms = hotel.occupiedRooms();
        assertEquals(3, listOfEmptyRooms.size());
    }

    @Test
    public void canGetListOfFullRooms(){
        hotel.checkIn(bedroom1, guest2);
        hotel.checkIn(conferenceRoom1, guest1);
        hotel.checkIn(diningRoom, guest3);
        ArrayList<Room> listOfEmptyRooms = hotel.fullRooms();
        assertEquals(1, listOfEmptyRooms.size());
    }

    @Test
    public void guestCanCheckInForMultipleNights(){
        hotel.checkInMultiple(bedroom1, guest1, 3);
        assertEquals(940, guest1.getMoney());
        assertEquals(3, bedroom1.getBooking());
    }

    @Test
    public void guestCanCheckInForMultipleDays(){
        hotel.checkInMultiple(conferenceRoom2, guest1, 3);
        assertEquals(700, guest1.getMoney());
        assertEquals(3, conferenceRoom2.getBooking());
    }
}
