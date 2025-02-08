package DSA.bits;

import java.util.*;

// Find the largest subset of elements in an array such that the bitwise AND of all elements is greater than 0

public class largestSubsetHavingAndGreThan0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = largestSubsetHavingAndGreThan0(arr);
        System.out.println(ans);
        sc.close();
    }

    public static int largestSubsetHavingAndGreThan0(int[] nums) {
        int maxSetBits = 0;

        // Iterate through bit positions (0 to 31)
        for (int bitPos = 0; bitPos < 32; bitPos++) {
            int setBitCount = 0;

            // Count numbers with a '1' at the current bit position
            for (int num : nums) {
                if ((num & (1 << bitPos)) != 0) {
                    setBitCount++;
                }
            }

            // Update the maximum count
            maxSetBits = Math.max(maxSetBits, setBitCount);
        }

        return maxSetBits;
    }   
    
    
    public static int largestSubarrayHavingAndGreThan0(int[] nums) {
        int result = 0;
        // For each bit position (0 to 31)
        for (int bitPos = 0; bitPos < 32; bitPos++) {
            int mask = 1 << bitPos;
            int currentStreak = 0;
            int maxStreak = 0;
            // Scan through the array
            for (int num : nums) {
                if ((num & mask) != 0) {
                    // If current number has the bit set, extend the streak
                    currentStreak++;
                } else {
                    // Reset the streak if bit not set
                    maxStreak = Math.max(maxStreak, currentStreak);
                    currentStreak = 0;
                }
            }
            // Check at the end in case the streak reaches the end of the array
            maxStreak = Math.max(maxStreak, currentStreak);
            // Update overall result
            result = Math.max(result, maxStreak);
        }
        return result;
    }

    
  
}


