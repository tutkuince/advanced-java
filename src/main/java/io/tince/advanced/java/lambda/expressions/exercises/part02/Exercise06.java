package io.tince.advanced.java.lambda.expressions.exercises.part02;

import java.util.Comparator;
import java.util.List;

public class Exercise06 {
    /**
     * In main(), invoke the sortName() method passing down listPeople; in sortName() do the following:
     * a) As in 6a except sort the Person objects in ascending name order.
     * b) Output the sorted list using the Iterable forEach() method passing in a lambda expression.
     *
     * */
    public static void main(String[] args) {
        List<Person> listPeople = Exercise05.getPeople();
        listPeople.sort(Comparator.comparing(person -> person.getName()));
        System.out.println("After Sort By Name");
        listPeople.forEach(System.out::println);
    }
}
