# Java 21, Java 17, Java 11 and Advanced Java 8
## Section - 1 Lambda Expressions
## Section - 2 Streams
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

