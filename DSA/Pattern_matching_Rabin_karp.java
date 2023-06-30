package DSA;

import java.util.*;
public class Pattern_matching_Rabin_karp {


        static final long mod = 1000000007;

        // Computes a^n % mod
        static long power(long a, long n) {
            long result = 1;
            while (n != 0) {
                if ((n & 1) != 0) {
                    result = (result * a) % mod;
                }
                n >>= 1;
                a = (a * a) % mod;
            }
            return result;
        }

        // Computes the hash value of a given string
        static long getHash(String key) {
            long value = 0;
            long p = 31;
            long p_power = 1;

            for (char ch : key.toCharArray()) {
                value = (value + (ch - 'a' + 1) * p_power) % mod;
                p_power = (p_power * p) % mod;
            }

            return value;
        }

        // Computes the hash values for all suffixes of the input string and stores them in the dp array
        // Also computes the powers of the prime number p and stores them in the primes array
        static void txthash(String input_string, long[] dp, long[] primes) {
            long p = 31;
            long p_power = 1;
            primes[0] = 1L;
            dp[0] = (input_string.charAt(0) - 'a' + 1);

            for (int i = 1; i < input_string.length(); i++) {
                char ch = input_string.charAt(i);
                p_power = (p_power * p) % mod;
                primes[i] = (primes[i - 1] * p) % mod;
                dp[i] = (dp[i - 1] + (ch - 'a' + 1) * p_power) % mod;
            }
        }

        static void rabinKarp(String st, String ptrn, ArrayList<Long> ans) {
            long[] dp = new long[st.length()];
            long[] primes = new long[st.length()];
            long ptrn_hash = getHash(ptrn);

            txthash(st, dp, primes);

            int i = 0, j = ptrn.length() - 1;

            while (j < st.length()) {
                long substr_hash = 0;
                if (i == 0) {
                    substr_hash = dp[j];
                } else if (i > 0) {
                    substr_hash = (dp[j] - dp[i - 1]);
                }

                // If the adjusted hash value of the pattern matches the hash value of the current substring,
                // add the starting index to the list of found occurrences
                if ((ptrn_hash * primes[i]) % mod == substr_hash) {
                    ans.add((long) i);
                }

                i++;
                j++;
            }
        }

        public static void main(String[] args) {
            String st = "abcabcabc";
            String ptrn = "abc";
            ArrayList<Long> ans = new ArrayList<>();
            rabinKarp(st, ptrn, ans);
            System.out.println(ans);
        }
    }
