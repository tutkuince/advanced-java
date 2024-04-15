package io.tince.advanced.java.lambda.section03.collections.queue;

public class Book {
    private final String title;
    private final Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", price=" + price + '}';
    }
}
