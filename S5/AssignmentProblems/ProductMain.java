import java.util.*;

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category, String manufacturer, double basePrice, double weight, String[] features, Map<String, String> specs) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = features.clone();
        this.specifications = new HashMap<>(specs);
    }

    public static Product createElectronics(String name, double price, double weight, String[] features, Map<String, String> specs) {
        return new Product(UUID.randomUUID().toString(), name, "Electronics", "GenericBrand", price, weight, features, specs);
    }

    public static Product createClothing(String name, double price, String[] features) {
        return new Product(UUID.randomUUID().toString(), name, "Clothing", "GenericBrand", price, 0.5, features, new HashMap<>());
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        return basePrice * (region.equalsIgnoreCase("CA") ? 0.13 : 0.1);
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - $" + basePrice;
    }
}

public class ProductMain {
    public static void main(String[] args) {
        String[] features = {"Bluetooth", "Waterproof"};
        Map<String, String> specs = new HashMap<>();
        specs.put("Battery", "10h");
        specs.put("Warranty", "2 years");

        Product p = Product.createElectronics("Wireless Headphones", 99.99, 0.3, features, specs);

        System.out.println("Product: " + p);
        System.out.println("Tax in CA: $" + p.calculateTax("CA"));
        System.out.println("Specs: " + p.getSpecifications());
    }
}
