import java.util.ArrayList;

public class DiningRoom extends Room {

    private int capacity;

    public DiningRoom(int capacity, ArrayList<Guest> guests) {
        super(guests);
        this.capacity = capacity;
    }

    public int capacity() {
        return capacity;
    }

    public int guestCount() {
        return super.guestCount();
    }
}
