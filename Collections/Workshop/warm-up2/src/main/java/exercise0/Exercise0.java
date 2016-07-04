package exercise0;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 * <p>
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 * print all its elements.
 */
public class Exercise0 {

    public Exercise0() {

    }

    public void iterateThroughMap() {

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "ceva0");
        map.put(2, "ceva1");
        map.put(3, "ceva2");
        map.put(4, "ceva3");
        map.put(1, "ceva4");
        map.put(2, "ceva5");
        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        Set<Integer> keyset = map.keySet();
        int count = 0;
        for (Integer i : keyset) {
            if (count == keyset.size() - 1) System.out.print(i + "=" + map.get(i));
            else {
                System.out.print(i + "=" + map.get(i) + " ,");
                count++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
