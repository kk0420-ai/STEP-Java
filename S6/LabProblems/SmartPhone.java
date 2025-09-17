class Phone {
    protected String brand, model;
    Phone() {
        this("Unknown", "Unknown");
        System.out.println("Phone default constructor");
    }
    Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone parameterized constructor");
    }
}
class SmartPhone extends Phone {
    private String os;
    SmartPhone() {
        super();
        this.os = "GenericOS";
        System.out.println("SmartPhone default constructor");
    }
    SmartPhone(String brand, String model, String os) {
        super(brand, model);
        this.os = os;
        System.out.println("SmartPhone parameterized constructor");
    }
    public static void main(String[] args) {
        new SmartPhone();
        new SmartPhone("Samsung", "S24", "Android");
    }
}
