package io.tince.advanced.java.lambda.section03.collections.sorting;

public class Worker {
    private final int id;

    public Worker(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                '}';
    }
}
