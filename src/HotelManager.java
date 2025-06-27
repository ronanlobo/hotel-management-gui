
import java.util.*;

public class HotelManager {
    private Map<Integer, Room> rooms = new HashMap<>();
    private List<Customer> customers = new ArrayList<>();

    public HotelManager() {
        for (int i = 101; i <= 110; i++) {
            rooms.put(i, new Room(i));
        }
    }

    public boolean bookRoom(String name, String phone, int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && !room.isBooked()) {
            room.book();
            customers.add(new Customer(name, phone, roomNumber));
            return true;
        }
        return false;
    }

    public boolean checkoutRoom(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null && room.isBooked()) {
            room.checkout();
            customers.removeIf(c -> c.getRoomNumber() == roomNumber);
            return true;
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms.values());
    }
}
