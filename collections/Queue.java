package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;

public class Queue {
    public static void main(String[] args) {
//        Queue<String> linkedList = new LinkedList<>();

        //  add(), offer(), remove(), poll(), peek()

    }
}

/**
    Since the Queue is an interface, we cannot provide the direct implementation of it.
        In order to use the functionalities of Queue, we need to use classes that implement it:
        ArrayDeque
        LinkedList
        PriorityQueue
Interface methods:
 offer() – Inserts a new element onto the Queue
 poll() – Removes an element from the front of the Queue, returns null if empty
 peek() – Inspects the element at the front of the Queue, without removing it, returns null if empty

 */


//

class Pair {
    private int key;
    private String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue with a lambda comparator for pairs, for max priority queue
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2.getKey() - pair1.getKey());


        // Add pairs to the priority queue
        priorityQueue.add(new Pair(3, "Value 3"));
        priorityQueue.add(new Pair(1, "Value 1"));
        priorityQueue.add(new Pair(2, "Value 2"));

        // Process pairs in the priority queue
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            System.out.println("Key: " + pair.getKey() + ", Value: " + pair.getValue());
        }
    }
}

//class usingLinkedList{
//
//    public static void main(String[] args) {
//        Queue<String> q= new LinkedList<>(); // this shows eror bec current class neme is queue.
//
//    }
//}

// The lambda function takes two arguments, pair1 and pair2, which represent two Pair objects.
// The comparison is done by subtracting the key of pair1 from the key of pair2.
// If the result is positive, it means pair2 has a higher priority than pair1, and if it's negative, pair1 has a higher priority. If the result is zero, it means both pairs have the same priority.



/**
 DEQUEUE
 It's not thread-safe
 Null elements are not accepted
 ArrayDeque automatically doubles the size of an array when the head and tail pointer meets each other while adding an element
 Interface methods:
 offer() – Inserts a new element onto the Queue
 poll() – Removes an element from the front of the Queue
 peek() – Inspects the element at the front of the Queue, without removing it

 Concrete methods:

 offerFirst(E e): These methods add an element to the front of the deque.
 offerLast(E e): These methods add an element to the tail of the deque.
 peekFirst(): These methods retrieve, but do not remove, the first element of the deque.
 peekLast(): These methods retrieve, but do not remove, the last element of the deque.
 pollFirst(): These methods remove and return the first element of the deque.
 pollLast(): These methods remove and return the last element of the deque.
 */

class dequeue{
    public static void main(String[] args) {
        Deque<String> dq  = new ArrayDeque<>();
        dq.offerFirst("qew");
        String st = dq.peekFirst();
        System.out.println(st);
    }
}
