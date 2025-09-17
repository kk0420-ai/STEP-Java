class Tool {
    private String privateField = "Private";
    protected String protectedField = "Protected";
    public String publicField = "Public";

    public String getPrivateField() { return privateField; }
}

class Hammer extends Tool {
    public void showAccess() {
        // System.out.println(privateField); // not allowed
        System.out.println(getPrivateField()); // access via getter
        System.out.println(protectedField);    // allowed
        System.out.println(publicField);       // allowed
    }

    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
