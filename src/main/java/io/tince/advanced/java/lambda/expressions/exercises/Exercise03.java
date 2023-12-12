package io.tince.advanced.java.lambda.expressions.exercises;

import java.util.function.Predicate;

public class Exercise03 {

    /**
     * In main() invoke the predicate() method; in predicate() do the following:
     *
     * a) Using a lambda expression, implement the Evaluate interface (typed for Integer).
     * The relevant method returns true if the argument passed is < 0, otherwise it returns false.
     * Invoke the relevant method twice – the first time pass in -1 and the second time pass in +1
     *
     * b) Using a lambda expression, implement 3a using a Predicate.
     *
     * c) Declare a generically-typed check() method (not in UML). The first parameter is generic and the second parameter is a Predicate,
     * also generically typed. The check() method returns true/false. Invoke the check() method with the following Predicate lambda expressions:
     *
     * - we want to know if a number is even (true) – invoke check() with 4 and 7 (true and false).
     *
     * - we want to know if a String begins with “Mr.” – invoke check() with “Mr. Joe Bloggs” and “Ms. Ann Bloggs”
     *
     * - we want to know if a person is an adult (age >= 18) – invoke check() with “Mike” who is 33 and 1.8 (metres assumed) in height;
     * and “Ann” who is 13 and 1.4 (metres) in height.
     * */
    public static void main(String[] args) {
        Evaluate<Integer> integerEvaluate = s -> s < 0;
        System.out.println("Evaluate: -1 => " + integerEvaluate.isNegative(-1));
        System.out.println("Evaluate:  1 => " + integerEvaluate.isNegative(1));

        Predicate<Integer> integerPredicate = s -> s < 0;
        System.out.println("Predicate: -1 => " + integerPredicate.test(-1));
        System.out.println("Predicate:  1 => " + integerPredicate.test(1));

        int number = 4;
        System.out.println("Is " + number + " even? => " + check(number, s -> s % 2 == 0));
        number = 7;
        System.out.println("Is " + number + " even? => " + check(number, s -> s % 2 == 0));

        String name = "Mr. Joe Bloggs";
        System.out.println("Does " + name + " start with Mr.? => " + check(name, n -> n.startsWith("Mr.")));
        name = "Ms. Ann Bloggs";
        System.out.println("Does " + name + " start with Mr.? => " + check(name, n -> n.startsWith("Mr.")));

        Person person = Person.Builder.newBuilder()
                .name("Mike")
                .age(33)
                .height(1.4)
                .build();

        System.out.println("Is " + person.name + " an adult? => " + check(person, s -> s.age >= 18));
        person = Person.Builder.newBuilder()
                .name("Ann")
                .age(13)
                .height(1.4)
                .build();
        System.out.println("Is " + person.name + " an adult? => " + check(person, s -> s.age >= 18));
    }

    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}

interface Evaluate<T> {
    Boolean isNegative(T t);
}

class Person {
    String name;
    int age;
    double height;

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        height = builder.height;
    }


    public static final class Builder {
        private String name;
        private int age;
        private double height;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder height(double val) {
            height = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}