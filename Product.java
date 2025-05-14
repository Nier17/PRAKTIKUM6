/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Objects;

public class Product<T extends Comparable<T>> implements Comparable<Product<T>> {
    private int id;
    private String name;
    private T category;
    private double price;

    public Product(int id, String name, T category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public T getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public int compareTo(Product<T> other) {
        return this.category.compareTo(other.category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product<?> product = (Product<?>) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
