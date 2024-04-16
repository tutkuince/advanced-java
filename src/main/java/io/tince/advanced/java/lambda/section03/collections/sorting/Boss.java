package io.tince.advanced.java.lambda.section03.collections.sorting;

public class Boss implements Comparable<Boss> {
    private final int id;

    public Boss(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Boss otherBoss) {
        return this.id - otherBoss.getId();
    }

    @Override
    public String toString() {
        return "Boss{" +
                "id=" + id +
                '}';
    }
}
