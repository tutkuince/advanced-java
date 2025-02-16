package io.tince.advanced.java.section02.streams;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class PartitioningByCollector {

    public static void main(String[] args) {
        List<FilteringElements.Car> cars = List.of(
                new FilteringElements.Car("sedan", "BMW", "530", 1998),
                new FilteringElements.Car("sedan", "Audi", "A5", 1998),
                new FilteringElements.Car("sedan", "Mercedes", "E-Class", 2500),
                new FilteringElements.Car("hatchback", "Opel", "Corsa", 1600),
                new FilteringElements.Car("hatchback", "Honda", "Type-R", 2000)
        );

        // Partitioning by
        Map<Boolean, List<FilteringElements.Car>> partitionedCars = cars.stream().collect(partitioningBy(car -> car.type().equals("sedan")));
        System.out.println("Partitioned cars: " + partitionedCars);

        // (type, (make, engineCapacity))
        Map<String, Map<String, Integer>> groupedCars = cars.stream().collect(
                groupingBy(FilteringElements.Car::type,toMap(FilteringElements.Car::make, FilteringElements.Car::engineCapacity))
        );
        System.out.println("Grouped Cars: " + groupedCars);
    }
}
