package DSA;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Constructs a maximum subsequence of the specified length k from the given
 * array
 * by using a monotonic stack approach.
 *
 * Explanation:
 * 1) We maintain a deque that stores elements in a non-increasing order
 * (monotonic).
 * 2) For each element arr[i], we pop from the back of the deque while:
 * - The element at the back is less than arr[i].
 * - We can still form a subsequence of length k if we remove that element
 * (i.e.,
 * (deque.size() - 1 + (arr.length - i) >= k)).
 * 3) We then add the current element arr[i] to the back of the deque.
 * 4) After processing all elements, the front k elements in the deque form the
 * maximum subsequence.
 * 5) Finally, we convert that subsequence to a string and return it.
 */
public class monotonicStack {
    public static String maxSubsequence(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException("k cannot exceed the size of the array.");
        }

        Deque<Integer> deque = new LinkedList<>();
        // Build a subsequence of length k
        for (int i = 0; i < arr.length; i++) {
            // While we can pop from the back of the deque to maintain a
            // non-increasing order, and still be able to form a subsequence of length k
            while (!deque.isEmpty()
                    && deque.peekLast() < arr[i]
                    && (deque.size() - 1 + (arr.length - i) >= k)) // elemsnt left in stack after popping + elements
                                                                   // left in array >= k
            {
                deque.pollLast();
            }
            deque.addLast(arr[i]);
        }

        // Build the result from the first k elements of deque
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = deque.pollFirst();
        }

        // Convert result to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }

    // Quick test
    public static void main(String[] args) {
        int[] arr1 = { 4, 9, 0, 2 };
        int k1 = 2;
        // Expected "92"
        System.out.println("Max subsequence of length " + k1 + " is: " + maxSubsequence(arr1, k1));

        int[] arr2 = { 3, 5, 7, 2, 6, 1, 9 };
        int k2 = 3;
        // Example result: "769"
        System.out.println("Max subsequence of length " + k2 + " is: " + maxSubsequence(arr2, k2));
    }

    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        // First pass: build monotonic decreasing stack of indices
        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            stack.push(i);

        }

        // Second pass: from right to left, find max width
        int maxWidth = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // While current number >= number at stack top
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, i - stack.pop());
            }
            if (stack.isEmpty())
                break;
        }

        return maxWidth;
    }
}