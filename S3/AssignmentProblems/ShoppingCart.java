class Product {
    String productId, productName, category;
    double price; int stockQuantity;
    static int totalProducts = 0;

    public Product(String id, String name, double price, String cat, int stock) {
        this.productId = id; this.productName = name; this.price = price;
        this.category = cat; this.stockQuantity = stock; totalProducts++;
    }
}

class ShoppingCart {
    String cartId, customerName;
    Product[] products = new Product[10];
    int[] quantities = new int[10];
    int count = 0; double cartTotal = 0;

    public ShoppingCart(String id, String name) { cartId = id; customerName = name; }

    public void addProduct(Product p, int qty) {
        if (p.stockQuantity >= qty) {
            products[count] = p; quantities[count] = qty;
            cartTotal += p.price * qty; p.stockQuantity -= qty; count++;
        }
    }

    public void displayCart() {
        System.out.println("Cart " + cartId + " (" + customerName + ")");
        for (int i = 0; i < count; i++)
            System.out.println(products[i].productName + " x" + quantities[i]);
        System.out.println("Total: " + cartTotal);
    }

    public void checkout() {
        System.out.println("Checking out: " + cartTotal);
        cartTotal = 0; count = 0;
    }

    public static void main(String[] args) {
        Product p1 = new Product("P1", "Laptop", 50000, "Electronics", 5);
        Product p2 = new Product("P2", "Book", 300, "Education", 20);
        ShoppingCart c1 = new ShoppingCart("C1", "Alice");

        c1.addProduct(p1, 1);
        c1.addProduct(p2, 2);
        c1.displayCart();
        c1.checkout();
    }
}
