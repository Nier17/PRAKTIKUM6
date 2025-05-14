/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;
import java.util.List;
import java.util.Queue;

public class Marketplace {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Membuat beberapa produk dengan kategori berbeda
        Product<String> product1 = new Product<>(1, "Laptop", "Electronics", 1200.00);
        Product<String> product2 = new Product<>(2, "Smartphone", "Electronics", 800.00);
        Product<String> product3 = new Product<>(3, "T-Shirt", "Clothing", 25.00);
        Product<Integer> product4 = new Product<>(4, "Desk", 101, 150.00); // Kategori sebagai Integer
        Product<Integer> product5 = new Product<>(5, "Chair", 101, 80.00); // Kategori sebagai Integer

        // Menambahkan produk ke manager
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        // Menambahkan beberapa produk ke antrian diproses
        manager.addToProcessedQueue(product1);
        manager.addToProcessedQueue(product3);
        manager.addToProcessedQueue(product5);

        // Demonstrasi fitur-fitur
        System.out.println("=== All Products Sorted by Category ===");
        List<Product<?>> allProducts = manager.getAllProductsSortedByCategory();
        allProducts.forEach(System.out::println);

        System.out.println("\n=== Unique Categories ===");
        System.out.println(manager.getAllProductsSortedByCategory());

        System.out.println("\n=== Search Results for 'sh' in Name ===");
        List<Product<?>> searchResults = manager.searchByName("sh");
        searchResults.forEach(System.out::println);

        System.out.println("\n=== Search Results for Electronics Category ===");
        List<Product<?>> electronics = manager.searchByCategory("Electronics");
        electronics.forEach(System.out::println);

        System.out.println("\n=== Processed Queue ===");
        Queue<Product<?>> queue = manager.getProcessedQueue();
        queue.forEach(System.out::println);

        // Demonstrasi fitur bonus: hitung produk per kategori
        System.out.println("\n=== Product Count by Category ===");
        System.out.println(manager.countProductsByCategory());

        // Menghapus produk
        manager.removeProduct(2);
        System.out.println("\n=== After Removing Product ID 2 ===");
        manager.getAllProductsSortedByCategory().forEach(System.out::println);
    }
}
