package io.tince.advanced.java.lambda.expressions.exercises.part02;

import java.util.Comparator;
import java.util.List;

import static io.tince.advanced.java.lambda.expressions.exercises.part02.Exercise05.getPeople;

public class Exercise07 {
    /**
     * In main(), invoke the sortHeight() method passing down listPeople; in sortHeight() do the following:
     * a) As in 6a except sort the Person objects in ascending height order.
     * b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.
     * */
    public static void main(String[] args) {
        List<Person> listPeople = getPeople();
        listPeople.sort(Comparator.comparing(person -> person.getHeight()));
        System.out.println("After Sort By Height");
        listPeople.forEach(System.out::println);
    }
}
