class Product {
    private int productId;
    private String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product p = (Product) obj;
        return this.productId == p.productId;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Phone");
        Product p2 = new Product(1, "Phone");
        Product p3 = p1;
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1 == p3: " + (p1 == p3));
    }
}
