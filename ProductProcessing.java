import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name, category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 900),
            new Product("Phone", "Electronics", 700),
            new Product("Shoes", "Fashion", 120),
            new Product("Watch", "Fashion", 250),
            new Product("Tablet", "Electronics", 400)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("Products Grouped by Category: " + groupedByCategory);

        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category, 
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));
        System.out.println("Most Expensive Products in Each Category: " + mostExpensiveInCategory);

        double avgPrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0);
        System.out.println("Average Price of All Products: $" + avgPrice);
    }
}
