import java.util.ArrayList;

public abstract class Room {

    public abstract int capacity();
    private ArrayList<Guest> guests;


    public Room() {
        this.guests = new ArrayList<Guest>();
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public int guestCount(){
        return getGuests().size();
    }

    public void checkIn(Guest guest){
        guests.add(guest);
    };

    public void checkOut(Guest guest){
        guests.remove(guest);
    };

    public void clearRoom() {
        guests.clear();
    }
}
