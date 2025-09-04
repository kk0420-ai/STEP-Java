class Room {
    String roomNumber, roomType;
    double pricePerNight; boolean isAvailable = true; int maxOccupancy;
    public Room(String no, String type, double price, int occ) {
        roomNumber = no; roomType = type; pricePerNight = price; maxOccupancy = occ;
    }
}

class Guest {
    String guestId, guestName, phone, email;
    public Guest(String id, String name, String phone, String email) {
        guestId = id; guestName = name; this.phone = phone; this.email = email;
    }
}

class Booking {
    static int totalBookings = 0; static double hotelRevenue = 0; static String hotelName = "MyHotel";
    String bookingId; Guest guest; Room room; String checkIn, checkOut; double totalAmount;

    public Booking(String id, Guest g, Room r, String in, String out, int days) {
        bookingId = id; guest = g; room = r; checkIn = in; checkOut = out;
        totalAmount = r.pricePerNight * days; room.isAvailable = false;
        totalBookings++; hotelRevenue += totalAmount;
    }

    public void display() {
        System.out.println("Booking " + bookingId + " Guest: " + guest.guestName +
                " Room: " + room.roomNumber + " Amount: " + totalAmount);
    }

    public static void main(String[] args) {
        Room r1 = new Room("101", "Deluxe", 2000, 2);
        Guest g1 = new Guest("G1", "Alice", "12345", "a@x.com");
        Booking b1 = new Booking("B1", g1, r1, "1-1-25", "3-1-25", 2);
        b1.display();
        System.out.println("Hotel Revenue: " + hotelRevenue);
    }
}
