package io.tince.advanced.java.lambda.section03.collections.list;

import java.util.*;

public class UsingLists {
    public static void main(String[] args) {
        factoryMethods();
        System.out.println("---------------");
        arrayList();
        System.out.println("---------------");
        stack();
        System.out.println("---------------");
        linkedList();
    }

    private static void linkedList() {
        // A doubly-linked list. We can manipulate both ends
        LinkedList<String> names = new LinkedList<>();
        names.add("Colin");             // [Colin]
        names.add("David");             // [Colin, David]
        names.addFirst("Brain");     // [Brain, Colin, David]
        names.addLast("Edward");     // [Brain, Colin, David, Edwards]
        System.out.println(names);      // [Brain, Colin, David, Edwards]

        names.remove("David");       // [Brain, Colin, Edwards]
        names.removeFirst();            // [Colin, Edwards]
        names.removeLast();             // [Colin]
        System.out.println(names);      // [Colin]
    }

    private static void stack() {
        // Stack is a LIFO structure (Last In First Out) - we can manipulate one end only
        // Using the Stack type as the reference type, so we get access to the push(), pop() and peek() methods.
        Stack<String> stack = new Stack<>();    // legacy class, use Deque interface instead
        stack.push("Andrea");
        stack.push("Barbara");
        stack.push("Caroline");
        System.out.println(stack);      // [Andrea, Barbara, Caroline]
        //
        //
        //
        System.out.println("Top of stack: " + stack.peek());    // Caroline
        System.out.println("Pooped: " + stack.pop());           // Caroline - [Andrea, Barbara]
        stack.push("Helen");                               // [Andrea, Barbara, Helen]
        System.out.println(stack);                              // [Andrea, Barbara, Helen]
    }

    private static void arrayList() {
        // LOD = Lord of the Dance
        //     Lists maintain Order (index) and allow Duplicates
        List<String> list = new ArrayList<>();
        list.add("Alan");
        list.add("Alan");
        list.add(1, "Sean");
        list.add("Mary");
        list.add("Mary");
        System.out.println(list);           // [Alan, Sean, Alan, Mary, Mary]
        System.out.println(list.get(1));    // Sean
        list.remove(0);               // result is [Sean, Alan, Mary, Mary]
        list.remove("Mary");
        System.out.println(list);           // [Sean, Alan, Mary]
        list.set(0, "Jack");                // [Jack, Alan, Mary]
        // replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T,T> where the input and output are the same type
        //
        list.replaceAll(name -> name + " Kennedy");
        System.out.println(list);           // [Jack Kennedy, Alan Kennedy, Mary Kennedy]
    }

    private static void factoryMethods() {
        String[] array = new String[]{"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array);
        List<String> of = List.of(array);
        List<String> copy = List.copyOf(asList);

        array[0] = "Delta";                             // Changes to the array 'write through to the list
        System.out.println(Arrays.toString(array));     // [Delta, Beta, Charlie]
        System.out.println(asList);                     // [Delta, Beta, Charlie]

        asList.set(1, "Echo");                          // Changes to the list 'write through' to the array
        System.out.println(Arrays.toString(array));     // [Delta, Echo, Charlie]
        System.out.println(asList);                     // [Delta, Echo, Charlie]

        // of.add("Foxtrot");                           // UnsupportedOperationException
        // copy.add("Foxtrot");                         // UnsupportedOperationException
        // asList.add("Foxtrot");                           // UnsupportedOperationException
    }
}
