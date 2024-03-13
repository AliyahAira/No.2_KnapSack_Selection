package g;

import java.util.*;
//Main 

// Problem#1 : Si Knapsack
//Problem#2 : Si Sort

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for weight gross
        double weightGross;
        do {
            System.out.print("Enter the weight gross of the motor vehicle (1-15 kilos): ");
            weightGross = scanner.nextDouble();
            if (weightGross > 15.0) {
                System.out.println("Invalid. It exceeds weight gross.");
            }
        } while (weightGross > 15.0);

        Product[] products = {
                new Product("Canned Goods", 5, 450),
                new Product("Cooking Oil", 3, 725),
                new Product("Noodles", 2.5, 375),
                new Product("Soap", 7, 500)
        };

        List<List<Product>> subsets = knapsack(products, weightGross);

        // Displaying subsets
        displaySubsets(subsets);

        // Sort the subsets based on user's choice
        sortSubsets(scanner, subsets);

        // Display sorted subsets
        displaySubsets(subsets);
    }

    public static List<List<Product>> knapsack(Product[] products, double weightGross) {
        List<List<Product>> subsets = new ArrayList<>();
        int n = products.length;
        int max = 1 << n; // Total number of subsets

        // Generate all possible subsets
        for (int i = 0; i < max; i++) {
            List<Product> subset = new ArrayList<>();
            double totalWeight = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(products[j]);
                    totalWeight += products[j].weight;
                }
            }

            // If the subset is not empty and the total weight is less than or equal to the weightGross, add it to the list
            if (totalWeight <= weightGross) {
                subsets.add(subset);
            }
        }

        return subsets;
    }

    public static void displaySubsets(List<List<Product>> subsets) {
        System.out.println("Products\t\t\t\t\tWeight\t\tTotal Amount");
        for (List<Product> subset : subsets) {
            double totalWeight = subset.stream().mapToDouble(Product::getWeight).sum();
            int totalAmount = subset.stream().mapToInt(Product::getAmount).sum();
            StringBuilder subsetString = new StringBuilder("{");
            for (Product product : subset) {
                subsetString.append(product.name).append(", ");
            }
            if (subsetString.length() > 1) {
                subsetString.setLength(subsetString.length() - 2); // Remove the last comma and space
            }
            subsetString.append("}");
            System.out.printf("%-50s%.2f\t\t%d%n", subsetString.toString(), totalWeight, totalAmount);
        }
    }

    public static void sortSubsets(Scanner scanner, List<List<Product>> subsets) {
        System.out.println("\nSort the subsets by:");
        System.out.println("a. Product Name");
        System.out.println("b. Weight");
        System.out.println("c. Total Amount");
        System.out.print("Enter your choice: ");
        char choice = scanner.next().charAt(0);

        switch (choice) {
            case 'a':
                SubsetSorter.sortByProductName(subsets);
                break;
            case 'b':
                SubsetSorter.sortByWeightAscending(subsets);
                break;
            case 'c':
                SubsetSorter.sortByTotalAmount(subsets);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}