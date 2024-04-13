package io.tince.advanced.java.lambda.section03.collections.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UsingMaps {
    public static void main(String[] args) {
        Map<String, Integer> mapTree = new TreeMap<>(); // sorted by keys
        mapTree.put("John", 18);
        mapTree.put("Mary", 23);
        mapTree.put("Chris", 62);
        System.out.println(mapTree.containsKey("John"));    // true
        System.out.println(mapTree.containsValue(18));      // true
        System.out.println(mapTree.isEmpty());              // false
        System.out.println(mapTree.get("John"));            // 18

        for (String name :mapTree.keySet()) {
            System.out.println(name);
        }

        for (Integer age : mapTree.values()) {
            System.out.println(age);
        }

        System.out.println(mapTree.containsValue("Paul"));  // false
        System.out.println(mapTree.containsValue(23));      // true
        System.out.println(mapTree.size());                 // 3
        mapTree.clear();
        System.out.println(mapTree.size());                 // 0

        // forEach(BiConsumer) -> BiConsumer<T, U>
        mapTree.put("John", 18);
        mapTree.put("Mary", 23);
        mapTree.put("Chris", 62);
        mapTree.forEach((k, v) -> System.out.println(k + " maps to " + v));

        // Set<Map.Entry<K, V>> entrySet() - Map.Entry encapsulates a key-value pair
        // go from a Map to a Set ( an official Collection )
        // Chris    -> 33
        // John     -> 18
        // MAry     -> 21
        mapTree.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        Set<String> keys = mapTree.keySet();
        // putIfAbsent()
        mapTree.put("Mike", null);              // [Chris=33, John=18, Mary=21, Mike=null]
        mapTree.putIfAbsent("Chris", 99);       // [Chris=33, John=18, Mary=21, Mike=null]
        mapTree.putIfAbsent("Mike", 55);        // [Chris=33, John=18, Mary=21, Mike=55]
        mapTree.putIfAbsent("Luke", 31);        // [Chris=33, John=18, Luke=31, Mary=21, Mike=null]
    }
}
