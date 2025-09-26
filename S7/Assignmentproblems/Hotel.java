class Hotel {
    void book(String room, int nights) {
        System.out.println("Standard: " + nights*1000 + " Rs");
    }
    void book(String room, int nights, double seasonal) {
        System.out.println("Seasonal: " + nights*1000*seasonal + " Rs");
    }
    void book(String room, int nights, int discount, boolean meal) {
        int cost = nights*1000 - discount;
        if(meal) cost += 500;
        System.out.println("Corporate: " + cost + " Rs");
    }
    void book(String room, int nights, int guests, int deco, int catering) {
        int cost = nights*1000 + guests*200 + deco + catering;
        System.out.println("Wedding: " + cost + " Rs");
    }
    public static void main(String[] args) {
        Hotel h = new Hotel();
        h.book("Deluxe", 3);
        h.book("Deluxe", 3, 1.5);
        h.book("Suite", 5, 1000, true);
        h.book("Hall", 2, 100, 5000, 8000);
    }
}
