package io.tince.advanced.java.lambda.section03.collections.sorting.comparable;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private final Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }

    // equal objects should have the same hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Product product) { // specifies "natural ordering" for Product
        // delegate to Integer which implements Comparable<Integer>
        return id.compareTo(product.id);
        // return Integer.compare(id, product.id);  // another option
        // return id - product.id;                  // sots ascending by id
    }
}
