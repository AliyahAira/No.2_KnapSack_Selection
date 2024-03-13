package g;
import java.util.*;
//Problem #2 : Sorting

public class SubsetSorter {

    public static void sortByProductName(List<List<Product>> subsets) {
        selectionSort(subsets, Comparator.comparing(s -> s.stream().map(Product::getName).reduce("", String::concat)));
    }

    public static void sortByWeightAscending(List<List<Product>> subsets) {
        selectionSort(subsets, Comparator.comparing(s -> s.stream().mapToDouble(Product::getWeight).sum()));
    }

    public static void sortByTotalAmount(List<List<Product>> subsets) {
        selectionSort(subsets, Comparator.comparing(s -> s.stream().mapToInt(Product::getAmount).sum()));
    }

    private static void selectionSort(List<List<Product>> subsets, Comparator<List<Product>> comparator) {
        int n = subsets.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(subsets.get(j), subsets.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                List<Product> temp = subsets.get(i);
                subsets.set(i, subsets.get(minIndex));
                subsets.set(minIndex, temp);
            }
        }
    }
}