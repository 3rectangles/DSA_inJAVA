package try1;

import java.util.*;

public class sliding_win_1 {
    public static void main(String[] args) {
        Solution ob =new Solution();

        int ans ;
        String s= "pwwkew"  ;
        ans =ob.lengthOfLongestSubstring(s);

        System.out.println(ans);
    }
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
class Solution {

    public int lengthOfLongestSubstring(String s) {
        // variable sliding window

        int i,j;
        i = j = 0;
        // i..j
        int n = s.length();
        Map<Character,Integer> um =new HashMap<>();

        int ans =0;
        while(j < n) {

            // add char in hash
            char ch = s.charAt(j);

//            um.put(ch,um.get(ch)+1);
            um.put(ch,um.getOrDefault(ch,0)+1);

            // shorten the window size till condition not met

            while( (j-i+1) > um.size() && i <= j){
                // deleting the ith
                char ith = s.charAt(i);
                um.put(ith,um.get(ith)-1);

                // if freq falls to 0 remove
                if( um.get(ith) ==0)
                {
                    um.remove(ith);
                }
                i++;

            }
            // condition met, store max
            ans = Math.max(ans, (j-i+1));

        j++;
        }
        return ans;
}}