# Java 21, Java 17, Java 11 and Advanced Java 8
## Section - 1 Lambda Expressions
Java Lambda Expressions are a feature introduced in Java 8 that allow you to write anonymous functions—functions without a name—using a concise syntax. They are primarily used to implement functional interfaces, i.e., interfaces with a single abstract method (SAM).
A lambda expression is an instance of a class that implements a functional interface.

### Why Use Lambdas?
- More concise: Reduces boilerplate code.
- Readability: Improves clarity, especially in functional-style operations (like map, filter, reduce).
- Used heavily in streams and functional programming.

### Interfaces 
Since Java 8, interfaces in Java can contain two types of concrete (non-abstract) methods:
#### 1. Default Methods
- Introduced in Java 8.
- Declared with the default keyword.
- Allow interfaces to have method implementations without breaking existing implementations.
- Can be inherited by implementing classes and overridden if needed.
```
interface Animal {
    default void sound() {
        System.out.println("Some animal sound");
    }
}

class Dog implements Animal {
    // Inherits 'sound' by default, can override if needed
}
```
#### 2. Static Methods
- Also introduced in Java 8.
- Declared with the static keyword.
- Belong to the interface itself, not inherited by implementing classes.
- Called using the interface name, not through an object.
```
interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
}

// Usage:
int result = MathUtils.add(3, 5);
```
### Functional Interfaces
A functional interface in Java is an interface that contains exactly ***one abstract*** method. It can have any number of default, static, or private methods, but only one abstract method qualifies it as functional. <br/>
Functional interfaces are the backbone of lambda expressions and method references, introduced in Java 8. <br/>
- default methods do not count
- static methods do not count
- methods inherited from Object do not count

***Key Features:***
- Marked with the @FunctionalInterface annotation (optional but recommended).
- Can be implemented using a lambda expression or a method reference.
- Enables functional programming in Java.
```
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

// Lambda usage
Greeting greet = (name) -> System.out.println("Hello, " + name);
greet.sayHello("Tutku");
```

### Predicate and BiPredicate
In Java, Predicate and BiPredicate are functional interfaces in the java.util.function package. They are used primarily for evaluating boolean conditions (i.e., true/false decisions), and they are often used with the Stream API, filtering, and conditional logic.

#### Predicate<T>
Represents a single-argument function that returns a boolean value.

```
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```
#### BiPredicate<T, U>
Represents a two-argument version of Predicate, also returning a boolean.

```
@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}
```
Useful Methods (both have):
- and(): Combines predicates with logical AND.
- or(): Combines with logical OR.
- negate(): Logical NOT.

### Supplier<T>
The Supplier<T> functional interface in Java (from java.util.function) represents a function that supplies a value without taking any input.

- It returns a value of type T.
- It does not accept any arguments.
- Typically used for lazy generation or factory-like behavior.

```
import java.util.function.Supplier;
import java.util.Random;

Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);

System.out.println(randomSupplier.get()); // Might print 42, 7, etc.
```

### Consumer and BiConsumer
In Java, Consumer and BiConsumer are functional interfaces from the java.util.function package. They represent operations that accept input but return no result — they are typically used to perform actions, such as printing or saving data.

#### Consumer<T>
Represents an operation that takes a single argument and returns no result.

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```
```
List<String> names = List.of("Ali", "Ayşe", "Veli");
names.forEach(greeter); // Calls accept() for each item
```

#### BiConsumer<T, U>
Represents an operation that takes two input arguments and returns no result.

```
@FunctionalInterface
public interface BiConsumer<T, U> {
    void accept(T t, U u);
}
```
```
BiConsumer<String, Integer> printAge = (name, age) ->
    System.out.println(name + " is " + age + " years old");

printAge.accept("Tutku", 30);  // Output: Tutku is 30 years old
```
```
Map<String, Integer> ages = Map.of("Ali", 25, "Ayşe", 28);
ages.forEach((name, age) -> System.out.println(name + ": " + age));

```

Common Use Cases
| Use Case                     | Interface    | Example                |
| ---------------------------- | ------------ | ---------------------- |
| Print/log a value            | `Consumer`   | `System.out::println`  |
| Apply an operation to a list | `Consumer`   | `list.forEach(...)`    |
| Operate on key-value pairs   | `BiConsumer` | Iterating over a `Map` |

### Function and BiFunction
In Java, Function and BiFunction are functional interfaces from the java.util.function package. They are used when you need to take input(s) and return a result — unlike Consumer, which returns nothing.

#### Function<T, R>
Represents a function that:
- Takes one argument of type T
- Returns a result of type R
```
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```
```
Function<String, Integer> stringLength = s -> s.length();

System.out.println(stringLength.apply("Tutku"));  // Output: 5
```
#### BiFunction<T, U, R>
Represents a function that: 
- Takes two argument of types T and U
- Returns a result of type R
```
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
```
```
BiFunction<Integer, Integer, String> sumToString = (a, b) -> "Sum: " + (a + b);

System.out.println(sumToString.apply(5, 3)); // Output: Sum: 8
```

Common Use Cases

| Use Case                      | Interface    | Example                               |
| ----------------------------- | ------------ | ------------------------------------- |
| Convert data (String → int)   | `Function`   | `String::length`, `Integer::parseInt` |
| Combine two values and return | `BiFunction` | Add, multiply, format, etc.           |
| Map transformation in streams | `Function`   | `list.stream().map(...).collect(...)` |

Example: Function with Stream API
```
List<String> names = List.of("Ali", "Ayşe", "Veli");
List<Integer> nameLengths = names.stream()
                                 .map(name -> name.length())
                                 .collect(Collectors.toList());

System.out.println(nameLengths); // [3, 4, 4]
```
### UnaryOperator and BinaryOperator
In Java, UnaryOperator and BinaryOperator are specialized versions of the Function and BiFunction interfaces, designed for operations where input and output types are the same.

They make the code more semantic and readable when you're working with such operations.

#### UnaryOperator<T>
A specialization of Function<T, T>.
It takes one argument and returns a result of the same type.

```
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> { }
```
Example
```
UnaryOperator<String> toUpper = s -> s.toUpperCase();

System.out.println(toUpper.apply("tutku"));  // Output: TUTKU
```

#### BinaryOperator<T>
A specialization of BiFunction<T, T, T>.
It takes two arguments of the same type and returns a result of the same type.

```
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> { }
```
Example:

```
BinaryOperator<Integer> sum = (a, b) -> a + b;

System.out.println(sum.apply(10, 5));  // Output: 15
```

| Interface           | General Version       | Purpose                                     |
| ------------------- | --------------------- | ------------------------------------------- |
| `UnaryOperator<T>`  | `Function<T, T>`      | Modify a value (e.g., trim, upper-case)     |
| `BinaryOperator<T>` | `BiFunction<T, T, T>` | Combine two values (e.g., add, max, concat) |

Real-World Example: Using BinaryOperator with reduce()
```
List<Integer> numbers = List.of(2, 4, 6);
BinaryOperator<Integer> sum = Integer::sum;

int result = numbers.stream().reduce(0, sum);
System.out.println(result);  // Output: 12
```

### final and effectively  final

#### final in Java
A variable declared with the final keyword cannot be reassigned after it's initialized.
```
final int x = 10;
x = 20;  // ❌ Compilation error
```
This ensures that the value of x remains constant after assignment.

#### Effectively Final
A variable is effectively final if you don't reassign it, even though it’s not explicitly marked as final.
```
int x = 10;  // Not declared final
// No reassignment afterwards → effectively final

Runnable r = () -> System.out.println(x);  // ✅ OK
```
This works because x is never changed, so the compiler treates it as if it were final.

However:
```
int x = 10;
x = 15;  // 🔁 reassigned → NOT effectively final

Runnable r = () -> System.out.println(x);  // ❌ Compilation error
```

***Why Does This Matter?***
Java requires captured variables in lambdas or anonymous inner classes to be final or effectively final. 
This avoids issues with variable mutability in closures.

| Term              | Reassignable? | Required for Lambdas? | Explicit Keyword? |
| ----------------- | ------------- | --------------------- | ----------------- |
| `final`           | ❌ No          | ✅ Yes                 | ✅ Yes             |
| Effectively final | ❌ No          | ✅ Yes                 | ❌ No              |


## Section - 2 Streams
In Java, a Stream is a sequence of elements that supports functional-style operations to process data. 

Introduced in Java 8, the Stream API lets you work with collections in a declarative, expressive, and concise way, similar to SQL or functional programming.

### Key Characteristics of Streams
- Not a data structure — it doesn’t store data.
- Lazy — operations are only executed when a terminal operation is called.
- Can be sequential or parallel.
- Doesn’t modify the source (e.g., the original list remains unchanged).

### Common Stream Operations
Streams are typically chained using a pipeline of methods:
1. Source
```
List<String> names = List.of("Ali", "Ayşe", "Veli");
Stream<String> stream = names.stream();
```
2. Intermediate operations (lazy)

| Operation            | Purpose                            |
| -------------------- | ---------------------------------- |
| `filter()`           | Select elements based on condition |
| `map()`              | Transform each element             |
| `sorted()`           | Sort the stream                    |
| `distinct()`         | Remove duplicates                  |
| `limit()` / `skip()` | Limit/skip items                   |

3. Terminal operations (trigger execution)

These produce a result or side-effect.

| Operation                   | Result Type        |
| --------------------------- | ------------------ |
| `forEach()`                 | void (side-effect) |
| `collect()`                 | Collection         |
| `reduce()`                  | Single value       |
| `count()`                   | long               |
| `anyMatch()` / `allMatch()` | boolean            |


### Streams vs Collections

| Feature               | Collections    | Streams                          |
| --------------------- | -------------- | -------------------------------- |
| Stores data?          | ✅ Yes          | ❌ No (views over data)           |
| Traversal             | Multiple times | Usually once                     |
| Lazy evaluation       | ❌ No           | ✅ Yes                            |
| Can be infinite       | ❌ No           | ✅ Yes (e.g., `Stream.iterate()`) |
| Supports parallel ops | ✅ (manual)     | ✅ (easy via `.parallel()`)       |


## Section - 3 Collections and Generics
- Working with generics, including wildcards
- Use a Java array and List, Set, Map and Deque collections, including convenience methods
- Sort collections and arrays using Comparator and Comparable interfaces
![image](https://github.com/tutkuince/advanced-java/assets/33215575/fbc7d709-df49-4226-9142-0a1b8ac4985f)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/3d599e84-9d2f-4ff9-bc2d-ac9b02b6031f)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/a2c4d875-62c1-411b-925e-b17fc371fa07)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/cc96a43f-b29d-4840-9e48-73260b6a913c)
### Collections have four basic flavours:
- <b>List</b>: An ordered collection (seqıence); provides precise control over access to an element using its integer index; duplicate elements are allowed
  - <b>Arraylist</b>: A growable array; fast iteration and fast random access; use when you are not likely to do much insertion/deletion (shuffling required).
  - <b>LinkedList</b>: Elements are doubly-linked to each other; fast insertion/deletion.
  - <b>Stack</b>: Represent a list-in-first-out (LIFO) stack of objects. The "Deque" interface an its implementations are more complete and should be used instead.

![image](https://github.com/tutkuince/advanced-java/assets/33215575/acc0a915-ce18-4ecb-adc4-c6137c4ba486)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/7510341c-4662-402b-8307-8225e278070d)

- <b>Set</b>: Collections with no duplicate elements
  - <b>HashSet</b>
    - Unsorted, unordered <i>Set</i>, uses the hashcode of the object being inserted; the more efficient your <i>hashCode()</i> implementation, the better access performance you will get.
    - use this class when you want to a collection with no duplicates and you don't care about order when you iterate through it.
  - <b>LinkedHashSet</b>
    - an ordered version of <i>HashSet</i> (insertion order).
    - elements are doubly-lined to each other
    - use this class instead of HashSet when you care about the iteration order.
  - <b>TreeSet</b>
    - a sorted collection ("Tree")
    - elements can be sorted according to their "natural order" - for <i>String</i>'s the natural order is alphabetic; for <i>Integer'</i>s, the natural order is numeric.

![image](https://github.com/tutkuince/advanced-java/assets/33215575/4132e9a9-6faa-4344-90f7-bf0200c0c324)
- <b>Map</b>: maps keys to values; keys are unique; each key can map to at most one value
  - <b>HashMap</b>
    - unsorted, unordered <i>Map</i>.
    - uses the hashcode of the object being inserted; the more efficient your <i>hashCode()</i> implementation, the better access performance you will get.
    - use this class when you want a <i>Map</i> and you don't care about order when you iterate through it.
    - allows one <i>null</i> key and multiple <i>null</i> values.
  - <b>LinkedHashMap</b>
    - maintains insertion order
  - <b>TreeMap</b>
    - a sorted Map; sorted by natural order of it's keys or by a custom order(via a comparator)
  - <b>Hashtable</b>
    - similar to <i>HashMap</i> except <i>Hashtable</i> is thread-safe(slower) anbd nulls are not allowed.
![image](https://github.com/tutkuince/advanced-java/assets/33215575/51ff6fac-f016-4bb6-8f8f-aa7f67ecb9df)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/53374270-86d3-456e-b8f3-75a87e87421a)

- <b>Queue</b>: a collection that specifies the order in which elements are to be processed.
  - Typically the order is FIFO (First In First Out).
  - Exceptions are priority queues ( order is natural ordering or according to a supplied comparator) and LIFO (Last In First Out) queues (stacks).
  - <i>LinkedList</i>
    - as <i>LinkedList</i> implements <i>Queue</i>; basic queues can be handled with a <i>LinkedList</i>
    - <i>PriorityQueue</i>
      - <i>PriorityQueue</i> orders the elements relative to each other such that "priority-in, priority-out" (as opposed to a FIFO or LIFO)
      - the elements are either ordered by natural order or by a custom order via a comparator.
      - elements that are sorted first will be accessed first.
- <b>Deque</b>
  - deque ("double ended queue")
  - access from both ends permitted
  - can be used as both FIFO (queue) and LIFO (stack).
  - <i>ArrayDeque</i>
    - expandable-array implementation of the <i>Deque</i> interface (no capacity restrictions)
    - API: "likely to be faster than <i>Stack</i> when used as a stack, and faster than <i>LinkedList</i> when used as a queue".
![image](https://github.com/tutkuince/advanced-java/assets/33215575/ee6fd5c8-3e72-4785-a3e1-c366d33b7fa7)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/a4a57519-776e-4a62-b08e-1e07a5e4d463)
![image](https://github.com/tutkuince/advanced-java/assets/33215575/1c116a2e-1a99-48e8-af9e-e71e7af61e04)
### Sorting
- Both collections and arrays can be sorted and searched using methods in the API
- The <i>Collections</i> class is a utility class i.e. a class which consist exclusively of static methods, used for operating on collections.
- The <i>Arrays</i> class is a also a utility class, the <i>Arrays</i> class however, operates on native array only ([] styntax).
- One can convert an array (of reference types) to a <i>List</i> using the <i>Arrays.asList</i> method. The returned <i>List</i> can then be passed to useful methods that exist in the <i>Collections</i> class.
#### <i>Comparable</i> and <i>Comparator</i> Interfaces
- The <i>Comparable<T></i> and <i>Comparator<T></i> interfaces are used for comparing objects of similar type.
- Both are functional interfaces.
- Sorting is a classic example where they are used.
- <i>java.lang.</i>Comparable and <i>java.util.</i>.Comparator
- Note: if you add an object of a class to e.g. <i>TreeSet</i> and the class does NOT implement <i>Comparable</i>, you will get a <i>ClassCastException</i>
##### Comparable Interface
- compareTo logic: return an <i>int</i> value based on the following:
  - return a positive number if the current object is larger than the object passed in
  - return 0 if the current object is equivalent to the object passed in
  - return a negative number if the current object is smaller than the object passed in
- This logic can be delegated to existing types (<i>String</i>, <i>Integer</i>) that already have implemented <i>Comparable</i>. In other words, if you are comparing <i>Integer's</i> you can delegate.
- <i>Comparable</i> - compareTo() and equals() consistency.
  - When are 2 objects equal?
    - compareTo() -> returns 0
    - equals()    -> return <i>true</i>
  - API: "The natural ordering for a class "C" is said to be <i>consistent with equals</i> if and only if e1.compareTo(e2) == 0 has the same boolean value as e1.equals(e2) for every e1 and e2 of class "C"
  - We are "strongly recommened" to keep our <i>Comparable</i> classes consistent with equals because "sorted sets (or sorted maps)... behave strangely" otherwise.
##### Comparator Interface
- What if the objects we wanted to sort did not implement <i>Comparable</i> or if we wanted to sort in several different ways? Answer: <i>Comparator</i>
- <i>Comparator</i> is also a functional interface:
  - int compare(T o1, T o2)
- The logic internally is the same as for <i>compareTo()</i>
- Typically, this is coded externally to the class whose objects we are comparing so we need to compare 2 objects.
  - as <i>Comparable</i> is coded internally to the class, we just need the one/other object we want to compare to <i>"this"</i> object.
