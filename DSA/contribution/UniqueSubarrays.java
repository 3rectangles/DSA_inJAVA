package DSA.contribution;

import java.util.Arrays;
import java.util.HashMap;

public class UniqueSubarrays {

    /*
    Number of Distinct Integers in all Subarrays

    Anonymous User   August 11, 2023 2:15 AM   296 VIEWS

    Count the number of distinct integers in each subarray.

    For Example:
    [1,2,2,1]

    The possible sub-arrays are:
    [1] -> 1 Unique Element
    [2] -> 1 Unique Element
    [2] -> 1 Unique Element
    [1] -> 1 Unique Element
    [1,2] -> 2 Unique Elements
    [2,2] -> 0 Unique Element
    [2,1] -> 2 Unique Elements
    [1,2,2] -> 1 Unique Element
    [2,2,1] -> 1 Unique Element
    [1,2,2,1] -> 0 Unique Element

    So we should return 1+1+1+1+2+0+2+1+1+0 = 10
    */

    // Function to compute the total sum of unique numbers over all subarrays
    public static long uniqueSubarrayCount(int[] arr) {
        int n = arr.length;
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        
        
        // Use a map to record the last occurrence of each element
        HashMap<Integer, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (lastOccurrence.containsKey(arr[i])) {
                leftBound[i] = lastOccurrence.get(arr[i]);
                // The current index is the next occurrence for the previous one.
                rightBound[lastOccurrence.get(arr[i])] = i;
            } else {
                leftBound[i] = -1; // No previous occurrence
            }
            lastOccurrence.put(arr[i], i);
        }

        // 0 1 2 3 4    5     6 7 8 9 10 11 12 13 14
        // a b x c d    x     e f g h x  i  j  k  l
        // contribution ox x at index 5 is 3 * 5= i.e ( 5-2)*(10-5)
        // Contribution at index i = (i - leftBound[i]) * (rightBound[i] - i)
        // when no boundary left possibilities = (i+1)
        // when no boundary right possibilities = (n-i)

        // Count subarrays where each arr[i] appears exactly once.
        long totalUniqueCount = 0;
        for (int i = 0; i < n; i++) {
            long countLeft = i - leftBound[i];
            rightBound[i] = rightBound[i] == 0? n : rightBound[i];
            long countRight = rightBound[i] - i;
            totalUniqueCount += countLeft * countRight;
        }

        return totalUniqueCount;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        long result = uniqueSubarrayCount(arr);
        System.out.println("Total count of unique numbers in all subarrays: " + result);
    }
}