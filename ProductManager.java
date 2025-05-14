/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import java.util.*;

public class ProductManager {
    private List<Product<?>> products;
    private Set<String> categories;
    private Queue<Product<?>> processedQueue;

    public ProductManager() {
        products = new ArrayList<>();
        categories = new HashSet<>();
        processedQueue = new LinkedList<>();
    }

    // Menambahkan produk ke daftar produk
    public void addProduct(Product<?> product) {
        products.add(product);
        categories.add(product.getCategory().toString());
    }

    // Menghapus produk berdasarkan ID
    public boolean removeProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    // Mencari produk berdasarkan nama
    public List<Product<?>> searchByName(String name) {
        List<Product<?>> result = new ArrayList<>();
        for (Product<?> p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    // Mencari produk berdasarkan kategori
    public <T> List<Product<?>> searchByCategory(T category) {
        List<Product<?>> result = new ArrayList<>();
        for (Product<?> p : products) {
            if (p.getCategory().equals(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Menampilkan semua produk diurutkan berdasarkan kategori
// Menampilkan semua produk diurutkan berdasarkan kategori
    public List<Product<?>> getAllProductsSortedByCategory() {
        List<Product<?>> sortedProducts = new ArrayList<>(products);
        
        // Menggunakan comparator yang membandingkan string representation dari kategori
        sortedProducts.sort((p1, p2) -> {
            String cat1 = p1.getCategory().toString();
            String cat2 = p2.getCategory().toString();
            return cat1.compareTo(cat2);
        });
        
        return sortedProducts;
    }

    // Menambahkan produk ke antrian yang telah diproses
    public void addToProcessedQueue(Product<?> product) {
        processedQueue.add(product);
    }

    // Menampilkan antrian produk yang telah diproses
    public Queue<Product<?>> getProcessedQueue() {
        return processedQueue;
    }

    // Fitur bonus: Menghitung jumlah produk per kategori
    public Map<String, Integer> countProductsByCategory() {
        Map<String, Integer> categoryCount = new HashMap<>();
        for (Product<?> p : products) {
            String category = p.getCategory().toString();
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }
        return categoryCount;
    }
}
