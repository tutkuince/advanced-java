package io.tince.advanced.java.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
//        creatingPrimitiveStreams();
        fromCollection();
    }

    public static void creatingPrimitiveStreams() {
        int[] intArray = {1, 2, 3};
        double[] doubleArray = {1.1, 2.2, 3.3};
        long[] longArray = {1L, 2L, 3L};

        IntStream iStream = Arrays.stream(intArray);
        DoubleStream dStream = Arrays.stream(doubleArray);
        LongStream lStream = Arrays.stream(longArray);
        System.out.println(iStream.count() + ", " + dStream.count() + ", " + lStream.count());  // 3, 3, 3

        IntStream intStream = IntStream.of(1, 2, 3);
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream longStream = LongStream.of(1L, 2L, 3L);
        System.out.println(intStream.count() + ", " + doubleStream.count() + ", " + longStream.count());  // 3, 3, 3
    }

    public static void fromCollection() {
        List<String> animalList = Arrays.asList("cat", "dog", "sheep", "bird");
        // Using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: " + streamAnimals.count());
        fromMap();
    }

    public static void fromArray() {
        Double[] numbers = {1.1, 2.2, 3.3};
        // Arrays.stream() creates a stream from the array 'numbers'.
        // The array is considered the source of the stream and while the data is flowing through the stream
        // we have an opportunity to operate on the data.
        Stream<Double> doubleStream = Arrays.stream(numbers);

        // let's perform an operation on the data
        // note that count() is a "terminal operation" - this means that you cannot perform any more operations on the stream.
        long n = doubleStream.count();
        System.out.println("Number of elements: " + n); // 3

        // Re-creating the stream using Stream.of();
        // static <T> Stream<T> of(T... values)
        Stream<Double> dStream = Stream.of(numbers);
        System.out.println("Number of elements: " + dStream.count());

        Stream<String> sStream = Stream.of("Austria", "New Zealand");
        System.out.println("Number of elements: " + sStream.count()); // 2
    }

    private static void fromMap() {
        // stream() is a default method in the Collection interface and therefore
        // is inherited by all classes that implement Collection. Map is NOT one
        // of those i.e. Map is not a Collection. To bridge between the two, we
        // use the Map method entrySet() to return a Set view of the Map(Set IS-A Collection)
        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("Mary", 24);
        namesToAges.put("Alice", 32);
        System.out.println("Number of entries: " +
                namesToAges.entrySet()  // get a Set (i.e. Collection) view of the Map
                        .stream()       // stream() is a default method in Collection
                        .count());      // 3
    }
}
