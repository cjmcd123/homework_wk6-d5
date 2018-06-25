import java.util.ArrayList;

public class ConferenceRoom extends Room {

    private int capacity;
    private int dailyRate;
    private int bookedDays;

    public ConferenceRoom(int capacity, int dailyRate) {
        this.capacity = capacity;
        this.dailyRate = dailyRate;
        this.bookedDays = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int guestCount() {
        return super.guestCount();
    }

    public int getBooking() {
        return bookedDays;
    }

    public void setBooking(int bookedDays) {
        this.bookedDays = bookedDays;
    }
}
