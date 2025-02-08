package DSA.MergeIntervals;

import java.util.*;

/**
 * LeetCode "My Calendar I"
 * ---------------------------------------------------------
 * You are implementing a calendar where values can be booked.
 * A booking is represented as [startTime, endTime).
 * This means all integer times t such that startTime <= t < endTime.
 * We consider it a "double booking" if two bookings overlap
 * in any non-empty range. We must avoid double booking.
 * 
 * Implement the MyCalendar class:
 *   MyCalendar() Initializes the calendar object.
 *   book(int start, int end)
 *     -> Returns true if the event can be added successfully
 *        (i.e., no overlap).
 *        Otherwise, returns false and does not add the event.
 * 
 * Example:
 *   Input:
 *     ["MyCalendar","book","book","book"]
 *     [[], [10,20], [15,25], [20,30]]
 *   Output:
 *     [null, true, false, true]
 * 
 * Explanation:
 *   MyCalendar obj = new MyCalendar();
 *   obj.book(10,20) -> true
 *   obj.book(15,25) -> false
 *   obj.book(20,30) -> true
 */
public class myCalendar1 {
    
    /**
     * Approach 1: Using TreeMap (Balanced BST)
     * -----------------------------------------
     * We keep a TreeMap with "startTime" as the key and "endTime" as the value.
     * 
     * Steps:
     *  1. Get the largest startTime less than or equal to 'start' (floorKey).
     *  2. Get the smallest startTime greater than or equal to 'start' (ceilingKey).
     *  3. If neither of these intervals conflict, insert the new interval and return true.
     *     Otherwise, return false.
     * 
     * Time Complexity: O(log N) per booking due to TreeMap operations.
     * Space Complexity: O(N) to store all intervals.
     */
    static class MyCalendarTreeMap {
        private TreeMap<Integer, Integer> calendar;
        
        public MyCalendarTreeMap() {
            calendar = new TreeMap<>();
        }
        
        public boolean book(int start, int end) {
            // Find the interval that starts before or at 'start'
            Integer prev = calendar.floorKey(start);
            // Find the interval that starts just after 'start'
            Integer next = calendar.ceilingKey(start);

            // Check for overlap with the previous interval
            if (prev != null && calendar.get(prev) > start) {
                return false; 
            }
            // Check for overlap with the next interval
            if (next != null && next < end) {
                return false;
            }
            
            // If no overlap, add this event
            calendar.put(start, end);
            return true;
        }
    }
    
    /**
     * Approach 2: Using an ArrayList (Brute Force)
     * ----------------------------------------------
     * We keep a List of [start, end], and for each new booking,
     * check every existing booking for overlap.
     * 
     * Steps:
     *  1. For each existing interval [s, e], if (start < e && end > s), there's overlap -> return false.
     *  2. Otherwise, add the new interval [start, end].
     * 
     * Time Complexity: O(N) per booking (we compare with all existing bookings).
     * Space Complexity: O(N) to store the intervals.
     */
    static class MyCalendarList {
        private List<int[]> bookings;
        
        public MyCalendarList() {
            bookings = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            for (int[] b : bookings) {
                // Overlap condition: newStart < oldEnd && newEnd > oldStart
                if (start < b[1] && end > b[0]) {
                    return false;
                }
            }
            // No overlap -> add booking
            bookings.add(new int[]{start, end});
            return true;
        }
    }
    
    /**
     * Approach 3: Using TreeSet (Balanced BST with intervals)
     * ---------------------------------------------------------
     * We keep a TreeSet of intervals (int[]), sorted by start time.
     * 
     * Steps:
     *  1. Use floor() / ceiling() to find intervals next to current booking.
     *  2. If there's no overlap, insert the new interval.
     *     Overlap conditions are similar:
     *         (prevInterval.end > newInterval.start) or
     *         (newInterval.end > nextInterval.start)
     *  3. Return true if successfully inserted, false otherwise.
     * 
     * Time Complexity: O(log N) per booking (due to TreeSet operations).
     * Space Complexity: O(N) to store intervals.
     */
    static class MyCalendarTreeSet {
        private TreeSet<int[]> bookings;
        
        public MyCalendarTreeSet() {
            // Sort by start time
            bookings = new TreeSet<>((a, b) -> a[0] - b[0]);
        }
        
        public boolean book(int start, int end) {
            // Proposed new interval
            int[] newInterval = new int[]{start, end};
            
            // floor() - largest interval that is <= newInterval by start
            int[] floor = bookings.floor(newInterval);
            // ceiling() - smallest interval that is >= newInterval by start
            int[] ceiling = bookings.ceiling(newInterval);
            
            // Check overlap with floor
            if (floor != null && floor[1] > start) {
                return false;
            }
            
            // Check overlap with ceiling
            if (ceiling != null && ceiling[0] < end) {
                return false;
            }
            
            // Insert interval if no overlap
            bookings.add(newInterval);
            return true;
        }
    }
    
    /**
     * Test the different approaches
     */
    public static void main(String[] args) {
        
        // Test Approach 1: TreeMap
        MyCalendarTreeMap calendar1 = new MyCalendarTreeMap();
        System.out.println(calendar1.book(10, 20)); // true
        System.out.println(calendar1.book(15, 25)); // false
        System.out.println(calendar1.book(20, 30)); // true
        
        // Test Approach 2: ArrayList
        MyCalendarList calendar2 = new MyCalendarList();
        System.out.println(calendar2.book(10, 20)); // true
        System.out.println(calendar2.book(15, 25)); // false
        System.out.println(calendar2.book(20, 30)); // true
        
        // Test Approach 3: TreeSet
        MyCalendarTreeSet calendar3 = new MyCalendarTreeSet();
        System.out.println(calendar3.book(10, 20)); // true
        System.out.println(calendar3.book(15, 25)); // false
        System.out.println(calendar3.book(20, 30)); // true
    }
}