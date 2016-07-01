package exercise.exercise0;
import java.util.*;
/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<Integer> array = new ArrayList<Integer>();
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
        array.add(1);
        array.add(2);
        array.add(3);
        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> it = array.listIterator();
        while(it.hasNext()){
                  System.out.println(it.next()+" ");
        }
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for(int i=0; i< array.size(); i++){
            System.out.println(array.get(i)+" ");
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(Integer elem:array){
            System.out.println(elem + " ");
        }

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 instance = new Exercise0();
        instance.iterateThroughList();
    }
}
