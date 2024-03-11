
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter the weight gross of the motor vehicle (1-15 kilos):");
            int grossWeight = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (grossWeight < 1 || grossWeight > 15) {
                System.out.println("Invalid weight gross. It should be between 1 to 15 kilos.");
                return;
            }
            
            Knapsack knapsack = new Knapsack(grossWeight);
            
            System.out.println("Enter the number of products:");
            int numProducts = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            for (int i = 0; i < numProducts; i++) {
                System.out.println("Enter product information (Product Name, Weight/box, Amount):");
                String productInfo = scanner.nextLine();
                knapsack.addProduct(productInfo);
            }
            
            if (!knapsack.checkValidWeight()) {
                return;
            }
            
            System.out.println("Sort by (a. Product Name, b. Weight, c. Amount):");
            char sortBy = scanner.next().charAt(0);
            
            knapsack.sortProducts(sortBy);
            knapsack.displayProducts();
        } finally {
            scanner.close();
        }
    }
}