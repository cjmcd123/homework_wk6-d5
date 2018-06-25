import java.util.ArrayList;

public class Bedroom extends Room {


    private final BedroomType type;
    private int roomNum;
    private int nightlyRate;
    private int bookedNights;

    public Bedroom(BedroomType type, int roomNum, int nightlyRate, ArrayList<Guest> guests) {
        super(guests);
        this.type = type;
        this.roomNum = roomNum;
        this.nightlyRate = nightlyRate;
        this.bookedNights = 0;
    }

    public int capacity(){
        return this.type.getCapacity();
    }

    public int getRoomNum() {
        return roomNum;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int guestCount() {
        return super.guestCount();
    }

    public int getBooking() {
        return bookedNights;
    }

    public void setBooking(int bookedNights) {
        this.bookedNights = bookedNights;
    }
}
