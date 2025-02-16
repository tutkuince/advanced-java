package io.tince.advanced.java.section02.streams;

import java.util.List;
import java.util.stream.Stream;

public class MappingElements {

    public static void main(String[] args) {

        List<FilteringElements.Car> cars = List.of(
                new FilteringElements.Car("sedan", "BMW", "530", 1998),
                new FilteringElements.Car("sedan", "Audi", "A5", 1998),
                new FilteringElements.Car("sedan", "Mercedes", "E-Class", 2500),
                new FilteringElements.Car("hatchback", "Opel", "Corsa", 1600),
                new FilteringElements.Car("hatchback", "Honda", "Type-R", 2000)
        );

        List<String> carMakeList = cars.stream().map(car -> car.make()).toList();
        System.out.println(carMakeList);

        // MakeAndModelList
        // Audi, A5, Mercedes, E-Class
        List<String> carMakeAndModelList = cars.stream().flatMap(car -> Stream.of(car.make(), car.model())).toList();
        System.out.println(carMakeAndModelList);

    }
}
