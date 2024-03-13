package g;

import java.util.*;
//Problem#1 : Si Knapsack to

public class KnapsackAlgorithm {

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

        // Adding the null subset
        subsets.add(new ArrayList<>());

        return subsets;
    }
}