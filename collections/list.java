package collections;

import java.util.*;

public class list {

    public static void main(String[] args) {

        int n =6;
        List<List<Integer>> graph = new ArrayList<>(n); // the n passed as an argument is the initial capacity of the ArrayList.
        // It means that the ArrayList is created with enough space to store n elements without needing to resize its internal array.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //graph.size();



    }
}
