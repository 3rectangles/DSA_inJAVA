package DSA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.*;

public class sliding_win_fixed_len {

    /**
     * QUES : Given an array of integers nums and an integer k, return the maximum sum of a non-empty
     *  https://leetcode.com/problems/sliding-window-maximum/description/
     * Returns an array of maximum elements for every sliding window of size k.
     *
     * Explanation of logic:
     * 1. We use a Deque to store the elements (not indices). We keep the Deque
     *    in a strictly decreasing order of values (deque.getFirst() is the max).
     * 2. For each new element num = nums[idx]:
     *    - While the last element in Deque is smaller than num, remove it (pollLast()),
     *      because it cannot be a candidate for the maximum if a bigger value arrives.
     *    - Add the current element to the back of the Deque (addLast(num)).
     * 3. If the window has moved beyond k elements, check if the oldest element
     *    (nums[idx - k]) is the same as the front of the Deque. If it is, pop it
     *    from the front (pollFirst()) because it's no longer in the window.
     * 4. Once we have at least k elements processed (idx >= k - 1),
     *    we add the Deque's front element (the largest for that window)
     *    to the result list.
     * 5. Finally, convert the result list to an int[] and return it.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];

            // Remove from the back all elements smaller than the current 'num'
            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.pollLast();
            }

            // Add the current element at the back
            deque.addLast(num);

            // Remove the element that goes out of this sliding window
            if (idx >= k && nums[idx - k] == deque.getFirst()) {
                deque.pollFirst();
            }

            // If we've processed at least k elements, record the front as the max
            if (idx >= k - 1) {
                res.add(deque.getFirst());
            }
        }

        // Convert result list to array manually
        int[] resultArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resultArray[i] = res.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        sliding_win_fixed_len obj = new sliding_win_fixed_len();
        int[] res = obj.maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
