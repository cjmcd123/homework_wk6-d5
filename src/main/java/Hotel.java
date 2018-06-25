import java.util.ArrayList;
import java.util.BitSet;

public class Hotel {

    private String name;
    private ArrayList<Room> rooms;

    public Hotel(String name, ArrayList<Room> rooms){
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }


    public void checkIn(Room room, Guest guest) {
        if (room.guestCount() < room.capacity()) {
            room.checkIn(guest);
           pay(room, guest, 1);
           booking(room, 1);
        }
    }

    public void pay(Room room, Guest guest, int nightsDays){
        if (room instanceof ConferenceRoom) {
            int cost = ((ConferenceRoom) room).getDailyRate();
            int money = guest.getMoney();
            money -= (cost * nightsDays);
            guest.setMoney(money);
        }
        if (room instanceof Bedroom) {
            int cost = ((Bedroom) room).getNightlyRate();
            int money = guest.getMoney();
            money -= (cost * nightsDays);
            guest.setMoney(money);
        }
    }

    public void booking(Room room, int nightsDays){
        if (room instanceof ConferenceRoom) {
            ((ConferenceRoom) room).setBooking(nightsDays);
        }
        if (room instanceof Bedroom) {
            ((Bedroom) room).setBooking(nightsDays);
        }
    }

    public void checkOut(Room room, Guest guest) {
        room.checkOut(guest);
    }

    public ArrayList<Guest> guestList(Room room) {
        return room.getGuests();
    }

    public void clearRoom(Room room) {
        room.clearRoom();
    }

    public ArrayList<Room> emptyRooms() {
        ArrayList<Room> emptyRooms = new ArrayList<Room>();
        for (Room room : this.rooms){
            if (room.guestCount() == 0){
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }


    public ArrayList<Room> occupiedRooms() {
        ArrayList<Room> occupiedRooms = new ArrayList<Room>();
        for (Room room : this.rooms){
            if (room.guestCount() > 0){
                occupiedRooms.add(room);
            }
        }
        return occupiedRooms;
    }

    public ArrayList<Room> fullRooms() {
        ArrayList<Room> fullRooms = new ArrayList<Room>();
        for (Room room : this.rooms){
            if (room.guestCount() == room.capacity()){
                fullRooms.add(room);
            }
        }
        return fullRooms;
    }

    public void checkInMultiple(Room room, Guest guest, int nightsDays) {
        if (room.guestCount() < room.capacity()) {
            room.checkIn(guest);
            pay(room, guest, nightsDays);
            booking(room, nightsDays);
        }
    }
}
