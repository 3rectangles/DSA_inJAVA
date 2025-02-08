package DSA.MergeIntervals;

import java.util.*;

/**
 * LeetCode "My Calendar II"
 * ---------------------------------------------
 * We need to add events so that no time is covered by three or more events.
 * A triple booking happens if three intervals overlap in any non-empty range.
 *
 * Approach (Sweep Line with TreeMap):
 * -----------------------------------
 * 1. We use a TreeMap<Integer, Integer> to store the "changes" at each time point:
 *    - When we book an event [start, end), we do:
 *        map.put(start, map.getOrDefault(start, 0) + 1)
 *        map.put(end,   map.getOrDefault(end, 0) - 1)
 *    - This denotes that at 'start' we begin a booking count (+1), and at 'end' we stop a booking count (-1).
 * 2. To check if this addition leads to a triple booking (sum >= 3), we traverse the map in ascending order of times,
 *    calculating the running sum of all +1 and -1. If at any point the sum >= 3, we revert the changes and return false.
 * 3. If we finish traversing without encountering sum >= 3, we keep the changes and return true.
 *
 * Time Complexity: O(N log N) for each booking in the worst case (where N is the number of bookings).
 *                  This is due to the TreeMap operations and the potential traversal of the keys.
 * Space Complexity: O(N), storing all time boundaries in the map.
 */
public class myCalendar2 {
    
    static class MyCalendarTwo {
        private TreeMap<Integer, Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }
        
        public boolean book(int start, int end) {
            // 1. Add new event changes to map
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            
            // 2. Check for triple booking by traversing map
            int curr = 0;
            for (int key : map.keySet()) {
                curr += map.get(key);
                if (curr >= 3) {
                    // Revert changes
                    map.put(start, map.get(start) - 1);
                    if (map.get(start) == 0) {
                        map.remove(start);
                    }
                    map.put(end, map.get(end) + 1);
                    if (map.get(end) == 0) {
                        map.remove(end);
                    }
                    return false;
                }
            }
            // 3. If no triple booking, return true
            return true;
        }
    }

    // Quick Test
    public static void main(String[] args) {
        MyCalendarTwo myCalendar = new MyCalendarTwo();
        
        System.out.println(myCalendar.book(10,20)); // true
        System.out.println(myCalendar.book(50,60)); // true
        System.out.println(myCalendar.book(10,40)); // true (double booking is allowed, but not triple)
        System.out.println(myCalendar.book(5,15));  // false (would cause triple booking)
        System.out.println(myCalendar.book(5,10));  // true
        System.out.println(myCalendar.book(25,55)); // true
    }
}