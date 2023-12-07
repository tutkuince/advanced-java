package io.tince.advanced.java.lambda.expressions;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefsAndContextTest {
    public static void main(String[] args) {
        // No Person being passed in => Supplier
        Supplier<Integer> lambda1 = () -> Person.howMany();
        Supplier<Integer> mr1 = () -> Person.howMany();
        System.out.println(lambda1.get());
        System.out.println(mr1.get());
        System.out.println("------------------------");

        // One Person to be passed in => Function
        Function<Person, Integer> lambda2 = person -> Person.howMany(person);
        Function<Person, Integer> mr2 = Person::howMany;
        System.out.println(lambda2.apply(new Person()));
        System.out.println(mr2.apply(new Person()));
        System.out.println("------------------------");

        // Two Person's to be passed in => Function
        BiFunction<Person, Person, Integer> lambda3 = (p1, p2) -> Person.howMany(p1, p2);
        BiFunction<Person, Person, Integer> mr3 = Person::howMany;
        System.out.println(lambda3.apply(new Person(), new Person()));
        System.out.println(mr3.apply(new Person(), new Person()));

    }
}

class Person {
    public static Integer howMany(Person... people) {
        return people.length;
    }
}
