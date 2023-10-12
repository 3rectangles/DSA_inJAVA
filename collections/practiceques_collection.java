package collections;


import java.util.*;

public class practiceques_collection {
    public static void main(String[] args) {
        // remove duplicate elements from list

        List<Integer> myList = new ArrayList<>();
        Set<Integer> mySet = new HashSet<Integer>(myList); // if ordereing isnt important
        myList.clear();
        myList.addAll(mySet);

    }
}
