class Product {
    private String name;
    private int weight;
    private int amount;
    
    public Product(String name, int weight, int amount) {
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getAmount() {
        return amount;
    }
}