
public class Customer {
    private String name;
    private String phone;
    private int roomNumber;

    public Customer(String name, String phone, int roomNumber) {
        this.name = name;
        this.phone = phone;
        this.roomNumber = roomNumber;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getRoomNumber() { return roomNumber; }
}
