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

| Method              | Description                                        |
| ------------------- | -------------------------------------------------- |
| `filter(Predicate)` | Filters elements based on a condition.             |
| `map(Function)`     | Transforms each element.                           |
| `flatMap(Function)` | Flattens nested structures into a single stream.   |
| `distinct()`        | Removes duplicate elements.                        |
| `sorted()`          | Sorts elements (natural or via comparator).        |
| `limit(long n)`     | Limits the number of elements.                     |
| `skip(long n)`      | Skips the first `n` elements.                      |
| `peek(Consumer)`    | Performs a side-effect (for debugging or logging). |


3. Terminal operations (trigger execution)

These produce a result or side-effect.

| Operation         | Return Type          | Purpose / Description                                                         |
| ----------------- | -------------------- | ----------------------------------------------------------------------------- |
| `collect()`       | Depends on collector | Collects stream elements into a collection (e.g., `List`, `Set`, `Map`, etc.) |
| `forEach()`       | `void`               | Applies an action to each element (e.g., printing)                            |
| `toArray()`       | `Object[]` or `T[]`  | Converts the stream to an array                                               |
| `reduce()`        | Optional / value     | Combines elements into a single result (e.g., sum, product, concatenation)    |
| `count()`         | `long`               | Counts the number of elements in the stream                                   |
| `min()` / `max()` | `Optional<T>`        | Finds the minimum or maximum element using a comparator                       |
| `anyMatch()`      | `boolean`            | Returns true if **any** element matches a given predicate                     |
| `allMatch()`      | `boolean`            | Returns true if **all** elements match a given predicate                      |
| `noneMatch()`     | `boolean`            | Returns true if **no** elements match a given predicate                       |
| `findFirst()`     | `Optional<T>`        | Returns the **first** element in the stream (useful in ordered streams)       |
| `findAny()`       | `Optional<T>`        | Returns **any** element (may be more performant, esp. in parallel streams)    |

Reductions are a special type of terminal operation where ALL of the contents of the stream are combined into a single primiteve or Object e.g. long or Collection

### Streams vs Collections

| Feature               | Collections    | Streams                          |
| --------------------- | -------------- | -------------------------------- |
| Stores data?          | ✅ Yes          | ❌ No (views over data)           |
| Traversal             | Multiple times | Usually once                     |
| Lazy evaluation       | ❌ No           | ✅ Yes                            |
| Can be infinite       | ❌ No           | ✅ Yes (e.g., `Stream.iterate()`) |
| Supports parallel ops | ✅ (manual)     | ✅ (easy via `.parallel()`)       |

### Streams are Lazy
- The princeple of "lazy" evaluation is that you get what you need only when you need it.
- Streams in Java are lazy, meaning that intermediate operations like map(), filter(), or sorted() are not executed immediately.
- Instead, they are deferred until a terminal operation is invoked, such as collect(), forEach(), count(), etc.
- Java builds a pipeline of operations but only starts processing data when it knows what to do with the results — this is efficient and avoids unnecessary computation.

For example, if you were displaying 10,000 records to a user, the princeple of lazy evaluation would be to retrieve 50 and while the user is viewing these, retrieve another 50 in the background.

- "Eager" evalutation would be to retrieve all 10,000 recods in one go.
- With regard to streams, this means that nothing happens until the terminal operation occurs.

### Why Is Laziness Useful?
- Improves performance by avoiding unnecessary computations.
- Enables short-circuiting — like in findFirst(), anyMatch().

### What is .peek() in Java Streams?
The .peek() method in Java Streams is an intermediate operation used mainly for debugging or observing the elements as they pass through the stream pipeline.

Syntax
```
Stream<T> peek(Consumer<? super T> action)
```
- It takes a Consumer (like System.out::println) and applies it to each element.
- It does not modify the stream elements.
- It’s lazy — it only executes when a terminal operation (like collect(), forEach(), etc.) is present.
- peek() is not meant for modifying elements. Use map() for transformation.
- It doesn’t do anything unless followed by a terminal operation.

 ### What is .collect() in Java Streams?
 The .collect() method is a terminal operation in Java Streams that transforms the elements of a stream into a different form, typically a collection like a List, Set, or Map.
 
It works together with the Collectors ***utility*** class, which provides various predefined collectors.

Basic syntax:
```
stream.collect(Collector<T, A, R>)
```

Where: 
- T is the stream element type,
- A is the intermediate accumulation type,
- R is the final result type (e.g. List, Set, Map, etc).

### Collectors.toMap()
This collector converts a stream into a Map. You need to provide:
- A key mapper function
- A value mapper function
- (Optionally) a merge function if duplicate keys may occur

```
List<String> names = List.of("Ali", "Ayşe", "Veli");

Map<String, Integer> nameLengthMap = names.stream()
    .collect(Collectors.toMap(
        name -> name,          // key: the name itself
        name -> name.length()  // value: length of the name
    ));

System.out.println(nameLengthMap); 
// Output: {Ali=3, Ayşe=4, Veli=4}
```

Important: If duplicate keys are possible, you must supply a merge function:
```
Collectors.toMap(
    keyMapper,
    valueMapper,
    (existing, replacement) -> existing  // or custom merge logic
)
```

### Collectors.groupingBy()
This collector is used to group stream elements by a classifier function, resulting in a Map<K, List<T>> where:
- K is the key (grouping criterion),
- List<T> is the list of elements belonging to that group.

Example:
```
List<String> names = List.of("Ali", "Ayşe", "Veli", "Zeynep");

Map<Integer, List<String>> groupedByLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

System.out.println(groupedByLength);
// Output: {3=[Ali], 4=[Ayşe, Veli], 6=[Zeynep]}
```

Advanced usage:
```
Map<Integer, Set<String>> groupedAsSet = names.stream()
    .collect(Collectors.groupingBy(
        String::length,
        Collectors.toSet()
    ));
```
### What is Collectors.partitioningBy()?
partitioningBy() splits the stream’s elements into two groups based on a boolean condition (i.e., a predicate). The result is a Map<Boolean, List<T>>:
- One list for elements where the predicate returns true
- One list for elements where it returns false

Syntax: 

```
Collectors.partitioningBy(Predicate<T> predicate)
```

You can also pass a downstream collector to customize the result:

```
Collectors.partitioningBy(Predicate<T> predicate, Collector<T, ?, D> downstream)
```

🧪 Example 1: Partitioning even and odd numbers:
```
import java.util.*;
import java.util.stream.Collectors;

public class PartitioningExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even numbers: " + partitioned.get(true));    // [2, 4, 6]
        System.out.println("Odd numbers: " + partitioned.get(false));    // [1, 3, 5]
    }
}
```

🧪 Example 2: Partitioning with a downstream collector
```
Map<Boolean, Long> countByParity = numbers.stream()
    .collect(Collectors.partitioningBy(
        n -> n % 2 == 0,
        Collectors.counting()
    ));

System.out.println(countByParity); // {false=3, true=3}
```

### ⚖️ Difference vs groupingBy()
| Feature  | `partitioningBy()`     | `groupingBy()`         |
| -------- | ---------------------- | ---------------------- |
| Groups   | Exactly 2 (true/false) | Any number of groups   |
| Key type | `Boolean`              | Any object type        |
| Use case | Binary classification  | General classification |

### Primitive Streams
Java has three specialized stream types for primitives in the java.util.stream package:

| Primitive Type | Stream Interface |
| -------------- | ---------------- |
| `int`          | `IntStream`      |
| `long`         | `LongStream`     |
| `double`       | `DoubleStream`   |

#### ✅ Why Use Primitive Streams?
- Performance: No boxing/unboxing overhead (e.g., int vs. Integer).
- Extra methods: Have special methods like sum(), average(), min(), max(), asDoubleStream() etc.
- Memory-efficient: Avoids wrapper object creation.

#### 🔄 Converting Between Streams
From Object Stream → Primitive Stream:
```
Stream<String> stream = Stream.of("1", "2", "3");
IntStream intStream = stream.mapToInt(Integer::parseInt);
```

From Primitive Stream → Object Stream:
```
IntStream intStream = IntStream.of(1, 2, 3);
Stream<Integer> boxed = intStream.boxed();  // Converts to Stream<Integer>
```
#### Useful Methods in Primitive Streams
| Method            | Description                                |
| ----------------- | ------------------------------------------ |
| `sum()`           | Calculates the sum of elements.            |
| `average()`       | Returns an `OptionalDouble` average value. |
| `min()` / `max()` | Finds the min or max value.                |
| `boxed()`         | Converts to wrapper `Stream<T>`.           |
| `asLongStream()`  | Converts `IntStream` to `LongStream`.      |
| `mapToObj()`      | Converts primitives to objects.            |

### Optional
In Java, Optional is a container object introduced in Java 8 that may or may not contain a non-null value. It helps avoid null pointer exceptions by providing a clear, functional-style API for handling values that might be absent.

✅ Purpose of Optional:
- Avoid null checks explicitly.
- Make your code more readable and safe.
- Promote functional programming style.

🧰 Declaring and Using Optional
1. Creating an Optional
```
Optional<String> name = Optional.of("Alice");        // value is present
Optional<String> empty = Optional.empty();           // no value
Optional<String> nullable = Optional.ofNullable(null); // can be null
```
2. Accessing Value
```
name.get();                // Returns the value, or throws NoSuchElementException if empty
name.isPresent();          // Returns true if value exists
name.ifPresent(System.out::println);  // Runs lambda only if value exists
```

3. Safe Value Handling
```
String result = name.orElse("Default");              // Return value or default
String result = name.orElseGet(() -> "Fallback");    // Lazy fallback
String result = name.orElseThrow(() -> new RuntimeException("Missing")); // Custom exception
```
4. Transforming the Value
```
Optional<String> upper = name.map(String::toUpperCase);  // Optional<A> → Optional<B>

Optional<Integer> len = name.map(String::length);        // Transforms contained value
```
5. Chaining Optionals (flatMap)
```
Optional<Person> person = Optional.of(new Person("Bob", new Address("Berlin")));

// Avoid nested Optionals
Optional<String> city = person.flatMap(p -> p.getAddress()).map(Address::getCity);
```

🛑 Common Mistakes to Avoid
- Do not use Optional for fields in data models or DTOs (bad for serialization).
- Don't use Optional.get() without checking isPresent().
- Don’t treat Optional as a replacement for null in all cases — it's a design choice for return types.

✅ Use Optional when:
- Returning a value that might be absent from a method.
- You want to avoid returning null.

### Parallel Streams
Parallel streams are a feature of the Java Stream API (introduced in Java 8) that allow stream operations to be executed concurrently across multiple threads, leveraging multi-core processors.

Instead of processing each element sequentially, a parallel stream splits the data and processes chunks in parallel, potentially speeding up performance on large datasets.

🆚 Sequential vs Parallel Stream
```
// Sequential stream
list.stream().forEach(System.out::println);

// Parallel stream
list.parallelStream().forEach(System.out::println);
```
OR
```
list.stream().parallel().forEach(System.out::println);
```

✅ Benefits
- Can significantly improve performance for large collections.
- Utilizes multiple CPU cores.
- Offers a declarative way to express parallelism.

⚠️ Things to Be Careful About
| Concern             | Details                                                                           |
| ------------------- | --------------------------------------------------------------------------------- |
| **Thread-safety**   | Avoid shared mutable state (like modifying shared variables).                     |
| **Order**           | Results may not maintain order (use `.forEachOrdered()` to preserve).             |
| **Small datasets**  | May be **slower** than sequential streams due to overhead.                        |
| **Splitting logic** | Works best with data sources that support efficient splitting (like `ArrayList`). |
| **Debugging**       | Harder to debug and trace due to concurrency.                                     |

🔍 Example: Comparing Sequential and Parallel
```
List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000)
                                 .boxed()
                                 .collect(Collectors.toList());

// Sequential sum
long seqStart = System.currentTimeMillis();
int seqSum = numbers.stream().reduce(0, Integer::sum);
long seqEnd = System.currentTimeMillis();

// Parallel sum
long parStart = System.currentTimeMillis();
int parSum = numbers.parallelStream().reduce(0, Integer::sum);
long parEnd = System.currentTimeMillis();

System.out.println("Sequential Time: " + (seqEnd - seqStart));
System.out.println("Parallel Time: " + (parEnd - parStart));
```

🔧 When to Use Parallel Streams
- When working with large datasets (hundreds of thousands or more).
- When operations are CPU-bound and stateless.
- When processing can be safely parallelized.

## Section - 3 Collections and Generics
In Java, Collections refers to the Java Collections Framework (JCF), a unified architecture for storing, manipulating, and accessing groups of objects.

Key Concepts
| Term            | Meaning                                                                                                                                              |
| --------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Collection**  | A **root interface** that represents a group of objects (like a list or set).                                                                        |
| **Collections** | A **utility class** in `java.util.Collections` that provides static methods for working with collections (e.g., `sort()`, `shuffle()`, `reverse()`). |

📚 Hierarchy of the Java Collections Framework
              
              Collection (Interface)
                 /      |       \
            List     Set     Queue (Interfaces)
             |         |         |
       ArrayList   HashSet   LinkedList (Classes)
       LinkedList  TreeSet   PriorityQueue

And

                Map (Interface)
                /         \
           HashMap     TreeMap (Classes)
           LinkedHashMap

🧩 Main Interfaces and Their Characteristics
| Interface | Description                  | Common Implementations                |
| --------- | ---------------------------- | ------------------------------------- |
| **List**  | Ordered, allows duplicates   | `ArrayList`, `LinkedList`, `Vector`   |
| **Set**   | Unordered, **no duplicates** | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Queue** | FIFO structure               | `LinkedList`, `PriorityQueue`         |
| **Map**   | Key-value pairs              | `HashMap`, `TreeMap`, `LinkedHashMap` |

🛠️ Collections Class (Utility)
Located in java.util.Collections, provides helper methods:
```
Collections.sort(list);
Collections.reverse(list);
Collections.max(list);
Collections.synchronizedList(list);
```

🔑 Key Benefits
- Reusable data structures
- Algorithms (searching, sorting, etc.)
- Thread-safe versions
- Generic support for type safety

Popular Collection Methods

| Return Type | Method                     | Description                           |
| --------- | ---------------------------- | ------------------------------------- |
| **boolean**  | add(E element)            | adds to the element to the end        |
| **boolean**  | remove(Object o)          | removes a single instance of the element specified |
| **int** | size()                         | returns the number of elements in the collection |
| **void**   | clear()                     | removes all of the elements |
| **boolean**   | contains(Object o)       | does the collection contain the specified element |
| **boolean**   | removeIf(Predicate<? super E> p)              | removes all elements that match the condition |
| **void**   | forEach(Consumer<? super T> c)              | performs the given action on all elements in the collection |

✅ Common Collection Methods (from java.util.Collection)
| Method                              | Description                                                |
| ----------------------------------- | ---------------------------------------------------------- |
| `add(E e)`                          | Adds an element to the collection.                         |
| `addAll(Collection<? extends E> c)` | Adds all elements from another collection.                 |
| `remove(Object o)`                  | Removes the first occurrence of the specified element.     |
| `removeAll(Collection<?> c)`        | Removes all elements in the specified collection.          |
| `retainAll(Collection<?> c)`        | Retains only the elements present in the given collection. |
| `clear()`                           | Removes all elements from the collection.                  |
| `contains(Object o)`                | Returns `true` if the element exists.                      |
| `containsAll(Collection<?> c)`      | Returns `true` if all elements exist in the collection.    |
| `isEmpty()`                         | Returns `true` if the collection is empty.                 |
| `size()`                            | Returns the number of elements.                            |
| `iterator()`                        | Returns an iterator to loop through elements.              |
| `toArray()`                         | Converts the collection to an array.                       |
| `stream()`                          | Returns a sequential `Stream` (Java 8+).                   |
| `parallelStream()`                  | Returns a parallel `Stream` (Java 8+).                     |


### List
In Java, a List is an ordered collection (also known as a sequence) that:
- Maintains the order of elements as they were inserted
- Allows duplicate elements
- Supports index-based access to elements (like arrays)

List is an Interface
It is part of the Java Collections Framework: It extends the Collection interface and adds methods for positional access, searching, iteration, and more.

📚 Common Implementations
| Class        | Description                                              |
| ------------ | -------------------------------------------------------- |
| `ArrayList`  | Fast for random access; backed by a dynamic array.       |
| `LinkedList` | Efficient insertions/deletions; uses doubly linked list. |
| `Vector`     | Synchronized version (legacy).                           |
| `Stack`      | Subclass of `Vector` with LIFO behavior (legacy).        |

🔧 Key Methods
| Method                | Description                                 |
| --------------------- | ------------------------------------------- |
| `add(E e)`            | Adds an element to the end.                 |
| `add(int index, E e)` | Inserts at a specific position.             |
| `get(int index)`      | Returns the element at that index.          |
| `set(int index, E e)` | Replaces the element at that index.         |
| `remove(int index)`   | Removes the element at the specified index. |
| `indexOf(Object o)`   | Returns first index of the object.          |
| `size()`              | Returns the number of elements.             |
| `isEmpty()`           | Returns `true` if the list is empty.        |
