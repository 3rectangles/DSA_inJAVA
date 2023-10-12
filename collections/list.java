package collections;

import java.util.*;

/**
 *  List<Integer> l = new ArrayList<>(4);
 *  you created with an initial capacity of 4 means that the ArrayList can hold up to four elements without needing to resize.
 *  However, it doesn't mean that you have four elements preallocated; it simply means that it has room for four elements.
 //add
 //get
 //set
 //remove
 //clear  --.empties the entire list

 */

public class list {

    public static void main(String[] args) {
//        List<Integer> l = new ArrayList<>();
//        Collections.sort(l);


        int n =6;
        List<List<Integer>> graph = new ArrayList<>(n); // the n passed as an argument is the initial capacity of the ArrayList.
        // It means that the ArrayList is created with enough space to store n elements without needing to resize its internal array.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(4));
            //
        }

        //graph.size();
        graph.get(3).add(12); // list[3].add
        System.out.println(Arrays.toString(graph.toArray()));


        List<Integer> l =new ArrayList<>();
        l.add(1); l.add(2);

        Integer[] arr1 = l.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr1) +"  used toArray function ");

        String a= "";
        a += a+"123";
        a = a.substring(0,a.length()-1);
        System.out.println(a);

        // quicky initilization of list

        List<Integer> l2 = List.of(1,2,3,4,50);
        System.out.println(Arrays.toString(l2.toArray()));



        // remove elements form list
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("Banana")) {
                iterator.remove(); // Removes the current element from the list
            }
        }


    }
}
