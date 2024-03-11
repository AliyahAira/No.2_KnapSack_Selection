import java.util.*;

class Knapsack {
    private int grossWeight;
    private List<Product> products;
    
    public Knapsack(int grossWeight) {
        this.grossWeight = grossWeight;
        products = new ArrayList<>();
    }
    
    public void addProduct(String productInfo) {
        String[] info = productInfo.split(",");
        if (info.length != 3) {
            System.out.println("Invalid product information format: " + productInfo);
            return;
        }
        String name = info[0].trim();
        int weight = Integer.parseInt(info[1].trim());
        int amount = Integer.parseInt(info[2].trim());
        products.add(new Product(name, weight, amount));
    }
    
    public boolean checkValidWeight() {
        int totalWeight = 0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        if (totalWeight > grossWeight) {
            System.out.println("Invalid: Total weight of products exceeds gross weight of motor vehicle.");
            return false;
        }
        return true;
    }
    
    public void sortProducts(char sortBy) {
        switch (sortBy) {
            case 'a':
                Collections.sort(products, Comparator.comparing(Product::getName));
                break;
            case 'b':
                Collections.sort(products, Comparator.comparingInt(Product::getWeight));
                break;
            case 'c':
                Collections.sort(products, Comparator.comparingInt(Product::getAmount));
                break;
            default:
                System.out.println("Invalid sorting option.");
        }
    }
    
    public void displayProducts() {
        System.out.println("\nProduct Name\tWeight/box\tAmount");
        for (Product product : products) {
            System.out.println(product.getName() + "\t\t" + product.getWeight() + "\t\t" + product.getAmount());
        }
    }
}