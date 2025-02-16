package io.tince.advanced.java.section02.streams;

import java.util.List;

public class FilteringElements {

    record Car(String type, String make, String model, Integer engineCapacity) {
    }

    public static void main(String[] args) {

        List<Car> cars = List.of(
                new Car("sedan", "BMW", "530", 1998),
                new Car("sedan", "Audi", "A5", 1998),
                new Car("sedan", "Mercedes", "E-Class", 2500),
                new Car("hatchback", "Opel", "Corsa", 1600),
                new Car("hatchback", "Honda", "Type-R", 2000)
        );

        List<Car> sedanCarList = cars.stream().filter(car -> car.type.equals("sedan")).toList();
        System.out.println(sedanCarList);
    }

}
