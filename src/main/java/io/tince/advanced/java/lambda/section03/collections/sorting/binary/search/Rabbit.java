package io.tince.advanced.java.lambda.section03.collections.sorting.binary.search;

import java.util.Objects;

public class Rabbit implements Comparable<Rabbit> {
    private final String name;
    private int age;

    public Rabbit(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rabbit rabbit = (Rabbit) o;
        return Objects.equals(name, rabbit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Rabbit rabbit) {
        return name.compareTo(rabbit.getName());
    }
}
