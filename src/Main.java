
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static HotelManager manager = new HotelManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Management System");
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(5, 1));

        JButton bookBtn = new JButton("Book Room");
        JButton checkoutBtn = new JButton("Checkout Room");
        JButton viewBtn = new JButton("View Bookings");
        JButton roomsBtn = new JButton("View Available Rooms");
        JButton exitBtn = new JButton("Exit");

        bookBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter name:");
            String phone = JOptionPane.showInputDialog("Enter phone:");
            int roomNum = Integer.parseInt(JOptionPane.showInputDialog("Enter room number (101–110):"));
            boolean success = manager.bookRoom(name, phone, roomNum);
            JOptionPane.showMessageDialog(null, success ? "Room booked!" : "Room unavailable.");
        });

        checkoutBtn.addActionListener(e -> {
            int roomNum = Integer.parseInt(JOptionPane.showInputDialog("Enter room number:"));
            boolean success = manager.checkoutRoom(roomNum);
            JOptionPane.showMessageDialog(null, success ? "Checkout successful." : "Invalid room or not booked.");
        });

        viewBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Customer c : manager.getCustomers()) {
                sb.append("Room ").append(c.getRoomNumber())
                  .append(": ").append(c.getName())
                  .append(", Phone: ").append(c.getPhone()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No bookings.");
        });

        roomsBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Room r : manager.getRooms()) {
                if (!r.isBooked()) {
                    sb.append("Room ").append(r.getRoomNumber()).append(" is available.\n");
                }
            }
            JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No rooms available.");
        });

        exitBtn.addActionListener(e -> System.exit(0));

        frame.add(bookBtn);
        frame.add(checkoutBtn);
        frame.add(viewBtn);
        frame.add(roomsBtn);
        frame.add(exitBtn);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
