package g;

class Product {
    String name;
    double weight;
    int amount;

    public Product(String name, double weight, int amount) {
        this.name = name;
        this.weight = weight;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }
}